package ma.enset.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    Java Method to define routes statically
 /**   @Bean
    public RouteLocator getRouteDefinitionLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/client/**").uri("lb://SERVICE-WALLET"))
                .route(r -> r.path("/wallet/**").uri("lb://SERVICE-WALLET"))
                .route(r -> r.path("/transfer/**").uri("lb://TRANSFER"))
                .build();
  }**/

//  Java Method to define routes dynamically
    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}
