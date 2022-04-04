FROM openjdk:11
ADD person.jar person.jar
EXPOSE 8000
CMD ["java", "-jar", "/person.jar"]