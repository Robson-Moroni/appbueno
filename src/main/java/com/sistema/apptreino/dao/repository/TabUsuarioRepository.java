package com.sistema.apptreino.dao.repository;

import com.sistema.apptreino.dao.TabUsuarioObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabUsuarioRepository extends JpaRepository<TabUsuarioObj, Integer> {
    TabUsuarioObj findByTxEmail(String TxEmail);
}
