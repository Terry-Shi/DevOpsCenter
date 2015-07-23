<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1><spring:message code="msg.create" /></h1>
    <a href="<spring:url value="/msg/list" />"><spring:message code="msg.list" /></a>
    <form:form method="POST" action="/msg" modelAttribute="form">
        <form:errors path="" element="div" />
        <div>
            <form:label path="toUser">To</form:label>
            <form:input path="toUser" />
            <form:errors path="toUser" />
        </div>
        <div>
            <form:label path="msg">Msg Content</form:label>
            <form:password path="msg" />
            <form:errors path="msg" />
        </div>
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>