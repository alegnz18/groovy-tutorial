English? [Here](README.md)

# groovy-tutorial
Tutorial de Groovy usando la imagen de Docker Groovy oficial

(basado en [este tutorial](https://groovy-lang.gitlab.io/101-scripts/docker/basico.html) )

Groovy cuenta desde hace un tiempo con imágenes oficiales, una para cada versión de JDK disponible, lo que hace posible que se puedan ejecutar proyectos y scripts en este lenguaje dentro de un contenedor Docker, crear/extender imágenes, compartir volúmenes, etc.

## Pre-requisitos

Tener instalado Docker en tu sistema.
La(s) imagen(es) se pueden encontrar en el repo oficial de docker https://hub.docker.com/_/groovy/

```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
```

Detalles y configuración para otros SO [aquí](https://minikube.sigs.k8s.io/docs/start/).

El segundo requerimiento es la herramienta de línea de comandos para Kubernetes [kubeclt](https://kubernetes.io/docs/reference/kubectl/kubectl/). Para instalarla seguir los pasos que se ven [aquí](https://kubernetes.io/docs/tasks/tools/). Se puede evitar la instalación y delegarle a minikube la ejecución de kubectl. Por ejemplo en Linux se logra con un alias:

```bash
alias kubectl="minikube kubectl --"
```

Finalmente, necesitamos [Docker](https://www.docker.com/) para realizar el build y obtener una imagen que contenga nuestra aplicación de ejemplo. Detalles sobre la instalación [aquí](https://www.docker.com/get-started/)

## Empaquetar la app en un container

Dentro de este repo, en la carpeta [hello-node](hello-node/) vas a encontrar 2 archivos con el código suficiente para construir una app nodejs básica (package.json y server.js).

Antes de desplegar esta aplicación en nuestro "cluster" minikube debemos realizar un build para obtener un container que tenga la app y sus dependencias.

```bash
cd hello-node
docker build -t hello-node:1.0.0 .
cd ..
```

Esto generará un container local que podemos ver con `docker images`:

```console
# docker images
REPOSITORY   TAG       IMAGE ID       CREATED          SIZE
hello-node   1.0.0     f811a976efe9   10 minutes ago   122MB
```

## Levantar un clúster minikube

Sencillamente ejecutamos:

```console
# minikube start
...
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
```

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

