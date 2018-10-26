package org.sopt.service.impl;

import org.sopt.model.University;
import org.sopt.model.builder.UniversityBuilder;
import org.sopt.service.UniversityService;

public class UniversityServiceImpl implements UniversityService {
    @Override
    public University getByUniversityIdx(int uniId) {
        final UniversityBuilder ub = new UniversityBuilder();

        final University uni = ub
                .setUniId(uniId)
                .setName("동덕여자대학교")
                .setAddress("성북구 화랑로 13")
                .setTelephone("02-940-4000")
                .build();

        return uni;
    }
}
