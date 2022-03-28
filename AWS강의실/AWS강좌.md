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
