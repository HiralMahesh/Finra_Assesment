package com.finra.assessment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class CombinationGeneratorControllerTest {
    @Autowired
    MockMvc mockMvc;

    //Test for Invalid Input
    @Test
    public void combinationsInvalidInputTest()throws Exception {
        String sampleInput = "321";
        MvcResult mvcResult = this.mockMvc.perform(get("/"+sampleInput)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.NOT_FOUND.value(),response.getStatus());
    }

    //Test for Valid Input
    @Test
    public void combinationsValidInputTest()throws Exception {
        String sampleInput = "7654321";
        MvcResult mvcResult = this.mockMvc.perform(get("/"+sampleInput)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

}
