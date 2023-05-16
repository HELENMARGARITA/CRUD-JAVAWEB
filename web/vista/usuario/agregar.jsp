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
                <h1>Agregar Usuario</h1>
                <form action="controladorUsuario">
                    <label for="usuario" class="form-label">Usuario</label>    
                    <input class="form-control" type="text" name="usuario"><br>
                    <label for="nombre" class="form-label">Nombres</label>    
                    <input class="form-control" type="text" name="nombre"><br>
                    <label for="apellido" class="form-label">Apellidos</label>    
                    <input class="form-control" type="text" name="apellido"><br>
                    <label for="genero" class="form-label">Género</label>
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="genero">
                        <option selected>Seleccione...</option>
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select>
                    <label for="email" class="form-label">Correo electrónico</label>    
                    <input class="form-control" type="email" name="email"><br>
                    <label for="password" class="form-label">Contraseña</label>    
                    <input class="form-control" type="password" name="password"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="controladorUsuario?accion=listar" class="btn btn-warning">Regresar</a>
                </form>
            </div>

        </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
