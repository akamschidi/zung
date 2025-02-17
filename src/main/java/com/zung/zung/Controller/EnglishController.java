package com.zung.zung.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.zung.zung.Entity.English;
import com.zung.zung.Service.EnglishService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




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
    
    @GetMapping("/allenglishstudents")
    public List<English> listOfEnglishStudents() {
        return englishService.listOfAllEnglishStudents();
    }
    
    @GetMapping("/englishstudentbyi/{id}")
    public ResponseEntity<English> englishStudentById(@PathVariable Integer id) {
        return englishService.findEnglishStudentByID(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());
       
    }

    @PutMapping("updateenglishstudent/{id}")
    public ResponseEntity<English> updateEnglishStudent(@PathVariable Integer id, @RequestBody English english) {
            return englishService.updateEnglishStudentDetails(id, english)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound()
                    .build());

    }
    
    @DeleteMapping("/deleteenglishstudent/{id}")
    public ResponseEntity<?> deleteEnglishStudentById(@PathVariable Integer id){
        return englishService.findEnglishStudentByID(id)
                .map(english -> {
                    englishService.deleteEnglishStudent(id);
                    return ResponseEntity.ok()
                    .build();
                }).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }
    
}
