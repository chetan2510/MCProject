<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Multiple Users Added</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<script>
    function onclick_event() {
        document.location.href = "/getallusers";
    }
</script>


<body>

<h1 align="center">${message}</h1>

<div align="center">
    <button type="button" class="btn btn-danger" onclick = "onclick_event()">View User List</button>
</div>

</body>