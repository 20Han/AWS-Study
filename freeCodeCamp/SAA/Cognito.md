# Cognito
* intro
    * Decentralized Managed Authentication
    * sign-up, sign-in integration, Socail 로그인(Facebook, Google)등을 지원
    
* Web Identity Federation & idP
    * idp
        * identity provider
        * Facebook, Amazon, Google 등등
    * Web Identity Federation : idP사이에 identity, security 정보를 교환하기 위해 사용

* User Pools
    * user directories used to manage actions for web and mobile (sign-up, sign-in, account recovery, account confirmation)
    * jwt를 통해 영구적 authentication을 함

* Identity Pools
    * S3, DynamoDB등에 접근할 수 있는 일시적인 AWS credentials를 제공
    
* Sync
    * 여러 디바이스에 걸친 user data를 sync
    * 클라우드에 있는 identity 데이터가 수정되면 SNS를 통해 user devices에 변화를 알림
