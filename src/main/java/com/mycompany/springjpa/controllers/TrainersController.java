package com.mycompany.springjpa.controllers;

import com.mycompany.springjpa.entities.Trainer;
import com.mycompany.springjpa.services.TrainerService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class TrainersController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        return "index";
    }

    @RequestMapping(value= "/trainers", method = RequestMethod.GET)
    public String getTrainers(ModelMap model, @ModelAttribute("success")String success) {
        TrainerService ts = new TrainerService();
        List<Trainer> list = ts.TrainerAsList();
        model.addAttribute("listofTrainers", list);
        return "trainers";
    }
    
    @RequestMapping(value= "/insert", method = RequestMethod.GET)
    public String insertTrainer(ModelMap model, @ModelAttribute("Trainer")Trainer t) {
        return "insert";
    }

    @RequestMapping(value= "/insertTrainer", method = RequestMethod.POST)
    public String saveTrainer(ModelMap model, @ModelAttribute("Trainer")Trainer t) {
        TrainerService ts = new TrainerService();
        String success;
        if(ts.TrainerInsert(t)){
            success = "Insertion success";
        }else{
            success = "Insertion NOT success";
        }
        model.addAttribute("success", success);
        return "redirect:/trainers";
    }
    
    @RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrainer(ModelMap model, @PathVariable("id") Long id) {
        TrainerService ts = new TrainerService();
        String success;
        if(ts.TrainerDelete(id)){
            success = "Delete success";
        }else{
            success = "Delete NOT success";
        }
        model.addAttribute("success", success);
        return "redirect:/trainers";
    }
    
    @RequestMapping(value= "/update/{id}", method = RequestMethod.GET)
    public String updateTrainer(ModelMap model, @PathVariable("id") Long id) {
        TrainerService ts = new TrainerService();
        Trainer t = ts.TrainerById(id);
        model.addAttribute("trainer", t);
        return "update";
    }
    
    //is not working
    @RequestMapping(value= "/updateform", method = RequestMethod.POST)
    public String update(ModelMap model, @ModelAttribute("trainer")Trainer t) {
        TrainerService ts = new TrainerService();
        String success;
        Trainer tr = ts.TrainerById(t.getTrainerId());
        tr.setFirstName(t.getFirstName());
        tr.setLastName(t.getLastName());
        tr.setSubject(t.getSubject());
        if(ts.TrainerUpdate(tr)){
            success = "Update success";
        }else{
            success = "Update NOT success";
        }
        model.addAttribute("success", success);
        return "redirect:/trainers";
    }
}
