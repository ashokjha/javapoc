**MICROSERVICE**

*To Exexutte Microservice follow below process*

*Step 1 : Service Registeration* for Registry Service execute below cmd from ServiceRegistry directory:  
         `runservicereg.cmd`

*Step 2 : For Configuration Server* execute below cmd from SampleConfigServer directory: 
         `runCFGServer.cmd`	
		 
*Step 3 : For API Gateway* execute below cmd from  ServiceCGateway directory: 
         `rungwyAPISer.cmd`	

*Step 4 : For Order Service* execute below cmd from OrderService directory: 
         `runorderservice.cmd`
		 
*Step 5 : For Payment Service* execute below cmd from PaymentService directory: 
         `runPySer.cmd`
		 
*Step 6: In this Active MQ used*: 
     
         For Verification execute:
         `runMQApp.cmd`
              		 
*Step 7:  For Reporting Service*:
         Execute:
		 `runReporting.cmd`
		 
*Initial configuration uses single machine with below port mapping*

**Used PORTS**

*Eureka Registry Service* 
        port: 8761
		
*Config Server*
       port: 9888
	   
*Gateway API*
        port: 8989

*MQ Service* 
        port: 8990 
		
*Payment Service* 
        port: 9010
		
*Order Service*
        port: 9001

*Reporting Service* 
        port: 9002	
		
         	          

*To Test Use Below URL:*

*Order*:
Do post request as sample given below:
```
 http://localhost:8989/ashu/order/bs
{
	"order": {
		"name": "iStar",
		"id": 1,
	    "quantity": 5,
	    "price": 4000000
	},
	"payment": {
		
	}
} 
```
*For Payment do post request with*    
 http://localhost:8989/ashu/payment/qrp



*Microservice used:*
| Name  | Version |Desc|
| ------------- | ------------- | ------------- |
|java|1.8||
|Spring-boot|2.5.9||
|ActiveMQ|apache-activemq-5.11.1| |
|Jasper|||
|h2database|||
|default tomcat|||
|Spring Cloud |2020.0.3||
|spring-boot-starter-web|||
|spring-boot-starter-data-jpa|||
|spring-cloud-starter-gateway|||
|spring-cloud-starter-netflix-eureka-client|||                           
|spring-cloud-starter-netflix-eureka-server|||                           
|spring-boot-starter-actuator|||      
|spring-cloud-starter-circuitbreaker-resilience4j|||
|spring-cloud-starter-circuitbreaker-reactor-resilience4j|||
|spring-cloud-config-server|||
|spring-cloud-starter-config|||
|net.sf.jasperreports jasperreports|6.16.0||
|security using jjwt|||
         	 	 
Common Configuration privided by config server: 
https://github.com/ashokjha/cloudconfigsrv

for reporing sample db script inldudes


**12 Factor of Micro Service**

*1 – Codebase*
     One codebase per service, tracked in revision control; many deploys   
     git preffered.
*2 – Dependencies*
    Explicitly declare and isolate dependencies
		
*3 – Config*
	Store configuration in the environment
	Anything that varies between deployments can be considered configuration. The Twelve‑Factor App guidelines recommend storing all configuration in the environment, rather than committing it to the repository 

*4 – Backing Services*
    Treat backing services as attached resources
    
*5 Build, Release, Run*
   Strictly separate build and run stages
   To support strict separation of build, release, and run stages, as recommended by The Twelve‑Factor App, we recommend the use of a continuous integration/continuous delivery (CI/CD) tool to automate builds. Docker images make it easy to separate the build and run stages. Ideally, images are created from every commit and treated as deployment artifacts.


*6– Processes*
    Execute the app in one or more stateless processes
    For microservices, the important point in the Processes factor is that your application needs to be stateless. This makes it easy to scale a service horizontally by simply adding more instances of that service. Store any stateful data, or data that needs to be shared between instances, in a backing service. 

*7 – Data Isolation*
     Each service manages its own data
     As a modification to make the Port binding factor more useful for microservices, we recommend that you allow access to thepersistent data owned by a service only via the service’s API. This prevents implicit service contracts between microservices and ensures that microservices can’t become tightly coupled. Data isolation also allows the developer to choose, for each service, the type of data store that best suits its needs.

*8  – Concurrency*
    Scale out via the process model
     The Unix process model is largely a predecessor to a true microservices architecture, insofar as it allows specialization and resource sharing for different tasks within a monolithic application. In a microservices architecture, you can horizontally scale each service independently, to the extent supported by the underlying infrastructure. With containerized services, you further get the concurrency recommended in the Twelve‑Factor App, for free.

*9 – Disposability*
    Maximize robustness with fast startup and graceful shutdown
    Instances of a service need to be disposable so they can be started, stopped, and redeployed quickly, and with no loss of data. Services deployed in Docker containers satisfy this requirement automatically, as it’s an inherent feature of containers that they can be stopped and started instantly. Storing state or session data in queues or other backing services ensures that a request is handled seamlessly in the event of a container crash. We are also proponents of using a backing store to support crash‑only design.


*10 – Dev/Prod Parity*
    Keep development, staging, and production as similar as possible
     Keep all of your environments – development, staging, production, and so on – as identical as possible, to reduce the risk that bugs show up only in some environments. To support this principle, we recommend, again, the use of containers – a very powerful tool here, as they enable you to run exactly the same execution environment all the way from local development through production. Keep in mind, however, that differences in the underlying data can still cause differences at runtime. 


*11 – Logs*
      Treat logs as event streams
      Instead of including code in a microservice for routing or storing logs, use one of the many good log management solutions on the market, several of which are listed in the Twelve‑Factor App. Further, deciding how you work with logs needs to be part of a larger APM and/or PaaS strategy.

*12 – Admin Processes*
     Run admin and management tasks as one/off processes
      In a production environment, run administrative and maintenance tasks separately from the app. Containers make this very easy, as you can spin up a container just to run a task and then shut it down. 


 
                	 
	 
	 
	          	          	 
