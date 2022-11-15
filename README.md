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
docker run --rm -it groovy:latest groovy //
```
En este momento estás ejecutando un contenedor de docker con groovy instalado y con todas las características de cualquier contenedor: network, volúmenes, incluirlo en un docker-compose, etc.

## Ejecución código Groovy desde línea de comando

En el siguiente ejemplo vamos a comprobar que el código se ejecuta en un contenedor:

```console
docker run --rm -e varprueba=test -it groovy:latest groovy -e "println System.getenv().each{println it}"
```

Si el comando se ejecuta correctamente deberías ver en consola las variables de entorno propias del contenedor incluida la que proporcionamos por argumento (varprueba). Por ejemplo HOSTNAME indicará el nombre que le ha asignado docker a tu imagen (y que no encontrarás después porque le hemos indicado con el argumento rm que la elimine al finalizar)


Minikube puede utilizar distintos drivers para resolver la virtualización necesaria para levantar el clúster. Por defecto, si Docker está instalado en el sistema, ulitiza ese driver. Si no funciona bien se pueden probar otras opciones, como por ejemplo VirtualBox (que debe estar instalado, por supuesto). En tal caso, el comando sería el siguiente:

```bash
minikube start --driver=virtualbox
```

Para ver que todo quedó funcionando bien:

```console
# minikube status
minikube
type: Control Plane
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Configured
```

También para verificar la instalación y contar con una UI web donde ver los recursos del clúster, podemos ejecutar lo siguiente:

