FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/ApiGateway-0.0.1-SNAPSHOT.jar app.jar

#RUN command

EXPOSE 8085

#ENV key=value

ENTRYPOINT [ "java", "-jar", "app.jar" ]

#FROM → WORKDIR → COPY → RUN → EXPOSE → ENV → ENTRYPOINT