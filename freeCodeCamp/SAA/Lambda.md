# Lambda
* Intro
    * 서버리스 함수
    * compute time 별 과금 : 쌈
    * Scale Automatically

* Lambda UseCase
    * 두 AWS 시스템을 연결하는 용도로 사용
        ex) S3-S3, Api Gateway - DynamoDB 등등 무수함

* Triggers
    * AWS SDK나 다른 AWS Service에 의해 트리거됨
    * 서드파티도 많음(DataDog, OneLogin...)
    
* Pricing
    * 한달에 100만건까지 무료, 그 후 100만건 당 0.2$
    * 400,000 GB execute까지 무료, 그 후 GB sec당 $0.000016667
        * 1GB sec당 요금 의미 : 1GB메모리를 할당했을 때 초당 요금
        * ex) 100만건 추가사용, 건당 1초, 512MB
            요금  = (횟수) * (건당 사용 GB sec * sec당 요금)
                 = 100만 * (521/1024)GB * 1초 * 0.00016667 

* Lambda Default and Limits
    * 1000개 람다까지 사용 가능
    * /tmp에 500MB까지 저장가능
    * vpc가 없음. 설정 가능
    * timeout을 15분까지 설정 가능
    * 128MB ~ 3008MB 까지 68MB 간격으로 설정 가능
    
* Lambda Cold Start
    * 람다가 AWS에서 준비된 서버에 코드를 올리가 실행준비를 하는데까지 시간이 걸림. 이를 Cold Start라고 부름
    * 같은 람다를 한 번 더 호출하면 첫번째 람다가 사용하던 서버를 그대로 사용(warm server)
    * Cold start는 유저에게 delay를 가져올 수 있음. 이를 막기 위해 노력해야함(Pre Warming 필요)
