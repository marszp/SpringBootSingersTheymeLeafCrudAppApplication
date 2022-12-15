package com.msz.SpringBootSingersTheymeLeafCrudApp.service;


import com.msz.SpringBootSingersTheymeLeafCrudApp.dao.SingersRepository;
import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // important to mark this class as a @Service -> SB.Bean
public class SingerServiceImpl implements SingerService{

    private SingersRepository singersRepository;

    @Autowired
    public SingerServiceImpl(SingersRepository theSingerRepository){
        singersRepository = theSingerRepository;
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> theSingers = singersRepository.findAll();
        return theSingers;
    }

    @Override
    public Singer findById(int id) {
        return null;
    }

    @Override
    public void save(Singer theSinger) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
