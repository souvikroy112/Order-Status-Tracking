<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList,dao.DbConnect,model.Distributor" %>
 <%
  try{
 %>  
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
		<marquee><h3><span style="color:#4676b8;text-transform: uppercase; font-weight: bold;">welcome to <%=session.getAttribute("catagory1") %> zone</span></h3>
		</marquee>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
			</div>
			<div class="col-sm-8">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#add" data-toggle="tab">Add Managers</a></li>
					<li><a href="#view" data-toggle="tab">View Manages</a></li>
					<li><a href="#distribute" data-toggle="tab">view Distributers</a></li>
					<li><a href="#logout" data-toggle="tab">Log out</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="add">
						<div class="media">
							<div class="media-body">
								<form role="form" action="insertManagerDetails" method="post" name="manager_registration">
									<div class="form-group">
										<input type="text" class="form-control" id="mgr_name" autocomplete="off" name="mgr_name" placeholder="Name" required="required">
									</div>
									<div class="form-group">
										<input type="date" class="form-control" id="mgr_dob" name="mgr_dob" placeholder="Date Of Birth" autocomplete="off" required="required">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="mgr_city" name="mgr_city" placeholder="City" autocomplete="off"required="required" >
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="mgr_contact" maxlength="10" name="mgr_contact" placeholder="Contact" autocomplete="off"  required="required">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="mgr_email" name="mgr_email" placeholder="Email" autocomplete="off" required="required">
									</div>
									<button type="submit" class="btn btn-default">Sign Up
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
					<div class="tab-pane fade" id="view">
						<div class="media">
							<div class="media-body">
								<form role="form" action="managerView" method="post" name="view_manager">
									<div class="form-group">
										<input type="text" class="form-control" id="manager_id" autocomplete="off" name="manager_id" placeholder="Manager Id" required="required">
									</div>
									<button type="submit" class="btn btn-default">View <span class="glyphicon glyphicon-ok"></span></button>
								</form>
								
							</div>
						</div>
						
					</div>
					 
					<div class="tab-pane fade" id="distribute">
						<div class="media">
							<div class="media-body">
								<table style="text-align: center; border:2px solid;border-color: #0c71fd">
  									<%
 									session = request.getSession(false);
 									ArrayList<Distributor> al=DbConnect.getDistributor();
 									if(al==null || al.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No new Distributor is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Id</th>
    									<th>Name</th>
    									<th>City</th>
    									<th>Mobile</th>
    									<th>Approve</th>
    									<th>Reject</th>
 									 </tr>
 										<%
 										for(Distributor d:al)
 										{%>
 											
 											 <tr>
    											<td><%=d.getDis_id() %></td>
    											<td><%=d.getDis_name() %></td>
    											<td><%=d.getDis_city()%></td>
    											<td><%=d.getDis_mobile()%></td>
    											<td>
    												<form role="form" action="updateStatusDistributor" method="post" name="form_login" onsubmit="return validateClient();">
														<div class="form-group">
															<input type="hidden" class="form-control"  autocomplete="off" name="dis_id" value="<%=d.getDis_id() %>" placeholder="Admin Id" required="required">
															<input type="hidden" class="form-control"  autocomplete="off" name="status" value="active" placeholder="Admin Id" required="required">
														</div>
														<button type="submit" class="btn btn-default">Approve
															<span class="glyphicon glyphicon-ok"></span>
														</button>
									
													</form>
    											</td>
    											<td>
    												<form role="form" action="updateStatusDistributor" method="post" name="form_login" onsubmit="return validateClient();">
														<div class="form-group">
															<input type="hidden" class="form-control"  autocomplete="off" name="dis_id" value="<%=d.getDis_id() %>" placeholder="Admin Id" required="required">
															<input type="hidden" class="form-control"  autocomplete="off" name="status" value="reject" placeholder="Admin Id" required="required">
														</div>
														<button type="submit" class="btn btn-default">Reject
															<span class="glyphicon glyphicon-ok"></span>
														</button>
									
													</form>
    											</td>
  											</tr>
 											
 										<%}
 									}
 									 %>
 									
  									<%
  									%>
  								</table>
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
	
	</body>
	<%
	if(session.getAttribute("catagory1")!="admin")
	{
		response.sendRedirect("admin_login.jsp");
	}
	%>
</html>
<%
  }catch(Exception e)
 {
	  response.sendRedirect("admin_login.jsp");
 }
%>
