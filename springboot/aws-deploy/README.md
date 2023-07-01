# AWS Project Deploy

### 1. Docker Hub에 Login

### 2. Docker Hub 에 Login 후 Repository 를 생성

### 3. AWS 계정도 생성 (AWS Cloud 도 필요함)
    
### 4. Docker Image 생성하기
##### 간단한 도커 이미지를 생성 (/hello 입력 시 Hello This is AWS-DEPLOY 문자열 Return)

### 5. Dockerfile 을 작성
    FROM openjdk:8-jdk-alpine
    ARG JAR_FILE=build/libs/*.jar
    COPY ${JAR_FILE} app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]
    EXPOSE 8080

#### It starts with an Open JDK on top of a Linux alpine dsitribution
#### and takes the path to a JAR file as an argument
#### within its own filesystem and runs java - jar app.jar to starts the application.

### 6. Project Buil
    프로젝트 디렉토리에서 gradlew clean build 명령어 실행
    위에 명령어를 실행을 하고나면 build/lib/*.jar 파일이 생성이 된다.
    Dockerfile 에서 ${JAR_FILE} 을 설정하였으므로 default 로 생성된 jar 가 설정이됨    

### 7. Docker Image Build 하기
    docker build -t {Image 이름 ex)reflectoring/aws-hello-world:latest} . 
    -t option: Name and optionally a tag in the name:tag format
    설정 한 Image 이름으로 docker image 가 생성이 됨, . 는 해당 Project root 에서 실행
    생성 된 이미지를 확인하고 싶을 시 docker images 를 입력 시 생성 된 Image 목록을 확인이 가능

### 8. Docker Run Test
    docker run -p 8081:8080 {Image 이름}
    -p option: we define that whatever is available on port 8080 within the container, 
    Docker will make available via the port 8081 on the host computer.

