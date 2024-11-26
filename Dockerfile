FROM gradle:8.7-jdk-21-and-22-alpine AS base
COPY build.gradle settings.gradle /build/
COPY gradle /build/gradle
WORKDIR /build
RUN gradle --no-daemon dependencies


FROM base AS build
COPY . /build
WORKDIR /build
RUN gradle --no-daemon clean build

FROM eclipse-temurin:22-jre AS production
WORKDIR /srv
COPY --from=build /build/build/libs/*jar ./app.jar
CMD ["java", "-jar", "./app.jar"]