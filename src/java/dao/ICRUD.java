package dao;

import java.util.List;

public interface ICRUD<Generica> {

    void registrar(Generica gen) throws Exception;

    void modificar(Generica gen) throws Exception;
    
    void modificarEst(Generica gen) throws Exception; // eliminar: cambiar de estado

    void eliminar(Generica gen) throws Exception;

    List<Generica> listar() throws Exception;
}
