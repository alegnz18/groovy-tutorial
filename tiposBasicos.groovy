println("no necesito un punto y coma al final")

println "Yo tampoco, ni los parentesis"

String myString

def unObjeto

unObjeto = "soy un string"

println unObjeto

unObjeto = 10

println unObjeto

println "Necesito una comilla simple ' "
println 'Necesito una comilla doble " '
println """Necesito muchas lineas
donde poder ver los retornos de carro 
sin tanto lio como concatenando String """

println "Mira lo que puedo hacer ${2+2} simplemente con el dolar y las llaves"

def unaClosure = { param ->
    "${param}".reverse()
}

println unaClosure.call("una cadena")
println unaClosure.call(10)

def lista = [1, 3, 4, "Una cadena", new Date() ]
List otraLista = [1, 3, 4, "Una cadena", new Date() ]

def mapa = [ clave : "valor", otra_clave: "otro valor"]

lista.each{ println "it es un objeto de la lista $it"}
mapa.each{ println "it es un Map.Entry $it.key=$it.value" }

lista.eachWithIndex{ ele, idx ->    //<1>
    println "posicion $idx, elmenento $ele"
}

