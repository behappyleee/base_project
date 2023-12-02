// 매우 간단한 NodeJS 프로젝트
// Docker 로 실행
// 모든 프로젝트 및 어플리케이션에서 Docker 를 실행이 가능
// Docker 없이 실행 하려면 Local 에서 Node 를 다운 받은 후 실행을하여야 함 !
// 하지만 Docker 를 사용하면 코드를 컨테이너에서 실행하면 컨테이너는 항상 이미지 기반이라
// Image 생성을 위해서 Dockerfile 을 생성 후 DockerScript 를 기입

const express = require('express');
const connectToDataBase = require('./helpers.js')

const app = express()

app.get('/', (req, res) => {
    res.send('<h1>Hello Docker and Node World !</h1>')
});

// 비동기 코드로 작동하는 NodeJS 기능으며 14.3 버전 이상에서 작동
// Error 발생하여 일단 주석 처리 !
// await connectToDataBase();

// Port Number 3000 으로 시작
app.listen(3000);