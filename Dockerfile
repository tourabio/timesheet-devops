FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/timesheet-1.0-SNAPSHOT.jar timesheetdevops.jar
ENTRYPOINT ["java","-jar","/timesheetdevops.jar"]
