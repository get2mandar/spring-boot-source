@ECHO OFF
:BEGIN
CLS

TITLE SB-ADMIN-CLIENT - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-admin-client-0.1.jar


:END
pause