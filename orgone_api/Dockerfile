FROM openjdk:11-jre-slim-buster

COPY build/libs/demo-*-all.jar demo_application.jar

EXPOSE 8080

CMD ["java", "-jar", "demo_application.jar"]