FROM openjdk:17.0.1-jdk-oracle
COPY ./target .
CMD ["java", "-jar", "foggy-0.0.2-SNAPSHOT.jar"]