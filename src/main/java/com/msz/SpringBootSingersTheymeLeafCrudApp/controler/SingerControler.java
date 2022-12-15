package com.msz.SpringBootSingersTheymeLeafCrudApp.controler;


import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;
import com.msz.SpringBootSingersTheymeLeafCrudApp.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class SingerControler {

    private SingerService singerService;

    @Autowired
    public SingerControler(SingerService theSingerService){
        singerService=theSingerService;
    }

    //For test purpose
    @GetMapping("/hello")
    public String getHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        // We have to return name of file that we want to open in this example
        // helloworld from directory templates/helloworld.html
        return "helloworld";
    }

    @GetMapping("/singers")
    public String getSingers(Model theModel){

        //By SingerService we are getting a list of Singer's
        List<Singer> theSingers = singerService.findAll();
        //Add to the model list of singers and use "singers" as a model attribute
        theModel.addAttribute("singers",theSingers);
        //Return template url
        return "/singers/singers-list";
    }
}
