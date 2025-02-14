package com.zung.zung.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.zung.zung.Entity.Maths;
import com.zung.zung.Service.MathService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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

    @GetMapping("/mathsstudents/{course_code}")
    public Maths findMathsStudent(@PathVariable Integer courseCode) {
       return mathService.findMathsStudentByCourseCode(courseCode);

    }

    @GetMapping("/allmathsstudents")
    public List<Maths> allMathsStudents() {
        return mathService.listOfAllMathsStudents();
    }
    
    
    
    
}
