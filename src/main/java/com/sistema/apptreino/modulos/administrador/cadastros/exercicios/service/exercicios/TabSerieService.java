package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios;

import com.sistema.apptreino.dao.TabSerieObj;
import com.sistema.apptreino.dao.repository.TabSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabSerieService {


    @Autowired
    TabSerieRepository tabSerieRepository;



    public List<TabSerieObj> listar(){
        List<TabSerieObj> listResult = new ArrayList<TabSerieObj>();
        listResult = tabSerieRepository.findAll();

        return listResult;
    }


    public TabSerieObj consultar(Integer cdSerie){

        TabSerieObj TabSerieObj = tabSerieRepository.findOne(cdSerie);
        return (TabSerieObj != null ? TabSerieObj : new TabSerieObj()) ;
    }



    public boolean gravar (TabSerieObj TabSerieObj){
       if(tabSerieRepository.save(TabSerieObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabSerieObj TabSerieObj){
        tabSerieRepository.delete(TabSerieObj);
    }



}
