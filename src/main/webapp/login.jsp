<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
<%--    <link rel="stylesheet" href="css/bootstrap.min.css"/>--%>
<%--    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"/>--%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<div id="app" >
    <form class="login-container form-horizontal" method="post" action="login">

        <h3 class="title">System Log In</h3>

        <div class="form-group">
            <label>Username</label>
            <input id="username" type="text" class="form-control input" name="username" required/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input id="password" type="password" class="form-control input" name="password" required/>
        </div>

        <button class="btn btn-success" type="submit">Login</button>
    </form>


<%--    <form class="login-container" action="login" method="post">--%>
<%--        <h3 class="title">System Log In</h3>--%>
<%--        <div class="item">--%>
<%--            <label >--%>
<%--                <input name="username" class="input" type="text"  placeholder="Username">--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="item">--%>
<%--            <label >--%>
<%--                <input name="password" class="input" type="password"  placeholder="Password">--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="item">--%>
<%--&lt;%&ndash;            <label >&ndash;%&gt;--%>

<%--&lt;%&ndash;                <input class="submit"  type="submit" value="Login">&ndash;%&gt;--%>
<%--&lt;%&ndash;            </label>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </form>--%>
</div>

<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="js/moment.min.js"></script>--%>
<%--<script src="js/bootstrap-datetimepicker.min.js"></script>--%>
<%--<script src="js/app.js"></script>--%>
</body>
</html>
