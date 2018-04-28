package nz.co.aj.expensemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()                 
	                .apis( RequestHandlerSelectors.any() )
	                .paths( PathSelectors.any() )
	                .build()
	                .apiInfo(metaData());
	    }
	 
	 private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo("Expense manager", "fsd", "1.0",
	        		"jbcdjsh", "Amulya", "dsf", "fs");
	        return apiInfo;
	    }

}
