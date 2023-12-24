import express from 'express';
import webSocket, { WebSocket } from 'ws';

const app = express();

app.use("/", function (req, res) {
    console.log('thisis tessst !')
    res.sendFile(__dirname + '/index.html');
})

app.listen(8080);

// Socket 을 8081 Port 로 하나 열어버림
// const socket = webSocket.Server({
//     port: 8081
// })
// const socket = new webSocket.Server({
//     port: 8081,
// })

// const socket = webSocket.Server({
//     port: 8081,
// })

const socket1 = new WebSocket().Server({
    port: 8081,
})

// const socket = new WebSocket().Server({
//     port: 8081,
// })
// const socket = new WebSocket.Server({
//     port: 8081
// })

// WebSocker Library 보다는 socket.io 같은 라이브러리들도 많이 사용 함
socket.on('connection', (ws, req) => {

    ws.on('message', (msg) => {
        console.log('USER 가 보낸 Message : ' + msg);
    })

    // WebSocket 을 이용해서 Server 가 User 에게 메세지를 보냄
    ws.send("THIS MESSAGE SEND FROM SERVER !")

})