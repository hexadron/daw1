package app.util;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlReader;

public class SuperSeeder {
	
	private Map<String, List<?>> data;
	private List<String> files;
	private String dataFolder;
	private String objectPackage;

	@SuppressWarnings("rawtypes")
	public Map<String, List<?>> superSeed() {
		data = new HashMap<String, List<?>>();
		
		if (files == null) {
			files = getFiles();
		}
		
		try {
			for	(String f : files) {
				Class _class = Class.forName(objectPackage + "." +  toClassName(f));
				List<?> subSet = readYML(f, _class);
				save(subSet);
				data.put(_class.getName(), subSet);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN. :). TODO: imprimir algo mejor.");		
		return data;
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> readYML(String f, Class<?> _class) {
		YamlReader reader;
		try {
			reader = new YamlReader(new FileReader(f));
			
			List<T> objects = new ArrayList<T>();
			
			while (true) {
				Map<String, Object> info = (Map<String, Object>) reader.read();
				
				if (info != null)
					objects.add((T) toAR(info, _class));
				else
					break;
			}
			
			return objects;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> T toAR(Map<String, Object> info, Class<?> _class) {
		try {
			T instance = (T) _class.newInstance();
			Method[] methods = _class.getMethods();
			
			for (Method m : methods)
				if (m.getName().startsWith("set")) {
					String attr = m.getName().substring(3);
					attr = attr.substring(0, 1).toLowerCase() + attr.substring(1);
					
					Object value = info.get(attr);
					
					Class<?>[] paramsTypes = m.getParameterTypes();
					
					if (value != null) {
						Class<?> vType = value.getClass();
						Class<?> pType = paramsTypes[0]; 
						if (vType.equals(pType)) {
							m.invoke(instance, value);
						} else {
							if (pType.getSuperclass() != null && pType.getSuperclass().equals(ActiveRecord.class)) {
								
								Class<? extends ActiveRecord> arType = (Class<? extends ActiveRecord>) pType; 
								
								Object arObject = arType.newInstance(); 
								arObject = ActiveRecord.find(arType, Long.parseLong(value.toString()));
								
								if (arObject != null) {
									m.invoke(instance, arObject);
								}
								
							} else {
								if (pType.getName().equals("int")) {
									m.invoke(instance, Integer.parseInt((String) value));
								}
							}
						}
					}
					
				}

			return instance;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String toClassName(String f) {
		// .../estado_civil.yml => EstadoCivil
		int last_slash = f.lastIndexOf("/");
		String className = f.substring(last_slash + 1, f.length() - 4);
		
		if (className.indexOf("_") != -1) {
			String[] parts = className.split("_");
			String end = "";
			for (String p : parts) {
				end += Utilities.capitalize(p);
			}
			className = end;
		} else {
			className = Utilities.capitalize(className);
		}
		return className;
	}

	private List<String> getFiles() {
		String folderName = sourceFolder(this.dataFolder);
		
		File folder = new File(folderName);
		List<String> filenames = new ArrayList<String>();
		
		File[] files = folder.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return name.endsWith(".yml");
			}
		});
		
		for (File f : files) {
			filenames.add(folderName + "/" + f.getName());
		}
		
		return filenames;
	}

	private String sourceFolder(String dataFolder2) {
		return System.getProperty("user.dir") + "/src/" + this.dataFolder;
	}

	public static void save(List<?> subSet) {
		for (Object item : subSet) {
			((ActiveRecord) item).save();
		}
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	public void setObjectPackage(String packageName) {
		this.objectPackage = packageName;
	}

	public void dependencyOrder(String... names) {
		files = new ArrayList<String>();
		
		String folderName = sourceFolder(dataFolder);
		
		for (String n : names) {
			files.add(folderName + "/" + n + ".yml");
		}
	}
	
}
