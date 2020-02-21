<%@ page session="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/" var="root"></c:url>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="${root }css/bootstrap.css" />
	<style type="text/css">
		body { padding-top: 70px; }
		.item img{
			margin: 0px auto;
		}
	</style>
	<script type="text/javascript" src="${root }js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${root }js/bootstrap.js"></script>
	<script type="text/javascript">

	$(function(){

		$('form').one('submit',function(){
			$('button[type="reset"]').off('click',delRecord).text('초기화');
				$('.page-header').html('<h1>수정페이지 <small>EMP TABLE Row</small></h1>');
				$('#name,#pay').removeAttr('disabled');
				return false;
			});

		$('button[type="reset"]').on('click',delRecord);
		
		});
	
	function delRecord(){
		var param={'sabun': ${bean.sabun} };
		$.post('../delete',param,function(){
				window.location.href='../list';
			});
		/*
		 .done(function(){
				window.location.href='../list';
			}); 
		window.location.replace('../list');
			*/
	}

	</script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${root }">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${root }">HOME <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">DEPT <span class="caret"></span></a>
        	<ul class="dropdown-menu">
        		<li><a href="${root }dept/list">LIST</a></li>
            	<li role="separator" class="divider"></li>
        		<li><a href="${root }dept/add">INSERT</a></li>
        	</ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">E M P <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${root }emp/list">LIST</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="${root }emp/add">INSERT</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-12">
<ol class="breadcrumb">
  <li><a href="#">HOME</a></li>
  <li><a href="#">EMP</a></li>
  <li class="active">${bean.sabun }</li>
</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<!-- content start -->

<div class="page-header">
  <h1>상세페이지 <small>EMP TABLE Row</small></h1>
</div>
<form class="form-horizontal" action="../edit" method="post">
	<div class="form-group">
	  <label for="sabun" class="col-sm-2 control-label">sabun</label>
	  <div class="col-sm-10">
	    <input type="text" class="form-control" name="sabun" id="sabun" placeholder="sabun" value="${bean.sabun }" readonly="readonly">
	  </div>
	</div>
	<div class="form-group">
	  <label for="name" class="col-sm-2 control-label">name</label>
	  <div class="col-sm-10">
	    <input type="text" class="form-control" name="name" id="name" placeholder="name" value="${bean.name }" disabled="disabled">
	  </div>
	</div>
	<div class="form-group">
	  <label for="nalja" class="col-sm-2 control-label">nalja</label>
	  <div class="col-sm-10">
	    <input type="text" class="form-control" name="nalja" id="nalja" placeholder="nalja" value="${bean.nalja }" disabled="disabled">
	  </div>
	</div>
	<div class="form-group">
	  <label for="pay" class="col-sm-2 control-label">pay</label>
	  <div class="col-sm-10">
	    <input type="text" class="form-control" name="pay" id="pay" placeholder="pay" value="${bean.pay }" disabled="disabled">
	  </div>
	</div>
	<div class="form-group">
	  <div class="col-sm-offset-2 col-sm-10">
	  <div class="btn-group btn-group-justified" role="group" aria-label="...">
	    <button type="submit" class="btn btn-primary">수정</button>
	    <button type="reset" class="btn btn-default">삭제</button>
	    <button type="button" class="btn btn-default" onclick="history.back();">BACK</button>
	  </div>
	  </div>
	</div>	
</form>
		
		<!-- content end -->
		</div>
	</div>
	<div class="row">
		<div class="col-md-12"></div>
	</div>
</div>
</body>
</html>




















