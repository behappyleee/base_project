# Docker Image Deploy Project On AWS

## Project build to Docker Image

### 1. Docker Hub에 Login

### 2. Docker Hub 에 Login 후 Repository 를 생성

### 3. AWS 계정도 생성 (AWS Cloud 도 필요함)
    
### 4. Docker Image 생성하기
##### 간단한 도커 이미지를 생성 (/hello 입력 시 Hello This is AWS-DEPLOY 문자열 Return)

### 5. Dockerfile 을 작성
    FROM openjdk:17-jdk-alpine
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
    
- 만약 Java Version (Java Version 명시 하지 않을 시 기본 Home Jave 로 인식) 이랑 
- Gradle Vesrion 이랑 맞지 않아서 오류가 발생할 수 있다.
- 하면 Build 시 Java Version 명시 (해당 프로젝트 root directory 에서 build 명령어 실행)
- gradlew build -Dorg.gradle.java.home="{jdk 17 Directory 기입} ex)C:\Program Files\Java\jdk-17"

### 7. Docker Image Build 하기
    docker build -t {Image 이름 ex)reflectoring/aws-hello-world:latest} . 
    -t option: Name and optionally a tag in the name:tag format
    설정 한 Image 이름으로 docker image 가 생성이 됨, . 는 해당 Project root 에서 실행
    생성 된 이미지를 확인하고 싶을 시 docker images 를 입력 시 생성 된 Image 목록을 확인이 가능

### 8. Docker Run Test
    docker run -p 8081:8080 {Image 이름:태그명}
    -p option: we define that whatever is available on port 8080 within the container, 
    Docker will make available via the port 8081 on the host computer.

- 만약 Image 못 찾는 다고 하면 Image 명 오타 or docker login 시도 or {docker image 이름:태그명}
- 태그명 잘 기입해주었는 지 확인이 필요 !!
- 만약 docker run 할 시 Unable to find image Error 가 Response 시 docker login 해 주기 !
- 권한이 없어서 해당 ERROR 가 발생하는 것일 수 있음 (Error Message 자세히 확인이 필요)

### 9. After Dcoker Run
    Docker Run 시킨 후 해당 port 로 접속하여 잘 돌아가는 지 확인
    ex) localhost:8081/hello 로 접속 시 Hello This is AWS-DEPLOY 확인

- 만약 실행 중인 Docker Container 를 멈추고 싶으면 `docker stop {Docker stop [Container ID]}`
- Docker Container 를 다시 실행 시키고 싶으면 `docker start {Docker start [Container ID]}`

- 실행 중인 Docker Container 목록 확인 `docker ps`
- Docker Container 목록 전체 확인 `docker ps -a`

### 9. Docker Hub 에 Docker Image Push 하기
- *꼭 Docker Hub 에 Image 를 Push 를 하기 위하여서는 Image 명에 자신의 Docke Hub Name 을 포함 시켜야 함*
- *ex) {docker UserName}/{Docker Image Name}:{Docker Tag Name}*

#### Docker Hub Image Push 순서
1. CMD 창에서 Docker Hub 에 Login `docker login registry-1.docker.io` 후 UserName Password 입력
2. docker image push 하기 `docker push {docker UserName}/{docker Image Name}:{docker TagName}`
   (주의 할 점은 꼭 docker image 에 docker UserName 이 들어가야 함)
3. docker hub 실제로 로그인하여 Image 잘 Push 되었는 지 확인이 필요

<hr/>

## AWS Configuration to Deploy Docker Project

#### AWS 용어 개념

- ECS(Elastice Container Service): ECS is the “entry point” service that allows us to run Docker containers on AWS infrastructure. Under the hood, it uses a bunch of other AWS services to get things done.
- Task: A task is AWS domain language for a wrapper around one or more Docker containers. A task instance is what AWS considers an instance of our application.
- Service: A service wraps a task and provides security rules to control access and potentially load balancing rules to balance traffic across multiple task instances.
- Cluster: A cluster provides a network and scaling rules for the tasks of a service.

### 1. Docker Container 구성



