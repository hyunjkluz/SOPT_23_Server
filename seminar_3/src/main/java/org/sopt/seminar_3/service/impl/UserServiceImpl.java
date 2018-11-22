package org.sopt.seminar_3.service.impl;

import org.sopt.seminar_3.model.DefaultRes;
import org.sopt.seminar_3.model.User;
import org.sopt.seminar_3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {
    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if (userList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트가 비었습니다");
        return DefaultRes.res(HttpStatus.OK.value(), "리스트 조회 성공", userList);
    }

    @Override
    public DefaultRes<User> findByUserIdx(int userIdx) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx)
                return DefaultRes.res(HttpStatus.OK.value(), "user 조회 성공", u);
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 user를 찾을 수 없습니다.");
    }

    @Override
    public DefaultRes<User> findByUserName(String name) {
        for (User u : userList) {
            if (u.getName().equals(name))
                return DefaultRes.res(HttpStatus.OK.value(), "user 조회 성공", u);
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 user를 찾을 수 없습니다.");
    }

    @Override
    public DefaultRes<List<User>> findByUserPart(String part) {
        List<User> partList = new LinkedList<>();

        for (User u : userList) {
            if (u.getPart().equals(part))
                partList.add(u);

        }

        if (partList != null) {
            return DefaultRes.res(HttpStatus.OK.value(), "user 조회 성공", partList);
        } else {
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 user를 찾을 수 없습니다.");
        }

    }

    @Override
    public DefaultRes saveUser(User user) {
        userList.add(user);
        return DefaultRes.res(HttpStatus.OK.value(), "user 등록 성공");
    }

    @Override
    public DefaultRes<User> updatebyUserIdx(int userIdx, User user) {
        for (User u : userList) {
            if (u.getUserIdx() == userIdx) {
                userList.remove(u);
                userList.add(user);
                return DefaultRes.res(HttpStatus.OK.value(), "user 정보 수정 성공");
            }
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 user를 찾을 수 없습니다.");
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        for (User u : userList) {
            if(u.getUserIdx() == userIdx)
                userList.remove(u);
            return DefaultRes.res(HttpStatus.OK.value(), "user 삭제 성공");
        }
        return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "해당 user를 찾을 수 없습니다.");
    }
}
