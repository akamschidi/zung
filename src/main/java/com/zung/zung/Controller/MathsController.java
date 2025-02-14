package com.zung.zung.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.zung.zung.Entity.Maths;
import com.zung.zung.Service.MathService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class MathsController {

    @Autowired
    private MathService mathService;

    public MathsController(MathService mathService) {
        this.mathService = mathService;
    }
    
    @PostMapping("/registermaths")
    public Maths registerMathsStudent(@RequestBody Maths maths) {
       return mathService.registerMathsStudent(maths);
    }

    @GetMapping("/findmathsstudents/{course_code}")
    public ResponseEntity<Maths> findMathsStudent(@PathVariable Integer courseCode) {
       return mathService.findMathsStudentByCourseCode(courseCode)
                .map(ResponseEntity:: ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());

    }

    @GetMapping("/findmathsstudentsid/{id}")
    public ResponseEntity<Maths> getMethodName(@PathVariable Integer id) {
        return mathService.findMathsStudentById(id)
                .map(ResponseEntity:: ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());
    }
    

    @GetMapping("/allmathsstudents")
    public List<Maths> allMathsStudents() {
        return mathService.listOfAllMathsStudents();
    }
    
    @PutMapping("updatemathstudent/{id}")
    public ResponseEntity<Maths> updateMathsStudent(@PathVariable Integer id, @RequestBody Maths mathsStudentDetails) {
        return mathService.updateMathsStudentDetail(id, mathsStudentDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());
   
    }
    
    @DeleteMapping("/deletemathsstudent/{id}")
    public ResponseEntity<?> deleteMathsStudent(@PathVariable Integer id){
       return mathService.findMathsStudentById(id)
                .map(maths -> {
                    mathService.deleteMathsStudent(id);
                    return ResponseEntity.ok()
                    .build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
