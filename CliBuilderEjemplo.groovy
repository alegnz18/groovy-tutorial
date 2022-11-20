def cli = new CliBuilder(usage: 'groovy DockerBasico.groovy -[had]')

cli.with { // <1>
     h(longOpt: 'help', 'Informacion de uso \n', required: false)
     a(longOpt: 'Hello','Al seleccionar "a" te saludara ', required: false)
     d(longOpt: 'Dogs', 'Genera imagenes de perros', required:false)
}

def options = cli.parse(args)

if (!options || options.h) {
    cli.usage
    println cli.usage
    return
}

//tag::hello[]
if (options.a) { 
    println "------------------------------------------------------------------"
    println "Hola!"
    System.getenv().each{
        println it
    }
    println "------------------------------------------------------------------"
}
//end::hello[]

//tag::dogs[]
if( options.d){
   def json = new groovy.json.JsonSlurper().parse(new URL("https://dog.ceo/api/breed/hound/images/random") )
   if(json.status=='success'){
   new File('perro.jpg').bytes =  new URL(json.message).bytes
   }
}
//end::dogs[]
