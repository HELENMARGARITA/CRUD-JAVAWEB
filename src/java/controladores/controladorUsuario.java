
package controladores;

import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.UsuarioDAO;
import co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class controladorUsuario extends HttpServlet {

    String listar="vista/usuario/listar_todo.jsp";
    String add="vista/usuario/agregar.jsp";
    String edit="vista/usuario/editar.jsp";
    String principal="vista/usuario/login.jsp";
    String login="index.jsp";
    Usuario u=new Usuario();
    UsuarioDAO dao=new UsuarioDAO();
    int id;
    int r;
    
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
//        String accion = request.getParameter("accion");
//        if (accion.equals("Login")){
//            String usuario = request.getParameter("usuario");
//            String password = request.getParameter("pass");
//            u.setUsuario(usuario);
//            u.setContrasena(password);
//            r = dao.iniciar_sesion(u);
//            
//            if (r==1){
//                request.getRequestDispatcher(inicio).forward(request, response);
//            }else {
//                request.getRequestDispatcher(login).forward(request, response);
//            }
//            
//        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorUsuario at " + request.getContextPath() + "</h1>");
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
            String usuario=request.getParameter("usuario");
            String pass=request.getParameter("password");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String genero=request.getParameter("genero");
            String email=request.getParameter("email");
            u.setUsuario(usuario);
            u.setNombre(nombre);
            u.setApellido(apellido);
            u.setGenero(genero);
            u.setEmail(email);
            u.setContrasena(pass);
            dao.agregar(u);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("iduser",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("id"));
            String usuario=request.getParameter("usuario");
            String pass=request.getParameter("password");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String genero=request.getParameter("genero");
            String email=request.getParameter("email");
            u.setId(id);
            u.setUsuario(usuario);
            u.setNombre(nombre);
            u.setApellido(apellido);
            u.setGenero(genero);
            u.setEmail(email);
            u.setContrasena(pass);
            dao.editar(u);
            acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            u.setId(id);    
            dao.eliminar(id);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("Login")){
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            u.setUsuario(usuario);
            u.setContrasena(password);
            r = dao.iniciar_sesion(u);
            
            if (r==1){
                //request.getRequestDispatcher(inicio).forward(request, response);
                acceso=principal;
            }else {
                //request.getRequestDispatcher(login).forward(request, response);
                acceso=principal;
            }

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
