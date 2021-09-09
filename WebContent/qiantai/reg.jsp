<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>用户注册</title>
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		//用户名
		if(!verifyUserName(document.form1.name.value)) {
			alert("请按要求填写用户名");
			return false;
		}
		//密码
		if(!verifyPwd(document.form1.pwd.value)) {
			alert("请按照要求填写密码");
			return false;
		}
		//两次密码相同
		if(!verifyConfirmPwd(document.form1.pwd.value, document.form1.qpwd.value)) {
			alert("请保证两次输入的密码一致");
			return false;
		}
		//真实姓名
		if(!verifyName(document.form1.realname.value)) {
			alert("请按要求输入真实姓名");
			return false;
		}
		//年龄
		if(!verifyAge(document.form1.age.value)) {
			alert("请按要求输入年龄");
			return false;
		}
		//身份证号
		if(!verifyID(document.form1.card.value)) {
			alert("请按要求输入身份证号");
			return false;
		}
		//家庭地址
		if(!verifyNotNull(document.form1.address.value)) {
			alert("家庭住址不能为空");
			return false;
		}
		//电话号码
		if(!verifyTel(document.form1.phone.value)) {
			alert("请按要求输入电话号码");
			return false;
		}
		//电子邮箱
		if(!verifyEmail(document.form1.email.value)) {
			alert("请按要求输入电子邮箱");
			return false;
		}
		//邮政编码
		if(!verifyPostcode(document.form1.code.value)) {
			alert("请按要求输入邮政编码");
			return false;
		}
	}
</script>
</head>
<body style='background:transparent'>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="20"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="center" height="450">
    
 <form action="${pageContext.request.contextPath }/usersServlet?action=registe" name="form1" method="post" onsubmit="return verifyInfo()">

  <div align="center"><br>
  <table border="1" cellspacing="0" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" width="700">
				<tr>
					<td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<font color="#666666">请填写用户信息(带<font color="red">*</font>为必填项)</font>
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">用 户 名：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="name"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left" >
						<font color="red">&nbsp;* </font>您用来登录的用户名
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">密&nbsp;&nbsp; &nbsp;码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="pwd" name="pwd"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>长度必须大于5个小于16个字符，只能为英语字、数字
					</td>
				</tr>				
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">确认密码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="password" name="qpwd"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请将输入的密码再次输入
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">真实姓名：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="realname"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>填写您的真实的姓名
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">性&nbsp; &nbsp;&nbsp;别：</font>
					</td>
					<td  bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input type="radio" name="sex" checked value="男">
						男&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女">
						女
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您的真实信息
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">年&nbsp;&nbsp; &nbsp;龄：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="age"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请输入您的真实年龄
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">身份证号：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="card"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您的真实信息
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">家庭住址：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="address"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您的真实信息
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">电话号码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="phone"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您的真实信息(格式为02411111111或13911111111) </td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">电子邮箱：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="email"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您有效的邮件地址，以便于我们为您提供有效的服务。
					</td>
				</tr>
				<tr>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="right">
						<font color="#996633">邮政编码：</font>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<input class="input7" type="text" name="code"/>
					</td>
					<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25" align="left">
						<font color="red">&nbsp;* </font>请填写您的真实信息(格式为111111)</td>
				</tr>
				<tr>
					<td colspan="3" align="center" bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0" height="25">
						<input type="submit" value="注册" />
					</td>
				</tr>
				
			</table>
  </div>
  </form>
    
    
    
     </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
