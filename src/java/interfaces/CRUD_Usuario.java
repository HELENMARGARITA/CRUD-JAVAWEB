
package interfaces;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario;
import java.util.List;

public interface CRUD_Usuario {
    
    public List listar_todo();
    public Usuario listar_con_filtro(int id);
    public boolean agregar(Usuario usu);
    public boolean editar(Usuario usu);
    public boolean eliminar(int id);
    public int iniciar_sesion(Usuario usu);

}
