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
    
# 7. RDS
* RDS의 특징
    * 관계형 데이터베이스 (DynamaDB와 같은 NoSql과 구분된다)
    * 가상 머신 위에서 동작. 직접 시스템에 로그인 불가능. 따라서 OS 패치, 관리 등은 AWS의 역할이 된다.
    * RDS는 Serverless 서비스가 아니다.
    * CloudWatch와 연동된다. DB인스턴스의 모니터링, DB에서 발생하는 여러 로그 등을 cloud watch와 연동하여 확인할 수 있다
    * 내부에서는 EC2활용. public IP를 기본적으로 부여하지 않아 외부에서 접근이 불가능하다. 또한 서브넷과 보안그룹 지정이 필요하다. 
    * 스토리지는 EBS를 활용. 타입과 EBS의 용량을 지정해서 생성해야 한다. 
    * Parameter Group : Root유저만 설정 가능한 DB의 설정값들을 모아 그룹화한 개념

* RDS 인증방법
    * 전통적인 유저/패스워드 방식 : AWS Secret Manager와 연동하여 자동 로테이션 가능
    * IAM DB 인증 : IAM 기반으로 관리
    * Kerberos 인증
    
* RDS 가격 모델
    * 컴퓨팅 파워 + 스토리지 용량 + 백업 용량 + 네트워크 비용
    * Reserved Instance 구매 가능 : EC2와 마찬가지로 일정 기간을 계약하여 저렴한 가격에 서비스 이용
    
* RDS의 백업
    * 자동 백업
        * 매일 마다 스냅샷을 만들고 트렌젝션 로그를 저장
        * 데이터는 S3에 저장되며 db의 크기 만큼 공간 점유
        * 저장된 데이터를 바탕으로 일정 기간 내의 특정시간으로 롤백 가능
        * 1~35일 보관 지원
    * 수동 백업(DB스냅샷)
        * 유저, 혹은 다른 프로세스로 부터 요청에 따라 만들어지는 스냅샷
        * DB가 삭제된 이후에도 계속 보관
        * 스냅샷의 복구는 항상 새로운 DB Instance를 생성하여 수행
        
* RDS Multi AZ
    * 두 개 이상의 AZ에 걸쳐 데이터베이스를 구축하고 원본과 다른 DB를 자동으로 동기화 시킨다. 
    * 한 쪽에서 장애가 발생시 자동으로 다른 쪽 DB가 원본으로 승격된다.
    * stanBy DB는 접근이 불가능하다. (원본 DB가 primary DB)
    * 안정성을 위한 서비스
    
* 읽기 전용 복제본
    * primary DB의 읽기전용 복제본 생성. 각 복제본에는 DNS가 할당되어서 접근 가능
    * 퍼포먼스를 위한 서비스
    * 총 5개까지 생성이 가능하다
    * 다른 AZ, Region에 존재 가능
    * 쓰는 작업에 비해 읽기 작업이 무척 많을 때 rds의 부하를 줄이기 위해 사용
    * Async 복제(RR과 primary DB사이에 약간의 딜레이가 존재할 수 있다)
    
* RDS MultiRegion
    * 다른 리전에 지속적으로 동기화시키는 DB클러스터 생성
    * 주로 로컬 퍼포먼스(다른 리전에 있는 곧에 RR을 생성해서 속도 향상)나 DR시나리오(자연재해)로 사용
    * 확장성 성능을 위해 사용
    * Async 복제
