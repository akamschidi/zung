package com.zung.zung.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zung.zung.Entity.Maths;
import com.zung.zung.Repository.MathsRepo;

@Service
public class MathService {
    @Autowired
    private MathsRepo mathsRepo;

    public MathService(MathsRepo mathsRepo) {
        this.mathsRepo = mathsRepo;
    }

    public Maths registerMathsStudent(Maths maths){
        return mathsRepo.save(maths);

    }

    public List<Maths> listOfAllMathsStudents(){
        return mathsRepo.findAll();
    }

    public Maths findMathsStudentByCourseCode(Integer courseCode){
        return mathsRepo.findByCourseCode(courseCode);
    }

    public Optional<Maths> updateMathsStudentDetail(Integer id, Maths mathsStudentDetails){
       return mathsRepo.findById(id).map(maths->{
            maths.setFirstName(mathsStudentDetails.getFirstName());
            maths.setLastName(mathsStudentDetails.getLastName());
            maths.setDepartment(mathsStudentDetails.getDepartment());
            maths.setCourse(mathsStudentDetails.getCourse());
            maths.setCourseCode(mathsStudentDetails.getCourseCode());
            maths.setExamScore(mathsStudentDetails.getExamScore());
        return Optional.of(mathsRepo.save(maths));
       }).orElse(Optional.empty());
        
    }

    public void deleteMathsStudent(Integer id){
        mathsRepo.deleteById(id);
    }
    
}
