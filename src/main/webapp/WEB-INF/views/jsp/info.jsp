<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="infoServerApp">
<head>
<title>InfoServer</title>
<script>
var host = "<%=request.getServerName() %>";
var port = "<%=request.getServerPort() %>";
</script>
<script src="${pageContext.request.contextPath}/resources/js/lib/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/infoServer.js"></script>

</head>
<body>
    <p>This is spartaaaaaaaaa......</p>
    <table ng-controller="InfoController as infoCtrl">
        <th >
        </th>
    </table>
</body>