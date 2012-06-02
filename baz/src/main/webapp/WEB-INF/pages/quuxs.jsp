<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="quuxList.title"/></title>
    <meta name="heading" content="<fmt:message key='quuxList.heading'/>"/>
    <meta name="menu" content="QuuxMenu"/>
</head>

<div id="search">
<form method="get" action="${ctx}/quuxs" id="searchForm">
    <input type="text" size="20" name="q" id="query" value="${param.q}"
           placeholder="Enter search terms"/>
    <input type="submit" value="<fmt:message key="button.search"/>"/>
</form>
</div>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/quuxform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<display:table name="quuxList" class="table" requestURI="" id="quuxList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="quuxform" media="html"
        paramId="id" paramProperty="id" titleKey="quux.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="quux.id"/>
    <display:column property="description" sortable="true" titleKey="quux.description"/>
    <display:column property="name" sortable="true" titleKey="quux.name"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="quuxList.quux"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="quuxList.quuxs"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="quuxList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="quuxList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="quuxList.title"/>.pdf</display:setProperty>
</display:table>

<input type="button" style="margin-right: 5px" onclick="location.href='<c:url value="/quuxform"/>'" value="<fmt:message key="button.add"/>"/>
<input type="button" onclick="location.href='<c:url value="/mainMenu"/>'" value="<fmt:message key="button.done"/>"/>

<script type="text/javascript">
    highlightTableRows("quuxList");
</script> 
