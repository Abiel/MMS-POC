<%@ include file="taglib.jsp" %>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

	<!-- Bootstrap core CSS -->
    <link href='<spring:url value="/resources/css/bootstrap3/css/bootstrap.css" />' rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href='<spring:url value="/resources/css/carousel.css" />' rel="stylesheet">
    	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	<script>
	$(function() {
		//alert('jQuery Initialized successfully');
	});
	</script>
	
</head>
<body style="background-image: linear-gradient(to bottom, #011111, #1f0a03);">

    <div class="container">
  		<div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
            <div class="row">
            	<div class="col-lg-5"><img width="25%" src='<spring:url value="/resources/images/logo.png"/>' class="img-polaroid"></div>
            	<div class="col-lg-5"><h3 align="right" id="forms">Accenture Mobile Operated Services</h3></div>
                </div>
            </div>
          </div>
        </div>

			<div class="row">
				<div class="col-sm-5">
					<div>
						<form class="bs-example form-horizontal" name='f'
							action="<c:url value='j_spring_security_check' />" method='POST'>
							<fieldset>
								<legend style="border-width: 0 0 0">Login</legend>
								<div class="form-group">
									<label class="col-lg-2 control-label" for="inputEmail">Username</label>
									<div class="col-lg-8">
										<input type="text" placeholder="Username" id="inputEmail"
											name='j_username' class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label" for="inputPassword">Password</label>
									<div class="col-lg-8">
										<input type="password" placeholder="Password"
											id="inputPassword" name='j_password' class="form-control">
										<c:if test="${not empty error}">
											<span class="help-block">Invalid Username or Password.</span>
											<%-- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
										</c:if>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-2">
										<button class="btn btn-default">Cancel</button>
										<button class="btn btn-primary" type="submit">Submit</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
				<div class="col-lg-4 col-lg-offset-1">

					<img src='<spring:url value="/resources/images/mobile.png"/>'
						class="img-polaroid">

				</div>
			</div>
			<br><br><br><br><br><br><br><br>
			
			<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src='<spring:url value="/resources/js/jquery.min.js" />'></script>
    <script src='<spring:url value="/resources/css/bootstrap3/js/bootstrap.min.js" />'></script>
    <script src='<spring:url value="/resources/js/holder.js"/>'></script>
    <br>
    <br>
    <br>
    <br>
    --
  </body>
  
</html>