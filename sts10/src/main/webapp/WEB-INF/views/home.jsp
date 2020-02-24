<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
	<style type="text/css">
	.result table>tbody>tr{
		cursor: pointer;
	}
	
	</style>
	<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript">
	var body;
	var menu;
	var p1=$('<div class="jumbotron"/>').append('<h1>환영합니다</h1>');
	var p2=$('<div class="jumbotron"/>').append('<h1>INTRO PAGE</h1>');
	var p3=$('<div class="jumbotron"/>').append('<h1>LIST PAGE</h1><p><a class="btn btn-primary btn-lg empAdd" href="#" role="button">입력</a></p>');
	var form;
		$(function(){
			form=$('#myModal form');

			form.submit(function(){
				if($('#myModal').find('form').attr('method')=='post'){
					$('#myModal').modal('hide');
					insertOne();
				}else{
					updateOne();
				}
				return false;
				});

			
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
				modalClear();
				$('.modal-footer button[type=button]').eq(0).hide();
				$('.modal-footer button[type=button]').eq(1).hide();
				$('#sabun').parent().parent().hide();
				$('#nalja').parent().parent().hide();
				$('#myModal').modal();
				$('#myModal').find('form').attr('method','post');
				return false;
				});

			$(document).on('click','.result table>tbody>tr',function(){
				//상세
				$('.modal-footer button[type=submit]').hide();
				console.log($(this).find('td').eq(0).text());
				var sabun=$(this).find('td').eq(0).text();
				getDetail(sabun);
			});

			$('.modal-footer button[type=button]').eq(0).click(function(){
				//수정
				$('.modal-footer button[type=submit]').show();
				$('.modal-footer button[type=button]').eq(0).hide();
				$('.modal-footer button[type=button]').eq(1).hide();
				$('#name,#pay,#etc').removeProp('readonly');
			});
			
			$('.modal-footer button[type=button]').eq(1).click(function(){
				
				deleteOne($('#sabun').val());
				});
		});

		function deleteOne(a){
			$.ajax({
					type:'delete',
					url:'emp/'+a,
					success:function(data){
						$('#myModal').modal('hide');
						modalClear();
						getList();
					}
				});
		}

		function updateOne(){
			var param={
						sabun:$('#sabun').val(),
						name:$('#name').val(),
						pay:$('#pay').val(),
						etc:$('#etc').val()
					};
			$.ajax({
					url:'emp/'+$('#sabun').val(),
					type:'put',
					data:JSON.stringify(param),
					contentType: 'application/json; charset=utf-8',
//					data:param,
//		            contentType:false,
//		            processData:false,
					success:function(data){
						$('#myModal').modal('hide');
						getList();
					}
				});
		}

		function getDetail(a){
			$.getJSON('emp/'+a,function(data){
				console.log(data);
				$('#myModalLabel').text('상세페이지');
				$('#myModal').modal('show');
				$('#myModal').find('input').eq(0).val(data.sabun);
				$('#myModal').find('input').eq(1).val(data.name);
				$('#myModal').find('input').eq(2).val(data.nalja);
				$('#myModal').find('input').eq(3).val(data.pay);
				$('#myModal').find('input').eq(4).val(data.etc);
				$('#myModal').find('input').each(function(){
					$(this).prop('readonly','readonly');
				});
			});
		}

		function getList(){
			$.getJSON('emp/',function(data){
				var arr=data;
				var table=$('<table/>').addClass('table');
				body.html(table);
				table.append('<thead><tr><th>사번</th><th>이름</th><th>날짜</th><th>금액</th></tr></thead>');
				var tbody=$('<tbody/>').appendTo(table);
				for(var i=0; i<arr.length; i++){
					var tr=$('<tr/>').appendTo(tbody);
					$('<td/>').appendTo(tr).text(arr[i].sabun);
					$('<td/>').appendTo(tr).text(arr[i].name);
					$('<td/>').appendTo(tr).text(arr[i].nalja);
					$('<td/>').appendTo(tr).text(arr[i].pay);
				}				
				table.before(p3);
			});
		}

		function insertOne(){
			/* 
			var param=$('#myModal form').serialize();
			 */

			var param={
						name:$('#name').val(),
						pay:$('#pay').val(),
						etc:$('#etc').val()
						};
			$.post('emp/',param,function(){
				getList();
			});
			modalClear();
		}
		function modalClear(){
			$('.modal-footer button[type=button]').eq(0).show();
			$('.modal-footer button[type=button]').eq(1).show();
			$('#sabun').parent().parent().show();
			$('#nalja').parent().parent().show();
			$('#myModal form input').val('');
			$('#myModal').find('form').removeAttr('method');
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
		<div class="col-xs-12 result"></div>
	</div>

<!-- content end -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">입력 페이지</h4>
      </div>
      <form class="form-horizontal">
      <div class="modal-body">
		<div class="form-group">
		    <label for="sabun" class="col-sm-2 control-label">sabun</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="sabun" id="sabun" placeholder="sabun" value="0"/>
		    </div>
		</div>
		<div class="form-group">
		    <label for="name" class="col-sm-2 control-label">name</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="name" id="name" placeholder="name"/>
		    </div>
		</div>
		<div class="form-group">
		    <label for="nalja" class="col-sm-2 control-label">nalja</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="nalja" id="nalja" placeholder="nalja"/>
		    </div>
		</div>
		<div class="form-group">
		    <label for="pay" class="col-sm-2 control-label">pay</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="pay" id="pay" placeholder="pay"/>
		    </div>
		</div>
		<div class="form-group">
		    <label for="etc" class="col-sm-2 control-label">etc</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="etc" id="etc" placeholder="etc"/>
		    </div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">수정</button>
        <button type="button" class="btn btn-danger">삭제</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div><!-- Modal end -->

</div><!-- container end -->
</body>
</html>



























