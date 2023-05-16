<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.dao.DocenteDAO"%>
<%@page import="co.edu.udec.devweb.activdad2.helen_lopez_solano.modelo.entidades.Docente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <%
                    DocenteDAO dao = new DocenteDAO();
                    int id = Integer.parseInt((String)request.getAttribute("iduser"));
                    Docente d = (Docente)dao.listar_con_filtro(id);
                %>
                <h1>Editar Docente</h1>
                <form action="controladorDocente">
                    <label for="nombre" class="form-label">Nombres</label>    
                    <input class="form-control" type="text" name="nombre" value="<%= d.getNombre()%>"><br>
                    <label for="apellido" class="form-label">Apellidos</label>    
                    <input class="form-control" type="text" name="apellido" value="<%= d.getApellido()%>"><br>
                    <label for="email" class="form-label">Correo electrónico</label>    
                    <input class="form-control" type="email" name="email" value="<%= d.getEmail()%>"><br>
                    <label for="telefono" class="form-label">telefono</label>    
                    <input class="form-control" type="text" name="telefono" value="<%= d.getTelefono()%>"><br>
                    <label for="blog" class="form-label">Blog</label>    
                    <input class="form-control" type="text" name="blog" value="<%= d.getBlog()%>"><br>
                    <label for="profesional" class="form-label">Profesión</label>    
                    <input class="form-control" type="text" name="profesional" value="<%= d.getProfesional()%>"><br>
                    <label for="escalafon" class="form-label">Escalafón</label>    
                    <input class="form-control" type="text" name="escalafon" value="<%= d.getEscalafon()%>"><br>
                    <label for="idioma" class="form-label">Idioma</label>    
                    <input class="form-control" type="text" name="idioma" value="<%= d.getIdioma()%>"><br>
                    <label for="experiencia" class="form-label">Años de experiencia</label>    
                    <input class="form-control" type="text" name="experiencia" value="<%= d.getAñosExperiencia()%>"><br>
                    <label for="area" class="form-label">Area de trabajo</label>    
                    <input class="form-control" type="text" name="area" value="<%= d.getAreaTrabajo()%>"><br>
                    <label for="password" class="form-label">Contraseña</label>    
                    <input class="form-control" type="password" name="password" value="<%= d.getClave()%>"><br>
                    <input type="hidden" name="id" value="<%= d.getId()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a href="controladorDocente?accion=listar" class="btn btn-warning">Regresar</a>
                </form>
            </div>

        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
