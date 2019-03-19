package com.cognizant.training.CrudDemo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cognizant.training.CrudDemo.Model.User;
import com.cognizant.training.CrudDemo.Repository.UserRepository;
import com.cognizant.training.CrudDemo.Service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CrudDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void mockitoTestForGetUsers () throws Exception {

		List<User> users = new ArrayList<>();
		User user = new User().withFirstName ("Anil").withLastName ("Varma").withAge (26);
		// User user2 = new User().withFirstName ("Amit").withLastName ("Khiani").withAge (31);
		users.add (user);
		// users.add (user2);
		when(userRepository.findAll()).thenReturn(users);

		List<User> userList = userServiceImpl.findAllService();

		System.out.println(userList.get(0).getFirstName());

		assertEquals(1,userList.size());
	}

	@Test
	public void testForSaveUserMockMVC () throws Exception {

		User user = new User().withFirstName ("Anil").withLastName ("Varma").withAge (26);
		/*ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(user);
		System.out.println(requestJson);*/

		this.mockMvc.perform(post("/userCtrl/saveUser").contentType("application/json").content("{\n" +
				"  \"id\" : null,\n" +
				"  \"firstName\" : \"Anil\",\n" +
				"  \"lastName\" : \"Varma\",\n" +
				"  \"age\" : 26\n" +
				"}")).andDo(print()).andExpect(status().isOk());
		/*this.mockMvc.perform(get("/userCtrl/users")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(user.getFirstName())));*/
	}

	/*@Test
	public void testForSaveUserMockMVC () throws Exception {

		User user = new User().withFirstName ("Anil").withLastName ("Varma").withAge (26);
		userServiceImpl.saveService(user);
		this.mockMvc.perform (get ("/userCtrl/users")).andDo (print ()).andExpect (status ().isOk ()).equals(user.getFirstName ().equalsIgnoreCase ("Anil"));
	}*/

	/*@Test
	public void contextLoads() {
	}*/

	@Test
	public void checkForHelloWorldMessage () throws Exception {
		this.mockMvc.perform (get ("/hello/hw")).andDo (print ()).andExpect (status ().isOk ())
				.andExpect (content ().string (containsString ("Hello World!")));
	}

	@Test
	public void checkForHelloWorldMessageWithName () throws Exception {
		this.mockMvc.perform (get ("/hello/hw/Anil")).andDo (print ()).andExpect (status ().isOk ())
				.andExpect (content ().string (containsString ("Hello Anil!")));
	}


}