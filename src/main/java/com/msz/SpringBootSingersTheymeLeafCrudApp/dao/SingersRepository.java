package com.msz.SpringBootSingersTheymeLeafCrudApp.dao;

import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingersRepository extends JpaRepository<Singer, Integer> {
    // This one interface gives us JPA Methods :)
}
