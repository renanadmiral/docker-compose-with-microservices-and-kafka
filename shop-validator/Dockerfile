FROM amazoncorretto:11-alpine

COPY target/shop-validator-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8081
