package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios;

import com.sistema.apptreino.dao.TabExercicioObj;
import com.sistema.apptreino.dao.repository.TabExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabExercicioService {


    @Autowired
    TabExercicioRepository tabExercicioRepository;



    public List<TabExercicioObj> listar(){
        List<TabExercicioObj> listResult = new ArrayList<TabExercicioObj>();
        listResult = tabExercicioRepository.findAll();

        return listResult;
    }


    public TabExercicioObj consultar(Integer cdDivisao){

        TabExercicioObj TabExercicioObj = tabExercicioRepository.findOne(cdDivisao);
        return (TabExercicioObj != null ? TabExercicioObj : new TabExercicioObj()) ;
    }



    public boolean gravar (TabExercicioObj TabExercicioObj){
       if(tabExercicioRepository.save(TabExercicioObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabExercicioObj TabExercicioObj){
        tabExercicioRepository.delete(TabExercicioObj);
    }



}
