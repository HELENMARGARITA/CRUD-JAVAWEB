
package co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario;
import config.Conexion;
import interfaces.CRUD_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CRUD_Usuario{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u=new Usuario();
    int r=0;

    @Override
    public List listar_todo() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from usuarios";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario usu=new Usuario();
                usu.setId(rs.getInt("Id"));
                usu.setUsuario(rs.getString("usuario"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setEmail(rs.getString("email"));
                usu.setGenero(rs.getString("genero"));
                usu.setContrasena(rs.getString("pass"));
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario listar_con_filtro(int id) {
        //ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from usuarios where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt("Id"));
                u.setUsuario(rs.getString("usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setGenero(rs.getString("genero"));
                u.setContrasena(rs.getString("pass"));
                //list.add(usu);
            }
        } catch (Exception e) {
        }
        return u;
    }

    @Override
    public boolean agregar(Usuario usu) {
        String sql="insert into usuarios(usuario, pass, nombre, apellido, genero, email)values('"+usu.getUsuario()+"','"+usu.getContrasena()+"','"+usu.getNombre()+"','"+usu.getApellido()+"','"+usu.getGenero()+"','"+usu.getEmail()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean editar(Usuario usu) {
        String sql="update usuarios set usuario='"+u.getUsuario()+"',nombre='"+u.getNombre()+"',apellido='"+u.getApellido()+"',genero='"+u.getGenero()+"',email='"+u.getEmail()+"',pass='"+u.getContrasena()+"'where Id="+u.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from usuarios where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public int iniciar_sesion(Usuario usu) {
        String sql="select * from usuarios where usuario=? and pass=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContrasena());
            ps.executeQuery();
            while(rs.next()){
                r = r+1;
                usu.setUsuario(rs.getString("usuario"));
                usu.setContrasena(rs.getString("pass"));
                //list.add(usu);
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            //System.err.print(e);
            return 0;
        }
        //return ;
        
    }
    
    
}
