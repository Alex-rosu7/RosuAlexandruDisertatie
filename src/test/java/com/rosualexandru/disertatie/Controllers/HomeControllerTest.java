//package com.rosualexandru.disertatie.Controllers;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.security.test.context.support.WithMockUser;
//import com.rosualexandru.disertatie.Config.SecurityConfig;
//import com.rosualexandru.disertatie.Services.TokenService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebMvcTest({HomeController.class, AuthController.class})
//@Import({SecurityConfig.class, TokenService.class})
//class HomeControllerTest {
//
//    @Autowired
//    MockMvc mvc;
//
//    @Test
//    void rootWhenUnauthenticatedThen401() throws Exception {
//        this.mvc.perform(get("/"))
//                .andExpect(status().isUnauthorized());
//    }
//
//    @Test
//    void rootWhenAuthenticatedThenSayHelloUser() throws Exception {
//        MvcResult result = this.mvc.perform(post("/token")
//                        .with(httpBasic("alex", "alex")))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String token = result.getResponse().getContentAsString();
//
//        this.mvc.perform(get("/")
//                        .header("Authorization", "Bearer " + token))
//                .andExpect(content().string("Hello, alex :) !"));
//
//    }
//
//    @Test
//    @WithMockUser
//    public void rootWithMockUserStatusIsOK() throws Exception {
//        this.mvc.perform(get("/")).andExpect(status().isOk());
//    }
//}