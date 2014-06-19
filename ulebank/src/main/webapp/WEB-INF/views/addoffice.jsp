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
					<a class="selected" href="<c:url value="addoffice.htm"/>">Add Office</a>
				</li>
				<li>
					<a href="<c:url value="addemployee.htm"/>">Add employee</a>
				</li>
				<li>
					<a href="<c:url value="officeslist.htm"/>">Search Offices</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="addoffice" /></b>
			</div>
			<form:form method="post" commandName="addOffice">
				<ul>
					<li>
						<b>Office id: </b>
					</li>
					<li>
						<form:input path="officeID" />
						<form:errors path="officeID" cssClass="error" />
					</li>
					<li>
						<b>Address: </b>
					</li>
					<li>
						<form:input path="address" />
						<form:errors path="address" cssClass="error" />
					</li>
					<li>
						<b>Local cost: </b>
					</li>
					<li>
						<form:input path="localCost" />
						<form:errors path="localCost" cssClass="error" />
					</li>
					<li>
						<b>Utilities cost: </b>
					</li>
					<li>
						<form:input path="utilitiesCost" />
						<form:errors path="utilitiesCost" cssClass="error" />
					</li>
					<li>
						<b>Employee cost: </b>
					</li>
					<li>
						<form:input path="employeeCost" />
						<form:errors path="employeeCost" cssClass="error" />
					</li>
					<li>
						<b>City: </b>
					</li>
					<li>
						<form:input path="city" />
						<form:errors path="city" cssClass="error" />
					</li>
					<li>
						<b>Zip Code: </b>
					</li>
					<li>
						<form:input path="postCode" />
						<form:errors path="postCode" cssClass="error" />
					</li>
					<li>
						<b>Telephone: </b>
					</li>
					<li>
						<form:input path="telephone" />
						<form:errors path="telephone" cssClass="error" />
					</li>					
					<li>
						<input type="submit" value="Execute">
					</li>
				</ul>
			</form:form>
		</div>
	</body>
	
</html>