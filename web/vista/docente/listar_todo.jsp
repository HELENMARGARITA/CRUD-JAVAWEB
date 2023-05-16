<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Docente"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.DocenteDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docentes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Docentes</h1>
            <a class="btn btn-success" href="controladorDocente?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">BLOG</th>
                        <th class="text-center">PROFESION</th>
                        <th class="text-center">ESCALAFON</th>
                        <th class="text-center">IDIOMA</th>
                        <th class="text-center">AÑOS EXPERIENCIA</th>
                        <th class="text-center">AREA DE TRABAJO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    DocenteDAO dao=new DocenteDAO();
                    List<Docente>list=dao.listar_todo();
                    Iterator<Docente>iter=list.iterator();
                    Docente docente=null;
                    while(iter.hasNext()){
                        docente=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= docente.getId()%></td>
                        <td class="text-center"><%= docente.getNombre()%></td>
                        <td class="text-center"><%= docente.getApellido()%></td>
                        <td class="text-center"><%= docente.getEmail()%></td>
                        <td class="text-center"><%= docente.getTelefono()%></td>
                        <td class="text-center"><%= docente.getBlog()%></td>
                        <td class="text-center"><%= docente.getProfesional()%></td>
                        <td class="text-center"><%= docente.getEscalafon()%></td>
                        <td class="text-center"><%= docente.getIdioma()%></td>
                        <td class="text-center"><%= docente.getAñosExperiencia()%></td>
                        <td class="text-center"><%= docente.getAreaTrabajo()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="controladorDocente?accion=editar&id=<%= docente.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="controladorDocente?accion=eliminar&id=<%= docente.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                <a class="btn btn-primary" href="controladorUsuario?accion=Login">Panel principal</a>
        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
