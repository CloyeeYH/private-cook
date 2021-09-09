<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		//公告标题
		if(!verifyNotNull(document.form1.name.value)) {
			alert("公告标题不能为空");
			return false;
		}
		//公告内容
		if(!verifyNotNull(document.form1.content.value)) {
			alert("公告内容不能为空");
			return false;
		}
	}
</script>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>&nbsp;</p>

				<div align="center">

					<form action="#" method="post"
						name="form1" onSubmit="return verifyInfo()">


						<table id="table2" class="line_table"
							style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
							cellPadding="0">

							<tr>
								<td class="line_table" align="right" width="10%"><span
									class="left_bt2">公告标题：</span></td>
								<td class="line_table" width="90%"><input type="text"
									name="name" size="45" value=""></td>
							</tr>
							<tr>
								<td class="line_table" align="right" width="10%"><span
									class="left_bt2">公告内容：</span></td>
								<td class="line_table" width="90%"><textarea rows="14"
										name="content" cols="105"></textarea></td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="添加">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>

		</tr>
	</table>
</body>
</html>
