package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.ExpertNotVDTO;
import com.backFalahApp.BackFalahApp.model.SuperUser;
import com.backFalahApp.BackFalahApp.service.ExpertService;
import com.backFalahApp.BackFalahApp.service.SuperUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/superuser")
public class SuperUserController {

    SuperUserService superUserService;
    ExpertService expertService;

    public SuperUserController(SuperUserService superUserService,
                               ExpertService expertService) {
        this.superUserService = superUserService;
        this.expertService = expertService;
    }

    @GetMapping("/verifyExpert")
    public ResponseEntity<Void> verifyCoach(@RequestHeader("expert_id") long coach_id) {
        return new ResponseEntity<>(
                expertService.verifyCoach(coach_id)
        );
    }

    @GetMapping("/listNotVerified")
    public ResponseEntity<List<ExpertNotVDTO>> listNotVerified() {
        return new ResponseEntity<>(
                expertService.listNotVerified(),
                HttpStatus.OK
        );
    }
    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperUser> getPersonalData(){
        return new ResponseEntity<>(
                superUserService.findCurrentSuperUser(),
                HttpStatus.OK
        );
    }
}
