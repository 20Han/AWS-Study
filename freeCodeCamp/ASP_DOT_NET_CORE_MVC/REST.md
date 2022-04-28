https://www.youtube.com/watch?v=ZXdFisA_hOY

# Entity, Repository, Controller (GET)
* Entity
    * Record Types
        * immutable object에 사용
        * with 지원 : Item potion2 = potion1 with { Price = 12 };
        * Value 기반 equality 체크
    * 변수 생성시 {get; init;}을 하면 init시에만 값이 할당되도록 한다
* ActionResult : data만 리턴하는 것이 아닌 NotFound()와 같은 request result도 리턴해야할 때 사용

# Persistence
* Persistence Options
    * Files
    * Database
        * RDB
        * No_SQL
* No SQL benefit
    * No Need for schema nor SQL
    * Low latency
    * High Performance

# Async Programming
* client -> controller -> repository -> DB의 경로를 모두 async하게 만든다 (Async All The Way)
* async하기 위해서는 리턴타입을 Task<R>로 해야한다. void도 Task타입으로 바꿔야 함
* keyword
    * async : 함수에 표기해주며 단순히 비동기 함수임을 나타냄
    * await : 기다려
* SuppressAsyncSuffixInActionNames : 함수 이름 뒤에 Async가 붙으면 CreatedAtAction에서 라우팅 이슈가 생긴다. 따라서 이 flag를 addController시에 false로 해야한다.

# Secrets management
* appsettings.json에서 pw를 숨겨야한다
* sercret manager
    * dotnet user-secrets init
    * dotnet user-secrets set MongoDbSettings:(my_pw)
    * 위 명령어를 사용하면 MongoDbSettings에 패스워드가 저장된다.
    

# Health Checks
* DB가 살아 있는지 체크
