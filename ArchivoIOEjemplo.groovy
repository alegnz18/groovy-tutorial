class ArchivoIOEjemplo { 

   static void main(String[] args) { 
      File file = new File("yourFile.txt");
      file.append('Linea 1');
      file.append('Linea 2');

      new File("yourFile.txt").eachLine {  
         line -> println "line : $line"; 
      } 

      // Mostrar el archivo como un string
      println(file.text);

      // Mostrar el tamaño del archivo
      println("File Size : ${file.length()} bytes");

      // Mostrar el tipo de elemento de que se trata
      println("File : ${file.isFile()}");
      println("Dir : ${file.isDirectory()}");

      // Copiar el archivo en otro archivo
      def newFile = new File("newFile.txt");
      newFile << file.text;

      // Borrar ambos archivos de pruebas
      newFile.delete();
      file.delete();
   } 
}

