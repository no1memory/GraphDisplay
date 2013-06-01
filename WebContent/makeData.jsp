<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>データ入力</title>
</head>
<body>
<form action="/graphDisplay/MakeDataServlet">
	データ個数を入力してください
	<input type="text" name="dataNum" >
	<input type="submit" value="送信">
	<br>
	出力データ:<%=request.getAttribute("dataOutput")  %>
</form>
</body>
</html>