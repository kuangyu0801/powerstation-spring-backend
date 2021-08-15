FROM openjdk:8-jdk-alpine

# Add new user to prevent application run as root
RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t kuangyu0801/powerstation-spring-backend .
# makre sure container runs in the same network as mysql (assume power-net)
# docker run --network power-net -d -p 8080:8080 kuangyu0801/powerstation-spring-backend