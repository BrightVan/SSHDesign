<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑图书页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">
	<link rel="icon" href="res/ic_logo.png" type="image/x-icon"/>

  </head>
  
  <body>
     <div id="container">
     
    	<!-- 头部内容 -->
		<div id="header" >
			<p style="font-size:50px">编辑图书信息</p>
		</div>
		
		<!-- 中间内容 -->
		<div id="content" >
		   <center>
		   		<form action="editbook.action" method="post">
						<font style="font-size:20px;font: 黑体;font-weight:bold">
						<s:property value="book.bookName"/>
						</font> 
						<input type="hidden" name="book.id" 
						value="<s:property value="book.id"/>"/>
						<input type="hidden" name="book.bookName" 
						value="<s:property value="book.bookName"/>"/>
						<br><br>
						<select name="pressName" title="选择出版社"
							style="background: url(res/ic_location.png)no-repeat 6px center">
							<s:iterator value="presses" var="press">
								<option><s:property value="#press.name" /></option>
							</s:iterator>
						</select> 
						<br><br>
						<input id="booknum" name="book.bookNum" class="text"
							type="text" placeholder="输入书的数量"
							style="background: url(res/ic_lock.png)no-repeat 6px center" 
							value="<s:property value="book.bookNum"/>"/> 
						<br><br> 
						<input id="bookposition" name="book.bookPosition"
							class="text" type="text" placeholder="输入所在位置"
							style="background: url(res/ic_location.png)no-repeat 6px center" 
							value="<s:property value="book.bookPosition"/>"/>
						<br><br><br>
						<input style="background:#1799ea;" class="button"
							type="submit" value="修改" onclick="return checkInput();"/>
				</form>
		    </center>
		</div>

	<!-- 底部内容 -->
		<div id="footer" >
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  		function checkInput(){
		if (document.getElementById("booknum").value == "") {
			alert("书的数量不能为空");
			return false;
		}else if(document.getElementById("bookposition").value == ""){
			alert("书的位置信息不能为空");
			return false;
		}
		return true;
	}
  </script>
</html>
