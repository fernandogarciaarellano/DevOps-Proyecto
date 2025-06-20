FROM maven:3.8.4-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM amazoncorretto:17-alpine-full
COPY --from=build /app/microservicio-web/target/microservicio-web-1.0-SNAPSHOT.jar microservicio-web.jar
EXPOSE 8080
CMD ["java", "-jar", "microservicio-web.jar"]