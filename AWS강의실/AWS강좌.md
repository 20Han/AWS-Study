# 6. VPC(1) : Virtual Private Cloud
* VPC
    * 가상 네트워크 센터, 컴퓨터를 사용하기 위한 네트워크를 구성하는 것. 서브넷, IP 주소 할당 등 네트워크 영역 총괄. 나만의 작은 데이터 센터
* 종류
    * Default VPC : 계정 생성시 자동으로 셋업 되어 있는 VPC. 
        * 모든 서브넷의 인테넷 접근이 가능. 
        * EC가 퍼블릭 IP와 private IP모두 가지고 있다
        * 삭제시 복구 불가
    * Custom VPC
        * 새로 만들어야 하는 VPC
        * Default VPC의 특징을 가지고 있지 않다
        
* VPC로 할 수 있는 일
    * 기본 : EC2 실행, 서브넷 구성, 보안 설정(Ip block, 인터넷에 노출되지 않는 EC2 구성)
    * VPC peering : 다른 VPC에 존재하는 EC2간 연결, 그러나 Transitive Peering(한다리 건너 연결)은 불가능하다.
    * VPC Flow Log :cloudwatch에 VPC로그 저장 가능
    * 다른 리전으로 확장은 불가능

* VPC의 구성요소
    * AZ(Availablity Zone)
    * Subnet : VPC의 하위 단위로 하나의 AZ에서 생성이 가능하며 다른 AZ로 확장이 안된다. 하나의 AZ안에는 여러 서브넷이 존재할 수 있다
        * private subnet : 인터넷 접근이 불가능한 서브넷
        * public subnet : 인터넷 접근이 가능한 서브넷
        * CIDR block range 설정 가능 : IP주소를 분배하는 방법
    * Internet Gateway(IGW) : 인터넷으로 나가는 통로, IGW와 연결되지 않은 서브넷이 private subnet이 된다. vpc에 할당 가능한 igw는 하나
    * NACL/Security Group : NACL은 statless, SG는 stateful. NACL은 보통 subnet이전에서 작동하는 보안 관련 설정, SG는 서브넷 내부에서 작동하는 설정. VPC 생성시 기본으로 만들어짐
    * Route Table : 트래픽이 어디로 가야하는지 알려주는 이정표. VPC 생성시 기본으로 만들어진다.
        
