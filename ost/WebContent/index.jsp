<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>OST SYSTEM</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="Creative, Onepage, Parallax, HTML5, Bootstrap, Popular, custom, personal, portfolio" /> 
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="javascript/jquery.min.js"></script>
	<script src="javascript/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<script type="text/javascript">
	$(document).ready(function(e) {
	    var $input = $('#refresh');

	    $input.val() == 'yes' ? location.reload(true) : $input.val('yes');
	});
	</script>
	</head>
	<body>
	<input type="hidden" id="refresh" value="no">
	<div class="jumbotron text-center">
		<h1><span style="color:#4676b8;font-size: 100px; ">O</span><span style=" text-transform: lowercase;font-size: 40px; font-style: italic;">ST</span></h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
			</div>
			<div class="col-sm-4">
				<a href="admin_login.jsp" type="submit" class="btn btn-block">Admin Section
															<span class="glyphicon glyphicon-ok"></span>
				</a><br>
				<a href="manager_login.jsp" type="submit" class="btn btn-block">Manager Section
															<span class="glyphicon glyphicon-ok"></span>
				</a><br>
				<a href="salesmanLogin.jsp" type="submit" class="btn btn-block">Salesman Section
															<span class="glyphicon glyphicon-ok"></span>
				</a><br>
				<a href="distributor_login.jsp" type="submit" class="btn btn-block">Distributor Section
															<span class="glyphicon glyphicon-ok"></span>
			    </a><br>
				 
			</div>
			<div class="col-sm-4"> 
			</div>
		</div>
	</div>
	</body>
</html>
