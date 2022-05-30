package com.sistema.apptreino.security;

import com.sistema.apptreino.dao.TabUsuarioObj;
import com.sistema.apptreino.dao.repository.TabUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	TabUsuarioRepository tabUsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TabUsuarioObj tabUsuarioObj = tabUsuarioRepository.findByTxEmail(username);

		if (tabUsuarioObj != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

			return new UsuarioPrincipal(tabUsuarioObj.getTxEmail(), tabUsuarioObj.getTxSenha(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
	}
}