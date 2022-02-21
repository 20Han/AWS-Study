# 2. 스프링 부트에서 테스트 코드를 작성해보자
* TDD 과정
1. 항상 실패하는 테스트를 작성(Red)
2. 테스트가 통과하는 프로덕션 테스트 작성(Green)
3. 테스트가 통과하면 프로덕션 코드를 리펙토링(Refactor)
* IoC : 사용자가 객체의 제어권을 다른 주체(Spring)에게 넘기는 것
* DI : 의존성을 객체 내부에서 만드는 것이 아닌 외부에서 주입해 주는 것.  
* bean : 사용자가 직접 관리하는 객체가 아닌 스프링 IoC 컨테이너에서 자동적으로 관리하는 객체.

# 3. 스프링 부트에서 JPA로 데이터베이스 다뤄보자
* JPA의 필요성
1. 아무리 java객체를 예쁘게 짜도 DB저장을 위해서는 SQL문을 피할 수 없다. 
2. RDB는 어떻게 데이터를 저장할지에 중점이지만 자바는 기능과 속성을 한 곳에서 관리하는 oop기술. -> 패러다임 불일치
ex) 부모 자식 관의 관계에 있는 두 객체가 db에 저장되면 따로 데이터를 가져오게 되면서 관계가 잘 보이지 않게된다. 
* JPA : 객체지향형 프로그래밍인 자바 코드를 작성하면 RDB에 맞는 SQL을 작성해주는 자바명세서.
* Spring Data JPA : JPA사용을 위해 Spring에서 제공하는 JPA 구현체. Spring Data 프로젝트는 JPA외에도 Redis, MongoDB등을 제공하는데 각 구현체의 인터페이스가 같기 때문에 훗날 db를 교체하는등의 작업에 용이하다. 
* DB Entity 생성 규칙
1. PK는 long으로 하며 auto_increase시킨다. 만약 비즈니스로직적인 Unique Key를 PK로 설정하면 나중에 비즈니스로직이 바뀔때 수정이 어렵다(ex : 주민등록번호)
2. Entity는 Setter를 두지 않고 특정 값을 할당하는 public 메소드를 두어 언제 어떻게 값이 바뀌는지 추적할 수 있도록 한다. 
* 스프링 웹 계층
스프링은 WebLayer, ServiceLayer, Repository, Dtos, Domain Layer로 구성된다. 
    1. Web Layer
    컨트롤러와 뷰 템플릿의 영역
    필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 전반적인 영역을 이야기한다
    2. Service Layer
    @Service에 사용되는 서비스 영역
    controller와 Dao의 중간 영역에서 사용된다. 
    @Transactional이 사용되어야 하는 영역이기도 하다
    3. Repository Layer
    DB 접근 layer
    Dao 같은 영역
    4. Dtos
    계층 간에 데이터 교환을 위한 객체
    5. Domain Model
    개발 대상을 단순화 시킨 모델. 비즈니스 로직
    @Entity를 도메인 모델이라 생각할 수 있다.
    그러나 항상 db와 관계된것은 아니다. VO(Value Object)같은 객체도 있다.
   

