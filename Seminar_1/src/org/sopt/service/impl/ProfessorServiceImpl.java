package org.sopt.service.impl;

import org.sopt.model.Professor;
import org.sopt.model.builder.ProfessorBuilder;
import org.sopt.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

    @Override
    public Professor getByProfessorIdx(int profId) {
        final ProfessorBuilder pb = new ProfessorBuilder();
        return pb.setProId(profId)
                .setDept("컴퓨터학과")
                .setName("한혁")
                .setSubject("알고리즘")
                .setTelephone("010").build();
    }
}
