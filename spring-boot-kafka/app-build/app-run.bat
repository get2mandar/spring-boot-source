@ECHO OFF
:BEGIN
CLS

TITLE SB-KAFKA - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-kafka-0.1.jar


:END
pause