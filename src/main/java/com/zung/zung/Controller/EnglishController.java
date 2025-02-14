package com.zung.zung.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.zung.zung.Entity.English;
import com.zung.zung.Service.EnglishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EnglishController {

    @Autowired
    private EnglishService englishService;

    public EnglishController(EnglishService englishService) {
        this.englishService = englishService;
    }


    @PostMapping("/newenglishstudent")
    public English newEnglishStudent(@RequestBody English english) {
     return englishService.registerEnglishStudent(english);
    }
    
    
}
