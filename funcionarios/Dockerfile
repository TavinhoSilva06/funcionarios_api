# Etapa 1 — Build da aplicação usando Maven diretamente
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o arquivo pom.xml e baixa dependências primeiro (para cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o restante do código e empacota
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2 — Imagem final leve com apenas o JAR
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Define variáveis de ambiente (o Render vai substituir automaticamente)
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_SHOW_SQL=true

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
