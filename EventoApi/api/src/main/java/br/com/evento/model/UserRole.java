package br.com.evento.model;

public enum UserRole {
    ADMIN("admin"),
    CLIENTE("cliente"),
    ORGANIZADOR("organizador");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
