<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Form</title>
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

<div align="center">
    <h1>Please enter your details so that help can reach you as soon as possible</h1> <br>
    <form action="/adduser" method="post" >
        Name: <input type="text" name="userName"> <br>
        Latitude: <input type="text" name="latitude"><br>
        Longitude: <input type="text" name="longitude"><br>
        <input type="submit" value="Submit">
    </form>

</div>


<div align="center">
    <button type="button" class="btn btn-danger" onclick = "onclick_event()">View User List</button>
</div>
</body>


</html>