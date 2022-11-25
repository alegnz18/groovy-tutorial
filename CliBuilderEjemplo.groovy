def cli = new CliBuilder(usage: 'groovy DockerBasico.groovy -[had]')

cli.with { // <1>
     h(longOpt: 'ayuda', 'Informacion de uso \n', required: false)
     a(longOpt: 'Hola','Al seleccionar "a" te saludara ', required: false)
     d(longOpt: 'Perros', 'Genera imagenes de perros', required:false)
}

def options = cli.parse(args)

if (!options || options.h) {
    cli.usage
    println cli.usage
    return
}

//tag::hola[]
if (options.a) { 
    println "------------------------------------------------------------------"
    println "Hola!"
    System.getenv().each{
        println it
    }
    println "------------------------------------------------------------------"
}
//end::hola[]

//tag::perros[]
if( options.d){
    //JsonSlurper -> parsea texto a una estructura de lists y maps
   def json = new groovy.json.JsonSlurper().parse(new URL("https://dog.ceo/api/breed/hound/images/random") )
   if(json.status=='success'){
   new File('perro.jpg').bytes =  new URL(json.message).bytes
   }
}
//end::perros[]
