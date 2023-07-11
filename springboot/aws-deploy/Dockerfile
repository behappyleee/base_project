FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# Dockerfile 에 EXPOSE 를 명시하였다고 하여 docker run -p 옵션을 사용하여 포트를 지정해주지 않을 시
# 컨테이너의 포트가 호스트 운영체제에 공개되지 않음
# 단 EXPOSE 만 사용하여 PORT 는 노출시키는 경우 호스트 내부에서만 접근이 가능
EXPOSE 8080