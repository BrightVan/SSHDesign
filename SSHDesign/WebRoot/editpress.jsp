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
    
    <title>编辑出版社页面</title>
    
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
			<p style="font-size:50px">编辑出版社信息</p>
		</div>
		
		<!-- 中间内容 -->
		<div id="content" >
		   <center>
		   		<form action="editpress.action" method="post">
						<font style="font-size:20px;font: 黑体;font-weight:bold">
						<s:property value="press.name"/>
						</font> 
						<input type="hidden" name="press.name" 
						value="<s:property value="press.name"/>"/>
						<br><br>
						<input id="phone" name="press.phone" class="text"
							type="text" placeholder="输入电话"
							style="background: url(res/ic_lock.png)no-repeat 6px center" 
							value="<s:property value="press.phone"/>"/> 
						<br><br> 
						<input id="postcode" name="press.postcode"
							class="text" type="text" placeholder="输入邮编"
							style="background: url(res/ic_location.png)no-repeat 6px center" 
							value="<s:property value="press.postcode"/>"/>
						<br><br> 
						<input id="location" name="press.location"
							class="text" type="text" placeholder="输入地址"
							style="background: url(res/ic_location.png)no-repeat 6px center" 
							value="<s:property value="press.location"/>"/>
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
  		var phone = new String;
	    phone = document.getElementById("phone").value;
	    var postcode = new String;
	    postcode = document.getElementById("postcode").value;
		if (phone == ""||phone.lengh!=11) {
			alert("电话必须输入11位的号码！");
			return false;
		}else if(postcode == ""||postcode.lengh!=6){
			alert("地址信息不能为空");
			return false;
		}else if(document.getElementById("location").value == ""){
			alert("地址信息不能为空");
			return false;
		}
		return true;
	}
  </script>
</html>
