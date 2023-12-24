## NodeJS 의 예제
### 일반적인 간단한 어플리케이션
### 노드 서버 안에는 몇개의 경로와 몇 개의 요청을 처리하는 로직이 있음

## Dockerized 화 하기
### 1. Dockerfile Script 작성
### 2. Dockerfile 이 작성이 완료 되었으면 Docker Image build 하기
### 3. docker build -t feedback-node . (Docker Image 생성하는 명령어)
### 4. docker image 를 build 후 docker container 를 실행 시켜 줌
### 5. docker run -p 3000:80 -d --name feedbaack-app --rm feedback-node (docker image 인 feedback-node 를 실행 하며 port 를 3000 번과 docker 내부 포트인 80 번을 맵핑 시켜 줌, -d 옵션은 Terminal 을 바로 사용 할 수 있게 detach mode 로 docker container 를 RUN 함, --name 은 Container Name 을 지정, --rm 옵션은 컨테이너가 중지 될 시 Container 를 바로 자동으로 제거가 됨)
### 6. 컨테이너와 로컬 이미지와는 어떤 연결점도 없음
### 7. 