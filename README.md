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

De aquí en adelante será necesario tener descargados los scripts subidos al repo actual en un directorio local.
A continuación aprovecharemos la característica propia de Docker de permitirnos montar un directorio del host como si fuera propio del contenedor, de forma tal que este pueda leer/escribir en el mismo. Una vez finalizada la prueba eliminaremos el contenedor gracias al parámetro --rm.

Para ello nos descargamos el script /scripts//DockerBasico.groovy en un directorio de nuestra máquina y ejecutamos desde ese directorio:

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy tiposBasicos.groovy
```
Siguiendo la salida de este script podemos ver la forma de trabajar de Groovy con números, cadenas, closures, otros tipos de datos y el manejo de estructuras de control.

## Ejecución Script Groovy instanciando CliBuilder

```console
docker run --rm -v "$PWD":/home/groovy/scripts -w /home/groovy/scripts groovy:latest groovy cliBuilderEjemplo.groovy -d
```

Acá puede verse en acción CliBuilder, clase del package util Groovy que asiste en el procesamiento de los argumentos que se pasan por la línea de comando (permitiendo hacer que sean más explícitos).


```bash
minikube start --driver=virtualbox
```
