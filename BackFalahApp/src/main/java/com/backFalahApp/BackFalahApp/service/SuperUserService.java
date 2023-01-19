package com.backFalahApp.BackFalahApp.service;
import com.backFalahApp.BackFalahApp.exceptions.UserNotFoundException;
import com.backFalahApp.BackFalahApp.model.SuperUser;
import com.backFalahApp.BackFalahApp.repository.SuperUserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional

public class SuperUserService extends UserService<SuperUser> {
    public SuperUserService(SuperUserRepository superUserRepository, EmailSenderService emailSenderService, PasswordEncoder passwordEncoder) {
        super(superUserRepository, emailSenderService, passwordEncoder);
    }

    public SuperUser findCurrentSuperUser() {
        System.out.println("search for this email");
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(email);
        Optional<SuperUser> admin = userRepository.findByEmail(email);
        System.out.println(admin.get());
        if (admin.isPresent())
            return admin.get();
        throw new UserNotFoundException(email);
    }
}
