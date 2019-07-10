package com.mycompany.springjpa.services;

import com.mycompany.springjpa.dao.TrainerDao;
import com.mycompany.springjpa.entities.Trainer;
import java.util.List;

public class TrainerService {

    public List<Trainer> TrainerAsList() {
        TrainerDao tdao = new TrainerDao();
        List<Trainer> list = tdao.getTrainers();
        return list;
    }
    
    public Trainer TrainerById(Long id){
        TrainerDao tdao = new TrainerDao();
        Trainer t = tdao.getTrainerById(id);
        return t;
    }
    
    public boolean TrainerInsert(Trainer t){
        TrainerDao tdao = new TrainerDao();
        return tdao.insertTrainer(t);
    }
    
    public boolean TrainerDelete(Long id){
        TrainerDao tdao = new TrainerDao();
        return tdao.deleteTrainer(id);
    }
    
    public boolean TrainerUpdate(Trainer t){
        TrainerDao tdao = new TrainerDao();
        return tdao.updateTrainer(t);
    }
    
}
