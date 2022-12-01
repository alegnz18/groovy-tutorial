
println "\nCLOSURES"
println "\nCALL"
def unaClosure = { param ->
    "${param}".reverse()
}
println unaClosure.call("una cadena")
println unaClosure.call(10)

println "\nSIN PARAMETROS"
def nombre = 'Juan'
def imprimeNombre = { println "Mi nombre es $nombre"}
imprimeNombre()
nombre = "Yolanda"
imprimeNombre()

println "\nPARAMETRO IMPLICITO"
// asume param implicito it
def imprimeNombre3 = { println "Mi nombre es $it" }
imprimeNombre3("Juan")
imprimeNombre3 "Yolanda"

def imprimeNombre2 = { nombre2 -> println "Mi nombre es ${nombre2}"}
imprimeNombre2("Juan")
imprimeNombre2 "Yolanda" //Los paréntesis son opcionales

println "\nCON MULTIPLES PARAMETROS"
def quintetoInicial = { base, escolta, alero, alapivot, pivot -> 
    println "Quinteto inicial compuesto por: ${base}, ${escolta}, ${alero}, ${alapivot} y ${pivot}"}

quintetoInicial "Calderón", "Navarro", "Jiménez", "Garbajosa", "Pau Gasol"

println "\nITERANDO EN LISTAS"
/* Metodo collect, itera una lista y va ejecutando el closure para cada elemnento 
a medida y grabandolos en una segunda lista */
def lst = [1,2,3,4];
def nuevalst = [];
nuevalst = lst.collect {elemento -> return elemento * elemento}
println(lst);
println(nuevalst);

println "\nCLOSURES Y MAPAS"
//defino el mapa/diccionario
def dicc=['Fernando':31,'Veronica':27,'María':43,'Yezmin':26,'Horacio':15]
def suma=0
//defino el closure
def edadTotal={ x ->
x.each{
        suma+=it.value
        // println("obtener valor: "+it.value+ " obtener llave o identificador: "+it.key)
    }
println("Suma total de edades: "+suma)
}
//invoco el closure
edadTotal(dicc)