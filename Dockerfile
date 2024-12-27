FROM openjdk:17-jdk-slim
COPY target/service-0.0.1-SNAPSHOT.jar /

ENTRYPOINT ["java", "-jar", "/application-0.0.1-SNAPSHOT.jar"]