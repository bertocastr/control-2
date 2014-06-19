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
					<a href="<c:url value="employees.htm"/>">Show all employees</a>
				</li>
			</ul>
		</nav>
		
		<div class="content">
			<div class="headerContent">
				<b class="titleContent"><fmt:message key="office" /><c:out value=" ${model.office.officeID}" /></b>
				<a class="searcherContent" href="<c:url value="searcher.htm"/>" title="Search office"></a>
			</div>
			<ul>
				<li>
					<b>Address: </b>
					<c:out value="${model.office.address}" />
				</li>
				<li>
					<b>Account: </b>
					<c:out value="${model.office.account}" />
				</li>
				<li>
					<b>Balance: </b>
					<c:out value="${model.office.balance}" />
				</li>
				<li>
					<b>Utilities costs: </b>
					<c:out value="${model.office.utilitiesCost}" />
				</li>
				<li>
					<b>Local costs: </b>
					<c:out value="${model.office.localCost}" />
				</li>
				<li>
					<b>Employee costs: </b>
					<c:out value="${model.office.employeeCost}" />
				</li>
				<li>
					<b>Total expenses: </b>
					<c:out value="${model.office.totalExpenses}" />
				</li>
				<li>
					<b>City: </b>
					<c:out value="${model.office.city}" />
				</li>
				<li>
					<b>PostCode: </b>
					<c:out value="${model.office.postCode}" />
				</li>
				<li>
					<b>Telephone: </b>
					<c:out value="${model.office.telephone}" />
				</li>
			</ul>
			
		</div>
	</body>
	
</html>