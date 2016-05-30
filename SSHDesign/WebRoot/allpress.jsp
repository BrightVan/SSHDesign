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
    
    <title>出版社管理界面</title>
    
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
    	<!-- 添加出版社的窗体和表单 -->
		<div id="addPress" class="hideform">
			<img class="closeimg" alt="关闭" src="res/ic_close.png" onclick="return closeAddPress();">
			<form action="addpress.action" method="post">
				<div class="input">
					<font style="font-size:20px;font: 黑体;font-weight:bold">添加出版社</font>
					<br><br>
					<input id="pressname" name="press.name" class="text"
						type="text" placeholder="输入出版社名"
						style="background: url(res/ic_lock.png)no-repeat 6px center"/>
					<br><br>
					<input id="pressphone" name="press.phone" class="text"
						type="text" placeholder="输入出版电话"
						style="background: url(res/ic_lock.png)no-repeat 6px center"/>
					<br><br>
					<input id="presspostcode" name="press.postcode" class="text"
						type="text" placeholder="输入出版社邮编"
						style="background: url(res/ic_lock.png)no-repeat 6px center"/>
					<br><br>
					<input id="presslocation" name="press.location" class="text" type="text"
						placeholder="输入出版社地址"
						style="background: url(res/ic_location.png)no-repeat 6px center"/>
					<br><br><br>
					<input style="background:#1799ea;" class="button"
						type="submit" value="添加">
				</div>
			</form>
		</div>
		
    	<!-- 头部内容 -->
		<div id="header" >
			 <form action="searchpress.action" method="get">
				 <div class="header_content" style="left: 35%;">
				   	输入关键字：
				   	<input id="searchInput" type="text" name="searchKey"/>
		            &nbsp;&nbsp;
		            <input type="checkbox" name="exactFlag" value="exact">精确查询
		            &nbsp;&nbsp;
		            <input type="submit" value="查询" onclick="return checkKey();"/>
				 </div>
				 
				 <div class="header_content" style="right: 30px;">
					<input type="button" value="添加出版社" onclick="return showAddPress();" />
				</div>
				 
				 <div class="header_content" style="left: 30px;">
		            <input type="button" value="返回主界面"
		            onclick="javascript:document.location.href='getallbooks.action';"
		            />
				 </div>
		     </form>
		</div>
		
		<!-- 中间内容 -->
		<div id="content" >
		   <center>
		    <s:if test="presses==null||presses.size<1">
				<br><br><br><br>
				<font style="font-size:20px;">搜索不到结果！请调整你的关键字重试 </font>		    
		    </s:if>
		    <s:else>
		    	<table>
					<tr>
						<th>出版社名</th>
						<th>电话</th>
						<th>邮编</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
					<s:iterator value="presses" var="press">
						<tr>
							<td><s:property value="#press.name" /></td>
							<td><s:property value="#press.phone" /></td>
							<td><s:property value="#press.postcode" /></td>
							<td><s:property value="#press.location" /></td>
							<td><a href="goeditpress.action?pressName=<s:property value="#press.name"/>">
									编辑
								</a>
							</td>
						</tr>
					</s:iterator>
				</table>
		    </s:else>
		   		
		    </center>
		</div>

		<!-- 底部内容 -->
		<div id="footer" >
			<p>Copyright @ 2016 13级计科8班-凡帅 -3113006116.</p>
		</div>
	</div>
  </body>
  <script type="text/javascript">
  	function goBack(){
  		window.history.back();
  	}
	function showAddPress(){
		document.getElementById("pressname").value = "";
		document.getElementById("pressphone").value = "";
		document.getElementById("presspostcode").value = "";
		document.getElementById("presslocation").value = "";
		document.getElementById("addPress").style.display = 'block';
	}
	function closeAddPress(){
		document.getElementById("addPress").style.display = 'none';
	}
	function checkKey(){
		if (document.getElementById("searchInput").value == "") {
			alert("关键字内容不能为空");
			return false;
		}
		return true;
	}
</script>
</html>
