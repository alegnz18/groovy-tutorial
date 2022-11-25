
class Perro extends Animal{
  def dueño;
 
  // Constructor
  def Perro(nombre, sonido, dueño){
 
    // Llama al constructor de Animal
    super(nombre, sonido);
    this.dueño = dueño;
  }
 
  // Sobreescribe el método hacerSonido()
  def hacerSonido(){
    println("${nombre} ladra y ${sonido}");
  }
}