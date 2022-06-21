package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//(exclude=HibernateJpaAutoConfiguration.class)
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class })
@EnableTransactionManagement
//@MappedTypes(Member.class)
@MapperScan(basePackages = "com.example.demo.mybatis"//, sqlSessionTemplateRef = "SecondarySessionTemplate"
)

public class DemoApplication extends SpringBootServletInitializer{
//	private static final Log logger = LogFactory.getLog(DigestAuthenticationFilter.class);
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(DemoApplication.class);
	    }
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
//		ApplicationContext context2 = new AnnotationConfigApplicationContext(DemoApplication.class);
		
//		Alien alien=context.getBean(Alien.class);
//		alien.show();
//		ConfigurableApplicationContext context2 = new AnnotationConfigApplicationContext(DemoApplication.class);
//		JsonUtil jsonUtil = context2.getBean(JsonUtil.class);
//		Gson gson = jsonUtil.getGsonObj();
//		Member member = gson.fromJson("{\n" + "  \"id\": 2,\n" + "  \"name\": \"admin2\",\n" + "  \"pwd\": \"1234\",\n"
//				+ "  \"birth\": \"2011-12-17T16:00:00.000+00:00\",\n" + "  \"email\": \"callerwang2021@gmail.com\"\n"
//				+ "}", Member.class);
		
//		List<Member> members=new ArrayList<Member>();
//		members.add(member);
//		members.forEach(memberz->System.out.println(memberz.getEmail()));
//		System.out.println(member.toString());
//		logger.debug("Digest comparison failure; trying to refresh user from DAO in case password had changed");

//		Member m=new Member(1,"","",new Date(),"");
	}

}
