Docker Image (Dissolber / BluePrint)
- Image 실제로 코드와 코드를 실행하는데 필요한 도구를 포함
- Image 에는 코드 설정 여러 것들이 포함 됨

Docker Container (실행 어플리케이션)
- 이미지의 구체적인 실행 인스턴스
- 이미지를 기반으로 하는 컨테이너를 실행
- 컨테이너는 실행 이미지의 인스턴스 같은 개념임

CMD
docker run -it node -> 도커에게 컨테이너 내부에서 호스팅 머신으로 대화형 Session 을 열어줌

Image 는 Container 이 Blue Print 같은 개념
Docker 는 궁금적으로 Container 임
이미지에 기반한 여러 컨테이너 실행이 가능, Container 는 이미지위에 얅은 Layer 같은 개념임
컨테이너가 이미지에서 코드와 환경을 새 컨테이너로 복사학거나 새 파일로 복사하지는 않는 것임
컨테이너는 이미지에 저장 된 환경을 사용
코드와 노드 환경은 하나의 이미지와 2개의 컨테이너가 존재 시 

## Docker CMD 모음
docker {명령어} --help -> Docker 에 명령어에 관한 help 를 받을 수 있음
docker ps -> docker 에서 실행 중인 모든 Container 확인이 가능
docker ps -a -> 과거에 실행하였던 모든 컨테이너 리스트들까지 확인이 가능 (중지한 컨테이너 까지 확인이 가능)
docker run -> 이미지를 기반으로 새 컨테이너를 만들고 새 컨테이너를 만듦, 이미지가 변경 된 경우 다시 새 컨테이너를 만들필요 없음
docker ps -a 검색 후 이전 Container 를 확인 후 docker start {docker name} 으로 시작 시 컨테이너를 새로 만들지 않고 시작이 가능

docker start (default - dettached mode) 와 docker run (attached mode) 은 엄연히 다른 것임
터미널의 실행 중인 docker 와 더 이상 연결되지 않음 (docker start 로 시작 시 바로 background 로 실행이 됨)
docker run 은 바로 foregrond 에서 실행이 되지만 docker start 로 실행 시 바로 docker 가 background 로 실행이 됨
docker run -d {image Id} 사용 시 dettached mode 가 실행이 됨

attached Mode / dettached Mode 

docker logs --help 사용 시 docker log 추적이 가능해짐
docker logs -f {Container Name} -> 해당 명령어 사용 시 Container Log 추적이 가능 해짐






























































