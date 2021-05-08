<html>
<head>
    <title>Add product</title>
</head>
<h1 align="center">Update product</h1>
<br><br><br>
<form method="post">
    <table align="center" style="border-spacing: 15px">
        <tr>
            <td>Product Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Brand:</td>
            <td><input type="text" name="brand"></td>
        </tr>
        <tr>
            <td>Made In:</td>
            <td><input type="text" name="madeIn"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Purchase Date:</td>
            <td><input type="date" name="date"></td>
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