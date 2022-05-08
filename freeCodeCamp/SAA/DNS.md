# DNS
* intro
    * phonebook of internet
    * domain이름을 ip address로 바꿔준다
    
* Internet Protocol (IP)
    * 컴퓨터의 고유 주소
    * ipv4
        * ex) 52.216.8.34
        * 32bit이며 4,294,967,296개의 어드레스가 가능하다
    * ipv6
        * 128bits, 340 undecililion
        
* Domain Registers
    * top-level domains 아래로 domain name을 부여할 수 있는 권한을 가진 것
    * InterNIC를 통해 Domain이 등록된다. 
    * 등록된 후에는 WhoIS db를 통해 공개적으로 확인 가능하다
    
* Top-Level Domains
    * 도메인의 마지막 단어가 top-level 도메인이다
        * ex) example.com의 경우 com이 top-level 도메인
        * AWS는 .aws라는 top-level domain을 가짐
    * second-level domain은 마지막에서 두번째 단어

* Start Of Authority (SOA)
    * 도메인에 대한 정보를 제공하는 방법 : 얼마나 자주 업데이트 되는지, admin의 email주소는 무엇인지 등등
    
* Records 
    * A record : domain과 연결된 실제 IP
    * CNAME record : 현재 도메인 아래에 나열되거나 현재 도메인과 연결된 하위 도메인들
    * NS record : 현재 도메인의 사용중인 네임 서버 

* Time To Live (TTL)
    * DNS 캐싱되는 시간
    
