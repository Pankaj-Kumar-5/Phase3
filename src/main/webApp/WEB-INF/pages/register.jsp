<html>
<head>
    <title>Register</title>
</head>
<h1 align="center">Register Page</h1>
<br><br><br>
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
            <td>Name:</td>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" required></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="number" name="phone" required></td>
        </tr>
        <tr>
            <%--        <td></td>--%>
            <td>
                <button type="submit">submit</button>
            </td>
        </tr>

    </table>
</form>
</html>