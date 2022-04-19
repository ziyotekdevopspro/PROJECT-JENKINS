FROM openjdk:11
COPY . /home/app
WORKDIR /home/app
CMD ["java","project_app"]
