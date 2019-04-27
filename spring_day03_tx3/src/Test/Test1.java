package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.AccountService;


public class Test1 {
	
	@Test
	public void demo(){
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		AccountService accountService = (AccountService) applicationContext.getBean("proxyAccountService");
		accountService.transfer("tom", "jerry", 1000);
	}

}
