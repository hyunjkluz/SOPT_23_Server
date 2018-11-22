package org.sopt.seminar_3.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userIdx;
    private String name, part;
}
