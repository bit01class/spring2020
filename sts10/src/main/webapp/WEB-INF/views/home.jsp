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
	var menu;
	var p1=$('<div class="jumbotron"/>').append('<h1>환영합니다</h1>');
	var p2=$('<div class="jumbotron"/>').append('<h1>INTRO PAGE</h1>');
	var p3=$('<div class="jumbotron"/>').append('<h1>LIST PAGE</h1><p><a class="btn btn-primary btn-lg empAdd" href="#" role="button">입력</a></p>');
		$(function(){
			body=$(".result");
			//getList();
			menu=$('.navbar-nav>li>a');
			menu.eq(0).click(function(){
				body.html(p1);
				return false;
				});
			menu.eq(1).click(function(){
				body.html(p2);
				return false;
				});
			menu.eq(2).click(function(){
				getList();
				return false;
				});
			menu.eq(0).click();
			$(document).on('click','.empAdd',function(){
				//입력
				$('#myModal').modal();
				return false;
				});
		});

		function getList(){
			$.getJSON('emp/',function(data){
				var arr=data;
				var table=$('<table/>').addClass('table');
				body.html(table);
				for(var i=0; i<arr.length; i++){
					var tr=$('<tr/>').appendTo(table);
					$('<td/>').appendTo(tr).text(arr[i].sabun);
					$('<td/>').appendTo(tr).text(arr[i].name);
					$('<td/>').appendTo(tr).text(arr[i].nalja);
					$('<td/>').appendTo(tr).text(arr[i].pay);
				}				
				table.before(p3);
				/* 
				for(var i=0; i<arr.length; i++){
					//console.log(arr[0]);
					tr+='<tr>';
					//body.text(data);
					tr+='<td>'+arr[i].sabun+'</td>';
					tr+='<td>'+arr[i].name+'</td>';
					var date=new Date(arr[i].nalja);
					console.log(date);
					tr+='<td>'+(date.getYear()+1900)+"/"
						+(date.getMonth()+1)+"/"
						+date.getDate()
						+'</td>';
					tr+='<td>'+arr[i].pay+'</td>';
					tr+='</tr>';
				}
				$('<table class="table"/>').appendTo(body).append(tr);
				 */
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

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>



























