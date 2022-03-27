FROM openjdk:11
WORKDIR /app
ADD ./target/minha-saude-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "minha-saude-0.0.1-SNAPSHOT.jar"]
