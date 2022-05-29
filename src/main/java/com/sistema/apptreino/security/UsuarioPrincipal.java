package com.sistema.apptreino.security;

import com.sistema.apptreino.dao.TabUsuarioObj;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsuarioPrincipal implements UserDetails {

    private final TabUsuarioObj tabUsuarioObj;

    public UsuarioPrincipal(TabUsuarioObj tabUsuarioObj) {
        this.tabUsuarioObj = tabUsuarioObj;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return tabUsuarioObj.getTxSenha();
    }

    @Override
    public String getUsername() {
        return tabUsuarioObj.getTxNome();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public TabUsuarioObj getTabUsuarioObj() {
        return tabUsuarioObj;
    }
}
