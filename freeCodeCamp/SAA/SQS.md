# SQS
* Intro
    * Queueing system
        * 비동기적 연결이나 message/event를 기반으로 sender와 receiver를 분리하기 위한 중간 과정으로 많이 사용됨
        * Queueing vs Streaming
            * Queueing : 한 번 사용되면 지워짐. Not Real-time to pull, Not Reactive
            * Streaming : 여러 컨슈머가 이벤트에 반응 가능. 이벤트는 stream에 긴 시간 머물 수 있다. 따라서 복잡한 작업이 가능. Real-time. kinesis가 대표적인 예.
    * SQS는 Application Integration으로 사용된다. 이 과정에서 queue는 프로세스 처리를 위한 임시저장소가 된다
    * pull based 
    
* Limits & Retention
    * Message Limits
        * 1byte ~ 256kb까지 가능. 
        * java라이브러리를 통해 256KB ~ 2GB도 사용 가능. 이때는 S3가 중간에 사용됨
    * Message Retention (얼마나 오래 보관후 삭제할 것인지)
        * 기본은 4일
        * 1분 ~ 14일까지 조정 가능

* Queue Types
    * Standard Queues
        * 거의 무제한의 transcations 성능 가짐
        * 적어도 한 번 delivered 됨을 보장
        * 그러나 message의 copy는 순서에 맞지 않게 전달될 수 있음
        * best-effort ordering을 제공하여 message가 최대한 순서에 맞게 전달되디록 함
    * FIFO Queues
        * FIFO 순서를 보장
        * 300 transactions/sec limit

* Visibility Timeout
    * 앱 A가 메세지를 읽는 과정동안 다른 앱 B가 해당 메세지를 읽을 수 있는 현상을 어떻게 방지하는가?
        * Message는 consumer의 process가 끝나면 지워진다.
        * 만약 visibility time-out 이후에도 작업이 안끝나면 작업 중임에도 불구하고 다른 앱들에게 해당 메세지가 노출된다. 
        * 이는 한 메세지가 두 번 전달되는 현상을 가져온다
    * visibility time-out : consumer가 메세지를 pick한 후 message가 SQS queue에서 보이지 않는 시간.

* Shor vs Long Polling
    * Short Polling(default)
        * 메세지 큐가 비어 있더라도 message를 즉시 받을 수 있음
        * 메세지가 바로 필요하다면 short polling이 유리
    * Long Polling
        * 큐에 메세지가 도착하거나 long poll timeout expires가 발생할 때까지 기다림
        * empty receive가 줄어들어서 cost 절감효과가 있음
     
    
    
    
