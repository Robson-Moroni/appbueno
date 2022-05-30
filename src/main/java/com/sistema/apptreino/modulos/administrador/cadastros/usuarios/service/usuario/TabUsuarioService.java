package com.sistema.apptreino.modulos.administrador.cadastros.usuarios.service.usuario;

import com.sistema.apptreino.dao.TabSuporteCategoriaObj;
import com.sistema.apptreino.dao.TabUsuarioObj;
import com.sistema.apptreino.dao.repository.TabUsuarioRepository;
import com.sistema.apptreino.dao.repository.suporte.TabSuporteCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabUsuarioService {


    @Autowired
    TabUsuarioRepository tabUsuarioRepository;


    public TabUsuarioObj gravar (TabUsuarioObj tabUsuarioObj){
       return tabUsuarioRepository.save(tabUsuarioObj);
    }

    public TabUsuarioObj buscar(Integer cdUsuario) {
        TabUsuarioObj tabUsuarioObj = tabUsuarioRepository.findOne(cdUsuario);
        return tabUsuarioObj;
    }

}
