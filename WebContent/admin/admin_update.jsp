<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		if(!verifyUserName(document.form1.name.value)) {
			alert("用户名为6-20位字母");
			return false;
		}
		
		if(!verifyPwd(document.form1.pwd.value)) {
			alert("密码为6-20位字母或数字");
			return false;
		}
	}
</script>
</head>

<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">


				<div align="center">

					<form name="form1" action="${pageContext.request.contextPath }/adminServlet?action=update"
						method="post" onsubmit="return verifyInfo()">
						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">
							<tbody style="margin: 0; padding: 0">
								<tr>
									<td class="line_table" align="center" colspan="8" height="20">
										<span class="left_bt2">更改管理员信息</span>
									</td>
								</tr>

								<tr>
									<td class="line_table" align="right" width="45%"><span
										class="left_bt2">管理员姓名</span></td>
									<td class="line_table" align="left" width="55%"><input
										type="text" name="name" size="20" value="${sessionScope.admin.name }"></td>
								</tr>
								<tr>
									<td class="line_table" align="right" width="45%"><span
										class="left_bt2">管理员密码</span></td>
									<td class="line_table" align="left" width="55%"><input
										type="password" name="pwd" size="20" value="${sessionScope.admin.pwd }">
										<input type="hidden" name="id" value="${sessionScope.admin.id }" />
									</td>
								</tr>
								<tr>
									<td class="line_table" align="center" colspan="8" height="20">
										<input type="submit" value="修改" />
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>


			</td>


		</tr>
	</table>

</body>
</html>
