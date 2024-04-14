package com.clover;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TreeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateTreeEndpoint() throws Exception {
        this.mockMvc.perform(post("/api/enter-numbers")
                        .contentType("application/json")
                        .content("[10, 20, 5]"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.treeJson").exists());
    }
}

