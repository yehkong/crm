<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	$(function() {
		$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",
				{"dict_type_code" : "006"},
				function(data) {
					$(data).each(function(i,n){
						$("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
					});	
					$("#cust_level option[value='${basedictLevel.dict_id}']").prop("selected","selected");
				}, "json");

		$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",
				{"dict_type_code" : "002"},
				function(data) {
					$(data).each(function(i,n){
						$("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
					});		
					$("#cust_source option[value='${basedictSource.dict_id}']").prop("selected","selected");
				}, "json");

		$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action",
				{"dict_type_code" : "001"},
				function(data) {
					$(data).each(function(i,n){
						$("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
					});	
					$("#cust_industry option[value='${basedictIndustry.dict_id}']").prop("selected","selected");
				}, "json");
	      });
</script> 

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_update.action"
		method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="${cust_id }"/>
		<input type="hidden" name="cust_Image" value="${cust_Image }"/>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
			<%-- 					<s:textfield theme="simple" cssClass="textbox" cssStyle="WIDTH: 180px" maxLength=50 name="cust_name" value="%{model.cust_name}"/> --%>
								<INPUT class=textbox id=sChannel2
											style="WIDTH: 180px" maxLength=50 name="cust_name" value="${cust_name }">
								</td>
								
								<td>客户级别 ：</td>
								<td>
									<select id="cust_level" name="basedictLevel.dict_id">
										<option value=""> -- 请选择 -- </option>
									</select>
								
								</td>
							</TR>
							
							<TR>
								<td>信息来源：</td>
								<td>
									<select id="cust_source" name="basedictSource.dict_id">
										<option value=""> -- 请选择 -- </option>
									</select>
								
								<%-- <INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custSource" value="${customer.custSource }"> --%>
								
														
								</td>
								
								<td>所属行业：</td>
								<td>
									<select id="cust_industry" name="basedictIndustry.dict_id">
										<option value=""> -- 请选择 -- </option>
									</select>
								
								<%-- <INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custSource" value="${customer.custSource }"> --%>
								
														
								</td>
								
								<%-- <td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custLinkman" value="${customer.custLinkman }">
								</td> --%>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<%-- <s:textfield cssClass="textbox"
											cssStyle="WIDTH: 180px" maxLength=50 name="cust_phone" value="%{model.cust_phone }"/> --%>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<%-- <s:textfield cssClass="textbox"
											cssStyle="WIDTH: 180px" maxLength=50 name="cust_mobile" value="%{model.cust_mobile }"/> --%>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${cust_mobile }">
								</td>
							</TR>
							
							<%-- <TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custAddress" value="${customerDetail.custAddress }">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custZip" value="${customerDetail.custZip }">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custFax" value="${customerDetail.custFax }">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custWebsite" value="${customerDetail.custWebsite }">
								</td>
							</TR> --%>
							
								<tr>
							<td>资质文件 ：</td>
								<td>
								<input type="file" name="uploadImage">
								</td>
								
							</tr>
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
