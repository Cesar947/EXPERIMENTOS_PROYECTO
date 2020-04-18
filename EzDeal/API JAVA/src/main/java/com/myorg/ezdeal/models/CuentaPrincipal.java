package com.myorg.ezdeal.models;

import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuentaPrincipal implements UserDetails {

    private Cuenta cuenta;

    public CuentaPrincipal(Cuenta cuenta){
        this.cuenta = cuenta;
    }


    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        Set<Rol> roles = cuenta.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities
                .add(new SimpleGrantedAuthority(role.getNombre().toString()))
        );
        return (Set<? extends GrantedAuthority>) authorities;
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
