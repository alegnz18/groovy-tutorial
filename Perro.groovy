
class Perro extends Animal{
  def duenio;
 
  // Constructor
  def Perro(nombre, sonido, duenio){
 
    // Llama al constructor de Animal
    super(nombre, sonido);
    this.duenio = duenio;
  }
 
  // Sobreescribe el método hacerSonido()
  def hacerSonido(){
    println("${nombre} ladra y ${sonido}");
  }
}