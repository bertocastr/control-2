<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
					<a href="<c:url value="addoffice.htm"/>">Add office</a>
				</li>
				<li>
					<a class="selected" href="<c:url value="addemployee.htm"/>">Add employee</a>
				</li>
				<li>
					<a href="<c:url value="officeslist.htm"/>">Search offices</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="addemployee" /></b>
			</div>
			<form:form method="post" commandName="addEmployee">
				<ul>
					<li>
						<div class="data"><b>Employee id: </b></div>
						<form:input path="employeeId" />
						<form:errors path="employeeId" cssClass="error" />
					</li>
					<li>
						<div class="data"><b>Name: </b></div>
						<form:input path="name" />
						<form:errors path="name" cssClass="error" />
					</li>
					<li>
						<div class="data"><b>Surname: </b></div>
						<form:input path="surnames" />
						<form:errors path="surnames" cssClass="error" />
					</li>
					<li>
						<div class="data"><b>Address: </b></div>
						<form:input path="address" />
						<form:errors path="address" cssClass="error" />
					</li>
					<li>
						<div class="data"><b>Salary: </b></div>
						<form:input path="salary" />
						<form:errors path="salary" cssClass="error" />
					</li>
					<li>
						<div class="data"><b>Office id: </b></div>
						<form:input path="officeId" />
						<form:errors path="officeId" cssClass="error" />
					</li>			
					<li>
						<input class="execute" type="submit" value="Execute">
					</li>
				</ul>
			</form:form>
		</div>
	</body>
	
</html>