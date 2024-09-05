package com.northcoders.record_shop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.controllers.RecordManagerController;
import com.northcoders.record_shop.model.RecordModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.northcoders.record_shop.service.RecordManagerServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

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

    @Test
    public void testGetAllRecordsReturnsRecords() throws Exception {

        List<RecordModel> recordList = new ArrayList<>();
        recordList.add(new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3));
        recordList.add(new RecordModel(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
        recordList.add(new RecordModel(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
        recordList.add(new RecordModel(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordServiceImpl.getAllRecords()).thenReturn(recordList);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/record/all-records"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].albumName").value("Vol.3: The Subliminal Verses"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].albumName").value("Follow the Leader"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].albumName").value("Nevermind"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].albumName").value("Enema Of The State"));

    }

    @Test
    public void testGetByIdReturnsRecord() throws Exception {

        Long testId = 1L;
        RecordModel test1 = new RecordModel(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordServiceImpl.getRecordById(testId)).thenReturn(test1);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/record/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Vol.3: The Subliminal Verses"));
    }

}