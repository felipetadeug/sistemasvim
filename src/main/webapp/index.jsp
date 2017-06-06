
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html >
    <head>
        <meta charset="UTF-8">
        <title>Sistema SVIM</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="login.css">
        <script src="login.js"></script>
    </head>

    <body>

        <div class="pen-title">
            <h1>Sistema Auto Posto SVIM</h1>
        </div>
        <div class="module form-module">

            <div class="form">

            </div>
            <div class="form">
                <h2>Entre com seu CPF e senha</h2>
                <form method="POST" action="./Autenticar">
                    <input type="text" name="cpf" placeholder="CPF"/>
                    <input type="password" name="senha" placeholder="Senha"/>
                    <button>Login</button>
                </form>
            </div>
        </div>


        <div class="modal fade" id="errorModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">ERRO!</h4>
                    </div>
                    <div class="modal-body">
                        <h4 id="msgErro">
                            <c:if test="${not empty msg}">
                                ${msg}
                            </c:if>
                        </h4>
                    </div>
                </div>				      
            </div>
        </div> 

    </body>
</html>