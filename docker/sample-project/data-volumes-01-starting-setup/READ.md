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
### 7. A container is based on Image
### 8. 컨테이너를 제거 하지 않고 중지만 하면 컨테이너 안 데이터는 손실되지않지만 컨테이너를 제거하면
### 컨테이너 내부에 데이터는 삭제가 됨
### 9. Docker 의 핵심 개념은 동일한 이미지의 다수 컨테이너가 완전히 격리되는 것
### 10. Docker 에는 Volume 이라는 내장 볼륨이 있음, Volume 은 host 머신의 폴더임
### 11. Volume 은 Host Machine Hard Drive 에 연결이 되며 mounted("made available" mapped) into containers.
### 12. 볼륨을 통해 데이터 유지가 가능
### 13. 컨테이너에 볼륨을 추가하는 경우 볼륨은 제거되지 않고 유지가 됨
### 14. 컨테이너는 볼륨에 데이터를 읽고 쓸수가 있음
### 15. 데이터가 외부에서도 존재하면 컨테이너가 제거되어도 데이터는 계속 존재 함
### 16. 