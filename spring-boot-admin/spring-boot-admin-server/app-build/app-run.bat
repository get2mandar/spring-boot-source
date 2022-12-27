@ECHO OFF
:BEGIN
CLS

TITLE SB-ADMIN-SERVER - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-admin-server-0.1.jar


:END
pause