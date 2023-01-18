package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.CustomAd;
import com.backFalahApp.BackFalahApp.service.AdService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(path = "annonces")
@AllArgsConstructor
public class AdController {

    private final AdService adService;

    @PostMapping(path = "save.ad")
    public void saveAd(@RequestBody AdRequest adRequest) throws IOException {
        adService.saveAd(adRequest);
    }

    @GetMapping(path = "adverts")
    public Collection<CustomAd> getAdverts() throws IOException {
        return adService.getAds();
    }
}
