FROM openjdk
COPY ./target/app..jar /app/app..jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app..jar"]
EXPOSE 8080