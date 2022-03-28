package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte;

import com.sistema.apptreino.dao.TabSuporteCategoriaObj;
import com.sistema.apptreino.dao.repository.suporte.TabSuporteCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabSuporteCategoriaService {


    @Autowired
    TabSuporteCategoriaRepository tabSuporteCategoriaRepository;



    public List<TabSuporteCategoriaObj> listar(){
        List<TabSuporteCategoriaObj> listResult = new ArrayList<TabSuporteCategoriaObj>();
        listResult = tabSuporteCategoriaRepository.findAll();

        return listResult;
    }


    public TabSuporteCategoriaObj consultar(Integer cdCategoria){

        TabSuporteCategoriaObj TabSuporteCategoriaObj = tabSuporteCategoriaRepository.findOne(cdCategoria);
        return (TabSuporteCategoriaObj != null ? TabSuporteCategoriaObj : new TabSuporteCategoriaObj()) ;
    }



    public boolean gravar (TabSuporteCategoriaObj TabSuporteCategoriaObj){
       if(tabSuporteCategoriaRepository.save(TabSuporteCategoriaObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabSuporteCategoriaObj TabSuporteCategoriaObj){
        tabSuporteCategoriaRepository.delete(TabSuporteCategoriaObj);
    }



}
