package org.sopt.seminar_3.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {

    @GetMapping("")
    public String defaultMain() {
        return (new Date()).toString();
    }

}
