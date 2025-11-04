FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/funcionarios-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db.kodepzsxnmgzqzszqoja.supabase.co:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=Funcionarios
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
