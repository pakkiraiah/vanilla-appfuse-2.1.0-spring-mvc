<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="quuxDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='quuxDetail.heading'/>"/>
</head>

<form:form commandName="quux" method="post" action="quuxform" id="quuxForm" onsubmit="return validateQuux(this)">
<form:errors path="*" cssClass="error" element="div"/>
<form:hidden path="id"/>
<ul>
    <li>
        <appfuse:label styleClass="desc" key="quux.description"/>
        <form:errors path="description" cssClass="fieldError"/>
        <form:input path="description" id="description" cssClass="text medium" cssErrorClass="text medium error" maxlength="2048"/>
    </li>
    <li>
        <appfuse:label styleClass="desc" key="quux.name"/>
        <form:errors path="name" cssClass="fieldError"/>
        <form:input path="name" id="name" cssClass="text medium" cssErrorClass="text medium error" maxlength="20"/>
    </li>

    <li class="buttonBar bottom">
        <input type="submit" class="button" name="save" value="<fmt:message key="button.save"/>"/>
        <c:if test="${not empty quux.id}">
        <input type="submit" class="button" name="delete" onclick="bCancel=true;return confirmDelete('quux')"
            value="<fmt:message key="button.delete"/>" />
        </c:if>
        <input type="submit" class="button" name="cancel" value="<fmt:message key="button.cancel"/>" onclick="bCancel=true"/>
    </li>
</ul>
</form:form>

<v:javascript formName="quux" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    Form.focusFirstElement($('quuxForm'));
</script>
