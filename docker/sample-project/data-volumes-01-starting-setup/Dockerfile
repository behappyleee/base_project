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

# Docker 에 Volume 을 추가하는 가장 쉬운 방법
# Container 파일 내부 경로에 데이턱 ㅏ존재
# 현재 파일 경로에서 feedback 이 영구적으로 저장이 되는 경로이고
# Temp 는 일시적으로 저장이 되는 경로
# WORKDIR 인 /app 아래 /feedback 디렉토리가 영구 저장되는 디렉토리 (Container 내부 경로)
# Container 외부에 Mapping 이 될  Container 내부 경로
VOLUME [ "/app/feedback" ]

# 명령어로 서버를 실행 Dockerfile Script 를 완성
CMD ["node", "server.js"]