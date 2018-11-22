package org.sopt.seminar_5.api;


import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar_5.dto.User;
import org.sopt.seminar_5.model.SignUpReq;
import org.sopt.seminar_5.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static org.sopt.seminar_5.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userservice) {
        this.userService = userservice;
    }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("name") final Optional<String> name,
                                  @RequestParam("part") final Optional<String> part) {
        try {
            if (name.isPresent())
                return new ResponseEntity<>(userService.findByUserName(name.get()), HttpStatus.OK);
            if (part.isPresent())
                return new ResponseEntity(userService.findByUserPart(part.get()), HttpStatus.OK);

            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity signup(SignUpReq signUpReq, @RequestPart(value = "profile", required = false) final MultipartFile profile) {
        try {
            //파일을 signUpReq 에 저장
            if (profile != null)
                signUpReq.setProfile(profile);
            return new ResponseEntity<>(userService.saveUser(signUpReq), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{userIdx}")
    public ResponseEntity updateUser( @PathVariable(value = "userIdx") final int userIdx,
                                      @RequestBody final User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(userIdx, user), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userIdx}")
    public ResponseEntity deleteUser(@PathVariable(value = "userIdx") final int userIdx) {
        try {
            return new ResponseEntity<>(userService.deleteUser(userIdx), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}