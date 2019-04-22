/**
 * 
 */
package com.afkl.cases.df;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author udayakumar.rajan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Bootstrap.class)
public class BootstrapTest {
	

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		assertThat(context, notNullValue());
	}


}
