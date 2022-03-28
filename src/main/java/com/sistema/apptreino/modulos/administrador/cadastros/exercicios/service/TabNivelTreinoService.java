package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service;

import com.sistema.apptreino.dao.TabDivisaoObj;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import com.sistema.apptreino.dao.repository.TabDivisaoRepository;
import com.sistema.apptreino.dao.repository.TabNivelTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabNivelTreinoService {


    @Autowired
    TabNivelTreinoRepository tabNivelTreinoRepository;

    public List<?> listar(){
        List<TabNivelTreinoObj>  listResult = tabNivelTreinoRepository.findAll();

        return (listResult.isEmpty() ? new ArrayList<TabNivelTreinoObj>() : listResult);
    }


    public TabNivelTreinoObj consultar(Integer cdNivelTreino){

        TabNivelTreinoObj tabNivelTreinoObj = tabNivelTreinoRepository.findOne(cdNivelTreino);
        return (tabNivelTreinoObj != null ? tabNivelTreinoObj : new TabNivelTreinoObj()) ;
    }



    public boolean gravar (TabNivelTreinoObj tabNivelTreinoObj){
       if(tabNivelTreinoRepository.save(tabNivelTreinoObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabNivelTreinoObj tabNivelTreinoObj){
        tabNivelTreinoRepository.delete(tabNivelTreinoObj);
    }



}
