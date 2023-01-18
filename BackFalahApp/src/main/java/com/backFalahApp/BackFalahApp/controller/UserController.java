package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.AppUserDto;
import com.backFalahApp.BackFalahApp.Dto.ExpertDto;
import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;
import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.model.Expert;
import com.backFalahApp.BackFalahApp.service.ExpertService;
import com.backFalahApp.BackFalahApp.service.FileService;
import com.backFalahApp.BackFalahApp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class UserController {

    ExpertService expertService;
    UserService userService;
    FileService fileService;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserController(ExpertService expertService, UserService userService, FileService  fileService) {
        this.expertService = expertService;
        this.userService = userService;
        this.fileService=fileService;
    }


    @GetMapping(path = "/list")
    public ResponseEntity<AppUser> listAllCoaches() {
        return new ResponseEntity<AppUser>(
                userService.getUserWithEmail("hajar@gmail.com"),
                HttpStatus.OK
        );
    }
    // create users:

    @PostMapping(path = "/create/expert",
            consumes = "multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Expert> createCoach(@ModelAttribute ExpertDto expertDto) throws Throwable {
        System.out.println(expertDto.getEmail());
        LOG.debug("new /create/expert request : " + expertDto.getEmail());
        return new ResponseEntity<>(
                expertService.createExpert(expertDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/client",
            consumes = "multipart/form-data",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> createClient(@ModelAttribute AppUserDto client) throws Throwable {
        AppUser appUser=new AppUser(client.getFirstName(), client.getLastName(), client.getEmail(), client.getPassword(),AppUserRole.USER,client.getProfession());
        fileService.uploadImageUser(appUser,client.getImage());
        return new ResponseEntity<>(
                userService.createUser(appUser),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/superuser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> createSuperUser(@RequestBody AppUser superUser) throws Throwable {
        superUser.setRole(AppUserRole.ADMIN);
        return new ResponseEntity<>(
                userService.createUser(superUser),
                HttpStatus.CREATED
        );
    }

}

/*

    // list users
   /* @GetMapping(path = "/list/coach/all")
    public ResponseEntity<List<Coach>> listAllCoaches(){
        return new ResponseEntity<>(
                coachService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list/client/all")
    public ResponseEntity<List<Client>> listAllClients(){
        return new ResponseEntity<>(
                clientService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list/superuser/all")
    public ResponseEntity<List<SuperUser>> listAllSuperUsers(){
        return new ResponseEntity<>(
                superUserService.getAllUsers(),
                HttpStatus.OK
        );
    }

    // delete users:

    @DeleteMapping(path = "/delete/ByEmail")
    public ResponseEntity<Void> deleteUserByEmail(@RequestHeader @Email(message = "must be an email") String email) {
        userService.deleteUserWithEmail(email);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete/ById/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        userService.deleteUserWithId(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteCurrentUser(@RequestHeader("Authorization") String jwtToken) {
        if (jwtToken == null || !jwtToken.startsWith(JwtProperties.TOKEN_PREFIX)){
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                userService.deleteUserWithToken(jwtToken)
        );
    }

    @PutMapping(path = "/changePassword")
    public ResponseEntity<Void> changePassword(@RequestBody JwtChangePassword jwtChangePassword,
                                               @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                userService.changePasswordFromToken(jwtToken, jwtChangePassword)
        );
    }

    @PutMapping(path = "/changePassword/{id}")
    public ResponseEntity<Void> changePasswordById(@RequestBody JwtChangePassword jwtChangePassword,
                                                   @PathVariable long id) {
        return new ResponseEntity<>(
                userService.changePasswordById(id, jwtChangePassword)
        );
    }

    @PostMapping(path = "/forgotPassword")
    public ResponseEntity<Void> forgotPassword(@RequestHeader String email) {
        return new ResponseEntity<>(
                userService.forgotPassword(email)
        );
    }
}
*/