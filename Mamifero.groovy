
class Mamifero extends Cosa{
  def Mamifero(nombre){
    this.nombre = nombre;
  }

  def getInfo() {
      println("El nombre del mamifero es ${nombre}");
  }
}