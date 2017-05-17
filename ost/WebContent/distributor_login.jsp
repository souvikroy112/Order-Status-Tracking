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
         		if(cookie.getName().equals("userid_distributor"))
         		{
         			counter++;
         		}
         		if(cookie.getName().equals("password_distributor"))
         		{
         			counter++;
         		}
      		}
      		//out.print(counter);
      		if(counter==2)
      		{
      			counter=0;
      			response.setHeader("method", "post");
      			response.sendRedirect("distributorLogin");
      		}
  		}
%>	
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
			</div>
			<div class="col-sm-4">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#login" data-toggle="tab">Log In </a></li>
					<li><a href="#signup" data-toggle="tab"> Sign Up </a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="login">
						<div class="media">
							<div class="media-body">
								<form role="form" action="distributorLogin" method="post" name="distributor_login" >
									<div class="form-group">
										<input type="number" class="form-control" id="username_login" autocomplete="off" name="Username" placeholder="Distributor Id" required="required">
									</div>
									<div class="form-group">
										<input type="password" class="form-control" id="password_login" name="Password" placeholder="Password" required="required">
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
					<div class="tab-pane fade" id="signup">
						<div class="media">
							<div class="media-body">
								<form role="form" action="distributorSignUp" method="post" name="form_reg" onsubmit="return validateForm();">
									<div class="form-group">
										<input type="text" class="form-control" id="name_reg" name="name" placeholder="Name" maxlength="50" required="required">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="email_reg" name="city" placeholder="City" maxlength="35" required="required">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="mobile_reg" name="Mobile" maxlength="10" placeholder="Mobile No." required="required">
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
									<div class="form-group">
										<input type="password" class="form-control" id="password_reg" name="Password" maxlength="35" placeholder="Password" required="required">
									</div>
									<button type="submit" class="btn btn-default">Register
										<span class="glyphicon glyphicon-ok"></span>
									</button>
									 
									<div class="form-group">
												<p><span style="color: #e50000;">
												<%
													if(session.getAttribute("msg_dis_signup")!=null){
												%>
												<script type="text/javascript">
												   
												   alert('<%=session.getAttribute("msg_dis_signup")%>')
												</script>
												 
										
												<%
													session.removeAttribute("msg_dis_signup");
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
	</body>
</html>
