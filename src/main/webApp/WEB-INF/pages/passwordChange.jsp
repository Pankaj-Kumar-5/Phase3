<html>
<head>
    <title>Change Password</title>
</head>
<div align="center" style="border: solid 4px black;height: auto">
    <h1 align="center">Change Password</h1><br><br>
    <center><a href="/mainApp/adminHome">
        <button style="width: 110px;">Home</button>
    </a></center>
    <br><br>
    <h4 align="center">${message}</h4><br>
    <form method="post">
        <table align="center" style="border-spacing: 15px">
            <tr>
                <td>Current Password:</td>
                <td><input type="password" name="currentPassword" required></td>
            </tr>
            <tr>
                <td>New Password:</td>
                <td><input type="password" name="newPassword" required></td>
            </tr>
            <tr>
                <td>Renter New Password:</td>
                <td><input type="password" name="reNewPassword" required></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>

        </table>
    </form>
</div>
</html>