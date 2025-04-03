FROM openjdk:16
VOLUME /tmp
COPY target/eventzen_sah-1.0.jar eventzen_sah.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=compose", "eventzen_sah.jar"]