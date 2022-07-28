###APP FOR READING LOGS FROM FILE AND PUT OUT IN BROWSER

This app read logs from file, which is placed in selected directory.
You just have to define environment variable LOGS_DIRECTORY (relative to project or absolute path). Default directory is "logs" in project directory.
#### Docker file is attached. You have to build package app with maven and use command "docker build --tag logsreader ."
#### For running image you should:
> bind volume /app/logs to your package with logs 

>define environment variable LOGS_DIRECTORY