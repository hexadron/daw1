package app.util;

public class Seeds {
	
	public static void main(String[] args) {
		
		SuperSeeder seeder = new SuperSeeder();
		
		seeder.setDataFolder("app/data");
		seeder.setObjectPackage("app.beans");
		
		// coloca un orden a la carga de yamls... de no utilizar el método setFiles,
		// cargará conforme estén, sin importar el orden de las dependencias.
		seeder.dependencyOrder("distrito", "estado_civil", "vendedor");
		seeder.superSeed();
	}
}