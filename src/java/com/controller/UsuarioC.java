package com.controller;

import com.dao.UsuarioD;
import com.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Data;
import services.Encriptar;

@Named(value = "usuarioC")
@SessionScoped
@Data
public class UsuarioC implements Serializable {

    private Usuario usuario;
    private String user;
    private String pass;

    public UsuarioC() {
        usuario = new Usuario();
    }

    public void loginC() {
        // Llamando al PreparedStatement
        UsuarioD dao;
        try {
            dao = new UsuarioD();            
            pass = Encriptar.encriptar(pass);
            usuario = dao.login(user.trim().toUpperCase(), pass);            
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().
                        getSessionMap().put("objetoUsuario", usuario);
                FacesContext.getCurrentInstance().getExternalContext().
                        redirect("/HospitalSec2/faces/index.xhtml");                
                
//                if(usuario.getNivel()==1){
//                FacesContext.getCurrentInstance().getExternalContext().
//                        redirect("/HospitalSec2/faces/Adninistrador.xhtml");
//                    
//                }
//                System.out.println("usuario correcto");
            } else {
                System.out.println("ya fuiste, no entras !!!");
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acceso al Sistema", "Usuario y/o contraseña incorrecta"));
            }
        } catch (Exception e) {
            System.out.println("Error en loginC: " + e.getMessage());
        }
    }

    public void loginC2() {
        // Llamando al Statement
        UsuarioD dao;
        try {
            dao = new UsuarioD();
            System.out.println("Aqui pasa");
            usuario = dao.login2(user.trim().toUpperCase(), pass);
            System.out.println("Aqui tmb");
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().
                        getSessionMap().put("objetoUsuario", usuario);
                FacesContext.getCurrentInstance().getExternalContext().
                        redirect("/HospitalSec2/faces/index.xhtml");
//                System.out.println("usuario correcto");
            } else {
                System.out.println("ya fuiste, no entras !!!");
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acceso al Sistema", "Usuario y/o contraseña incorrecta"));
            }
        } catch (Exception e) {
            System.out.println("Error en loginC: " + e.getMessage());
        }

    }

    // Obtener el objeto de la sesión activa
    public static Usuario obtenerObjetoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().get("objetoUsuario");
    }
 
    // Si la sesión no está iniciada no permitirá entrar a otra vista de la aplicación
    public void seguridadSesion() throws IOException {
        if (obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().
                    redirect("/HospitalSec2");
        }
    }

    // Cerrar y limpiar la sesión y direccionar al xhtml inicial del proyecto
    public void cerrarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/HospitalSec2");
    }

    // Si la sesión está activa se redirecciona a la vista principal
    public void seguridadLogin() throws IOException {
        Usuario us = obtenerObjetoSesion();
        if (us != null) {
            FacesContext.getCurrentInstance().getExternalContext().
                    redirect("/HospitalSec2/faces/index.xhtml");
        }
    }

}
