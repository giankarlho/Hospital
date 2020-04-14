package controller;

import dao.PacienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Paciente;

@Named(value = "pacienteC") //@ManagedBean
@SessionScoped
public class PacienteC implements Serializable {

    private PacienteImpl dao;
    private Paciente paciente;
    private List<Paciente> lstPacientes;

    public PacienteC() {
        paciente = new Paciente();
        dao = new PacienteImpl();
    }

    public void registrar() {
        try {
            paciente.setUbigeo(dao.obtenerCodigoUbigeo(paciente.getUbigeo()));
            dao.registrar(paciente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro","Registrado con éxito"));
            limpiar();
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Registro","no registrado"));
            System.out.println("error en registrarC " + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            dao.eliminar(paciente);
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación","Eliminado con éxito"));
             listar();
        } catch (Exception e) {
            System.out.println("error en eliminarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
//            paciente.setNacimiento(Strin);
            dao.modificar(paciente);
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación","Registrado con éxito"));
             listar();
        } catch (Exception e) {
            System.out.println("error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            lstPacientes = dao.listar();
        } catch (Exception e) {
            System.out.println("error en listarC " + e.getMessage());
        }
    }

    public void limpiar() {
        dao = new PacienteImpl();
    }

    public List<String> completeTextUbigeo(String query) throws SQLException, Exception {
        PacienteImpl daoUbi = new PacienteImpl();
        return daoUbi.autocompleteUbigeo(query);
    }

    // Código generado    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public void setLstPacientes(List<Paciente> lstPacientes) {
        this.lstPacientes = lstPacientes;
    }

    public PacienteImpl getDao() {
        return dao;
    }

    public void setDao(PacienteImpl dao) {
        this.dao = dao;
    }

}
