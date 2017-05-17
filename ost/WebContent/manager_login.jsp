<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<%!String userid;
		String password;
		int counter=0;
	%>
	<%
  		 Cookie cookie = null;
   		 Cookie[] cookies = null;
   		// Get an array of Cookies associated with this domain
   		cookies = request.getCookies();
   		if( cookies != null ){
      		for (int i = 0; i < cookies.length; i++){
         		cookie = cookies[i];
         		if(cookie.getName().equals("userid_manager"))
         		{
         			counter++;
         		}
         		if(cookie.getName().equals("password_manager"))
         		{
         			counter++;
         		}
      		}
      		//out.print(counter);
      		if(counter==2)
      		{
      			counter=0;
      			//response.setHeader("method", "post");
      			response.sendRedirect("oldManagerLogin");
      		}
  		}
%>
	<div class="jumbotron text-center">
		<h1><span style="color:#4676b8;font-size: 100px; ">O</span><span style=" text-transform: lowercase;font-size: 40px; font-style: italic;">ST</span></h1>
		
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
			</div>
			<div class="col-sm-4">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#old_manage" data-toggle="tab">Old Manager </a></li>
					<li><a href="#new_manager" data-toggle="tab">New Manager</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="old_manage">
						<div class="media">
							<div class="media-body">
								<form role="form" action="oldManagerLogin" method="post" name="form_login" onsubmit="return validateClient();">
									<div class="form-group">
										<input type="number" class="form-control" id="username_login" autocomplete="off" name="Username" placeholder="Manager Id">
									</div>
									<div class="form-group">
										<input type="password" class="form-control" id="password_login" name="Password" placeholder="Password" >
									</div>
									<div class="checkbox">
										<label>
											<input type="checkbox"> Remember
										</label>
									</div>
									<button type="submit" class="btn btn-default">Log In 
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
					<div class="tab-pane fade" id="new_manager">
						<div class="media">
							<div class="media-body">
								<form role="form" action="newManagerValidity" method="post" name="form_reg" onsubmit="return validateForm();">
									<div class="form-group">
										<input type="name" class="form-control" id="name_reg" name="username_manager" placeholder="Manager Id" maxlength="50">
									</div>
									<div class="form-group">
										<input type="date" class="form-control" id="email_reg" name="date_maneger" placeholder="Date of Birth" maxlength="35">
									</div>
									<button type="submit" class="btn btn-default">Login
										<span class="glyphicon glyphicon-ok"></span>
									</button>
								</form>
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
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-4"> 
			</div>
		</div>
	</div>
	</body>
</html>
