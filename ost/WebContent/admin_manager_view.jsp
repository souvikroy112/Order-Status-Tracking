<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    try{
    %>
<!DOCTYPE html>
<html>
	<head>
	<title>OST SYSTEM  </title>
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
					<li class="active"><a href="#view" data-toggle="tab">View </a></li>
					<li><a href="#logout" data-toggle="tab">Log Out </a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="view">
						<div class="media">
							<div class="media-body">
								 
									 <%
                        if(session.getAttribute("msg")!=null){%>
                        <span style="color:#e50000;text-transform: uppercase; font-weight: bold;">                  
                            <%
                        	out.println(session.getAttribute("msg"));
                        	session.removeAttribute("msg");
                        	%>
                        	</span>  
                        	<%
                        }
                        else
                        {
                        	%>
                        	<table>
                        		<tr>
                        			<td>Id</td>
                        			<td><%=session.getAttribute("mgr_id") %></td>
                        		</tr>
                        		<tr>
                        			<td>Name</td>
                        			<td><%=session.getAttribute("mgr_name") %></td>
                        		</tr>
                        		<tr>
                        			<td>Date Of Birth</td>
                        			<td><%=session.getAttribute("mgr_dob") %></td>
                        		</tr>
                        		<tr>
                        			<td>City</td>
                        			<td><%=session.getAttribute("mgr_city") %></td>
                        		</tr>
                        		<tr>
                        			<td>Contact</td>
                        			<td><%=session.getAttribute("mgr_contact") %></td>
                        		</tr>
                        		<tr>
                        			<td>Email</td>
                        			<td><%=session.getAttribute("mgr_email") %></td>
                        		</tr>
                        	</table>
                        	<a href="admin_manager_update.jsp" class="btn btn-default">Update
								<span class="glyphicon glyphicon-ok"></span>
							</a>
                        	<%
                        	}
                        	%>
								
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
	if(session.getAttribute("catagory1")!="admin")
	{
		response.sendRedirect("admin_login.jsp");
	}
	%>
	</body>
</html>
<%
    }catch(Exception e)
    {
    	response.sendRedirect("admin_login.jsp");
    }
%>
