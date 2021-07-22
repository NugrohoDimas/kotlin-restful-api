FROM openjdk:12

COPY build/libs/kotlin-restful-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]