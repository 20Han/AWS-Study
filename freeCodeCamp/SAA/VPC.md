https://www.youtube.com/watch?v=Ia-UEYYR44s

# VPC
* Key Features
    * Region Specific, 리전당 5개 가능, 각 리전은 default VPC를 가짐
    * VPC당 200 subnet 생성 가능
    * 요금 부하 x : Route Tables, Nacls, Internet Gateway, Security Group, subnets, VPC peering
    * 요금 부하 o : Nat Gateway, VPC Endpoints, VPN Gateway, Customer Gateway
    
* Default VPC
    * 특정 리전에서 인스턴스를 바로 만들 수 있도록 default VPC를 제공한다
    * size /16 IPv4 CIDR 블록을 생성
    * AZ마다 /20 default subnet 생성
    * internet gateway, default Security group, NACL, DHCP, 를 만들어서 defualt vpc에 연결
    * main route table이 생성됨
    
* Default Everywhere IP
    * 0.0.0.0/0 : 어떤 IP든 pulic resource에 접근할 수 있다
    
* VPC Peering
    * private ip를 사용하여 다른 VPC에 direct newtork route를 통해 접근
    * peered vpc에 있는 인스턴스는 같은 vpc에 있는것처럼 행동
    * 다른 AWS계정, region에도 peering가능
    * Star Configuration : 1 Central VPC- 4 other VPCs
    * No Transitive Peering(한다리 건너 peering 안됨)
    * No overlapping CIDR Blocks

* Route Tables
    * network traffic이 어디로 가야하는지를 표시
    * 서브넷도 Route table에 연결되어야 한다. 서브넷은 한 번에 하나의 route table에만 연결 가능하다. 하나의 Route Table에는 여러개의 서브넷이 연결가능하다

* Internet Gateway
    * VPC가 인터넷에 접근할 수 있도록 함
    * 하는일
        1. route table에 internet 접근 제공
        2. IPv4를 할당받은 인스턴스에 NAT(Network Address Translation)을 제공

* Bastions/Jumpbox
    * Bastions : ssh와 rcp를 통해 private subnet에 있는 EC2에 접근을 할 수 있도록 도와주는 EC2 인스턴스
    * 하나의 Ec2에서 다른 EC2로 바로 점프하게 도와준다고 하여 Jumpbox라고도 부른다
    * NAT Gateways/Instances는 EC2 인스턴스의 아웃바운드에만 적용되기 때문에 Bastions로 사용될 수 없다
    * System Manager의 Session Manager가 Bastions를 대체했다
    
* Direct Connect
    * AWS에 온프레미스 접근을 위한 전용 네트워크를 만드는 서비스
    * 매우 빠름
    * 네트워크 비용을 줄이고 bandwidth throughput을 늘린다
    
    
# VPC Endpoints
* Intro
    * VPC가 다른 AWS 리소스와 다른 VPC endpoint에 private하게 접근하도록 허용한다
    * 종류
        * Interface Endpoints
        * Gateway Endpoints
    * 필요성
        * VPC내부의 인스턴스가 public ip없이 AWS 리소스에 접근할 수 있도록 한다. 이과정에서 IGW, NAT Devices, VPN Connection, AWS Direct Network등이 필요하지 않다(AWS 네트워크에서 연결이 이루어진다)
        
* Interface Endpoints
    * private Ip Address를 가진 Elastic Network Interface
    * AWS Private Link를 통해 사용됨(돈듦)
    
* Gateway Endpoints
    * 특정한 라우팅을 위한 게이트웨이로 공짜다
    * 현재는 S3와 Dynamo DB만 지원된다
