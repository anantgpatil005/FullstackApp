FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/RatingService-0.0.1-SNAPSHOT.jar app.jar

#RUN command

EXPOSE 8083

#ENV key=value

ENTRYPOINT [ "java", "-jar", "app.jar" ]

#FROM → WORKDIR → COPY → RUN → EXPOSE → ENV → ENTRYPOINT