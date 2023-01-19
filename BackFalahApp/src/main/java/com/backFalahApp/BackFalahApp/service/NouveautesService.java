package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.Dto.AdDTO;
import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.NouveauteDto;
import com.backFalahApp.BackFalahApp.Dto.NouveauteRequest;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.model.Nouveautes;
import com.backFalahApp.BackFalahApp.repository.NouveautesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NouveautesService {

    private final NouveautesRepository nouveautesRepository;

    private final FileService fileService;

    public Nouveautes saveNouveautes(NouveauteRequest nouveauteRequest) throws IOException, NoSuchAlgorithmException {

        Nouveautes nouveautes = new Nouveautes(nouveauteRequest.getTitle(),nouveauteRequest.getDescription(), LocalDateTime.now());

        fileService.uploadImageNews(nouveautes,nouveauteRequest.getImage());
        nouveautesRepository.save(nouveautes);

        return nouveautes;
    }

    public List<NouveauteDto> getNouveautes() {
        List<Nouveautes> nouveautes =  nouveautesRepository.findAll();

        return nouveautes.stream().map((news) -> {
            NouveauteDto newsDto =  new NouveauteDto(news.getId(),news.getTitle(), news.getDescription(), news.getImage());

            return newsDto;
        }).collect(Collectors.toList());
    }
}
