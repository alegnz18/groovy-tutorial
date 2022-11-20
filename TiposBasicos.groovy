println("no necesito un punto y coma al final")

println "Yo tampoco, ni los parentesis"

String myString


// Def se usa para definir una variable
// Los nombres de variables comienzan con una letra y puede contener
// números y el signo _
// Las variables son tipadas dinámicamente y pueden contener 
// cualquier valor

def objetoEdad

objetoEdad = "soy la edad de la persona"

println objetoEdad

objetoEdad = 40

println objetoEdad

println "Necesito una comilla simple ' "
println 'Necesito una comilla doble " '
println """Necesito muchas lineas
donde poder ver los retornos de carro 
sin tanto lio como concatenando String """

println "Mira lo que puedo hacer ${2+2} con el dolar y las llaves"

// Todo en Groovy es un objeto incluyendo los números

  // Operadores matemáticos de tipo entero
  println("5 + 4 = " + (5 + 4));
  println("5 - 4 = " + (5 - 4));
  println("5 * 4 = " + (5 * 4));
  println("5 / 4 = " + (5.intdiv(4)));
  println("5 % 4 = " + (5 % 4));

  // Operadores matemáticos de punto flotante
  println("5.2 + 4.4 = " + (5.2.plus(4.4)));
  println("5.2 - 4.4 = " + (5.2.minus(4.4)));
  println("5.2 * 4.4 = " + (5.2.multiply(4.4)));
  println("5.2 / 4.4 = " + (5.2 / 4.4));

  // Orden de las operaciones
  println("3 + 2 * 5 = " + (3 + 2 * 5));
  println("(3 + 2) * 5 = " + ((3 + 2) * 5));

  // Funciones matemáticas
  def randNum = 2.0;
  println("Math.abs(-2.45) = " + (Math.abs(-2.45)));
  println("Math.round(2.45) = " + (Math.round(2.45)));
  println("randNum.pow(3) = " + (randNum.pow(3)));
  println("3.0.equals(2.0) = " + (3.0.equals(2.0)));
  println("randNum.equals(Float.NaN) = " + (randNum.equals(Float.NaN)));
  println("Math.sqrt(9) = " + (Math.sqrt(9)));
  println("Math.cbrt(27) = " + (Math.cbrt(27)));
  println("Math.ceil(2.45) = " + (Math.ceil(2.45)));
  println("Math.floor(2.45) = " + (Math.floor(2.45)));
  println("Math.min(2,3) = " + (Math.min(2,3)));
  println("Math.max(2,3) = " + (Math.max(2,3)));

  // Incremento y decremento
  println("objetoEdad++ = " + (objetoEdad++));
  println("++objetoEdad = " + (++objetoEdad));
  println("objetoEdad-- = " + (objetoEdad--));
  println("--objetoEdad = " + (--objetoEdad));


// LISTAS
def sesiones = ['Introducción a Groovy', 'El lenguaje Groovy', 'Aspectos avanzados en Groovy']
assert sesiones[1] == 'El lenguaje Groovy'
sesiones[3] = 'Librerías propias de Groovy'//La lista se expande automáticamente
assert sesiones.size() == 4

sesiones.each{ println "Es un objeto de la lista: $it"}

//MAPAS
def http = [
100 : 'Continue',
200 : 'OK',
400 : 'Bad Request'
]
assert http[200] == 'OK'
assert http.size() == 3

//RANGOS
def x = 1..10
assert x.contains(2)
assert x.size() == 10
println x.reverse() == 10..1

def lista = [1, 3, 4, "Una cadena", new Date() ]
List otraLista = [1, 3, 4, "Una cadena", new Date() ]

lista.each{ println "Es un objeto de la lista: $it"}

def mapa = [ clave : "valor", otra_clave: "otro valor"]

mapa.each{ println "Es un Map.Entry $it.key=$it.value" }

lista.eachWithIndex{ ele, idx ->
    println "posicion $idx, elemento $ele"
}

lista = ['a','b','c','d']
def nuevaLista = []
lista.collect( nuevaLista ) {
it.toUpperCase()
}
println nuevaLista

