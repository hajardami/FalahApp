package com.backFalahApp.BackFalahApp.repository;

import com.backFalahApp.BackFalahApp.Dto.CustomAd;
import com.backFalahApp.BackFalahApp.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional(readOnly = true)
public interface AdRepository extends JpaRepository<Advert, Long> {
    @Transactional
    @Query(value = "SELECT ad.id, ad.title, ad.createdat, ad.description, ad.type,  appuser.email,  appuser.firstname, appuser.lastname\n" +
            "FROM ad, appuser \n" +
            "WHERE ad.userid = appuser.id\n" +
            "ORDER BY ad.createdat DESC;", nativeQuery = true)
    Collection<CustomAd> getAds();
}
