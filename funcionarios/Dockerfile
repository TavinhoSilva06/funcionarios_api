# Etapa 1 — Build da aplicação com Maven
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copia o projeto
COPY . .

# Dá permissão de execução ao mvnw (preciso em Linux)
RUN chmod +x mvnw

# Compila e empacota a aplicação (sem rodar testes)
RUN ./mvnw clean package -DskipTests


# Etapa 2 — Imagem final e mais leve para produção
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=build /app/target/funcionarios-0.0.1-SNAPSHOT.jar app.jar

# Variáveis de ambiente (Render pode sobrescrever essas automaticamente)
ENV SPRING_APPLICATION_NAME=funcionarios
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db.kodepzsxnmgzqzszqoja.supabase.co:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=Funcionarios
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ENV SPRING_JPA_SHOW_SQL=true

# Porta padrão da aplicação
EXPOSE 8080

# Comando para iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
