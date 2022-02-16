
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
		 
Step 6: In this Active MQ used 
     
         For Verification execute:
         runMQApp.cmd
              		 
	 


Intial configuration uses single machine with below port mapping


Eureka Registry Service 
        port: 8761
		
Config Server
       port: 9888
	   
Gateway API 
        port: 8989

MQ Service 
        port: 8990 
		
Payment Service 
        port: 9010
		
Order Service 
        port: 9001

Reporting Service 
        port: 9011	
		
         	          

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
	 
	 For IBM MQ 
	      docker
		  Then 
		              docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443:9443 --detach ibmcom/mq

     ActiveMQ                               apache-activemq-5.11.1
         Start MQ server using 
                 bin/activemq start >  E://log/activemqlog  2>&1 &;	
     Jasper
              	 
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
	 net.sf.jasperreports jasperreports      6.16.0
	 
Common Configuration privided by config server: 
https://github.com/ashokjha/cloudconfigsrv
    
	 
                	 
	 
	 
	          	          	 