# IAM
* Core Components
    * IAM Identities 
        * IAM Users : AWS 리소스를 사용하는 엔드 유저
        * IAM Groups : Users의 그룹. permission을 공유할 수 있도록 해준다. (Admin, Developer, Auditors 등등)
        * IAM Rules : Role에 permission을 할당한 후 user, group등에게 role을 부여. Aws resource에 바로 부여될 수 있다
    * IAM Polices : IAM Identities에게 permission을 부여하는 json document
    
* Types of Polices
    * Managed Polices : AWS에 의해 관리되는 policy. 수정 불가능. 왼쪽에 주황색 박스가 떠있음
    * Custom Managed Polices : 사용자에 의해 관리되는 policy. 수정 가능
    * Inline Polices : User에게 바로 붙여질 수 있는 policy. 
    
* Policy Structure
    * Version : policy language version. 2012-10-17로 고정
    * Statement : policy의 내용
    * Sid : statement를 라벨링함
    * Effect : Allow or Deny
    * Action : policy가 허용하거나 허용하지 않는 actions의 집합
    * Resources : action이 적용될 AWS Resources
    * Condition : 조건에 따라 permission 허용 or 불허
    
* Password Policy
    * password 최소 길이, password 필수 갱신주기 등을 설정할 수 있다
    
* Programmatic Access Keys
    * aws cli나 sdk를 통해 resource를 사용할 때 access key가 사용됨
    * 유저당 두 개의 access keys 할당 가능 
    
* MFA
    * 유저별 MFA on off 가능
    * 유저에게 MFA를 강제할 수는 없음
    * 다만 admin 어카운트로 AWS 특정 리소스에 접근할 때는 MFA 요구를 할 수 있음
    
        
