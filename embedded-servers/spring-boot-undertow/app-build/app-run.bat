@ECHO OFF
:BEGIN
CLS

TITLE SB-EMBEDDED-SERVER-UNDERTOW - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-undertow-0.1.jar


:END
pause