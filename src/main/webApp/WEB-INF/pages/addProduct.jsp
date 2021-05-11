<html>
<head>
    <title>Add product</title>
</head>
<h1 align="center">Add product</h1>
<br>
<center><a href="/mainApp/adminHome"><button style="width: 110px;">Home</button></a></center><br><br>
<form method="post">
    <table align="center" style="border-spacing: 15px">
        <tr>
            <td>Product Name:</td>
            <td><input type="text" name="name" required></td>
        </tr>
        <tr>
            <td>Brand:</td>
            <td><input type="text" name="brand" required></td>
        </tr>
        <tr>
            <td>Made In:</td>
            <td><input type="text" name="madeIn" required></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" required></td>
        </tr>
        <tr>
            <td>Purchase Date:</td>
            <td><input type="date" name="date" required></td>
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