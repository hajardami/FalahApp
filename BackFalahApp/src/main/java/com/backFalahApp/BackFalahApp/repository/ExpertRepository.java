package com.backFalahApp.BackFalahApp.repository;

import com.backFalahApp.BackFalahApp.model.Expert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpertRepository extends UserRepository<Expert>{

    public List<Expert> findExpertByVerified(boolean verified);

}
