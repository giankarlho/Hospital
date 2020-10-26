package com.model;

import lombok.Data;

@Data
public class Usuario {
    private String user;
    private String pwd;
    private String nombreUsuario;
    private int nivel; // niveles: 1 admin, 2 operario
}
