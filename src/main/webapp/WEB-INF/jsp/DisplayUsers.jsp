<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Displaying Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<script>
    function onclick_event() {
        document.location.href = "/getuserform";
    }
</script>

<script type="text/javascript">
    $(window).on('load', function() {
        $('#exampleModal').modal('show');
    });
</script>

<body>
<%--<h1>${message}</h1>--%>
<%--<h2>Hello</h2>--%>
<%--<h2>${userList.size()}</h2>--%>
<h1 align="center">User List</h1>
<br/>
<table border="1" cellpadding="10">
    <tr>
        <th>Name</th><th>Latitude</th><th>Longitude</th>
    </tr>
    <c:forEach var="contact" items="${userList}">
        <tr>
            <td>${contact.userName}</td>
            <td>${contact.latitude}</td>
            <td>${contact.longitude}</td>
        </tr>
    </c:forEach>
</table>

<div align="center">
    <button type="button" class="btn btn-primary" onclick = "onclick_event()">Add More Users</button>
</div>



<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Message from Admin</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ${notification}
            </div>
        </div>
    </div>
</div>

</body>