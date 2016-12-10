(function() {
    var app = angular.module("infoServerApp", []);

    app.controller("InfoController", function($scope, $http) {
        $scope.fileList = [];
        
        $http.get('/is/getFileList').then(function(response) {
            $scope.fileList = response.data;
        });
        
        this.update = function() {
            //Initialize fileList with empty values
            $http.get('/is/data/' + $scope.selectedFileName).then(function(response) {
                $scope.info = response.data;
            });
        }
    });
})();