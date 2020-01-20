FROM gradle:5.0-jdk8-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/loyalty-0.1.jar .
CMD ["java", "-jar", "loyalty-0.1.jar"]