<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>
        User List
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div align="center" style="border: solid 4px black;height: 95%">
    <h1 align="center">User List</h1><br><br><br>
    <center><a href="/mainApp/adminHome">
        <button style="width: 110px;">Home</button>
    </a></center>
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
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</div>
</body>
</html>