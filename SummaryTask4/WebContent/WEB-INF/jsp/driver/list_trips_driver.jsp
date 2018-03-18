<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title" value="All trips" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<table id="main-container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <tr>
        <td class="content">
            <%-- CONTENT --%>
            <c:if test="${not empty okMessage}">
                <div style="margin-bottom: 15px; margin-top: 10px; color: green;">
                    <fmt:message key="okMessage"/>
                    <br><br>
                    <strong> <fmt:message key="${okMessage}"/></strong>
                </div>
            </c:if>

            <div style="margin-bottom: 15px; margin-top: 10px; color: grey; font-size: medium">
                <b><fmt:message key="titleTrips"/></b>
            </div>

            <c:choose>
                <c:when test="${fn:length(allTrips) == 0}">
                    <div style="margin-bottom: 15px; margin-top: 10px; color: rgb(204, 69, 0);">
                        <fmt:message key="noSuchTrips"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <table id="list-trips-driver-table" class="table table-hover">
                        <thead>
                        <tr>
                            <td class="text-center"><fmt:message key="listTripsNumber"/></td>
                            <td class="text-center"><fmt:message key="listTripsDateCreation"/></td>
                            <td class="text-center"><fmt:message key="listTripsDateDeparture"/></td>
                            <td class="text-center"><fmt:message key="listTripsDestination"/></td>
                            <td class="text-center"><fmt:message key="listTripsDistance"/></td>
                            <td/>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach var="bean" items="${allTrips}">
                            <tr>
                                <td class="text-center">${bean.tripNumber}</td>
                                <td class="text-center">${bean.dateCreation}</td>
                                <td class="text-center">${bean.dateDeparture}</td>
                                <td class="text-center">${bean.destination}</td>
                                <td class="text-center">${bean.distance}</td>
                                <td class="text-center">
                                    <form name="send-request" action="controller" method="get">
                                        <input type="hidden" name="command" value="requestCreate"/>
                                        <button class="btn btn-default" type="submit"
                                                name="idTrip" value=${bean.id}>
                                            <fmt:message key="titleCreateRequest"/>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
            <%-- CONTENT --%>
        </td>
    </tr>
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</table>
</body>
</html>