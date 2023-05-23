package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = { "institution_mgmt","department_mgmt","faculty_mgmt","student_mgmt","batch_mgmt","session_mgmt" })
@EntityScan(basePackages ={"institution_mgmt","department_mgmt","faculty_mgmt","student_mgmt","batch_mgmt","session_mgmt" })
@ComponentScan(basePackages ={"institution_mgmt","department_mgmt","faculty_mgmt","student_mgmt","batch_mgmt","session_mgmt" })
public class LMS_OrgStruct_Main extends SpringBootServletInitializer  
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LMS_OrgStruct_Main.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LMS_OrgStruct_Main.class, args);
	}
}