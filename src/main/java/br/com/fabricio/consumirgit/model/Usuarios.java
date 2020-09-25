package br.com.fabricio.consumirgit.model;

import java.util.List;

public class Usuarios {

    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean persistido;

    private List<Roles> roles;

    public Usuarios(String username, String password, List<Roles> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enabled = true;
    }

    public Usuarios() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public Boolean getPersistido() {
        return persistido;
    }

    public void setPersistido(Boolean persistido) {
        this.persistido = persistido;
    }
}
