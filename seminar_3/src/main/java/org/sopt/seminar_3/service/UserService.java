package org.sopt.seminar_3.service;

import org.sopt.seminar_3.model.DefaultRes;
import org.sopt.seminar_3.model.User;

import java.util.List;

public interface UserService {
    DefaultRes<List<User>> findAll();
    DefaultRes<User> findByUserIdx(final int userIdx);
    DefaultRes<User> findByUserName(final String name);
    DefaultRes<List<User>> findByUserPart(final String part);
    DefaultRes saveUser (final User user);
    DefaultRes<User> updatebyUserIdx (final int userIdx, final User user);
    DefaultRes deleteByUserIdx (final int userIdx);
}
