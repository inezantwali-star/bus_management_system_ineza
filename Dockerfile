FROM openjdk:17

WORKDIR /app

COPY BusManagementSystem.jar app.jar

CMD ["java", "-jar", "app.jar"]