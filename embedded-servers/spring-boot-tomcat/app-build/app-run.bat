@ECHO OFF
:BEGIN
CLS

TITLE SB-EMBEDDED-SERVER-TOMCAT - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-tomcat-0.1.jar


:END
pause