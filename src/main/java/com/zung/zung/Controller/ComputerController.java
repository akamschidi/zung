package com.zung.zung.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.zung.zung.Entity.Computer;
import com.zung.zung.Service.ComputerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }
    

    @PostMapping("/registercomputerstudent")
    public Computer registerComputerStudent(@RequestBody Computer computer) {
      return computerService.registerComputerStudent(computer);
    }

    @GetMapping("/allcomputerstudents")
    public List<Computer> allComputerStudents() {
        return computerService.findAllComputerStudents();
    }
    
    @GetMapping("/computerstudentid/{id}")
    public ResponseEntity<Computer> getMethodName(@PathVariable Integer id) {
        return computerService.findComputerStudentByID(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                .build());
    }
    
    @PutMapping("updatecomputerstudent/{id}")
    public ResponseEntity<Computer> updateComputerStudent(@PathVariable Integer id, @RequestBody Computer computerStudentDetails) {
       return computerService.updateComputerStudentDetails(id, computerStudentDetails)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound()
            .build());
    }

    @DeleteMapping("/deletecomputerstudent/{id}")
    public ResponseEntity<?> deleteComputerStudentByID(@PathVariable Integer id){
            return computerService.findComputerStudentByID(id)
            .map(computer -> {
                computerService.deleteComputerStudent(id);
                return ResponseEntity.ok()
                .build();
            }).orElseGet(() -> ResponseEntity.notFound()
            .build());
            
    }
}
