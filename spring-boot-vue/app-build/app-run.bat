@ECHO OFF
:BEGIN
CLS

TITLE SB-VUE - JAR RUN

CD ..

CALL %JAVA_HOME%\bin\java -jar -XX:+UseSerialGC -Xss512k target\spring-boot-vue-0.1.jar


:END
pause