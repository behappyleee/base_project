FROM node

# WORKDIR 정하는 것은 자기가 원하는 것에 달려 있음
# 작업 디렉토리가 설정 되어있음
WORKDIR /app
# package.jso 을 작업 디렉토리에 복사
# COPY package.json /app 해당 처럼 작업 경로를 직접 명시도 가능
COPY package.json .
# package.json 에 설치 된 모든 dependency 들을 설치
RUN npm install

# 그 설정 후에 나머지 모든 소스를 복사 
# 첫번째 . 은 Dockerfile 이 있는 여기의 전체 폴더를 가르키는 . 과 두번째 . 작업 디렉토리를 나타내는 . 
COPY . .
# PORT 를 노출 시켜 줌
EXPOSE 80

# 명령어로 서버를 실행 Dockerfile Script 를 완성
CMD ["node", "server.js"]