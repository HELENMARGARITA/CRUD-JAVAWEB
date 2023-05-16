/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.DocenteDAO;
import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Docente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Solís Poveda
 */
public class controladorDocente extends HttpServlet {
    String listar="vista/docente/listar_todo.jsp";
    String add="vista/docente/agregar.jsp";
    String edit="vista/docente/editar.jsp";
    Docente d=new Docente();
    DocenteDAO dao=new DocenteDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorDocente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorDocente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }else if(action.equalsIgnoreCase("Agregar")){
            //String usuario=request.getParameter("usuario");
            String pass=request.getParameter("password");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");
            String blog=request.getParameter("blog");
            String profesion=request.getParameter("profesional");
            String escalafon=request.getParameter("escalafon");
            String anios=request.getParameter("experiencia");
            String area=request.getParameter("area");
            String idioma=request.getParameter("idioma");
            //d.setUsuario(usuario);
            d.setNombre(nombre);
            d.setApellido(apellido);
            d.setTelefono(telefono);
            d.setBlog(blog);
            d.setProfesional(profesion);
            d.setEscalafon(escalafon);
            d.setAñosExperiencia(anios);
            d.setAreaTrabajo(area);
            d.setEmail(email);
            d.setClave(pass);
            d.setIdioma(idioma);
            dao.agregar(d);
            acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            d.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("iduser",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("id"));
            String pass=request.getParameter("password");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String email=request.getParameter("email");
            String telefono=request.getParameter("telefono");
            String blog=request.getParameter("blog");
            String profesion=request.getParameter("profesional");
            String escalafon=request.getParameter("escalafon");
            String anios=request.getParameter("experiencia");
            String area=request.getParameter("area");
            //d.setUsuario(usuario);
            d.setId(id);
            d.setNombre(nombre);
            d.setApellido(apellido);
            d.setTelefono(telefono);
            d.setBlog(blog);
            d.setProfesional(profesion);
            d.setEscalafon(escalafon);
            d.setAñosExperiencia(anios);
            d.setAreaTrabajo(area);
            d.setEmail(email);
            d.setClave(pass);
            dao.editar(d);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
