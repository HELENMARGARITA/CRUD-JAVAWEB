
package co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Docente;
import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario;
import config.Conexion;
import interfaces.CRUD_Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO implements CRUD_Docente{
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Docente d=new Docente();

    @Override
    public List listar_todo() {
        ArrayList<Docente>list=new ArrayList<>();
        String sql="select * from docentes";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Docente doce=new Docente();
                doce.setId(rs.getInt("id"));
                doce.setNombre(rs.getString("nombre"));
                doce.setApellido(rs.getString("apellido"));
                doce.setEmail(rs.getString("email"));
                doce.setTelefono(rs.getString("telefono"));
                doce.setBlog(rs.getString("blog"));
                doce.setProfesional(rs.getString("profesional"));
                doce.setIdioma(rs.getString("idioma"));
                doce.setEscalafon(rs.getString("escalafon"));
                doce.setAñosExperiencia(rs.getString("añosExperiencia"));
                doce.setAreaTrabajo(rs.getString("areaTrabajo")); 
                list.add(doce);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Docente listar_con_filtro(int id) {
        String sql="select * from docentes where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            //ps.setString(1, sql);
            rs=ps.executeQuery();
            while(rs.next()){
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido(rs.getString("apellido"));
                d.setEmail(rs.getString("email"));
                d.setTelefono(rs.getString("telefono"));
                d.setBlog(rs.getString("blog"));
                d.setProfesional(rs.getString("profesional"));
                d.setIdioma(rs.getString("idioma"));
                d.setEscalafon(rs.getString("escalafon"));
                d.setAñosExperiencia(rs.getString("añosExperiencia"));
                d.setAreaTrabajo(rs.getString("areaTrabajo")); 
                //list.add(usu);
            }
        } catch (Exception e) {
        }
        return d;
    }

    @Override
    public boolean agregar(Docente doc) {
        String sql="insert into docentes(clave, nombre, apellido, email, telefono, blog, profesional, escalafon, idioma, añosExperiencia, areaTrabajo)values('"+doc.getClave()+"','"+doc.getNombre()+"','"+doc.getApellido()+"','"+doc.getEmail()+"','"+doc.getTelefono()+"','"+doc.getBlog()+"','"+doc.getProfesional()+"','"+doc.getEscalafon()+"','"+doc.getIdioma()+"','"+doc.getAñosExperiencia()+"','"+doc.getAreaTrabajo()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean editar(Docente doc) {
        String sql="update docentes set clave='"+doc.getClave()
                +"',nombre='"+doc.getNombre()+"',apellido='"+doc.getApellido()+"',email='"+doc.getEmail()
                +"',telefono='"+doc.getTelefono()+"',blog='"+doc.getBlog()+"',profeional='"+doc.getProfesional()+"',escalafon='"+doc.getEscalafon()
                +"',añosExperiencia='"+doc.getAñosExperiencia()+"',idioma='"+doc.getIdioma()+"',areaTrabajo='"+doc.getAreaTrabajo()+"'where Id="+doc.getId();
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
        String sql="delete from docentes where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
