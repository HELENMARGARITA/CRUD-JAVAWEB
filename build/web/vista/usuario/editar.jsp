<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Usuario"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    UsuarioDAO dao = new UsuarioDAO();
                    int id = Integer.parseInt((String)request.getAttribute("iduser"));
                    Usuario u = (Usuario)dao.listar_con_filtro(id);
                %>
                <h1>Editar Usuario</h1>
                <form action="controladorUsuario">
                    <label for="usuario" class="form-label">Usuario</label>    
                    <input class="form-control" type="text" name="usuario" value="<%= u.getUsuario()%>"><br>
                    <label for="nombre" class="form-label">Nombres</label>    
                    <input class="form-control" type="text" name="nombre" values="<%= u.getNombre()%>"><br>
                    <label for="apellido" class="form-label">Apellidos</label>    
                    <input class="form-control" type="text" name="apellido" values="<%= u.getApellido()%>"><br>
                    <label for="genero" class="form-label">Género</label>
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="genero">
                        <option selected value="<%= u.getGenero()%>"><%= u.getGenero()%></option>
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select>
                    <label for="email" class="form-label">Correo electrónico</label>    
                    <input class="form-control" type="email" name="email" values="<%= u.getEmail()%>"><br>
                    <label for="password" class="form-label">Contraseña</label>    
                    <input class="form-control" type="password" name="password" value="<%= u.getContrasena()%>"><br>
                    <input type="hidden" name="id" value="<%= u.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a href="controladorUsuario?accion=listar" class="btn btn-warning">Regresar</a>
                </form>
            </div>

        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
