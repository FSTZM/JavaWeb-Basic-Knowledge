package junitDemo;

import org.junit.Assert;
import org.junit.Test;


//���Է���Ҫ�󣺲����з���ֵ�������в���

public class test {
	
	@Test
	public void test1(){
		calc c = new calc();
		c.add(3, 10);
		Assert.assertEquals(13, c.add(3, 10));
	}

	@Test
	public void test2(){
		calc c = new calc();
		Assert.assertEquals(3, c.div(10, 3),0.4);
	}

}
