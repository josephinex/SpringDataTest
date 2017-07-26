package application.context;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {
"com.packtpub.springdata.jpa.controller",
"com.packtpub.springdata.jpa.service"
})
@EnableJpaRepositories("com.packtpub.springdata.jpa.repository")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")


public class ApplicationContext extends WebMvcConfigurerAdapter {
	@Resource
	private Environment env;
}
