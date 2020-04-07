package dao;

import java.util.List;

public interface ICRUD<Generica> {

    void registrar(Generica gen) throws Exception;

    void modificar(Generica gen) throws Exception;

    void eliminar(Generica gen) throws Exception;

    List<Generica> listar() throws Exception;
}
