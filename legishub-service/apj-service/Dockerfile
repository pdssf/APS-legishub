FROM gradle:7.5.1-jdk17 as builder
WORKDIR /project
COPY . /project/
RUN gradle build --no-daemon

FROM openjdk:17-slim
EXPOSE 8081
COPY --from=builder /project/build/libs/*T.jar server.jar
ENTRYPOINT ["java", "-jar", "server.jar"]
