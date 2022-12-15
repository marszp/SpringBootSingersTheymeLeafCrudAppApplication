package com.msz.SpringBootSingersTheymeLeafCrudApp.service;

import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;

import java.util.List;

public interface SingerService {

    public List<Singer> findAll();

    public Singer findById(int id);

    public void save(Singer theSinger);

    public void deleteById(int theId);
}
