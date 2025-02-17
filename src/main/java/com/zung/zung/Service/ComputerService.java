package com.zung.zung.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zung.zung.Entity.Computer;
import com.zung.zung.Repository.ComputerRepo;

@Service
public class ComputerService {
    
    private ComputerRepo computerRepo;

    public ComputerService(ComputerRepo computerRepo) {
        this.computerRepo = computerRepo;
    }
    

    public Computer registerComputerStudent(Computer computerStudent){
        return computerRepo.save(computerStudent);

    }

    public Computer findComputerStudent(Integer CourseCode){
        return computerRepo.findByCourseCode(CourseCode);
    }

    public List<Computer> findAllComputerStudents(Computer computerStudent){
        return computerRepo.findAll();
    }

    public Optional<Computer> findComputerStudentByID(Integer id){
        return computerRepo.findById(id);
    }

    public Optional<Computer> updateComputerStudentDetails(Integer id, Computer computerStudentDetails){
        return computerRepo.findById(id).map(computerStudent ->{
            computerStudent.setFirstName(computerStudentDetails.getFirstName());
            computerStudent.setLastName(computerStudentDetails.getLastName());
            computerStudent.setDepartment(computerStudentDetails.getDepartment());
            computerStudent.setCourse(computerStudentDetails.getCourse());
            computerStudent.setCourseCode(computerStudentDetails.getCourseCode());
            computerStudent.setExamScore(computerStudentDetails.getExamScore());

        return Optional.of(computerRepo.save(computerStudent));
        }).orElse(Optional.empty());
    }

    public void deleteComputerStudent(Integer id){
        computerRepo.deleteById(id);
    }
}
