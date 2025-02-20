FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/ReceiptProcessor-1.0-SNAPSHOT.jar ReceiptProcessor-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ReceiptProcessor-1.0-SNAPSHOT.jar"]