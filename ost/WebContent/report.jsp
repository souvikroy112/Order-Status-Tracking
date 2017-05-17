<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,dao.DbConnect,model.Product,model.Order,model.Salesman,model.SalmnVsStatus,model.DistVsStatus,model.SalmnVsZone,model.DistVsZone" %>
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
					<li class="active"><a href="#report" data-toggle="tab">Report</a></li>
					<li><a href="#logout" data-toggle="tab">Log out</a></li>
				</ul>
				<div class="tab-content">	 
					<div class="tab-pane fade in active" id="report">
						<div class="media">
							<div class="media-body">
							<h3 style="text-transform: uppercase;padding-bottom: 10px">report generation</h3>
							<%
							 if(request.getParameter("row").equals("Salesman") && request.getParameter("column").equals("Order Status"))
								{%>
								 		<table style="text-align: center; border:2px solid;border-color: #0c71fd">
  									<%
 									session = request.getSession(false);
 									ArrayList<SalmnVsStatus> al1=DbConnect.getSalesmanStatusReport();
 									if(al1==null || al1.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										<h5 style="text-transform: uppercase;padding-bottom: 10px;font-weight: bold;">Salesman Vs Status Report</h5>
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Salesman Id</th>
    									<th>Pending</th>
    									<th>Processing</th>
    									<th>Delivered</th>
 									 </tr>
 										<%
 										for(SalmnVsStatus d:al1)
 										{%><tr>
 											
 											<td><%=d.getSalmn_id() %></td>
 											<%
 												if(d.getStatus().equals("pending"))
 												{
 													%><td><%=d.getNumber() %> </td>  <%
 												}
 												else
 												{
 													%><td>-</td>  <%
 												}
 												
 											if(d.getStatus().equals("processing"))
												{
													%><td><%=d.getNumber() %> </td>  <%
												}
 											else
												{
													%><td>-</td>  <%
												}
												
 											if(d.getStatus().equals("delivered"))
												{
													%><td><%=d.getNumber() %> </td>  <%
												}
 											else
												{
													%><td>-</td>  <%
												}
												
 											%>
 											</tr>
 											
 										<%}
 									}
 									 %>
 									
  									<%
  									%>
  								</table>
								<%}
							 else if(request.getParameter("row").equals("Distributor") && request.getParameter("column").equals("Order Status"))
							 {%>
								 <table style="text-align: center; border:2px solid;border-color: #0c71fd">
								 <h5 style="text-transform: uppercase;padding-bottom: 10px;font-weight: bold;">Distributor Vs Status Report</h5>
  									<%
 									session = request.getSession(false);
 									ArrayList<DistVsStatus> al2=DbConnect.getDistributorStatusReport();
 									if(al2==null || al2.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Distributor Id</th>
    									<th>Pending</th>
    									<th>Processing</th>
    									<th>Delivered</th>
 									 </tr>
 									 	
 										<%
 										for(DistVsStatus d:al2)
 										{%><tr>
 											
 											<td><%=d.getDis_id() %></td>
 											<%
 												if(d.getStatus().equals("pending"))
 												{
 													%><td><%=d.getNumber() %> </td>  <%
 												}
 												else
 												{
 													%><td>-</td>  <%
 												}
 												
 											if(d.getStatus().equals("processing"))
												{
													%><td><%=d.getNumber() %> </td>  <%
												}
 											else
												{
													%><td>-</td>  <%
												}
												
 											if(d.getStatus().equals("delivered"))
												{
													%><td><%=d.getNumber() %> </td>  <%
												}
 											else
												{
													%><td>-</td>  <%
												}
												
 											%>
 											</tr>
 											
 										<%}
 									}
 									 %>
 									
  									<%
  									%>
  								</table>
							 <%}
							 else if(request.getParameter("row").equals("Salesman") && request.getParameter("column").equals("Zone"))
							 {%>
								  <table style="text-align: center; border:2px solid;border-color: #0c71fd">
								  <h5 style="text-transform: uppercase;padding-bottom: 10px;font-weight: bold;">Salesman Vs Zone Report</h5>
  									<%
 									session = request.getSession(false);
 									ArrayList<SalmnVsZone> al2=DbConnect.getSalesmanZoneReport();
 									if(al2==null || al2.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Salesman Id</th>
    									<th>East</th>
    									<th>West</th>
    									<th>North</th>
    									<th>South</th>
 									 </tr>
 										<%
 										for(SalmnVsZone d:al2)
 										{%><tr>
 											<td><%=d.getSalmn_id() %></td>
 											<%if(d.getZone_id()==1)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==2)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==3)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==4)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											
 											 
 											</tr>
 											
 										<%}
 									}
 									 %>
 									
  									<%
  									%>
  								</table>
							 <%}
							 else if(request.getParameter("row").equals("Distributor") && request.getParameter("column").equals("Zone"))
							 {%>
								  <table style="text-align: center; border:2px solid;border-color: #0c71fd">
								   <h5 style="text-transform: uppercase;padding-bottom: 10px;font-weight: bold;">Distributor Vs Zone Report</h5>
  									<%
 									session = request.getSession(false);
 									ArrayList<DistVsZone> al2=DbConnect.getDistributorZoneReport();
 									if(al2==null || al2.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Distributor Id</th>
    									<th>East</th>
    									<th>West</th>
    									<th>North</th>
    									<th>South</th>
 									 </tr>
 										<%
 										for(DistVsZone d:al2)
 										{%><tr>
 											<td><%=d.getDis_id() %></td>
 											<%if(d.getZone_id()==1)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==2)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==3)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											<%if(d.getZone_id()==4)
 											{%>
 												<td><%=d.getNumber() %></td>
 											<%}
 											else
 											{%>
 												<td>-</td>
 											<%}
 											%>
 											</tr>
 											
 										<%}
 									}
 									 %>
 									
  									<%
  									%>
  								</table>
							 <%}
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
<%
}catch(Exception e)
{
	response.sendRedirect("manager_login.jsp");
}

%>