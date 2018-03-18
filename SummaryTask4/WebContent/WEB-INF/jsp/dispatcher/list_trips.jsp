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
                    <table id="trips-table" class="table table-hover">
                        <thead>
                        <tr>
                            <td class="text-center"><fmt:message key="listTripsNumber"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeNumberTrip"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="listTripsDateCreation"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeDateCreation"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="listTripsDateDeparture"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeDateDeparture"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="listTripsDestination"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeDestination"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="listTripsDistance"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeDistance"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="listTripsStatus"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeStatus"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="userFirstName"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeFirstName"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="userLastName"/>
                                <form action="controller" method="get">
                                    <input type="hidden" name="command" value="sortTrips"/>
                                    <button class="btn btn-default" type="submit" name="sortTripsType"
                                            value="sortTripsTypeLastName"><span class="caret"/>
                                    </button>
                                </form>
                            </td>
                            <td class="text-center"><fmt:message key="userDriverPhoto"/></td>
                            <td class="text-center"><fmt:message key="listTripsTruck"/></td>
                            <td/>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="bean" items="${allTrips}">
                            <tr>
                                <td class="text-center">${bean.beanTripNumber}</td>
                                <td class="text-center">${bean.beanDateCreation}</td>
                                <td class="text-center">${bean.beanDateDeparture}</td>
                                <td class="text-center">${bean.beanDestination}</td>
                                <td class="text-center">${bean.beanDistance}</td>
                                <td class="text-center">${bean.beanStatusName.name}</td>
                                <td class="text-center">${bean.beanDriverFirstName}</td>
                                <td class="text-center">${bean.beanDriverLastName}</td>
                                <td class="text-center">
                                    <img src="Resources/photo/users/${bean.beanDriverPhotoLink}"
                                         width="70" height="70" class="img-rounded">
                                </td>
                                <td class="text-center">
                                    <img src="Resources/photo/trucks/${bean.beanTruckPhotoLink}"
                                         width="100" height="70" class="img-rounded">
                                </td>
                                <td class="text-center">
                                    <form name="send-request" action="controller" method="post">

                                        <input type="hidden" name="command" value="changeTripStatus"/>

                                        <button class="btn btn-default" type="submit"
                                                onclick="return confirm('<fmt:message
                                                        key="listTripsButtonCancelMessage"/>')"
                                                name="changeStatusTripId" value=${bean.id}><fmt:message
                                                key="listTripsButtonCancel"/>
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