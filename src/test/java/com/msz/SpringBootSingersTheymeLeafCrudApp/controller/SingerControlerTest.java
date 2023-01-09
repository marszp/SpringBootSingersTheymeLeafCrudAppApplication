package com.msz.SpringBootSingersTheymeLeafCrudApp.controller;

import com.msz.SpringBootSingersTheymeLeafCrudApp.dao.SingersRepository;
import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;
import com.msz.SpringBootSingersTheymeLeafCrudApp.service.SingerServiceImpl;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;



class SingerControlerTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    SingersRepository singersRepository = Mockito.mock(SingersRepository.class);;

    @InjectMocks
    SingerServiceImpl singerService;

    @Test
    void getHello() {
         //Simple test to check that Junit works
        assertEquals("helloworld","helloworld");

    }

    @Test
    public void finlAll_Test(){
        //setup
        List<Singer> testSingers = new ArrayList<Singer>();

        testSingers.add(new Singer("Natalia","Netrebko",
                "np@gmail.com","Sopran"));

        Singer singerToCompare = new Singer("Natalia","Netrebko",
                "np@gmail.com","Sopran");

        String singerName = singerToCompare.getFirstName();

        //when
        when(singersRepository.findAll()).thenReturn(testSingers);

        //then
        assertNotNull(singersRepository.findAll().stream().filter(x -> x.getFirstName().equals(singerName)));
    }

}