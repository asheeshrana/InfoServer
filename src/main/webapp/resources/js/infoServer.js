(function() {
    var app = angular.module("infoServerApp", []);
    
    app.controller("InfoController", function($scope, $http) {
        $http.get('/is/data/myInfo.json').then(function(response) {
            $scope.myWelcome = response.data;
            alert('response = ' + JSON.stringify(response.data));
        });
    });
})();