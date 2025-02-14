package com.zung.zung.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zung.zung.Entity.Maths;



@Repository
public interface MathsRepo extends JpaRepository <Maths, Integer>{

    Maths findByCourseCode(Integer courseCode);
    
}
