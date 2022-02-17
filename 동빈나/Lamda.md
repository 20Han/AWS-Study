[강의링크](https://www.youtube.com/watch?v=7uEDep9DFJs&list=PLRx0vPvlEmdD_AdG6fEwcfVrq5Qb3q_Ja)

# 1. AWS Lambda 개요
- AWS 클라우드 상에서 특정 함수를 동작시키는 것. 별도의 인스턴스가 필요없다. 
- 일반적으로 python, nodeJS를 많이 사용한다


# 2. AWS Lambda로 크롤링 봇 만들기
- 람다에 라이브러리를 업로드 할 수 있다. 크롤링 봇에서는 beautiful soup를 사용
- zip 파일 형태로 라이브러리를 올려서 사용가능 

# 3. AWS Lambda Layer
- layer에 zip 파일 형태로 라이브러리를 올려서 람다 함수마다 라이브러리를 올려야 하는 수고를 덜 수 있다. 
- 최상위 폴더를 python으로 두어야 하고 Library폴더에 포함된 채로 업로드 해야한다. 

# 4. Lambda로 게시판 서버 만들기1(Api Gateway, GET, POST API)
- API Gateway : REST API로 만듦, resource를 지정하고 GET방식으로 접근시에 직접 만든 람다함수가 실행되도록 함.
- 브라우저로 접근시 undefined로 접근했다고 나타남. 즉 기본적으로 GET방식을 사용하지 않음. -> Use Lambda Proxy Integration을 게이트웨이시 체크해야한다. 
- Lambda Proxy Integration : 람다는 서버가 따로 존재하지 않아서 엔드포인트가 없다. 따라서 엔드포인트 역할을 할 수 있는 프록시 서버가 필요한데 이를 사용하는 체크박스이다. 

# 5. Lambda로 게시판 서버 만들기2(웹 클라이언트 접속 및 CORS 설정)
- CORS : 특정 웹사이트에서 다른 웹사이트의 정보를 받아오도록 하면 에러가 발생. 이를 위해 CORS(Cross-origin resource sharing) 설정 필요
- cors를 서버에 허용한다. 이후 API Gateway를 deploy해야한다. 또한 람다함수의 헤더에 'Access-Control-Allow-Origin' : '*'을 추가해야한다.  

# 6. AWS Lambda와 MongoDB 연동
- Enviornment Variables : lambda함수에서 사용할 여러 변수를 지정 가능, 패스워드등의 값을 넣어주면 좋다

# 7. AWS Lambda로 게시판 서버 API 만들기
- api gateway 설정시 {proxy+}를 설정하면 해당 path 값에 모든 값을 사용할 수 있다. 

