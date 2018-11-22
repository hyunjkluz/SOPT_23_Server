package org.sopt.seminar_5.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("")
public class DefaultController {

    @GetMapping("")
    public String hello() {
        return (new Date()).toString();
    }
}
