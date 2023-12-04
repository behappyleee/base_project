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

