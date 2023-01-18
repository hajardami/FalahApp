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
    @Query(value = "SELECT advert.id, advert.title, advert.createdat, advert.description, advert.type,  appuser.email,  appuser.firstname, appuser.lastname\n" +
            "FROM advert, appuser \n" +
            "WHERE advert.userid = appuser.id\n" +
            "ORDER BY advert.createdat DESC;", nativeQuery = true)
    Collection<CustomAd> getAdverts();
}
