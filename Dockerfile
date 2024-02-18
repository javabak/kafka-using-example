FROM openjdk:17
COPY target/demo-0.0.1-SNAPSHOT.jar kafka.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kafka.jar"]
