# Docker Hub 에서 Python 을 가져옴
FROM python

WORKDIR /app

COPY . /app

# EXPOSE 는 안해주어도 됨 소스에서 port 노출 되는 곳이 하나도 없음 !

CMD ["python", "rng.py"]

# Docker 로 빌드 된 Image 를 실행 시 반드시
# -it 옵션 사용시 인풋과 아웃풋을 볼 수 있음
# docker run -it {imagename} 으로 실행하여야 입력값을 받을 수 있음
# start 로 재시작 시에는 docker start -a -i {containerName} 으로 시작함!


