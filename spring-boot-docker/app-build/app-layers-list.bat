@ECHO OFF
:BEGIN
CLS

TITLE SB-DOCKER RUN

CALL %JAVA_HOME%\bin\java -Djarmode=layertools -jar -XX:+UseSerialGC -Xss512k ..\target\spring-boot-docker-0.1.jar list

:END
pause