<html>
<head>
    <title>Login Page</title>
</head>
<div align="center" style="border: solid 4px black;height: auto">
    <h1 align="center">Login</h1><br>
    <font color="green"><h4 align="center">${logout}</h4></font>
    <font color="red"><h4 align="center">${message}</h4></font>
    <form method="post">
        <table align="center" style="border-spacing: 15px">
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>

        </table>
    </form>
</div>
</html>