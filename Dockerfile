FROM eclipse-temurin:18-jdk
CMD ["./gradlew", "clean", "build"]
ARG JAR_FILE_PATH=build/libs/elasticsearch-api.war
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["nohup", "java", "-jar", "app.jar", "2>&1", "&"]