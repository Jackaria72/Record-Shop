package com.northcoders.record_shop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.model.Album;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.northcoders.record_shop.service.RecordManagerServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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
    public void testGetAllAlbumsReturnsAlbums() throws Exception {

        List<Album> recordList = new ArrayList<>();
        recordList.add(new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3));
        recordList.add(new Album(2L, "Follow the Leader", "Korn", "nuMetal", 1998, 2));
        recordList.add(new Album(3L, "Nevermind", "Nirvana", "Grunge", 1991, 35));
        recordList.add(new Album(4L, "Enema Of The State", "blink-182", "pop-punk", 1999, 1));

        when(mockRecordServiceImpl.getAllAlbums()).thenReturn(recordList);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/album/all-albums"))
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
    public void testGetByIdReturnsAlbum() throws Exception {

        Long testId = 1L;
        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordServiceImpl.getAlbumById(testId)).thenReturn(test1);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/album/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.albumName").value("Vol.3: The Subliminal Verses"));
    }

    @Test
    public void testPostMappingAddAnAlbum() throws Exception {

        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordServiceImpl.insertAlbum(test1)).thenReturn(test1);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.post("/api/v1/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(test1)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(mockRecordServiceImpl, times(1)).insertAlbum(test1);

    }
    @Test
    public void testPutMappingUpdatesAnAlbum() throws Exception {

        Long id = 1L;
        Album test1 = new Album(1L, "Vol.3: The Subliminal Verses", "Slipknot", "nuMetal", 2004, 3);

        when(mockRecordServiceImpl.updateAlbumById(test1, id)).thenReturn(test1);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.put("/api/v1/album/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(test1)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        verify(mockRecordServiceImpl, times(1)).updateAlbumById(test1, id);

    }
    @Test
    public void testDeleteMappingDeletesAnAlbum() throws Exception {
        Long id = 1L;

        doNothing().when(mockRecordServiceImpl).deleteAlbumById(id);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.delete("/api/v1/album/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}