package com.northcoders.record_shop.service;

import com.northcoders.record_shop.repository.ArtistManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistManagerServiceImpl implements ArtistManagerService {

    @Autowired
    ArtistManagerRepository artistManagerRepository;


}
