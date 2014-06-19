<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>
<html>

	<head>
		<style type="text/css">
			<%@include file="/resources/css/style.css" %>
	  	</style>
		<title><fmt:message key="title" /></title>
	</head>
	
	<body>
		<header>
			<a class="backHome" href="<c:url value="startpage.htm"/>" title="Home"></a>
			<a class="optionsHeader assets" href="<c:url value="assets.htm"/>" title="Assets"></a>
			<a class="optionsHeader brokerage" href="<c:url value="brokerage.htm"/>" title="brokerage"></a>
			<a class="optionsHeader liabilities" href="<c:url value="liabilities.htm"/>" title="Liabilities"></a>
			<a class="optionsHeader payments" href="<c:url value="payments.htm"/>" title="Payments"></a>
		</header>
		
		<nav class="menu">
			<ul>
				<li>
					<a href="<c:url value="costmodify.htm"/>">Modify cost</a>
				</li>
				<li>
					<a href="<c:url value="addressChange.htm"/>">Modify address</a>
				</li>
				<li>
					<a href="<c:url value="accounts.htm"/>">Show all accounts</a>
				</li>
				<li>
					<a class="selected" href="<c:url value="employees.htm"/>">Show all employees</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="employees" /></b>
			</div>
			<ul>
				<c:forEach items="${model.employees}" var="empl">
				<li>
					<b>Name: </b>
					<c:out value="${empl.name}" />
				</li>
				</c:forEach>
			</ul>
		</div>
	</body>
	
</html>