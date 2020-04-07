
import dao.PacienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;

@Named(value = "pacienteC") //@ManagedBean
@SessionScoped
public class PacienteC implements Serializable {

    PacienteImpl dao;
    private Paciente paciente;
    private List<Paciente> pacientes;

    public PacienteC() {
        paciente = new Paciente();
        dao = new PacienteImpl();
    }

    public void registrar() {
        try {
            dao.registrar(paciente);
            limpiar();
        } catch (Exception e) {
            System.out.println("error en registrarC " + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            dao.eliminar(paciente);
            limpiar();
        } catch (Exception e) {
            System.out.println("error en eliminarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            dao.modificar(paciente);
            limpiar();
        } catch (Exception e) {
            System.out.println("error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            pacientes = new ArrayList<>();
            pacientes = dao.listar();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        dao = new PacienteImpl();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
