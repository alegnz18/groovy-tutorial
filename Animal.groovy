
import groovy.transform.ToString;
 
// Annotation para crear el metodo ToString para la clase
@ToString(includeNames=true, includeFields=true)

class Animal {
  def nombre;
  def sonido;
 
  // Métodos
  def corre(){
    println("${nombre} corre");
  }
  def haceSonido(){
    println("${nombre} hace ${sonido}");
  }
 
  // Método del Constructor
  def Animal(nombre, sonido){
    this.nombre = nombre;
    this.sonido = sonido;
  }
 
}