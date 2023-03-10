package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.Dto.AdDTO;
import com.backFalahApp.BackFalahApp.Dto.AdRequest;
import com.backFalahApp.BackFalahApp.Dto.CustomAd;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.repository.AdRepository;
import com.backFalahApp.BackFalahApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdService {
    private final AdRepository adRepository;
    //private final AppUserRepository appUserRepository;

    private final UserRepository<AppUser> userRepository;

    private final UserService userService;

private final FileService fileService;
    /*public Collection<CustomAd> getAds() {
        // delete expired ads
        Collection<CustomAd> adverts = this.adRepository.getAdverts();
        return  adverts;
    }*/

    public List<AdDTO> getAds() {
        List<Advert> adverts =  adRepository.findAll();
        return adverts.stream().map((advert) -> {
            AdDTO adDTO =  new AdDTO(advert.getId(), advert.getAppUser().getFirstname(), advert.getAppUser().getLastname(), advert.getType(), advert.getTitle(), advert.getDescription(), advert.getCreatedat(), advert.getImage());

            return adDTO;
        }).collect(Collectors.toList());
    }

    public Advert saveAd(AdRequest adRequest) throws IOException, NoSuchAlgorithmException {
        AppUser appUser = userRepository.findByEmail(adRequest.getEmailUser()).get();

        Advert ad = new Advert(adRequest.getTitle(),adRequest.getDescription(), LocalDateTime.now(), adRequest.getType(),
                appUser);

        fileService.uploadImageAdvert(ad,adRequest.getImage());
        adRepository.save(ad);
        return ad;
    }
}
