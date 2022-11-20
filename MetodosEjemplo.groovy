
class TestMetodos {
    // Static: será compartido por todas las instancias de la clase
    static def decirHola() {
      println("Hola");
    }

    // Pueden recibir parámetros con valores default
    static def getSuma(num1=0, num2=0){
      return num1 + num2;
    }

    // Los objetos pasados a un método se pasan por valor
    static def pasadoPorValor(nombre){

      // nombre es local a la función y no puede ser accedido fuera de ella
      nombre = "En la funcion";
      println("Nombre : " + nombre);
    }

    // Recibe y devuelve una lista
    static def dobleLista(lista){

      // El Collect hace el cálculo correspondiente en cada elemento de la lista
      def nuevaLista = lista.collect { it * 2};
      return nuevaLista;
    }

    // Pasar una cantidad no especificada de elementos a un método
    static def sumarTodos(int... num){
      def suma = 0;

      // Hace el cálculo en cada elemento del each
      num.each { suma += it; }
      return suma;
    }
}

def test = new TestMetodos()

test.decirHola()

//test.dobleLista([1,2,3]).each{ println "Es un objeto de la lista: $it"}

