package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte;

import com.sistema.apptreino.dao.TabSuportePerguntaRespostaObj;
import com.sistema.apptreino.dao.repository.suporte.TabSuportePerguntaRespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabSuportePerguntaRespostaService {


    @Autowired
    TabSuportePerguntaRespostaRepository tabSuportePerguntaRespostaRepository;



    public List<TabSuportePerguntaRespostaObj> listar(){
        List<TabSuportePerguntaRespostaObj> listResult = new ArrayList<TabSuportePerguntaRespostaObj>();
        listResult = tabSuportePerguntaRespostaRepository.findAll();

        return listResult;
    }


    public TabSuportePerguntaRespostaObj consultar(Integer cdPerguntaResposta){

        TabSuportePerguntaRespostaObj TabSuportePerguntaRespostaObj = tabSuportePerguntaRespostaRepository.findOne(cdPerguntaResposta);
        return (TabSuportePerguntaRespostaObj != null ? TabSuportePerguntaRespostaObj : new TabSuportePerguntaRespostaObj()) ;
    }



    public boolean gravar (TabSuportePerguntaRespostaObj TabSuportePerguntaRespostaObj){
       if(tabSuportePerguntaRespostaRepository.save(TabSuportePerguntaRespostaObj) != null){
           return true;
       }else {
           return false;
       }
    }

    public void excluir (TabSuportePerguntaRespostaObj TabSuportePerguntaRespostaObj){
        tabSuportePerguntaRespostaRepository.delete(TabSuportePerguntaRespostaObj);
    }



}
