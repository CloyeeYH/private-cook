<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网上订餐管理员登陆</title>
<!-- href="images/skin.css" -->
<link href="images/skin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	//验证用户名和密码是否为空
	function verifyLogin() {
		if(!verifyNotNull(document.form1.name.value)) {
			alert("用户名不能为空！");
			return false;
		}
		
		if(!verifyNotNull(document.form1.pwd.value)) {
			alert("密码不能为空！");
			return false;
		}
	}
</script>
</head>

<body>
	<table width="100%" height="166" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="42" valign="top"><table width="100%" height="42"
					border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
					<tr>
						<td width="1%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="17%">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td valign="top"><table width="100%" height="532" border="0"
					cellpadding="0" cellspacing="0" class="login_bg">
					<tr>
						<td width="25%">&nbsp;</td>
						<td width="50%" valign="bottom"><table width="100%"
								height="59" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="4%">&nbsp;</td>
									<td width="96%" height="38"><span class="login_txt_bt">登陆网上订餐后台管理</span></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="21"><table cellSpacing="0" cellPadding="0"
											width="100%" border="0" id="table211" height="328">
											<tr>
												<td height="164" colspan="2" align="center">

													<form name="form1" action="${pageContext.request.contextPath }/adminServlet?action=login" method="post"
														onSubmit="return verifyLogin()">
														<table cellSpacing="0" cellPadding="0" width="100%"
															border="0" height="143" id="table212">
															<tr>
																<td width="13%" height="38" class="top_hui_text"><span
																	class="login_txt">管理员：&nbsp;&nbsp; </span></td>
																<td height="38" colspan="2" class="top_hui_text"><input
																	name="name" class="name" value="" size="20"></td>
															</tr>
															<tr>
																<td width="13%" height="35" class="top_hui_text"><span
																	class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
																<td height="35" colspan="2" class="top_hui_text"><input
																	class="pwd" type="password" size="20" name="pwd">
																	<img src="images/luck.gif" width="19" height="18">
																</td>
															</tr>
															<tr>
																<td height="35">&nbsp;</td>
																<td width="20%" height="35"><input name="Submit"
																	type="submit" class="button" id="Submit" value="登 陆">
																</td>
																<td width="67%" class="top_hui_text"><input
																	name="cs" type="reset" class="button" id="cs"
																	value="重置"></td>
															</tr>
														</table>
														<br>
													</form>

												</td>
											</tr>
											<tr>
												<td width="433" height="164" align="right" valign="bottom"><img
													src="images/login-wel.gif" width="242" height="138"></td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="20"><table width="100%" border="0" cellspacing="0"
					cellpadding="0" class="login-buttom-bg">
					<tr>
						<td align="center"><span class="login-buttom-txt">Copyright
								&copy; 2017-2020</span></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
