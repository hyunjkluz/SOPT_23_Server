package org.sopt.seminar_3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar_3.model.User;
import org.sopt.seminar_3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userservice) {
        this.userService = userservice;
    }

    @GetMapping("")
    public ResponseEntity findByEntity(@RequestParam(value = "part", defaultValue = "") final String part,
                                     @RequestParam(value = "name", defaultValue = "") final String name) {
        if (name.equals("") && part.equals("")) {
            return new ResponseEntity(userService.findAll(), HttpStatus.OK);
        } else if (!name.equals("")) {
            return new ResponseEntity(userService.findByUserName(name), HttpStatus.OK);
        } else if (!part.equals("")) {
            return new ResponseEntity(userService.findByUserPart(part), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/{user_idx}")
    public ResponseEntity findByUserIdx(@PathVariable(value = "user_idx") final int user_idx) {
        return new ResponseEntity(userService.findByUserIdx(user_idx), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity saveUser(@RequestBody final User user) {
        return new ResponseEntity(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("/{user_idx}")
    public ResponseEntity updateUser(@PathVariable(value = "user_idx")final int user_idx,
                                     @RequestBody final User user) {
        return new ResponseEntity(userService.updatebyUserIdx(user_idx, user), HttpStatus.OK);
    }

    @DeleteMapping("/{user_idx}")
    public ResponseEntity updateUser(@PathVariable(value = "user_idx")final int user_idx) {
        return new ResponseEntity(userService.deleteByUserIdx(user_idx), HttpStatus.OK);
    }
}
