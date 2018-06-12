<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Análise Combinatória - Informações</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand py-0">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="https://github.com/iagocolodetti">GitHub</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ac.jsp">Voltar</a>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="form-group text-center">
                    <h3>Análise Combinatória</h3>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-xs-10 col-sm-7 col-md-5 col-lg-5 text-center">
                    <label style="font-size: 14px; font-style:italic; color:navy;">
                        p = número de elementos escolhidos.
                        <br>
                        p,p,... = número de repetições.
                        <br>
                        n = número total de elementos.
                    </label>
                </div>
            </div>
            <div class="dropdown text-center">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Selecionar Tipo</button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="acinfo?tipo=ps">Permutação Simples</a>
                    <a class="dropdown-item" href="acinfo?tipo=pr">Permutação com Repetição</a>
                    <a class="dropdown-item" href="acinfo?tipo=as">Arranjo Simples</a>
                    <a class="dropdown-item" href="acinfo?tipo=ar">Arranjo com Repetição</a>
                    <a class="dropdown-item" href="acinfo?tipo=cs">Combinação Simples</a>
                    <a class="dropdown-item" href="acinfo?tipo=cr">Combinação com Repetição</a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group text-center">
                    <h5>${tipoSelecionado}</h5>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group text-center">
                    <img src="${tipoSelecionadoImg}"/>
                </div>
            </div>
                <div class="row justify-content-center">
                <div class="form-group col-xs-10 col-sm-7 col-md-5 col-lg-5 text-center">
                    <h6>${tipoSelecionadoInfo}</h6>
                </div>
            </div>
        </div>
    </body>
</html>
