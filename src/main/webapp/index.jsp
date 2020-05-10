<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tips of the day</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/index.css"/>
</head>
<body>


<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Tips</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addTipModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New Tip</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">Actions</th>
                <th scope="col">Start</th>
                <th scope="col">End</th>
                <th scope="col" style="width:80%;">Content</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${tips}" var="tip">
                <tr>
                    <td>
                        <a href="#editTipModal" class="edit" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                        </a>
                        <a href="#deleteTipModal" class="delete" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                        </a>
                    </td>
                    <td>${tip.start}</td>
                    <td>${tip.end}</td>
                    <td>${tip.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addTipModal" class="modal fade">
    <div class="modal-dialog">

        <div class="modal-content">
            <form id="addTipForm" name="addTipForm" class="form-horizontal" role="from" method="get"
                  url="${submitTipUrl}">
                <div class="modal-header">
                    <h4 class="modal-title">Add a new tip</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Start</label>
                        <input id="tipStart" type="date" class="form-control" name="tipStart" required/>
                    </div>
                    <div class="form-group">
                        <label>End</label>
                        <input id="tipEnd" type="date" class="form-control" name="tipEnd" required/>
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea class="form-control" required id="tipContent" name="tipContent" rows="5" cols="10">
                        </textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input id="submitNewTip" type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editTipModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Edit Tip</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Start</label>
                        <input id="tipStart" type="date" class="form-control" name="tipStart" required/>
                    </div>
                    <div class="form-group">
                        <label>End</label>
                        <input id="tipEnd" type="date" class="form-control" name="tipEnd" required/>
                    </div>
                    <div class="form-group">
                        <label>Content</label>
                        <textarea class="form-control" required id="tipContent" name="tipContent" rows="5" cols="10">
                        </textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input id="submitNewTip" type="submit" class="btn btn-success" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteTipModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Tip</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this tip?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input id="deleteTip" type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<script src="js/moment.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/app.js"></script>
</body>
</html>
