package com.zung.zung.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zung.zung.Entity.Computer;


@Repository
public interface ComputerRepo extends JpaRepository <Computer, Integer>{

    Computer findByCourseCode(int courseCode);
}
