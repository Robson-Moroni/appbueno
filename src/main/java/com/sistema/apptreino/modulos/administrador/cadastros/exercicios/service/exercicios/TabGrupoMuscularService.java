package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios;

import com.sistema.apptreino.dao.TabGrupoMuscularObj;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import com.sistema.apptreino.dao.repository.TabGrupoMuscularRepository;
import com.sistema.apptreino.dao.repository.TabNivelTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabGrupoMuscularService {


    @Autowired
    TabGrupoMuscularRepository tabGrupoMuscularRepository;



    public List<TabGrupoMuscularObj> listar(){
        List<TabGrupoMuscularObj> listResult = new ArrayList<TabGrupoMuscularObj>();
        listResult = tabGrupoMuscularRepository.findAll();

        return listResult;
    }


    public TabGrupoMuscularObj consultar(Integer cdGrupoMuscular){

        TabGrupoMuscularObj tabGrupoMuscularObj = tabGrupoMuscularRepository.findOne(cdGrupoMuscular);
        return (tabGrupoMuscularObj != null ? tabGrupoMuscularObj : new TabGrupoMuscularObj()) ;
    }



    public boolean gravar (TabGrupoMuscularObj tabGrupoMuscularObj){
       if(tabGrupoMuscularRepository.save(tabGrupoMuscularObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabGrupoMuscularObj tabGrupoMuscularObj){
        tabGrupoMuscularRepository.delete(tabGrupoMuscularObj);
    }



}
