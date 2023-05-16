<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Usuarios</h1>
            <a class="btn btn-success" href="controladorUsuario?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">USUARIO</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">GENERO</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Usuario>list=dao.listar_todo();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario user=null;
                    while(iter.hasNext()){
                        user=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= user.getId()%></td>
                        <td class="text-center"><%= user.getUsuario()%></td>
                        <td><%= user.getNombre()%></td>
                        <td class="text-center"><%= user.getApellido()%></td>
                        <td class="text-center"><%= user.getGenero()%></td>
                        <td class="text-center"><%= user.getEmail()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="controladorUsuario?accion=editar&id=<%= user.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="controladorUsuario?accion=eliminar&id=<%= user.getId()%>">Remove</a>
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
