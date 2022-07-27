###APP FOR READING LOGS FROM FILE AND PUT OUT IN BROWSER

This app read logs from file, which is placed in directory logs.
You just have to determinate environment variable LOG_FILE, which is the name of the log file in logs directory.
#### Docker file is attached. You have to build package app with maven and use command "docker build --tag logsreader ."
#### For running image you should:
> bind volume /app/logs to your package with logs 

>mention environment variable LOG_FILE