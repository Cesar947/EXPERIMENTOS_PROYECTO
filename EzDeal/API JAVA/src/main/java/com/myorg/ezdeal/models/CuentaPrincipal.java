package com.myorg.ezdeal.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CuentaPrincipal implements UserDetails {

    private Cuenta cuenta;

    public CuentaPrincipal(Cuenta cuenta){
        this.cuenta = cuenta;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROL_CLIENTE"));
    }

    public Long getId() {
        return cuenta.getId();
    }

    public String getEmail() {
        return cuenta.getEmail();
    }

    @Override
    public String getPassword() {
        return cuenta.getContrasena();
    }

    @Override
    public String getUsername() {
        return cuenta.getNombreUsuario();
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
}
