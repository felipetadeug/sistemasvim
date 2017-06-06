
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html >
    <head>
        <meta charset="UTF-8">
        <title>Sistema SVIM</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="login.css">

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

    </body>
</html>