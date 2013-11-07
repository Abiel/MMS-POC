<%@ include file="taglib.jsp" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
    <link href="../../docs-assets/ico/favicon.png" rel="shortcut icon">

    <title>Signin Template for Bootstrap</title>

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
		<form:form class="form-signin" name='f' action="capability.htm"  method='POST' commandName="product">
			<h2 class="form-signin-heading" >Create New Project (Step-1)</h2>
			<div>Insert Project Details.</div>
			<div style="width: 100%; border:2px solid; border-radius:25px; padding: 10 10 10 10">
				
				<div style="width: 50%; float: left;"> 
					Project Name:
					<input type="text" autofocus="" required="" placeholder="Project Name" class="form-control"> 
					Client Name:
					<input type="text" autofocus="" required="" placeholder="Client Name" class="form-control">
					Project Country:
					<input type="text" autofocus="" required="" placeholder="Project Country" class="form-control">
				</div>
				
				<div style="margin-left: 52%; ">
					Project Description:  
					<input type="text" autofocus="" required="" placeholder="Project Description" class="form-control">
					Delivery Center:<br>
					<select>
						  <option value="NorthAmerica" >North America</option>
						  <option value="AsiaPacific">Asia Pacific</option>
						  <option value="Europe">Europe</option>
						  <option value="MiddleEastAfrica">MiddleEast Africa</option>
						  <option value="LatinAmerica">Latin America</option>
						</select>
					<br>Shared Model:<br>
					<select>
					  <option value="volvo">Volvo</option>
					  <option value="saab">Saab</option>
					  <option value="opel">Opel</option>
					  <option value="audi">Audi</option>
					</select>
				</div>
				<div style=clear: both;"></div>
			</div>
			
			<div>Select Project Domain</div>
			<div style="width: 100%;  border:2px solid; border-radius:25px; padding: 10 10 30 10">
				
				<div style="width: 50%; float: left;"> 
					Telematics:<br>
					<div class="checkbox-list">
					    <c:forEach var="i" varStatus="status" items="${productList}">
				          <tr>
				            <td><input type="checkbox" name="name" value="${i.name}"> <c:out value="${i.name}" /></td>
				          </tr>
				        </c:forEach>
					</div>
					Financial Services:<br>
					<div class="checkbox-list">
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					    <input type="checkbox" /> This is checkbox <br />
					</div>
				</div>
				
				<div style="margin-left: 52%;">
					
					<br><br><br><br><br><br><br><br><br>
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