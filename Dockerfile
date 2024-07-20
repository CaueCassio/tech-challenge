FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/vehicle-sale-application.jar /app/vehicle-sale-application.jar

# Exponha a porta que o aplicativo usa
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "vehicle-sale-application.jar"]