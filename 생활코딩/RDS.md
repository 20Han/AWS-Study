[강의링크](https://opentutorials.org/course/2717/11807)

# 1. RDS 소개
- RDS : Relational Database Service, AWS에서 제공하는 RDB 서비스
- MySQL, Maria, Aurora, Oracle, SQL Server


# 2. 데이터베이스 서버 생성
- AZ (Availability Zone) : 물리적으로 독립된 데이터센터에서 사용할 수 있는 지역. Multi-AZ면 여러 데이터 센터에 저장되어 유실걱정이 적다. 하지만 비싸다
- Publicly Accessible : No로 설정하면 같은 VPC안에서만 접근할 수 있다


# 3. RDS 백업 & 복원
- 복원 
한 AZ에 있는 RDS가 죽으면 미들웨어가 데이터를 다른 AZ의 RDS에 저장하도록 한다. 
그리고 추후 죽었던 RDS가 살아나면 다른 AZ의 RDS와 동기화 시킨다.

- 백업 
Take Snapshot, 중요한 작업 전에 snapShot을 찍어놓고 문제가 존재할 때 snapShot을 바탕으로 백업한다. 
스냅샷을 복구 하는 것은 기존 db 인스턴스에 스냅샷을 덧씌우는게 아니라 새 db 인스턴스를 만드는 것.
혹은 Restore point in time을 통해 특정 시점으로 돌아갈 수 있다. 

# 4. RDS Scalue Up & Out
- scale up : 한 인스턴스의 성능을 업그레이드
- Scale Out : 여러 인스턴스를 연결, 하나의 master 컴퓨터를 두고 여러대의 slave 컴퓨터를 둔다. slave는 항상 빠르게 master와 동기화. 쓰기는 master를 통해서, 읽기는 slave를 통해서 동작. 만약 master의 크기가 계속 커져서 한 컴퓨터로 감당하지 못한다면 sharding을 사용해야 한다. 
- Slave를 만드는 방법 : create read replica 
