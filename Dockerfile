FROM openjdk:8-jdk-alpine
COPY "./target/neoris-1.0-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
# Ejecuta el archivo jar
ENTRYPOINT ["java","-jar","app.jar"]

