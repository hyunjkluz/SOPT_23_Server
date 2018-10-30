package org.sopt.seminar_2.api;

import org.sopt.seminar_2.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class UserController {
    public ArrayList<User> userList = new ArrayList<User>();

    @GetMapping("")
    public String hello() {
        userList.add(new User(1, "김현진", "Server"));
        userList.add(new User(2, "이민형", "Design"));
        userList.add(new User(3, "강수진", "Android"));
        userList.add(new User(4, "배다슬", "Server"));
        return (new Date()).toString();
    }

    @GetMapping("users")
    public String check(@RequestParam(value = "part", defaultValue = "") final String part,
                            @RequestParam(value = "name", defaultValue = "") final String name) {
//   public String check(@RequestParam(value = "part", defaultValue = "") Optional<String> part,
//                          @RequestParam(value = "name", defaultValue = "") Optional<String> name) {

        //final = 이미 주소값을 배정받은 변수에 defaultValue 값이나 파람 값이 들어감
        ArrayList<User> parts = new ArrayList<User>();

        if (name.equals("") && part.equals("")) {
        //if (name != null && part != null) {
            return userList.toString();
        } else if (!name.equals("")) {
            for (User u : userList) {
                if ((u.getName()).equals(name))
                    return u.toString();
            }
            return "해당 이름을 가진 유저가 없습니다.";
        } else if (!part.equals("")) {
            for (User u : userList) {
                if ((u.getPart().equals(part)))
                    parts.add(u);
            }
            if (parts != null) {
                return parts.toString();
            }
            return "해당 파트를 가진 유저가 없습니다.";
        } else {
            return "잘못된 접근입니다.";
        }
    }

    @GetMapping("users/{user_idx}")
    public String searchUser(@PathVariable(value = "user_idx") final int user_idx) {
        for (User u : userList) {
            if (u.getUser_idx() == user_idx)
                return u.toString();
        }
        return "해당 인덱스를 가진 유저가 없습니다.";
    }

    @PostMapping("users")
    public String insertUser(@RequestBody final User user) {
        userList.add(user);
        return user.toString();
    }

    @PutMapping("users/{user_idx}")
    public String updateUser(@PathVariable(value = "user_idx") final int user_idx,
                           @RequestBody final User user) {
        for (User u : userList) {
            if (u.getUser_idx() == user_idx)
                userList.set(userList.indexOf(u), user);
        }
        return user.toString();
    }

    @DeleteMapping("users/{user_idx}")
    public String deleteUser(@PathVariable(value = "user_idx") final int user_idx) {
        for (User u : userList) {
            if (u.getUser_idx() == user_idx) {
                String name = u.getName();
                userList.remove(u);
                return name + " 유저를 삭제하였습니다.";
            }
        }
        return "해당 유저를 찾을 수 없습니다.";
    }
}
