https://www.youtube.com/watch?v=Ia-UEYYR44s

# RDS
* RDS Encryption
    * 모든 RDS Engine에 대해 Encryption 가능 (특정 버전의 옛날 버전은 불가능)
    * Encryption은 자동 백업, 스냅샷, read replicas에 모두 적용
    * AWS KMS를 통해 encryptin 됨
    
* RDS Backups
    * Automated Backups
        * 자동 백업으로 S3에 설정한 주기(1~35 days)마다 백업된다
        * 추가 요금이 발생하지 않는다
        * Storeage I/O가 backup동안 지연될 수 있다
    * Manual Snapshots
        * 유저가 직접 이미지를 만듬
        * RDS instance를 지우더라도 Manual Snapshots은 보존된다

* RDS Restoring Backup
    * recovering은 가장 최근의 backup을 이용한다. 당시의 transcation log data를 통해 복원. point-int-time recovery
    * 현재 상태 이후의 backup data는 저장되지 않는다
    * Recovery RDS instance는 새로운 DNS endpoint를 갖는다
    
* RDS - Multi AZ
    * 하나의 AZ가 불가능하게 되어도 RDS가 정상작동하도록 여러 AZ에 거쳐 저장
    * AWS 내부적으로 두 AZ의 데이터를 synchronize한다
    
* RDS - READ Replicas
    * 보통 db작업은 쓰는 작업보다 읽는 작업이 많기 때문에 읽기전용 Replicas를 여러개 생성할 수 있도록 해줌
    * RR을 사용하기 위해서는 automatic backups를 사용해야한다. 
    * 비동기적으로 RR이 생성된다
    * 5개까지 가질 수 있다, 각 RR은 각자의 DNS Endpoint를 가진다
    * Multi-AZ replicas, 다른 regin replicas도 존재 가능
    * replcias는 고유의 데이터베이스를 갖도록 설정할 수 있지만 이경우 replication이 끊긴다
    
* RDS - Multi-AZ vs READ Replicas
    * 표
