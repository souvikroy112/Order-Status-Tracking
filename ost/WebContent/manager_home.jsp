<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,dao.DbConnect,model.Product,model.Order,model.Salesman,model.SalmnVsStatus" %>
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
	<script src="javascript/jquery-3.0.0.js"></script>
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
	<script>
$(document).ready(function(){
    $("#panel-heading1").click(function(){
        $("#panel-body1").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#panel-heading2").click(function(){
        $("#panel-body2").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#panel-heading3").click(function(){
        $("#panel-body3").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#panel-heading4").click(function(){
        $("#panel-body4").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#panel-heading5").click(function(){
        $("#panel-body5").slideToggle("slow");
    });
});
$(document).ready(function(){
    $("#panel-heading6").click(function(){
        $("#panel-body6").slideToggle("slow");
    });
});
 
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
		<marquee><h3><span style="color:#4676b8;text-transform: uppercase; font-weight: bold;">welcome to <%=session.getAttribute("catagory1") %> zone</span></h3>
		</marquee>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
			</div>
			<div class="col-sm-8">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#product" data-toggle="tab">Product</a></li>
					<li><a href="#salesman" data-toggle="tab">Salesman</a></li>
					<li><a href="#report" data-toggle="tab">Report</a></li>
					<li><a href="#logout" data-toggle="tab">Log out</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="product">
						<div class="media">
							<div class="media-body">
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading1">Add Products</div>
  									<div class="panel-body" id="panel-body1" style="display: none;">
  										<form role="form" action="insertProductDetails" method="post" name="insertProductDetails">
										<div class="form-group">
											<input type="text" class="form-control" id="product_title" autocomplete="off" name="product_title" placeholder="Title" required="required">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" id="product_decription" name="product_decription" placeholder="Description" autocomplete="off" required="required">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" id="product_price" name="product_price" placeholder="Price" autocomplete="off"required="required" >
										</div>
										<div class="form-group">
											<input type="text" class="form-control" id="product_catagory" name="product_catagory" placeholder="Catagory" autocomplete="off"  required="required">
										</div>
										
										<button type="submit" class="btn btn-default">Sign Up
											<span class="glyphicon glyphicon-ok"></span>
										</button>
									
										<div class="form-group">
											<p><span style="color: #e50000;">
											<%
												if(session.getAttribute("msg_product_add")!=null){
											%>
											<script type="text/javascript">
												   
												   alert('<%=session.getAttribute("msg_product_add")%>')
												</script>
											<%
											session.removeAttribute("msg_product_add");
											}
											%>
											</span>
											</p>
										</div>
										</form>
  									</div>
								</div>
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading2">View Products</div>
  									<div class="panel-body" id="panel-body2" style="display: none;">
  										<form role="form" action="productView" method="post" name="view_product">
											<div class="form-group">
												<input type="text" class="form-control" id="product_id" autocomplete="off" name="product_id" placeholder="Product Id" required="required">
											</div>
											<button type="submit" class="btn btn-default">View <span class="glyphicon glyphicon-ok"></span></button>
										</form>
  									</div>
								</div>
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading3">Delete product</div>
  									<div class="panel-body" id="panel-body3" style="display: none;">
  										<form role="form" action="productDelete" method="post" name="delete_product">
											<div class="form-group">
												<input type="text" class="form-control" id="product_id" autocomplete="off" name="product_id" placeholder="Product Id" required="required">
											</div>
											<button type="submit" class="btn btn-default">Delete<span class="glyphicon glyphicon-ok"></span></button>
											<div class="form-group">
												<p><span style="color: #e50000;">
												<%
													if(session.getAttribute("msg_product_delete")!=null){
												%>
												<%=session.getAttribute("msg_product_delete")%>
												<script>
												alert('<%=session.getAttribute("msg_product_delete")%>')
												</script>
												<%
													session.removeAttribute("msg_product_delete");
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
					<div class="tab-pane fade" id="salesman">
						<div class="media">
							<div class="media-body">
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading4">Add Salesman</div>
  									<div class="panel-body" id="panel-body4" style="display: none;">
  										<form role="form" action="insertSalesmanDetails" method="post" name="insertProductDetails">
										 	<div class="form-group">
												<input type="text" class="form-control" id="mgr_name" autocomplete="off" name="salmn_name" placeholder="Name" required="required">
											</div>
											<div class="form-group">
												<input type="date" class="form-control" id="mgr_dob" name="salmn_dob" placeholder="Date Of Birth" autocomplete="off" required="required">
											</div>
											<div class="form-group">
												<input type="text" class="form-control" id="mgr_city" name="salmn_city" placeholder="City" autocomplete="off"required="required" >
											</div>
											<div class="form-group">
												<input type="text" class="form-control" id="mgr_contact" maxlength="10" name="salmn_contact" placeholder="Contact" autocomplete="off"  required="required">
											</div>
											<div class="form-group">
												<input type="email" class="form-control" id="mgr_email" name="salmn_email" placeholder="Email" autocomplete="off" required="required">
											</div>
											<div class="form-group">
										<select class='form-control' name="zone" required>
											  <option value="">Zone</option>
    										  <option value="1" >East</option>
   											  <option value="2">West</option>
  											  <option value="3">North</option>
  											  <option value="4">South</option>
 										 </select>
									</div>
									
									 		<button type="submit" class="btn btn-default">Register
												<span class="glyphicon glyphicon-ok"></span>
											</button>
									
											<div class="form-group">
												<p><span style="color: #e50000;">
												<%
													if(session.getAttribute("msg_salesman_add")!=null){
												%>
												<script type="text/javascript">
												   
												   alert('<%=session.getAttribute("msg_salesman_add")%>')
												</script>
												
												<%
													session.removeAttribute("msg_salesman_add");
												}
												%>
												</span>
												</p>
											</div>
										</form>
  									</div>
								</div>
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading5">View Salesman</div>
  									<div class="panel-body" id="panel-body5" style="display: none;">
  										<form role="form" action="salesmanView" method="post" name="view_product">
											<div class="form-group">
												<input type="text" class="form-control" id="salesman_id" autocomplete="off" name="salesman_id" placeholder="salesman Id" required="required">
											</div>
											<button type="submit" class="btn btn-default">View <span class="glyphicon glyphicon-ok"></span></button>
										</form>
  									</div>
								</div>
								<div class="panel panel-default">
  									<div class="panel-heading" id="panel-heading6">Remove Salesman</div>
  									<div class="panel-body" id="panel-body6" style="display: none;">
  										<form role="form" action="salesmanDelete" method="post" name="delete_product">
											<div class="form-group">
												<input type="text" class="form-control" id="salesman_id" autocomplete="off" name="salesman_id" placeholder="Salesman Id" required="required">
											</div>
											<button type="submit" class="btn btn-default">Delete<span class="glyphicon glyphicon-ok"></span></button>
											<div class="form-group">
												<p><span style="color: #e50000;">
												<%
													if(session.getAttribute("msg_salesman_delete")!=null){
												%>
												<%=session.getAttribute("msg_salesman_delete")%>
												<script>
												alert('<%=session.getAttribute("msg_salesman_delete")%>')
												</script>
												<%
													session.removeAttribute("msg_salesman_delete");
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
					 
					<div class="tab-pane fade" id="report">
						<div class="media">
							<div class="media-body">
							<h3>REPORT GENERATION</h3>
							<form action="report.jsp" method=post class="form-inline">
								<div class="form-group">
										<select class='form-control' name="row" required>
											  <option value="">None</option>
    										  <option value="Salesman" >Salesman</option>
   											  <option value="Distributor">Distributor</option>
 										 </select>
									</div>
									<div class="form-group">
										<select class='form-control' name="column" required>
											  <option value="">None</option>
    										  <option value="Order Status">Order Status</option>
   											  <option value="Zone">Zone</option>
 										 </select>
									</div>
									<button type="submit" class="btn btn-default">Analyse
											
									</button>
									
							</form>	 
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="logout">
						<div class="media">
							<div class="media-body">
								<form role="form" action="logout" method="get">
									<h3><span style=" text-transform: uppercase;font-weight: bold;"> catagory : <%=session.getAttribute("catagory1") %></span></h3>
									<h3><span style=" text-transform: uppercase;font-weight: bold;"> id : <%=session.getAttribute("id")%></span></h3>
									<h3><span style=" text-transform: uppercase;font-weight: bold;"> Session id : <%=session.getId()%></span></h3>
									<button type="submit" class="btn btn-default">Log Out
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-2"> 
			</div>
			
		</div>
	</div>
	<%
	if(session.getAttribute("catagory1")!="manager")
	{
		response.sendRedirect("manager_login.jsp");
	}
	%>
	</body>
</html>
<%}catch(Exception e)
{
	response.sendRedirect("manager_login.jsp");
}
%>