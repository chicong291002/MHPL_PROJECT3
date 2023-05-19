package BanHang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("BanHang.Repository")
@EntityScan({"BanHang.Entity"})
@ComponentScan({"BanHang.Controller","BanHang.Repository","BanHang.Service","BanHang.ViewModel"})
public class MhplSpringbootProject3Application extends SpringBootServletInitializer{

	public static void main(String[] args)  {
		SpringApplication.run(MhplSpringbootProject3Application.class, args);
	}
}
