FROM java:8
COPY . /home/app
WORKDIR /home/app
CMD ["java","project_app"]
