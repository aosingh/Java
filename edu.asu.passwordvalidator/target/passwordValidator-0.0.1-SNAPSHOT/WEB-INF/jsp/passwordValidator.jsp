<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Password Validator Form</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style>
body {
	background-color: #eee;
	align-content: center;
	text-align: center;
	font: helvetica;
}

#container {
	width: 700px;
	background-color: #fff;
	margin: 30px auto;
	padding: 30px;
	border-radius: 25px;
	box-shadow: 5px;
	align-content: center;
	text-align: center;
	display:inline-block;
}

.green {
	font-weight: bold;
	color: green;
}

label {
	width: 200px;
	display: inline-block;
}

form {
	line-height: 160%;
	align-content: center;
	text-align: center;
}
</style>
</head>
<body>
	<div id="container">
		<h2>Validate your password</h2>
		<c:if test="${not empty message }">
			<div class="green">${message }</div>
		</c:if>
		<form:form modelAttribute="passwordValidator" method="POST">
			<label for="passwordInput">Enter password</label>
			<form:password path="password" id="passwordInput" />
			</br>

			<label for="firstPasswordFilterInput">First filter</label>
			<form:select path="firstPasswordFilter" id="firstPasswordFilterInput">
				<form:option value="NONE">NONE</form:option>
				<c:forEach items="${passwordValidatorRuleType}"
					var="passwordValidatorIter">
					<form:option value="${passwordValidatorIter}">${passwordValidatorIter}</form:option>
				</c:forEach>
			</form:select>
			</br>
			<label for="secondPasswordFilterInput">Second filter</label>
			<form:select path="secondPasswordFilter"
				id="secondPasswordFilterInput">
				<form:option value="NONE">NONE</form:option>
				<c:forEach items="${passwordValidatorRuleType}"
					var="passwordValidatorIter">
					<form:option value="${passwordValidatorIter}">${passwordValidatorIter}</form:option>
				</c:forEach>
			</form:select>
			</br>
			<label for="thirdPasswordFilterInput">Third filter</label>
			<form:select path="thirdPasswordFilter" id="thirdPasswordFilterInput">
				<form:option value="NONE">NONE</form:option>
				<c:forEach items="${passwordValidatorRuleType}"
					var="passwordValidatorIter">
					<form:option value="${passwordValidatorIter}">${passwordValidatorIter}</form:option>
				</c:forEach>
			</form:select>
			</br>
			<input type="submit" value="Submit" />

		</form:form>

	</div>
</body>

</html>