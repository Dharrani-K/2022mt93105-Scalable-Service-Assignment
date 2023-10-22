# Builder stage
FROM ubuntu:20.04 as builder
RUN apt-get update && apt-get install -y openjdk-17-jre
WORKDIR /source
ARG JAR_FILE=target/movie-service.jar
COPY ${JAR_FILE} movie-service-SNAPSHOT.jar
EXPOSE 8094
RUN java -Djarmode=layertools -jar movie-service-SNAPSHOT.jar extract

# Runtime stage
FROM ubuntu:20.04
RUN apt-get update && apt-get install -y openjdk-17-jre openssl procps
WORKDIR source
ARG env_var=dev
ENV var=$env_var
COPY --from=builder /source/movie-service-SNAPSHOT.jar ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
CMD ["--spring.config.location=/config/", "--spring.profiles.active=${var}"]

