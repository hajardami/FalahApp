package com.backFalahApp.BackFalahApp.controller;


import com.backFalahApp.BackFalahApp.Dto.AdDTO;
import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.NouveauteDto;
import com.backFalahApp.BackFalahApp.Dto.NouveauteRequest;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.Nouveautes;
import com.backFalahApp.BackFalahApp.service.NouveautesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(path = "nouveautes")
@AllArgsConstructor
public class NouveautesController {
    private final NouveautesService nouveautesService;

    @PostMapping(path = "save.news",
            consumes = "multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Nouveautes> saveNews(@ModelAttribute NouveauteRequest newsRequest) throws IOException, NoSuchAlgorithmException {
        //adService.saveAd(adRequest);
        return new ResponseEntity<>(
                nouveautesService.saveNouveautes(newsRequest),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "news")
    public ResponseEntity<List<NouveauteDto>> getNouveautes() {
        return new ResponseEntity<>(
                nouveautesService.getNouveautes(),
                HttpStatus.OK
        );
    }
}
