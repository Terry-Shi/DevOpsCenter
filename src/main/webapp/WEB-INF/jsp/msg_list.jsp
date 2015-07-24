<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1><spring:message code="user.list" /></h1>
    <ul>
    <c:forEach items="${msgs}" var="msg">
        <li>
            <c:out value="${msg.getFromUser()}" /> : <c:out value="${msg.getMsg()}" /> 
        </li>
    </c:forEach>
    </ul>

    <a href="<spring:url value="/msg/sender" />"><spring:message code="user.create" /></a>
</body>
</html>