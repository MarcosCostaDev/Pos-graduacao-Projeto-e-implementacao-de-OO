package repositorios;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioBase<T> {
    public void inserir(T objeto) throws SQLException;
    public void alterar(T objeto) throws SQLException;
    public void excluir(T objeto) throws SQLException;
    public List<T> listarConsulta(String dao, String filtro) throws SQLException;
    public T selecionarConsulta(String  dao, String codigo) throws SQLException;
}
