package com.bananahrm.hrms.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/check-health")
public class HomeController {
    @GetMapping()
    public String getMethodName() {
        return new String("ok");
    }
    
}
