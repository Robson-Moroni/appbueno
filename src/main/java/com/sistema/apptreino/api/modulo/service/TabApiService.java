package com.sistema.apptreino.api.modulo.service;

import com.sistema.apptreino.api.dao.TabArticulacaoObj;
import com.sistema.apptreino.api.dao.repository.TabArticulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabApiService {



        @Autowired
        TabArticulacaoRepository tabArticulacaoRepository;




        public List<TabArticulacaoObj> listarArticulacao(){


           return tabArticulacaoRepository.findAll();


        }


}
