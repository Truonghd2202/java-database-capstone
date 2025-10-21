# Dockerfile giả lập chạy ứng dụng Java thuần
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN javac src/com/project/back_end/controllers/Main.java
CMD ["java", "com.project.back_end.controllers.Main"]
