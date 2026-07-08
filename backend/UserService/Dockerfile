FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/UserService-0.0.1-SNAPSHOT.jar app.jar

#RUN command

EXPOSE 8081

#ENV key=value

ENTRYPOINT [ "java", "-jar", "app.jar" ]

#FROM → WORKDIR → COPY → RUN → EXPOSE → ENV → ENTRYPOINT