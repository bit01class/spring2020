<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript">
	var body;
		$(function(){
			body=$(".result");
			getList();
		});

		function getList(){
			$.getJSON('emp/',function(data){
				console.log(data);
				body.text(data);
			});
		}
	</script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">비트교육센터</a>
    </div><!-- navbar-header end -->
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">HOME <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Intro</a></li>
        <li><a href="#">E M P</a></li>
        <li><a href="#">LOGIN</a></li>
       </ul>
    </div>
  </div>
</nav>
<!-- content start -->
<div class="container">
	<div class="row">
		<div class="col-md-12 result"></div>
	</div>
</div>

<!-- content end -->
</body>
</html>



























