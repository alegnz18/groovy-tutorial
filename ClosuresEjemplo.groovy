
//CLOSURES
def unaClosure = { param ->
    "${param}".reverse()
}

println unaClosure.call("una cadena")
println unaClosure.call(10)

def nombre = 'Juan'
def imprimeNombre = { println "Mi nombre es $nombre"}
imprimeNombre()
nombre = "Yolanda"
imprimeNombre()

def imprimeNombre2 = { nombre2 -> println "Mi nombre es ${nombre2}"}
imprimeNombre2("Juan")
imprimeNombre2 "Yolanda" //Los paréntesis son opcionales

//Con múltiples parámetros
def quintetoInicial = { base, escolta, alero, alapivot, pivot -> 
    println "Quinteto inicial compuesto por: ${base}, ${escolta}, ${alero}, ${alapivot} y ${pivot}"}

quintetoInicial "Calderón", "Navarro", "Jiménez", "Garbajosa", "Pau Gasol"

def imprimeNombre3 = { println "Mi nombre es $it" }
imprimeNombre3("Juan")
imprimeNombre3 "Yolanda"
