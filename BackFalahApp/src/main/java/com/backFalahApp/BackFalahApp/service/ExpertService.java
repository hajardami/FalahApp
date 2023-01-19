package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.Dto.AdDTO;
import com.backFalahApp.BackFalahApp.Dto.ExpertDto;
import com.backFalahApp.BackFalahApp.Dto.ExpertListDTO;
import com.backFalahApp.BackFalahApp.Dto.ExpertNotVDTO;
import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;
import com.backFalahApp.BackFalahApp.enumerations.ExpertDocuments;
import com.backFalahApp.BackFalahApp.exceptions.ExpertNotFoundException;
import com.backFalahApp.BackFalahApp.model.Advert;
import com.backFalahApp.BackFalahApp.model.Expert;
import com.backFalahApp.BackFalahApp.repository.ExpertRepository;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional

public class ExpertService extends UserService<Expert>{

    ExpertRepository expertRepository;
    private FileService fileService;

    public ExpertService(ExpertRepository expertRepository, EmailSenderService emailSenderService,
                         PasswordEncoder passwordEncoder, @Lazy FileService fileService) {
        super(expertRepository, emailSenderService, passwordEncoder);
        this.expertRepository = expertRepository;
        this.fileService = fileService;
    }

//    @Autowired
//    public void setFileService(FileService fileService) {
//        this.fileService = fileService;
//    }

    public boolean exists(Expert expert) {
        if (Objects.isNull(expert)) {
            return false;
        }
        return userRepository.existsById(expert.getId());
    }
    public Expert findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public Expert findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void setExpertDocument(@NotNull Expert expert, @NotNull ExpertDocuments expertDocuments, @NotNull String documentPath) {
        if (expertDocuments == ExpertDocuments.IDENTITY_DOCUMENT) {
            expert.setIdentityDocument(documentPath);
        }else if (expertDocuments == ExpertDocuments.EXPERT_CERTIFICATE) {
            expert.setExpertCertificate(documentPath);
        }else if (expertDocuments == ExpertDocuments.IMAGE){
            expert.setPersonalphoto(documentPath);
        }else {
            throw new IllegalArgumentException("Invalid document type");
        }
        userRepository.save(expert);
    }


    public Expert createExpert(ExpertDto expertDto) throws IOException, NoSuchAlgorithmException {
             Expert expert= new Expert(expertDto.getFirstName(),expertDto.getLastName(),expertDto.getEmail(),expertDto.getPassword(), AppUserRole.EXPERT,expertDto.getProfession(),expertDto.getDescription(),expertDto.getPhone());
        createUser(expert);
        fileService.uploadExpertDocuments(expert,expertDto.getExpertCertificate(),ExpertDocuments.EXPERT_CERTIFICATE);
        fileService.uploadExpertDocuments(expert,expertDto.getIdentityDocument(),ExpertDocuments.IDENTITY_DOCUMENT);
        fileService.uploadExpertDocuments(expert,expertDto.getImage(),ExpertDocuments.IMAGE);
        return expert;
    }

    public Expert findCurrentExpert() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Expert> coach = expertRepository.findByEmail(email);
        if (coach.isPresent())
            return coach.get();
        throw new ExpertNotFoundException(email);
    }


    public HttpStatus verifyCoach(long coach_id) {
        Expert expert = getUserWithId(coach_id);
        expert.setVerified(true);
        expertRepository.save(expert);
        return HttpStatus.OK;
    }


    public List<ExpertNotVDTO> listNotVerified() {
        return expertRepository.findExpertByVerified(false).stream().map(
                expert -> new ExpertNotVDTO(expert.getId(),expert.getFirstname() + " " + expert.getLastname(),expert.getExpertCertificate(),
                        expert.getIdentityDocument(),expert.getPersonalphoto())
        ).collect(Collectors.toList());
    }


    public List<ExpertListDTO> getExperts() {
        List<Expert> experts =  expertRepository.findAll();
        return experts.stream().map((expert) -> {
            ExpertListDTO adDTO =  new ExpertListDTO(expert.getId(),expert.getFirstname(),expert.getLastname(),expert.getEmail(), expert.getProfession(), expert.getDescription(),expert.getPhone(),expert.getPersonalphoto());
            return adDTO;
        }).collect(Collectors.toList());
    }

}



