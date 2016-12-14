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
    <div ng-controller="InfoController as infoCtrl">
        <input type="text" class="form-control" placeholder="find the entry" ng-model="searchEntry">

        <select ng-model="selectedFileName" ng-options="fileName for fileName in fileList" ng-change="infoCtrl.update()""></select>
        <table border="1">
            <th ng-repeat="header in info.headers">{{header}}</th>
            <tr ng-repeat="row in info.data | filter:searchEntry">
                <td ng-repeat="key in info.headers">{{row[key]}}</td>
            </tr>
        </table>
    </div>
</body>