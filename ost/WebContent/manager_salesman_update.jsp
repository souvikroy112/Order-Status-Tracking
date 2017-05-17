<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<div class="col-sm-4">
			</div>
			<div class="col-sm-4">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#update" data-toggle="tab">Update </a></li>
					<li><a href="#logout" data-toggle="tab">Log Out </a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="update">
						<div class="media">
							<div class="media-body">
								<form role="form" action="updateSalesmanDetails" method="post" name="manager_update">
									<div class="form-group">
										<input type="text" class="form-control" id="salmn_id" autocomplete="off" name="salmn_id" placeholder="Id" required="required" value=<%=session.getAttribute("salmn_id") %> readonly="readonly">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="salmn_name" autocomplete="off" name="salmn_name" placeholder="Name" required="required" value="<%=session.getAttribute("salmn_name")%>">
									</div>
									<div class="form-group">
										<input type="date" class="form-control" id="salmn_dob" name="salmn_dob" placeholder="Date Of Birth" autocomplete="off" required="required" value="<%=session.getAttribute("salmn_dob") %>">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="salmn_city" name="salmn_city" placeholder="City" autocomplete="off"required="required" value="<%=session.getAttribute("salmn_city") %>">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="salmn_contact" name="salmn_contact" placeholder="Contact" autocomplete="off"  required="required" value="<%=session.getAttribute("salmn_contact") %> ">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="salmn_email" name="salmn_email" placeholder="Email" autocomplete="off" required="required" value="<%=session.getAttribute("salmn_email") %>">
									</div>
									<button type="submit" class="btn btn-default">Update
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
					<div class="tab-pane fade" id="logout">
						<div class="media">
							<div class="media-body">
								<form role="form" action="logout" method="get">
									<h3><span style=" text-transform: uppercase;font-weight: bold;"> catagory : <%=session.getAttribute("catagory1") %></span></h3>
									<h3><span style=" text-transform: uppercase;font-weight: bold;"> id : <%=session.getAttribute("id")%></span></h3>
									<button type="submit" class="btn btn-default">Log Out
									</button>
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
	if(session.getAttribute("catagory1")!="manager")
	{
		response.sendRedirect("manager_login.jsp");
	}
	%>
	</body>
</html>
<%
    }catch(Exception e)
    {
    	response.sendRedirect("manager_login.jsp");
    }
%>
