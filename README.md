# El proyecto esta compilando con una version java 1.8  con maven compilar y descargar dependencias.

# Base de datos.
-Se manejo una base de datos relacional postgres
-Ejecutar el archivo BaseDatos.sql en secuencia.

# Postman.
-Los endpoint a probar se encuentran en el archivo Neoris.postman_collection.json descargar y importar en postman

# Docker
Se crea un archivo dockerfile y docker-compose
1.Para ejecutar el docker en el proyecto se recomienda posicionarce dentro de la carpeta raiz del proyecto desde una termina cmd o powershell
2.revisar que el proyecto genere el .jar en la carpeta target
3.ejecutar el siguiente comando  docker-compose up --build
