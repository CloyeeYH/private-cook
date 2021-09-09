<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>菜品展示</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta content="" name=keywords />
<meta content="" name=description />
<link href="css/skin.css" rel="stylesheet" type="text/css" />
</head>



<body style='background:transparent'>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="center" height="450">
    

    <div align="center">
	

    <table id="table2"   class="line_table" style="width:100%;  margin: 0; padding: 0" cellSpacing="0" cellPadding="0">
   
		<tr>
			<td  class="line_table" height="25" align="right" width="20%"><span class="left_bt2">菜单名称：</span></td>
			<td class="line_table" height="25"  width="70%">
			<input type="text" name="name" size="45" readonly value="糖醋排骨"></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">原&nbsp;&nbsp;&nbsp; 
			料：</span></td>
			<td class="line_table" height="25" width="80%">
			<input type="text" name="burden" size="45" readonly value="排骨、糖、醋"></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">市场单
			价：</span></td>
			<td height="25"  width="80%">
			<input type="text" name="price" size="45" readonly value="26.0"></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">会员单
			价：</span></td>
			<td height="25"  width="80%">
			<input type="text" name="price1" size="45" readonly value="24.0"></td>
		</tr>
		<tr>
			<td class="line_table"  height="25"  align="right" width="20%"><span class="left_bt2">说&nbsp;&nbsp;&nbsp; 
			明：</span></td>
			<td class="line_table" height="25"  width="80%">
			<textarea rows="12" name="brief" cols="100" readonly>暂无</textarea></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">菜品类别：</span></td>
			<td  class="line_table"  height="25"  width="80%">
			<input type="text" name="type" size="45" readonly value="炒菜">
			</td>
		</tr>
		<tr>
			<td class="line_table" align="right" width="20%">
			<span class="left_bt2">展示图片</span>：</td>
			<td  class="line_table" width="80%" align="left"><img src="../img/m_tangcupaigu.gif"></td>
		</tr>

		<tr>
			<td  class="line_table" height="25"  align="center" colspan="2">
			<a href="index.jsp" target="_self"><input type="submit" value="返回"></a>
			</td>
		</tr>
		
    
		</table>

  	</div>
    
    
    
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
