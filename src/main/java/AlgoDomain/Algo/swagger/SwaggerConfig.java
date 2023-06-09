package AlgoDomain.Algo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
 public Docket petApi() { 
		return new Docket(DocumentationType.SWAGGER_2)
	  .groupName("full-petstore-api")  
	  .apiInfo(apiInfo())  .select() 
	 .apis(RequestHandlerSelectors.basePackage("AlgoDomain.Algo.swagger"))  
	 .paths(PathSelectors.ant("/api1/"))
	  .build(); 
		}
	 
	
//	
//	  public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
//	 .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
//	 .build().apiInfo(apiInfo()); }
	 
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("My API")
				.description("API for my project")
				.version("1.0")
				.build();
	}

}
