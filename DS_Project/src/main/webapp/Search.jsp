<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>GoogleSearch</title>
	<style type="text/css">
.button{
	position:absolute;
	width:45px;
	height:25px;
	font-size:15px;
	left:50%;
	top:50%;
}
.border-style {
	border-radius:75px/90px;
}
#padding{
	padding: 0px 0px 0px 15px;
}
</style>
<script type="text/javascript">

</script>
</head>
<body style='background-color:#acc37c'>
<form action='${requestUri}' method='get'>

<div class = 'box' style = 'position:absolute;margin-top:530px;margin-left:635px;'></div>
 
<div>
<input type='text' class="border-style" id="padding"  
style='font-size:120%;position:absolute;left:50%;top:48%;
margin-top:-47px;margin-left:-400px;width:800px;height:45px' name='keyword' placeholder='請輸入關鍵字'
onfocus="placeholder= '' " onblur="placeholder='請輸入關鍵字'" />
</div>

<div>
<input type='image' src="images/loupe-2.png" 
style='position:absolute;width:40px;height:40px;left:50%;top:50%;margin-top:-58px;margin-left:350px'/>
</div>
<div>
<a href ='http://localhost:8080/DS_Project/TestProject'><img src="images/band.png" style='position:absolute;width:500px;height:500px;left:50%;top:50%;margin-top:-450px;margin-left:-250px'></a>
</div>
</form>
</body>
</html>