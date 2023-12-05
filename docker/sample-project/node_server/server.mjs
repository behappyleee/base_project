import express from 'express';
import bodyParser from 'body-parser';

// Image 와 Container 구성
// 모든 도커 명령에 --help 를 추가하면 모든 옵션 확인이 가능
// 컨테이너 중지 재 시작
// 이미지와 컨테이너 관리

const app = express();

let userGoal = 'Learn Docker!';

app.use(
  bodyParser.urlencoded({
    extended: false,
  })
);

app.use(express.static('public'));

app.get('/', (req, res) => { 
  res.send(`
    <html>
      <head>
        <link rel="stylesheet" href="styles.css">
      </head>
      <body>
        <section>
          <h2>My Course Goal Hello Docker World !!!!! T2</h2>
          <h3>This is DOcker !!!</h3>
          <h3>Testing for Docker Cache Test !!</h3>
          <h3 id="setGoadId">${userGoal}</h3>
        </section>
        <form action="/store-goal" method="POST">
          <div class="form-control">
            <label>Course Goal</label>
            <input type="text" name="goal">
          </div>
          <button>Set Course Goal</button>
        </form>
      </body>
    </html>
  `);
});

app.post('/store-goal', (req, res) => {
  const enteredGoal = req.body.goal;
  console.log('this is new image from docker : ' + enteredGoal);
  userGoal = enteredGoal;
  res.redirect('/');
});

app.listen(80);

// Image 는 Layer 기반 이미지를 다시 빌드 시 변경 된 부분의 명령과 그 이후의 모든 명령이 재 평가 됨
// Image 를 Build 시 Using cache 라는 메세지 확인이 가능 도커는 모든 명령 결과를 캐시
// Image 를 다시 build 하지 않는 한 Image 는 바뀌지 않음 Image 는 Read-only 임
// Image 는 Layer 기반이므로 모든 Layer 를 Caching 이 가능, 하나의 레이어가 변경 될 때마다 다른 모든 Layer 가 재빌드 됨
// 즉 한 Layer 가 변경 될 때마다 다른 Layer 도 실행이 됨
// Docker 는 다시 실행 되어야 할 항목만 빌드 하여 속도를 높음
// ex caching 시 다시 빌드시 package.json 이 변경 되지 않았으면 npm install 을 재실행 하지 않아도 됨 (Cache 를 하므로 .. 훨씬 속도가 빠름)

