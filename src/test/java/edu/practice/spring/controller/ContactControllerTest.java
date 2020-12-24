package edu.practice.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring.App;
import edu.practice.spring.domain.ContactDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("h2")
@SpringBootTest(classes = App.class) //load complete application context for end to end integration testing
@RunWith(SpringRunner.class) //provide a bridge between Spring Boot test features and JUnit
@AutoConfigureMockMvc //auto-configuration related to the web layer
public class ContactControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void should_create_contact() throws Exception {
        ContactDTO dto = new ContactDTO();
        MvcResult mvcResult = this.mockMvc.perform(post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andReturn();
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        ContactDTO actualResponse = objectMapper.readValue(actualResponseBody, ContactDTO.class);
        ContactDTO expectedResponse = new ContactDTO();
        expectedResponse.setId(1L);
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
    }

}
