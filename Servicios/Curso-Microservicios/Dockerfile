FROM maven:3.8.5-jdk-11 as builder
WORKDIR /
COPY . .
RUN ["mvn", "clean", "install"]

FROM amazoncorretto
ARG JAR_FILE=microservicio-web/target/*.jar
COPY --from=builder  ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]