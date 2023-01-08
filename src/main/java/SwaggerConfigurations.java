

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//SWAGGER CONFIGURATIONS CLASS.......................
@Configuration
@EnableWebMvc
public class SwaggerConfigurations {

	// BEAN GENERATING FUNCTION .................
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("FILE UPLOAD SERVICE").apiInfo(getInfo()).select()
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {

		return new ApiInfo("FILE UPLOAD SERVICE",
				"THIS SERVICE CAN UPLOAD ANY FILE IN SIMPLE OR BASE 64 FORMAT TO A REMOTE LOCATION", "VERSION 0001",
				"http://localhost:1357/fileUploadService/uploadFile",
				new Contact("GURSHARAN S. SANDHU", "http://localhost:1357", "sandhugursharan70@gmail.com"),
				"LICENSE 1.2.3", "http://localhost:1357", Collections.emptyList());
	}

}
