package com.socialNetwork.restservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SocialNetworkControllerTests {

	@Autowired
	SocialNetworkRepository socialNetworkRepository;

	@Autowired
    private MockMvc mockMvc;


	// @Test
	// public void succesfulRegister() throws Exception {
	// 	this.mockMvc.perform(post("/register")).andDo(print()).andExpect(status().isOk())
	// 			.andExpect(jsonPath("$.content").value("Hello, World!"));
	// }

	// @Test
	// public void unsuccesfulRegister() throws Exception {

	// 	this.mockMvc.perform(post("/register").param("name", "Spring Community"))
	// 			.andDo(print()).andExpect(status().isOk())
	// 			.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	// }

	@Test
public void registerUserSuccesful() throws Exception 
{
	this.mockMvc.perform( MockMvcRequestBuilders
      .post("/register")
	  .content(asJsonString(new User("UserName", "Password")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.content().string("{\"message\": \"User created\"}"));
}

	@Test
public void registerUserUnsuccesfulName() throws Exception 
{
	this.mockMvc.perform( MockMvcRequestBuilders
      .post("/register")
	  .content(asJsonString(new User("Usu", "Password")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound())
      .andExpect(MockMvcResultMatchers.content().string("The name is not correct, name must have between 5 and 10 alfanumerics"));
    //   .andExpect(status().reason("The name is not correct, name must have between 5 and 10 alfanumerics"));
}

	@Test
public void registerUserUnsuccesfulNameRepeated() throws Exception 
{
    socialNetworkRepository.save(new User("UserId", "Password"));
	this.mockMvc.perform( MockMvcRequestBuilders
      .post("/register")
	  .content(asJsonString(new User("UserId", "Password")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound())
      .andExpect(MockMvcResultMatchers.content().string("The name is not correct, name already in use"));
}

@Test
public void registerUserUnsuccesfulPwd() throws Exception 
{
	this.mockMvc.perform( MockMvcRequestBuilders
      .post("/register")
	  .content(asJsonString(new User("UserName", "Pwd")))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound())
      .andExpect(MockMvcResultMatchers.content().string("The password is not correct, password must have between 8 and 12 alfanumerics"));
}
 
public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}
