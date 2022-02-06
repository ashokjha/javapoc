
In Order to Execute the Microservice follow below process
Step 1 : From ServiceRegistry execute 
         runservicereg.cmd
		 
Step 2 : From OrderService execute 
         runorderservice.cmd
		 
Step 3 : From PaymentService execute 
         runPySer.cmd
		 
Step 4 : From ServiceCGateway execute 
         rungwyAPISer.cmd		 


Intial configuration uses single machine with below mapping
Eureka Registry Service 
        port: 8761
Payment Service 
        port: 9010
Order Service 
        port: 9001
Gateway API 
        port: 8989
         	          

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
     Spring-boot                             2.5.4 
     h2database
	 default tomcat
     Spring Cloud Gateway                    2020.0.3
	 eureka-client                           
	 eureka-server                           
	 circuitbreaker-resilience4j             
	 circuitbreaker-reactor-resilience4j     
	 
	 
	          	          	 