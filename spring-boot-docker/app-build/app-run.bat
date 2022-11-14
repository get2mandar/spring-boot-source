@ECHO OFF
:BEGIN
CLS

TITLE SB-DOCKER - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-docker-0.1.jar

:END
pause