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
<body>
<div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">MMS Wizard</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav"></ul>
            </div>
          </div>
        </div>

      </div>
    </div>
    
    <div style="float: right; padding-right:15%">
 
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	
	
	
	
	<!-- Put some contents here -->
	<h1>Capability!</h1>
	
	
 
	<form name='f' action="<c:url value='service.htm' />"  method='POST'>
 		<input name="submit" type="submit"	value="Next >>" />
	</form>
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src='<spring:url value="/resources/js/jquery.min.js" />'></script>
    <script src='<spring:url value="/resources/css/bootstrap3/js/bootstrap.min.js" />'></script>
    <script src='<spring:url value="/resources/js/holder.js"/>'></script>
  </body>
  
</html>