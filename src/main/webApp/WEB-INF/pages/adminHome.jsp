<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<h1 align="center">Welcome to Sporty Shoes</h1><br>
<h3 align="center">${name}[admin]</h3><br>
<center><a href="/mainApp/passwordChange"><button>Change Password</button></a>
    <a href="/mainApp/userList"><button style="width: 110px;">User List</button></a>
    <a href="/mainApp/signIn?logout"><button style="width: 110px;">Logout</button></a></center>
<br><br>


<div class="container">
    <div class="container">

        <form method="post">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="search">
                <div class="input-group-btn">
                    <button class="btn btn-default" type="submit">Search</button>
                </div>
            </div>
        </form>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Brand</th>
            <th>Made In</th>
            <th>Price</th>
            <th>Purchase Date</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.productName}</td>
                        <td>${product.brand}</td>
                        <td>${product.madeIn}</td>
                        <td>${product.price}</td>
                        <td>${product.purchaseDate}</td>
                        <td><a type="button" class="btn btn-success"
                               href="/mainApp/update-product?id=${product.id}">Update</a></td>
                        <td><a type="button" class="btn btn-warning"
                               href="/mainApp/delete-product?id=${product.id}">Delete</a></td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>
    <div>
        <a class="button" href="/mainApp/addProduct">Add a product</a>
    </div>

    <h4 align="center">${message}</h4>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
</body>
</html>