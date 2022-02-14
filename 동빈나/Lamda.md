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

# 4. Lambda로 게시판 서버 만들기
