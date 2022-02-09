
In Order to Execute the Microservice follow below process
Step 1 : For Registry Service execute below cmd from ServiceRegistry directory  
         runservicereg.cmd

Step 2 : For Configuration Server execute below cmd from SampleConfigServer directory 
         runCFGServer.cmd.cmd	
		 
Step 3 : For API Gateway execute below cmd from  ServiceCGateway directory 
         rungwyAPISer.cmd	

Step 4 : For Order Service execute below cmd from OrderService directory 
         runorderservice.cmd
		 
Step 5 : For Payment Service execute below cmd from PaymentService directory 
         runPySer.cmd
		 
	 


Intial configuration uses single machine with below port mapping

Eureka Registry Service 
        port: 8761
Config Server
       port: 9888
Gateway API 
        port: 8989
  
Payment Service 
        port: 9010
Order Service 
        port: 9001
	
		
         	          

To Test Use Below URL:

For Order:
Do post request as sample given below:
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

For Payment do post request with    
 http://localhost:8989/ashu/payment/qrp



Microservice use below:
     java                                    1.8
     Spring-boot                             2.5.9 
     h2database
	 default tomcat
	 Spring Cloud                           2020.0.3
	 spring-boot-starter-web
	 spring-boot-starter-data-jpa
	 spring-cloud-starter-gateway
	 spring-cloud-starter-netflix-eureka-client                           
	 spring-cloud-starter-netflix-eureka-server                           
	 spring-boot-starter-actuator      
	 spring-cloud-starter-circuitbreaker-resilience4j
     spring-cloud-starter-circuitbreaker-reactor-resilience4j
	 spring-cloud-config-server
	 spring-cloud-starter-config
	 
Common Configuration privided by config server: 
https://github.com/ashokjha/cloudconfigsrv
    
	 
                	 
	 
	 
	          	          	 