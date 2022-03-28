package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios;

import com.sistema.apptreino.dao.TabDivisaoObj;
import com.sistema.apptreino.dao.repository.TabDivisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabDivisaoService {


    @Autowired
    TabDivisaoRepository tabDivisaoRepository;



    public List<TabDivisaoObj> listar(){
        List<TabDivisaoObj> listResult = new ArrayList<TabDivisaoObj>();
        listResult = tabDivisaoRepository.findAll();

        return listResult;
    }


    public TabDivisaoObj consultar(Integer cdDivisao){

        TabDivisaoObj tabDivisaoObj = tabDivisaoRepository.findOne(cdDivisao);
        return (tabDivisaoObj != null ? tabDivisaoObj : new TabDivisaoObj()) ;
    }



    public boolean gravar (TabDivisaoObj tabDivisaoObj){
       if(tabDivisaoRepository.save(tabDivisaoObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabDivisaoObj tabDivisaoObj){
        tabDivisaoRepository.delete(tabDivisaoObj);
    }



}
