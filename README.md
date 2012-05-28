# Test setup
	
	brew install qt
	bundle
	rspec
	
# Seeds :D

In app/util/Seeds.java
    
    package app.util;

    public class Seeds {
	
		public static void main(String[] args) {
			
			SuperSeeder seeder = new SuperSeeder();
			
			seeder.setDataFolder("app/data");
			seeder.setObjectPackage("app.beans");
			seeder.dependencyOrder("distrito", "estado_civil", "vendedor"); // not required
			seeder.superSeed();
		}
	} 

## Explanation

- Here we go...
	- DataFolder: Location for the *.yml files.
	- ObjectPackage: Location for the models package.
	- DependecyOrder: A list for manage the dependencies between models. (TODO: make dependency inference)
	- SuperSeed: Launch the seeder
	
## YML files
Examples:

>> estado_civil.yml

      descripcion: soltero
      ---
      descripcion: casado
      ---
      descripcion: divorciado

note: estado_civil.yml file maps to EstadoCivil class.

>> vendedor.yml

      nombre: Jorge
      apellido: Arcos
      edad: 25
      fechaNacimiento: 1979-10-10
      estadoCivil: 1
      distrito: 3
      ---
      nombre: María
      apellido: Gutarra
      edad: 25
      fechaNacimiento: 1940-02-20
      estadoCivil: 2
      distrito: 1
      ---
      nombre: Patricia
      apellido: Vivas
      edad: 28
      fechaNacimiento: 1980-05-15
      estadoCivil: 3
      distrito: 2
      
note: Unfortunately, there is no way to connect with other relationships by name without exploding my brain with java. For my health, the only way to map to other relationships is with the id… Because that, the dependency order is very important. TODO: get a better way to connect entities.

## Usage

Just Run the main!! :D
