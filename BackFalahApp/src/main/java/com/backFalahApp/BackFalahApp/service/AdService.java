package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.CustomAd;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.repository.AdRepository;
import com.backFalahApp.BackFalahApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AdService {
    private final AdRepository adRepository;
    //private final AppUserRepository appUserRepository;

    private final UserRepository<AppUser> userRepository;

    private final UserService userService;


    public Collection<CustomAd> getAds() {
        // delete expired ads
        Collection<CustomAd> adverts = this.adRepository.getAds();
        return  adverts;
    }

    public Advert saveAd(AdRequest adRequest) throws IOException {
        AppUser appUser = userRepository.findByEmail(adRequest.getEmailUser()).get();

        Advert ad = new Advert(
                adRequest.getTitle(),
                adRequest.getDescription(),
                LocalDateTime.now(),
                adRequest.getType(),
                appUser,
                adRequest.getImage()
        );
        adRepository.save(ad);
        return ad;
    }
}
