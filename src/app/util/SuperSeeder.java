package app.util;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
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
	private boolean fromScratch;

	@SuppressWarnings("unchecked")
	public Map<String, List<?>> superSeed() {
		data = new HashMap<String, List<?>>();
		
		// TODO: debo hacer truncates D:		
		if (files == null) {
			this.loadFiles();
		}
		
		try {
			for	(String f : files) {
				Class<? extends ActiveRecord> _class =
						(Class<? extends ActiveRecord>) Class.forName(objectPackage + "." +  toClassName(f));
				List<?> subSet = readYML(f, _class);
				if (fromScratch) {
					this.destroyTable(_class);
				}
				this.save(subSet);
				data.put(_class.getName(), subSet);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("FIN. :). TODO: imprimir algo mejor.");		
		return data;
	}

	private void destroyTable(Class<? extends ActiveRecord> model) {
		ActiveRecord.truncate(model);
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
	private <T> T toAR(Map<String, Object> info, Class<?> _class) {
		try {
			T instance = (T) _class.newInstance();
			Method[] methods = _class.getMethods();
			
			for (Method m : methods)
				if (m.getName().startsWith("set")) {
					String attr = m.getName().substring(3);
					attr = Utilities.camelCase(attr);
					
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
								
								Object arObject = 
										ActiveRecord.find(arType, Long.parseLong(value.toString()));
								
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
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String toClassName(String f) {
		int last_slash = f.lastIndexOf("/");
		String className = f.substring(last_slash + 1, f.length() - 4);
		return Utilities.capitalize(Utilities.camelCase(className));
	}

	private void loadFiles() {
		String folderName = this.sourceFolder();
		
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
		
		this.files = filenames;
	}

	private String sourceFolder() {
		return System.getProperty("user.dir") + "/src/" + this.dataFolder;
	}

	public void save(List<?> subSet) {
		for (Object item : subSet) {			
			((ActiveRecord) item).save();
			System.out.println(item.toString());
		}
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	public void setObjectPackage(String packageName) {
		this.objectPackage = packageName;
	}

	public void dependencyOrder(String... names) {
		this.files = new ArrayList<String>();
		
		String folderName = this.sourceFolder();
		
		for (String n : names) {
			this.files.add(folderName + "/" + n + ".yml");
		}
	}

	public void setFromScratch(boolean fromScratch) {
		this.fromScratch = fromScratch;
	}
	
}
