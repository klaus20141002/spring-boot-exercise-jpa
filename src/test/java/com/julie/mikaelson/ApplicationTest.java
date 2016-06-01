package com.julie.mikaelson;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.julie.mikaelson.common.user.model.User;
import com.julie.mikaelson.common.user.repository.UserRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {
	
	@Autowired
	private WebApplicationContext webContext;
	@Autowired
	private UserRepository userRepository ;
	
	private MockMvc mockMvc;
	@Before
	public void setupMockMvc() {
	mockMvc = MockMvcBuilders
	.webAppContextSetup(webContext)
	.build();
	}
	
	
	@Test
	public void homePage() throws Exception {
	mockMvc.perform(MockMvcRequestBuilders.get("/users"))
	.andExpect(MockMvcResultMatchers.status().isOk())
	.andExpect(MockMvcResultMatchers.view().name("success"))
//	.andExpect(MockMvcResultMatchers.model().attributeExists("books"))
//	.andExpect(MockMvcResultMatchers.model().attribute("books",Matchers.is(Matchers.empty())))
	;
	}
	
	@Test
	public void  addUser() {
		User user  = new User() ;
		user.setUsername("niklaus Mikaelson");
		user.setPassword("123456");
		user.setEmail("love20141002@126.com");
		user.setPhone("18626463"+(int)Math.random()*20000);
		user.setAccount(String.valueOf(UUID.randomUUID().toString()));
		userRepository.save(user) ;
		
	}
	
	
	

}
