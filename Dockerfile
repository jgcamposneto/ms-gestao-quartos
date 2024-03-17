FROM eclipse-temurin:21-jre-alpine
COPY target/gestao-quarto-0.0.1-SNAPSHOT.jar /app/gestao-quarto.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "gestao-quarto.jar"]