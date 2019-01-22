var app = angular.module('myApp', []);
app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 20000;
}])
app.controller('myCtrl', function($scope, $http) {
    this.retrieve = function() {
    $http.get('http://localhost:1111/booking/reservation/' + $scope.name)
    .then(function (response) {
        console.log('inside'+ response);
        $scope.quotes = response.data;
    }, function (response) {
        console.log('came here');
    });
    }


    this.add = function() {
        var message = {
            userName: $scope.name,
            quotes: [$scope.quote]
        }
        $http.post('http://localhost:1111booking/reservation/add', message)
            .then(function(response) {
                $scope.quotes = response.data;
            }, function(response) {
                console.log('error..');
            });
    }
});