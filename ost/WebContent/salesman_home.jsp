<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,dao.DbConnect,model.Product,model.Order,model.Salesman" %>
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
		<marquee><h3><span style="color:#4676b8;text-transform: uppercase; font-weight: bold;">welcome to <%=session.getAttribute("catagory1") %> zone</span></h3>
		</marquee>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
			</div>
			<div class="col-sm-8">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#add" data-toggle="tab">View Orders</a></li>
					<li><a href="#view" data-toggle="tab">View Profile</a></li>
					<li><a href="#logout" data-toggle="tab">Log out</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="add">
						<div class="media">
							<div class="media-body">
									<table style="text-align: center; border:2px solid;border-color: #0c71fd">
  									<%
 									session = request.getSession(false);
  									String dis_id=session.getAttribute("id").toString();
 									ArrayList<Order> al1=DbConnect.getOrderDetails(dis_id);
 									if(al1==null || al1.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										%>
 										<tr style="text-align: center; border:2px solid;border-color: #0c71fd">
    									<th>Order Id</th>
    									<th>Order Date</th>
    									<th>Expected Date</th>
    									<th>Actual Date</th>
    									<th>Status</th>
    									<th>Approval</th>
    									<th>Delivered</th>
 									 </tr>
 										<%
 										for(Order d:al1)
 										{%>
 											
 											 <tr>
    											<td><%=d.getOrder_id() %></td>
    											<td><%=d.getOrder_date() %></td>
    											<td><%=d.getExpected_delivery()%></td>
    											<td><%=d.getAcrual_deliver()%></td>
    											<td><%=d.getStatus()%></td>
    											<td>
    											<form role="form" action="insertExpectedDeliveryDate.jsp" method="post" name="form_login" onsubmit="return validateClient();">
    											<input type="hidden" class="form-control"  autocomplete="off" name="order_id" value="<%=d.getOrder_id() %>" required="required">
    											<input type="hidden" class="form-control"  autocomplete="off" name="order_date" value="<%=d.getOrder_date() %>" required="required">
    											<input type="hidden" class="form-control"  autocomplete="off" name="salesman_id_order" value="<%=session.getAttribute("id") %>" required="required">
    											
													<button type="submit" class="btn btn-default">Approve
														 
														</button>
												</form>
													
    											</td>
    											<td>
    											<form role="form" action="updateDeliveredOrderDate" method="post" name="form_login" onsubmit="return validateClient();">
    											<input type="hidden" class="form-control"  autocomplete="off" name="order_id" value="<%=d.getOrder_id() %>" required="required">
    											
													<button type="submit" class="btn btn-default">Delivered
														 
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
					<div class="tab-pane fade" id="view">
						<div class="media">
							<div class="media-body">
								<table>
								<%
 									session = request.getSession(false);
									Salesman ob=new Salesman();
  									String salesman_id=session.getAttribute("id").toString();
  									ob.setSalmn_id(Long.parseLong(salesman_id));
 									ArrayList<Salesman> al2=DbConnect.getSalesmanDetails(ob);
 									if(al2==null || al2.size()==0)
 									{
 										%>
 										<h1 style="text-transform: uppercase;">No Product is found.</h1>
 										<%
 									}
 									else
 									{
 										for(Salesman d:al2){
 										%>
                        		<tr>
                        			<td>Id</td>
                        			<td><%=d.getSalmn_id()%></td>
                        		</tr>
                        		<tr>
                        			<td>Name</td>
                        			<td><%=d.getSalmn_name() %></td>
                        		</tr>
                        		<tr>
                        			<td>Date Of Birth</td>
                        			<td><%=d.getSalmn_dob() %></td>
                        		</tr>
                        		<tr>
                        			<td>City</td>
                        			<td><%=d.getSalmn_city() %></td>
                        		</tr>
                        		<tr>
                        			<td>Contact</td>
                        			<td><%=d.getSalmn_contact() %></td>
                        		</tr>
                        		<tr>
                        			<td>Email</td>
                        			<td><%=d.getSalmn_email() %></td>
                        		</tr>
                        		<%}
 									}
 									
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
	<%
	if(session.getAttribute("catagory1")!="salesman")
	{
		response.sendRedirect("salesmanLogin.jsp");
	}
	%>
	</body>
</html>
<%
}catch(Exception e)
{
	response.sendRedirect("salesmanLogin.jsp");
}
%>
