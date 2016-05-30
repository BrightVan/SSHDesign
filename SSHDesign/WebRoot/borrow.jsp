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
    
    <title>个人借书记录</title>
    
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
			 <form action="searchmyborrow.action" method="get">
				 <div class="header_content" style="left: 35%;">
				   	输入关键字：<input id="searchInput" type="text" name="searchKey"/>
		            &nbsp;&nbsp;
		            <input type="checkbox" name="exact
		            Flag" value="exact">精确查询
		            &nbsp;&nbsp;
		            <input type="submit" value="查询" onclick="return checkForm();"/>
		             &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
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
		   		<s:if test="myborrows==null||myborrows.size<1">
		   			<br><br><br><br>
					<font style="font-size:20px;">搜索不到借书记录 </font>
		   		</s:if>
		   		<s:else>
			   		<table>
						<tr>
							<th>书号</th>
							<th>书名</th>
							<th>出版社</th>
							<th>借书时间</th>
							<th>还书时间</th>
							<th>操作</th>
						</tr>
						<s:iterator value="myborrows" var="myborrow">
							<tr>
								<td><s:property value="#myborrow.books.id" /></td>
								<td><s:property value="#myborrow.books.bookName" /></td>
								<td><s:property value="#myborrow.press.name" /></td>
								<td style="text-align: left;"><s:property value="#myborrow.borrowDate" /></td>
								<td style="text-align: left;"><s:property value="#myborrow.returnDate" /></td>
								<s:if test="#myborrow.returnDate==null">
								<td><a href="returnbook.action?bookId=<s:property value="#myborrow.books.id"/>">
								还书</a></td>
								</s:if>
								<s:else>
								<td>已还</td>
								</s:else>
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
	function checkForm(){
		if(document.getElementById("searchInput").value==""){
			alert("关键字内容不能为空");
			return false;
		}
		return true;
	}
</script>
</html>
