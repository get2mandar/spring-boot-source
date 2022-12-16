@ECHO OFF
:BEGIN
CLS

TITLE SB-SWAGGER3 - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-swagger3-0.1.jar


:END
pause