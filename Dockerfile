FROM openjdk:17-oracle
VOLUME /tmp
EXPOSE 8080
ADD target/springbot-application-image.jar springbot-application-image.jar
ENTRYPOINT ["java","-jar","/springbot-application-image.jar"]
