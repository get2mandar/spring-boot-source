@ECHO OFF
:BEGIN
CLS

TITLE SB-EMBEDDED-SERVER-TOMCAT - JAR COMPILE and RUN

CD ..

CALL %MAVEN_HOME%\bin\mvn clean package -DskipTests

CD app-build

CALL app-run.bat

:END