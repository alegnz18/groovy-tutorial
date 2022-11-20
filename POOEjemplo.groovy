

  // Constructor de un Animal
  def leon = new Animal('Leon', 'rugido');

  println("${leon.nombre} hace ${leon.sonido}");

  // Cambiar el atributo de un objeto con un setter
  leon.setSonido('Grrrr');
  println("${leon.nombre} hace ${leon.sonido}");

  leon.corre();

  println(leon.toString());

  //A traves de la herencia una clase puede heredar todos los campos y métodos de otra clase
  def bulldog = new Perro('Bulldog', 'Grrrrr', 'Mario');

  leon.haceSonido();
  bulldog.haceSonido();

  // Un mamífero hereda de la clase abstracta Cosa
  def hamster = new Mamifero('Hamster');
  hamster.getInfo();