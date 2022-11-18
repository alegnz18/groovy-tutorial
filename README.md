English? [Here](README.md)

# groovy-tutorial
Tutorial de Groovy usando la imagen de Docker Groovy oficial

(basado en [este tutorial](https://groovy-lang.gitlab.io/101-scripts/docker/basico.html) )

## Pre-requisitos

Groovy cuenta desde hace un tiempo con imágenes oficiales, una para cada versión de JDK disponible, lo que hace posible que se puedan ejecutar proyectos y scripts en este lenguaje dentro de un contenedor Docker, crear/extender imágenes, compartir volúmenes, etc.

Tener instalado Docker en tu sistema.
Las imágenes se pueden encontrar en el repo oficial de docker https://hub.docker.com/_/groovy/


Detalles y configuración para otros SO [aquí](https://minikube.sigs.k8s.io/docs/start/).

## GroovyShell

En su forma más simple el ejecutar un contenedor con cualquiera de estas imágenes nos iniciará una shell de Groovy como para trabajar ahí dentro.

```console
docker run --rm -it groovy:latest groovy
```
En este momento estás ejecutando un contenedor de docker con groovy instalado y con todas las características de cualquier contenedor: network, volúmenes, incluirlo en un docker-compose, etc.

## Ejecución código Groovy desde línea de comando

En el siguiente ejemplo vamos a comprobar que el código se ejecuta en un contenedor:

```console
docker run --rm -e varprueba=test -it groovy:latest groovy -e "println System.getenv().each{println it}"
```

Si el comando se ejecuta correctamente deberías ver en consola las variables de entorno propias del contenedor incluida la que proporcionamos por argumento (varprueba). Por ejemplo HOSTNAME indicará el nombre que le ha asignado docker a tu imagen (y que no encontrarás después porque le hemos indicado con el argumento rm que la elimine al finalizar)

## Ejecución Script Groovy básico

Una de las características propias de Docker es permitirte montar un directorio del host como si fuera propio del contenedor, de tal forma que pueda leer/escribir en el mismo. Una vez finalizada la prueba eliminaremos el contenedor.

De aquí en adelante será necesario tener descargados los scripts subidos al repo actual en un directorio local; en este primero caso, TiposBasicos.groovy

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy TiposBasicos.groovy
```
Siguiendo la salida de este script podemos ver la forma de trabajar de Groovy con números, cadenas, closures, otros tipos de datos y el manejo de estructuras de control.

## Ejecución Script Groovy  - Declaración de Closures

Script con diferentes ejemplos de Closures y sus invocaciones.

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy ClosuresEjemplo.groovy
```

## Ejecución Script Groovy instanciando CliBuilder

Acá puede verse en acción CliBuilder, clase del package util Groovy que asiste en el procesamiento de los argumentos que se pasan por la línea de comando (permitiendo hacer que sean más explícitos).

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy CliBuilderEjemplo.groovy -d
```

## Compilación de Clase Groovy

En caso de necesitar compilar nuestros programas Groovy, utilizaremos una sentencia en línea decomandos llamada groovyc.
En este ejemplo vamos a compilar la clase Animal (archivo Animal.groovy).

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovyc -d classes Animal.groovy 
```
El parámetro -d le indica a groovyc que debe crear un nuevo directorio donde alojar el/los ejecutable/s.
El número de archivos generados dependerá del contenido del propio script, de la misma forma que sucede cuando
compilamos un archivo en Java, en este caso será solo uno de nombre Animal.class

## Instanciando clases en un script

El próximo script instancia una serie de clases y muestra las relaciones de herencia entre las mismas y la forma de implementar interfases.

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy POOEjemplo.groovy
```

## Getters y setters con una particularidad

El próximo script instancia una clase cuya declaración está incluída dentro del mismo archivo y en donde la misma clase duplica el valor de su única
propiedad cuando se invoca por los métodos tradicionales (bien mediante el método get o mediante el operador ..

muestra que es posible cambiar el comportamiento del método get y asimismo acceder al valor original de la variable.

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy DobleValorEjemplo.groovy
```
Para permitirnos recuperar el valor original de la propiedad vemos que Groovy introduce el operador .@


