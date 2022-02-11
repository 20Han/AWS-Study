`[강의링크](https://opentutorials.org/course/2717/11273)

# 1. 소개
- Instance : 컴퓨터 한 대가 인스턴스 하나.


# 2. EC2 인스턴스 타입
- vCPU : aws에서 자체적으로 cpu성능을 측정하여 수치화 한 것
- Type : m으로 시작하면 메모리상 우위, c는 cpu, g = gpu


# 3. 가격정책
- 온 디맨드 인스턴스 : 필요에 따라 켜고 킬수 있는 인스턴스
- 예약 인스턴스 : 할인권이 적용된 인스턴스
- 스팟 인스턴스 : 사용되지 않는 인스턴스를 입찰하는 방식


# 4. 태그와 보안그룹
- 태그 : 인스턴스에 대한 정보 메모(name, manager ...)
- Configure Security Group : 네트워크를 통해 누가 접근할 수 있는지 설정


# 5. AWS MarketPlace
- 앱스토어에서 앱을 다운받듯이 다른 사람이 만든 서버를 사용 가능


# 6. Scalability - Scale Up
- ELB : 여러 컴퓨터를 병렬로 연결 -> 로드 밸런서
- Auto Scailing : 자동으로 ELB를 생성
- scalability : 수요에 따라 운영 서버의 컴퓨터 수를 동적으로 변화시킴
- Elastic IPs
서버를 stop했다가 다시 켜면 IP가 바뀜. 즉 IP로 접근할때마다 주소가 바뀌는 것. 
IP는 한정되어있기 때문에 AWS에서 종료된 서버의 IP를 회수해서 다른 필요한 서버에 할당
엘라스틱 IP는 위와 같은 이유로 AWS에서 할당해주는 고정 IP 
- 인스턴스 교체
1. 교체하고자 하는 인스턴스의 이미지를 만든다
2. 이미지 통해 어떤 부분(CPU, DB ...)이 부족한지 확인하고 instance type 결정 및 생성
3. 기존 서버의 elastic Ip를 교체된 서버에 할당


# 7. Scalability - Scale Out
- Scale Out : 여러 컴퓨터를 연결하여 동작하게 하는 것
- Scale Out 흐름 : 한 컴퓨터에서 진행하던 일을 여러 컴퓨터로 분산
- Load Balancer(ELB) : 여러 Web Server로 리다이렉팅 시킬때 각 Web server에 비슷한 수준으로 접근이 일어나도록 분산시켜주는 것.  
- Health Check : Web Server가 사용가능한 상태인지 ELB가 계속 체크


# 8. Auto Scaling
- 인스턴스를 만들어서 로드 밸런서에 붙이거나 제거하는 작업을 자동으로 할 수 있도록 함.
- launch : 이미지를 인스턴스로 만드는 동작
- launch configuration : 인스턴스를 만들 때 어떤 이미지와 어떤 타입을 통해 만들지 설정하는 부분
- AutoScaling Group : 오토스케일링에 사용할 로드밸런서 및 설정을 지정
- Cloud Watch : AWS서비스를 감시할 수 있는 부분
