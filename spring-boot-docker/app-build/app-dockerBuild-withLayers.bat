@ECHO OFF
:BEGIN
CLS

TITLE SB-DOCKER - DOCKER COMMAND BUILD - WITH LAYERS DOCKER FILE

CD ..

CALL docker build -f DockerfileMultiStage -t sbdocker-layers:v1 .

:END
pause