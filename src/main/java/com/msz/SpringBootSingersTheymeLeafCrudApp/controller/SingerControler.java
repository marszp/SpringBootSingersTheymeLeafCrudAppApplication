package com.msz.SpringBootSingersTheymeLeafCrudApp.controler;


import com.msz.SpringBootSingersTheymeLeafCrudApp.entity.Singer;
import com.msz.SpringBootSingersTheymeLeafCrudApp.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "singers/singers-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //Create empty Singer
        Singer theSinger = new Singer();
        //Add to the model empty singer and use "singer" as a model attribute
        theModel.addAttribute("singer",theSinger);
        //Return template url
        return "singers/singer-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("singer") Singer theSinger){
        singerService.save(theSinger);
        return "redirect:/api/singers";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("singerId") int singerId){
        singerService.deleteById(singerId);
        return "redirect:/api/singers";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("singerId") int theId, Model theModel){
        Singer tempSinger = singerService.findById(theId);
        theModel.addAttribute("singer",tempSinger);
        return "singers/singer-form";
    }
}
