package com.zung.zung.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zung.zung.Entity.English;
import com.zung.zung.Repository.EnglishRepo;

@Service
public class EnglishService {

    @Autowired
    private EnglishRepo englishRepo;

    public EnglishService(EnglishRepo englishRepo) {
        this.englishRepo = englishRepo;
    }

    public English registerEnglishStudent(English english){
        return englishRepo.save(english);
    }

    public List<English> listOfAllEnglishStudents(English english){
        return englishRepo.findAll();
    }

    public English findEnglishStudentByCourseCode(Integer courseCode){
        return englishRepo.findByCourseCode(courseCode);
    }

    public Optional<English> updateEnglishStudentDetails(Integer id, English englishStudentDetails){
        return englishRepo.findById(id).map(english->{
            english.setFirstName(englishStudentDetails.getFirstName());
            english.setLastName(englishStudentDetails.getLastName());
            english.setDepartment(englishStudentDetails.getDepartment());
            english.setCourse(englishStudentDetails.getCourse());
            english.setCourseCode(englishStudentDetails.getCourseCode());
            english.setExamScore(englishStudentDetails.getExamScore());
        return Optional.of(englishRepo.save(english));
        }).orElse(Optional.empty());
    }



    public void deleteEnglishStudent(Integer id){
            englishRepo.deleteById(id);
    }
}
