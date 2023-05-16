
package interfaces;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Docente;
import java.util.List;


public interface CRUD_Docente {
    
    public List listar_todo();
    public Docente listar_con_filtro(int id);
    public boolean agregar(Docente doc);
    public boolean editar(Docente doc);
    public boolean eliminar(int id);
    
}
