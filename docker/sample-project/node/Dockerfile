# Container 내부에서 NodeJS 이미지를 사용이 가능
FROM node:20

# 컨테이너 파일 시스템 내에는 특정한 디렉토리가 있음
WORKDIR /app

# package.json 파일을 작업 디렉토리에 복사
COPY package.json .

# 그 다음 npm 명령어를 사용하여 필요한 모든 종속성을 설치
RUN npm install

# 그런 다음 나머지 코드를 여기에 복사
COPY . .

# PORT 를 노출 (app 에서 listen 을 하고 있는 port 이기에 exposed 시켜 줌)
# NodeJS 앱은 포트 3000 에서 들어오는 요청을 수신대기하는 웹 서버를 생성 해 줌
# 생성 된 Image 를 실행 실제로 여기에 있는 컨테이너에는 통신하려는 포트가 있음
# 실제로 실행 하려는 컨테이너에 해당 포트를 publish 해야 함 -p 옵션 사용
EXPOSE 3000

# Node 명렁으로 app.js 를 실행 시켜 줌 node 환경에서 노출 되어서 해당 명령어 실행이 가능
CMD ["node", "app.js"]

# DOcker build . 명령어 입력 시 Dockerfile 을 찾아 실행하게 됨 Dockerfile 을 기반으로 이미지를 빌드하게 됨
# 터미널에서 docker build . 명령어를 입력하여 Docker Image 를 Build


