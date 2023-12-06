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

docker run --help 를 검색하여 인터랙티브 모드 인 -i 옵션을 확인
docker run -t 옵션은 TTY 옵션임
docker run -it 옵션을 사용 하면 컨테이너는 실제로 입력을 받는 입장이 됨 

- 사용하지 않는 Docker Container 제거 방법
- docker rm {container name} -> 실행 중인 컨테이너를 삭제할 수 없다하면
docker stop {container name} -> 컨테이너를 일단 실행 중지 시킴
- docker ps -a 검색 후 docker rm {container name} {container name} {container name} {container name} ===> 여러개 Container 삭제 가능
- docker ps -a 검색 후 컨테이너를 한번에 지우는 방법 -> docker images 검색 후 가진 이미지 모두 표시
- 크기의 대부분은 노드로 구성, 또 다른 이미지로 구축이 됨, Linux 운영 체제임 노드 이미지 빌드에 툴과 운영체제가 포함된 것임 이미지에 크기가 됨
- docker rmi {image name} {image name} ===> image 를 제거하기 위한 명령어 (이미지 내부의 모든 레이어를 삭제)
- 이미지 제거에 중요한 점은 더이 상 컨테이너에 사용되지 않고 컨테이너가 중지 된 경우에는 container 를 먼저 삭제 후 docker image 를 삭제가 가능
- 컨테이너가 시작 되거나 중지되더라도 image 삭제는 불가능
- docker image prune ==> 사용 되지 않는 모든 image 를 제거

- 실행 중이지 않는 Container 들 제거
- docker run -rm 옵션 컨테이너가 종료 될 때 자동적으로 제거 (매번 중지 된 컨테이너를 삭제할 필요가 없음)
- docker run -p 3000:80 -d --rm {image name} ===> detach 모드와 컨테이너가 사용되지 않을 때 바로 삭제하는 option 들
- 컨테이너를 중지하면 컨테이너가 삭제 가 됨 (-rm 옵션 사용 시)
- 특히 컨테이너에 이러한 노드 서버와 같은 것이 포함 된 경우면 코드가 변경 된 경우에만 컨테이너를 중지하는 경우가 많으며 이는 이미지를 다시 빌드 하여야 함
- 또 컨테이너를 재 빌드 해야 함 --rm 플래그로 컨테이너를 실행하여 컨테이너가 중지 되었을 때 자동으로 삭제가 가능 (docker run --rm 옵션 사용 시)

- Image 에는 코드와 환경이 포함 되어 있어 Image 크기가 꽤 큼
- 실행 중인 컨테이너는 실제로 그렇게 크지 않고 명령 레이어가 이기지 위에 추가 된 얇은 부가 레이어임
- 컨테이너는 이미지를 기반으로 실행이 됨 여러 컨테이너는 이미지 내부 코드를 공유하게 됨
- docker image inspect {image name} 추가 시 image 에 대한 정보가 출력이 가능 (모든 정보 확인이 가능, 만들어진 시간 entry point, 실행 중인 컨테이너 등 확인이 가능)
- docker image inspect 명령어로 os 까지 확인이 가능

- 컨테이너를 살펴보고 싶거나 컨테이너에 무건가를 추가하거나 컨테이너가 무언가를 추출하고 싶을 떄 docker cp (copy) 명령어 사용
- 실행 중인 컨테이너로 또는 실행 중인 컨테이너 밖으로 파일 또는 폴더를 복사
- docker cp 명령어 사용시에는 절대 경로나 해당 directory 로 이동하여 docker cp 를 시도하여야 함
- docker cp 경로\. (하면 해당 디렉토리에 모든 파일이 복사가 됨) 
- docker cp dummy\. {another container name}:/test (다른 컨테이너 경로 지정 만약 지정 한 경로에 디렉토리가 없을 시 새로 생성 됨) ===> 다른 컨테이너로 파일이 복사 됨

- docker cp dummy\test.txt focused_sammet:\test 하면 해당 Container 에 파일이 복사 가 됨 (만약 test 경로가 존재하지 않을 시 test 경로를 새로 만듦)

>docker cp focused_sammet:\test dummy ===> 현재 해당 경로 Local dummy 에 복사가 됨 !
Successfully copied 2.05kB to C:\Users\Chul Han\Desktop\workspace\study\base_project\docker\sample-project\python\dummy

- 파일을 복사하는 것은 좋은 해결책은 아님 -> 더 나은 방법들이 존재
- Docker Container 에서 파일을 복사하는 것은 꽤 흥미로움 -> 꽤 많은 양의 Log 파일들을 로컬로 복사해서 확인이 가능




































































