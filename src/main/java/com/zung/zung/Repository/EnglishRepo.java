package com.zung.zung.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zung.zung.Entity.English;
import java.util.List;


@Repository
public interface EnglishRepo extends JpaRepository <English, Integer>{

    English findByCourseCode(int courseCode);
    
}
