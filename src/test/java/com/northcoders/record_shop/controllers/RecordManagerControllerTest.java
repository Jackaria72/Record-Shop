package com.northcoders.record_shop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.controllers.RecordManagerController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.northcoders.record_shop.service.RecordManagerServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class RecordManagerControllerTest {

    @Mock
    private RecordManagerServiceImpl mockRecordServiceImpl;

    @InjectMocks
    private RecordManagerController recordManagerController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(recordManagerController).build();
        mapper = new ObjectMapper();
    }

}