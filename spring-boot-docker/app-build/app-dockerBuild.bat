@ECHO OFF
:BEGIN
CLS

TITLE SB-DOCKER - DOCKER COMMAND BUILD

CD ..

CALL docker build -t sbdocker:v1 .

:END
pause