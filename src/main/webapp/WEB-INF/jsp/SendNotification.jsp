<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">


<html>


<body>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Send Notificatin To The Users</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <form action="/sendNotification" method="post" >
                        <label for="InputText">Type Message</label>
                        <input type="email" class="form-control" id="InputText" aria-describedby="emailHelp" placeholder="Message for Users">
                        <small id="emailHelp" class="form-text text-muted">Message will only be shared with active users</small>
                        <input type="submit" value="Submit">
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


</body>




</html>