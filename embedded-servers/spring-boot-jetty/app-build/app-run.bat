@ECHO OFF
:BEGIN
CLS

TITLE SB-EMBEDDED-SERVER-JETTY - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-jetty-0.1.jar


:END
pause