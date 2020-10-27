package com.dao;

import com.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioD extends Conexion {

    public Usuario login(String user, String pass) throws Exception {
        Usuario usuario = null;
        String sql = "select nomusu, usuusu, pwdusu, levusu from usuario where usuusu=? and pwdusu=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUser(user);
                usuario.setPwd(pass);
                usuario.setNombreUsuario(rs.getString("nomusu"));
                usuario.setNivel(rs.getInt("levusu"));
            }
            ps.close();
            rs.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("**************  Error en loginDao:  " + e.getMessage() + " *********************");
            throw e;
        }
    }

    public Usuario login2(String user, String pass) throws Exception {
        Usuario usuario = null;
        String sql = "select nomusu, usuusu, pwdusu, levusu from usuario where"
                + " usuusu='" + user + "' and pwdusu='" + pass + "'";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUser(user);
                usuario.setPwd(pass);
                usuario.setNombreUsuario(rs.getString("nomusu"));
                usuario.setNivel(rs.getInt("levusu"));
            }
            st.close();
            rs.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("**************  Error en loginDao:  " + e.getMessage() + " *********************");
            throw e;
        }
    }
}
