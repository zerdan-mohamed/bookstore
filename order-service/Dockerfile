FROM amazoncorretto:21

COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar

# ARG APP_NAME="order-service"
# LABEL version="0.0.1"

EXPOSE 8083

ENTRYPOINT ["java","-jar","/app.jar"]
