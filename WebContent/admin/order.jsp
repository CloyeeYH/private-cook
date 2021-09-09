<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/admin/">
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>

<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="12"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">单价(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">合计(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购时间</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">是否派送</span></td>
								<td class="line_table" align="center" colspan="2"><span
									class="left_bt2">确认订单</span></td>
							</tr>
						<c:forEach items="${requestScope.page.list }" var="orders">
                             <tr>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.userid }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.realname }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.phone }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.address }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.menuname }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.menusum }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.price }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.price*order.menusum }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.times }</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">${orders.delivery eq 0?'否':'是'}</span></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath }/ordersServlet?action=ensure">确认</a></td>
								<td class="line_table" align="center"><a
									href="${pageContext.request.contextPath }/ordersServlet?action=delete&&id=${orders.id}">取消</a></td>
							</tr>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
								<span class="left_bt2">第${page.curPage }页
										&nbsp;&nbsp;共${page.totalPage }页
								</span>&nbsp;&nbsp; 
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
								<span style="font-size: 12px; color:gray">[首页]</span>
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath }/ordersServlet?action=findAll&&curPage=1">[首页]</a>
								</c:otherwise>
								
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
								<span style="font-size: 12px; color:gray">[尾页]</span>
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath }/ordersServlet?action=findAll&&curPage=${page.totalPage}">[尾页]</a>
								</c:otherwise>
								
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq 1 }">
								<span style="font-size: 12px; color:gray">[上一页]</span>
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath }/ordersServlet?action=findAll&&curPage=${page.curPage-1}">[上一页]</a>
								</c:otherwise>	
								</c:choose>
								
								<c:choose>
								<c:when test="${page.curPage eq page.totalPage }">
								<span style="font-size: 12px; color:gray">[下一页]</span>
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath }/ordersServlet?action=findAll&&curPage=${page.curPage+1}&&userid=${requestScope.ordersInfo.userid}">[下一页]</a>
								</c:otherwise>	
								</c:choose>

								</td>
							</tr>
							
					</table>
				</div>
				
				
				
				
			</td>
		</tr>
	</table>
</body>
</html>