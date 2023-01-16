package com.backFalahApp.BackFalahApp.repository;
import com.backFalahApp.BackFalahApp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository<T extends AppUser> extends JpaRepository<T, Long> {
    Optional<T> findByEmail(String email);
    Optional<T> findById(long id);
  //  List<T> findByFirstNameAndLastName(String firstName, String lastName);
  //  boolean deleteByEmail(String email);
boolean existsByEmail(String email);
}
