package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;

public class PacienteImpl extends Conexion implements ICRUD<Paciente> {
// NUMPAC   NOMPAC        APEPAC      SEXPAC FNPAC      DNIPAC   TELFPAC  EMAILPAC       NUMUBI DIRPAC     GSPAC HCPAC   ESTPAC

    @Override
    public void registrar(Paciente pac) throws Exception {
        String sql = "insert into Paciente "
                + "(NOMPAC,APEPAC, SEXPAC, FNPAC, DNIPAC, TELFPAC,  EMAILPAC, NUMUBI, DIRPAC,"
                + " GSPAC, HCPAC, ESTPAC) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getNombre());
            ps.setString(2, pac.getApellido());
            ps.setString(3, pac.getSexo());
            ps.setString(4, pac.getNacimiento());
            ps.setString(5, pac.getDni());
            ps.setString(6, pac.getTelef());
            ps.setString(7, pac.getMail());
            ps.setString(8, pac.getUbigeo());
            ps.setString(9, pac.getDireccion());
            ps.setString(10, pac.getGrupo());
            ps.setString(11, pac.getHistoria());
            ps.setString(12, pac.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarPacDao" + e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Paciente pac) throws Exception {
        String sql = "update Paciente set "
                + "NOMPAC=?,APEPAC=?, SEXPAC=?, FNPAC=?, DNIPAC=?, TELFPAC=?,  EMAILPAC=?, NUMUBI=?, DIRPAC=?,"
                + " GSPAC=?, HCPAC=?, ESTPAC=? where NUMPAC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getNombre());
            ps.setString(2, pac.getApellido());
            ps.setString(3, pac.getSexo());
            ps.setString(4, pac.getNacimiento());
            ps.setString(5, pac.getDni());
            ps.setString(6, pac.getTelef());
            ps.setString(7, pac.getMail());
            ps.setString(8, pac.getUbigeo());
            ps.setString(9, pac.getDireccion());
            ps.setString(10, pac.getGrupo());
            ps.setString(11, pac.getHistoria());
            ps.setString(12, pac.getEstado());
            ps.setInt(13, pac.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificarPacDao" + e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Paciente pac) throws Exception {
        String sql = "delete from paciente where NUMPAC=?";
        try {
           PreparedStatement ps= this.conectar().prepareStatement(sql);
           ps.setInt(1, pac.getCodigo());
           ps.executeUpdate();
           ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarPacDao" + e.getMessage());
        } finally{
            this.cerrarCnx();
        }
    }    
    
    @Override
    public List<Paciente> listar() throws Exception {
       List<Paciente> listado = new ArrayList<>();
       Paciente pac;
       String sql = "select * from paciente";
        try {            
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               pac = new Paciente();
               pac.setCodigo(rs.getInt("NUMPAC"));
               pac.setNombre(rs.getString("NOMPAC"));
               pac.setNombre(rs.getString("APEPAC"));
               pac.setNombre(rs.getString("SEXPAC"));
               pac.setNombre(rs.getString("FNPAC"));
               pac.setNombre(rs.getString("DNIPAC"));
               pac.setNombre(rs.getString("TELFPAC"));
               pac.setNombre(rs.getString("EMAILPAC"));
               pac.setNombre(rs.getString("NUMUBI"));
               pac.setNombre(rs.getString("DIRPAC"));
               pac.setNombre(rs.getString("GSPAC"));
               pac.setNombre(rs.getString("HCPAC"));
               pac.setNombre(rs.getString("ESTPAC"));
               listado.add(pac);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la listaPacDao " + e.getMessage());
        }finally{
            this.cerrarCnx();
        }
        return listado;
    }

    @Override
    public void modificarEst(Paciente pac) throws Exception {
               String sql = "update Paciente set "
                + "ESTPAC=? where NUMPAC=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pac.getEstado());
            ps.setInt(2, pac.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificarEstPacDao" + e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }

}
