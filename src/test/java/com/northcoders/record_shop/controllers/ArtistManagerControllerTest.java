package com.northcoders.record_shop.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.Artist;
import com.northcoders.record_shop.service.ArtistManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ArtistManagerControllerTest {

    @MockBean
    private ArtistManagerServiceImpl mockArtistServiceImpl;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mapper = new ObjectMapper();
    }

    @Test
    void testGetAllArtistsReturnsAllArtists() throws Exception {

        Set<Album> albums = new HashSet<>();
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist(1L, "Slipknot", albums));
        artistList.add(new Artist(2L, "Korn", albums));
        artistList.add(new Artist(3L, "Nirvana", albums));
        artistList.add(new Artist(4L, "blink-182", albums));

        when(mockArtistServiceImpl.getAllArtists()).thenReturn(artistList);


        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/artist/all-artists"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].artistName").value("Slipknot"));
    }
    @Test
    void testGetArtistByIdReturnsArtist() throws Exception {

        Long testId = 1L;
        Set<Album> albums = new HashSet<>();
        Artist test1 = new Artist(1L, "Slipknot", albums);

        when(mockArtistServiceImpl.getArtistById(testId)).thenReturn(test1);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/artist/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artistName").value("Slipknot"));

    }
    @Test
    void testAddArtistAddsArtist() throws Exception {

        Long testId = 1L;
        Set<Album> albums = new HashSet<>();
        Artist test1 = new Artist(1L, "Slipknot", albums);

        when(mockArtistServiceImpl.insertArtist(test1)).thenReturn(test1);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/artist")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(test1)))
                .andExpect(status().isCreated());

        verify(mockArtistServiceImpl, times(1)).insertArtist(test1);
    }
}