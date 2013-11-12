<%@ include file="taglib.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
    <link href="../../docs-assets/ico/favicon.png" rel="shortcut icon">

    <title>Service</title>

    <!-- Bootstrap core CSS -->
   <link href='<spring:url value="/resources/css/bootstrap3/css/bootstrap.css" />' rel="stylesheet">      
  <script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
  <script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
  
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap3/css/signin.css" />'>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
	</head>
	
	<body>
		<div class="navbar-wrapper">
			<div class="container">
	
				<div class="navbar navbar-inverse navbar-static-top">
					<div class="container">
						<div class="navbar-header">
							<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
								<span class="icon-bar"></span> 
								<span class="icon-bar"></span> 
								<span	class="icon-bar"></span>
							</button>
							<a href="#" class="navbar-brand"><img width="15%" src='<spring:url value="/resources/images/logo.png"/>' class="img-polaroid"></a>
						</div>
					</div>
				</div>
	
			</div>
		</div>

<div class="container">
		<form:form class="form-signin" name='f' action="appcomponent.htm" method='POST' commandName="product">
			<h2 class="form-signin-heading" >Create New Project (Step-3)</h2>
			<div>Project Name: <c:out value="${projectName}" /> </div>			
			
			<div style="width: 100%; height:102%; border:2px solid; border-radius:25px; padding: 10 10 30 10">
				<div>Below you can find the services associated to <br> Please select from the optional capabilities listed below.</div>
				<div style="width: 50%; float: left;"> 
					
					Out of box capabilities:
					<div class="service-list">
						<c:forEach var="capability" varStatus="statusCapability" items="${product.mandatoryCapabilityList}">
							<b>Capability:<c:out value="${capability.name}" /></b><br>
							<b>Services:</b><br>
							<div class="checkbox-list">
					        	<form:hidden path="mandatoryCapabilityList[${statusCapability.index}].uri" value="${capability.uri}" />
						        <c:forEach var="service" varStatus="statusService" items="${capability.serviceList}">
					            	<form:checkbox path="mandatoryCapabilityList[${statusCapability.index}].serviceList" value="${service.uri}" /> <c:out value="${service.name}" /><br>
					        	</c:forEach>
							</div>
				        </c:forEach>
					</div>
					Optional capabilities:
					<div class="service-list">
					    <c:forEach var="optionalCapability" varStatus="statusCapability" items="${product.optionalCapabilityList}">
							<b>Capability:<c:out value="${optionalCapability.name}" /></b><br>
							<b>Services:</b><br>
							<div class="checkbox-list">
								<form:hidden path="optionalCapabilityList[${statusCapability.index}].uri" value="${optionalCapability.uri}" />
						        <c:forEach var="service" varStatus="statusService" items="${optionalCapability.serviceList}">
					            	<form:checkbox path="optionalCapabilityList[${statusCapability.index}].serviceList" value="${service.uri}" /> <c:out value="${service.name}" /><br>
					        	</c:forEach>
							</div>
				        </c:forEach>
					</div>
					
				</div>
				<div style="margin-left: 52%; height:100%;">
					<button type="submit" class="btn btn-lg btn-primary btn-block">Next Step</button>
				</div>
				<div style=clear: both;"></div>
			</div>
		</form:form>
	</div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  

</body></html>