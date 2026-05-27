package lk.ijse.aad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/api")
@Slf4j
public class Test {

    @GetMapping(value = "/ping")
    public String ping(){
        log.info("---------- Request is here ----------");
        log.info("---------- Request is processing ----------");
        return "Application is running...";
    }
}