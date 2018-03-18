<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title" value="Create request from trip" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<table id="main-container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <tr>
        <td class="content">
            <%-- CONTENT --%>
            <div style="margin-bottom: 15px; margin-top: 10px; color: grey; font-size: medium">
                <b><fmt:message key="titleCreateRequest"/></b>
            </div>

            <table id="request-create-table" class="table table-striped">
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
                <tr>
                    <td class="text-center">${requestTrip.tripNumber}</td>
                    <td class="text-center">${requestTrip.dateCreation}</td>
                    <td class="text-center">${requestTrip.dateDeparture}</td>
                    <td class="text-center">${requestTrip.destination}</td>
                    <td class="text-center">${requestTrip.distance}</td>
                    <td/>
                </tr>
                </tbody>
            </table>

            <div style="margin-bottom: 15px; margin-top: 10px;">
                <i><fmt:message key="truckCharacteristic"/></i>
            </div>

            <form name="request-create-form" class="form-inline" action="controller" method="post">
                <input type="text" class="form-control" placeholder="<fmt:message key="truckCarrying"/>"
                       maxlength="7"
                       pattern="^\d{0,2}\.?\d*$" name="carrying" style="width:160px">

                <input type="text" class="form-control" placeholder="<fmt:message key="truckCapacity"/>"
                       maxlength="7"
                       pattern="^\d{0,2}\.?\d*$" name="capacity" style="width:160px">

                <input type="text" class="form-control" placeholder="<fmt:message key="truckLength"/>"
                       maxlength="7"
                       pattern="^\d{0,2}\.?\d*$" name="length" style="width:160px">

                <select name="lorryWithSides" class="form-control" style="width:160px">
                    <option value="true" selected><fmt:message key="truckLorryWithSidesInputForm"/></option>
                    <option value="false"><fmt:message key="truckLorryWithoutSides"/></option>
                </select>

                <select name="refrigerator" class="form-control" style="width:170px">
                    <option value="false" selected><fmt:message key="truckNotRefrigerator"/></option>
                    <option value="true"><fmt:message key="truckRefrigerator"/></option>
                </select>

                <input type="hidden" name="command" value="requestCreate"/>

                <button class="btn btn-default" type="submit" name="insertToBD" value="insertToBD"
                        style="width:125px"><fmt:message key="titleCreateRequest"/>
                </button>

            </form>
            <%-- CONTENT --%>
            <%@ include file="/WEB-INF/jspf/footer.jspf" %>
        </td>
    <tr>
</table>
</body>
</html>