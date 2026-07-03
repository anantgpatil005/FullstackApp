package com.agp.service.gateway.config;

import org.springframework.context.annotation.Configuration;

//@Configuration
public class RouteConfig {
	
	/*
	 * private RouteLocator customRoutes(RoutesLocatorBuilder builder){
	 * 
	 * }
	 */

}
//spring.cloud.gateway.routes[0].id=USER-SERVICE
//spring.cloud.gateway.routes[0].uri=lb://USER-SERVICE
//spring.cloud.gateway.routes[0].predicates[0]=Path=/users/**

//spring.cloud.gateway.routes[1].id=HOTEL-SERVICE
//spring.cloud.gateway.routes[1].uri=lb://HOTEL-SERVICE
//spring.cloud.gateway.routes[1].predicates[0]=Path=/hotels/**

//spring.cloud.gateway.routes[2].id=RATING-SERVICE
//spring.cloud.gateway.routes[2].uri=lb://RATING-SERVICE
//spring.cloud.gateway.routes[2].predicates[0]=Path=/ratings/**