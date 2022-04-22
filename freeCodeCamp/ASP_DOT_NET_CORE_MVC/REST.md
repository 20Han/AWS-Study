https://www.youtube.com/watch?v=ZXdFisA_hOY

# Entity, Repository, Controller (GET)
* Entity
    * Record Types
        * immutable object에 사용
        * with 지원 : Item potion2 = potion1 with { Price = 12 };
        * Value 기반 equality 체크
    * 변수 생성시 {get; init;}을 하면 init시에만 값이 할당되도록 한다
* ActionResult : data만 리턴하는 것이 아닌 NotFound()와 같은 request result도 리턴해야할 때 사용
