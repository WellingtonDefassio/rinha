FROM openjdk:17-alpine
VOLUME /tmp 
COPY target/rinha-0.0.1-SNAPSHOT.jar rinha-ms.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rinha-ms.jar"]