<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    try{
    %>
<!DOCTYPE html>
<html>
	<head>
	<title> OST SYSTEM</title>
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
				<ul class="nav nav-tabs">
					<li class="active"><a href="#order" data-toggle="tab">Order</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="order">
						<div class="media">
							<div class="media-body">
								<form role="form" action="insertOrderDetails" method="post" name="form_login" onsubmit="return validateClient();">
									<div class="form-group">
										 <input type="hidden" class="form-control"  autocomplete="off" name="product_id" value="<%=request.getParameter("product_id") %>" required="required">
										 <input type="hidden" class="form-control"  autocomplete="off" name="product_price" value="<%=request.getParameter("product_price") %>" required="required">
										 <input type="hidden" class="form-control"  autocomplete="off" name="distributor_id" value="<%=request.getParameter("distributor_id") %>" required="required">
										 <input type="text" class="form-control" id="quantity" autocomplete="off" name="quantity" placeholder="Quantity" required="required">
									</div>
									<button type="submit" class="btn btn-default">Order 
										<span class="glyphicon glyphicon-ok"></span>
									</button>
									<div class="form-group">
										<p><span style="color: #e50000;">
										<%
										if(session.getAttribute("msg")!=null){
											%>
											<%=session.getAttribute("msg")%>
											<%
											session.removeAttribute("msg");
										}
										%>
										</span>
										</p>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-4"> 
			</div>
		</div>
	</div>
	 <%
	if(session.getAttribute("catagory1")!="distributor")
	{
		response.sendRedirect("distributor_login.jsp");
	}
	%>
	</body>
</html>
<%
    }catch(Exception e)
    {
    	response.sendRedirect("distributor_login.jsp");
    }
%>