package org.zerock.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 책 61페이지
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j  // 우리눈에는 보이지않는 log라는 필드를 사용할수 있게해주는 어노테이션임 
public class SampleTests {
	
	@Autowired  // 필드에 autowired를 쓸수있으나 권장되는 방법은아님
	private ApplicationContext context;
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("------------------");
		log.info(restaurant.getChef());
	}
	
	@Test
	public void testExist2() {
		Chef c1 = (Chef) context.getBean("chef");
		Restaurant r1 = (Restaurant) context.getBean("restaurant");
		
		assertNotNull(r1.getChef());
		assertEquals(c1, r1.getChef());
		
		log.info("-----");
		assertNotNull(context);
		assertNotNull(context.getBean("chef"));
		assertNotNull(context.getBean("restaurant"));
		
	}

}
