<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
<style type="text/css">
    body {
        background-color: #acc37c;
        margin: 0;
    }

    #padding {
        padding: 15px;
    }

    a {
        color: #0B173B;
        font-size: 30px;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    .border-style {
        border-radius: 90px/90px;
        font-size: 120%;
        width: 800px;
        height: 25px;
        position: absolute;
        left: 50%;
        top: 48%;
        margin-top: -250px;
        margin-left: -500px;
    }

    .result-container {
        position: absolute;
        margin-top: 250px;
        margin-left: 200px;
    }
    
    .lcs-container {
        position: absolute;
        margin-top: 250px;
        margin-left: 1200px;
    }

    .logo-container {
        position: absolute;
        width: 90px;
        height: 70px;
        left: 50%;
        top: 50%;
        margin-top: -250px;
        margin-left: -400px;
    }
</style>
</head>
<body>

<form action='${requestUri}' method='get'>
    <div class="result-container">
        <%
        String[][] orderList = (String[][]) request.getAttribute("query");
        for (int i = 0; i < orderList.length; i++) {
            String s = orderList[i][1];
        %>

        <a href='<%=s%>'><%=orderList[i][0]%> </a> <br> <br>
        <br>
        <%
        }
        %>
    </div>
    
    <div class="lcs-container">
    	<a>—————————</a><br>
        <a>建議搜索的關鍵字:</a><br>
    <%  
    	String lcs = (String)request.getAttribute("res");;
	%>
		<a><%= request.getAttribute("res") %></a><br>
    	<a>—————————</a><br>  
    </div>
    
	<div>
		<img src="images/mountain-2.png" style='position: absolute; width: 165px; height: 67px; left: 50%; top: 50%; margin-top: -280px; margin-left: -670px'>
	</div>
	
    <div>
        <input type='text' class="border-style" id="padding" name='keyword'
               placeholder='請輸入關鍵字' value='<%=request.getParameter("keyword")%>'/>
    </div>
    <div>
	<input type='image' src="images/loupe-2.png" 
	style='position:absolute;width:40px;height:40px;left:50%;top:50%;margin-top:-256px;margin-left:280px'/>
	</div>
</form>

</body>
</html>
