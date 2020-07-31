// package com.socialNetwork.restservice;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class SocialNetworkControllerTests {

// 	@Autowired
// 	SocialNetworkRepository socialNetworkRepository;

// 	@Autowired
// 	private MockMvc mockMvc;

// 	// @Test
// 	// public void succesfulRegister() throws Exception {
// 	// 	this.mockMvc.perform(post("/register")).andDo(print()).andExpect(status().isOk())
// 	// 			.andExpect(jsonPath("$.content").value("Hello, World!"));
// 	// }

// 	// @Test
// 	// public void unsuccesfulRegister() throws Exception {

// 	// 	this.mockMvc.perform(post("/register").param("name", "Spring Community"))
// 	// 			.andDo(print()).andExpect(status().isOk())
// 	// 			.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
// 	// }

// 	@Test
// public void registerUserSuccesful() throws Exception 
// {
// 	this.mockMvc.perform( MockMvcRequestBuilders
//       .post("/register")
// 	  .content(asJsonString(new User("Nombre", "PWD")))
//       .contentType(MediaType.APPLICATION_JSON)
//       .accept(MediaType.APPLICATION_JSON))
//       .andExpect(status().isOk())
//       .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
// }

// 	@Test
// public void registerUserUnsuccesfulName() throws Exception 
// {
// 	this.mockMvc.perform( MockMvcRequestBuilders
//       .post("/register")
// 	  .content(asJsonString(new User("Nombre", "Contrasena")))
//       .contentType(MediaType.APPLICATION_JSON)
//       .accept(MediaType.APPLICATION_JSON))
//       .andExpect(status().isNotFound())
//       .andExpect(status().reason("The user is not correct, it must contain between 5 and 10 characters"));
// }

// 	@Test
// public void registerUserUnsuccesfulNameRepeated() throws Exception 
// {
// 	this.mockMvc.perform( MockMvcRequestBuilders
//       .post("/register")
// 	  .content(asJsonString(new User("Nombre", "Contrasena")))
//       .contentType(MediaType.APPLICATION_JSON)
//       .accept(MediaType.APPLICATION_JSON))
//       .andExpect(status().isNotFound())
//       .andExpect(status().reason("The user is not correct, user already in use"));
// }

// public void registerUserUnsuccesfulPwd() throws Exception 
// {
// 	this.mockMvc.perform( MockMvcRequestBuilders
//       .post("/register")
// 	  .content(asJsonString(new User("Rey", "Contrasena")))
//       .contentType(MediaType.APPLICATION_JSON)
//       .accept(MediaType.APPLICATION_JSON))
//       .andExpect(status().isNotFound())
//       .andExpect(status().reason("The password is not correct, it must contain between 8 and 12 characters"));
// }
 
// public static String asJsonString(final Object obj) {
//     try {
//         return new ObjectMapper().writeValueAsString(obj);
//     } catch (Exception e) {
//         throw new RuntimeException(e);
//     }
// }

// }
