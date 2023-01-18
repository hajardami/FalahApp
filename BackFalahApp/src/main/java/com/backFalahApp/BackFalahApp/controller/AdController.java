package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.CustomAd;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.service.AdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

@RestController
@RequestMapping(path = "annonces")
@AllArgsConstructor
public class AdController {

    private final AdService adService;

    @PostMapping(path = "save.ad",
    consumes = "multipart/form-data",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advert> saveAd(@ModelAttribute AdRequest adRequest) throws IOException, NoSuchAlgorithmException {
        adService.saveAd(adRequest);
        return new ResponseEntity<>(
                adService.saveAd(adRequest),
                HttpStatus.CREATED
        );
    }
/*    @PostMapping(path = "/create/client",
            consumes = "multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> createClient(@ModelAttribute AppUserDto client) throws Throwable {
        AppUser appUser=new AppUser(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(),AppUserRole.USER,client.getProfession());
        fileService.uploadImageUser(appUser,client.getImage());
        return new ResponseEntity<>(
                userService.createUser(appUser),
                HttpStatus.CREATED
        );
    }*/
    @GetMapping(path = "adverts")
    public Collection<CustomAd> getAdverts() throws IOException {
        return adService.getAds();
    }
}
