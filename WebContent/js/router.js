myApplication.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'templates/mainView.html',
            controller: 'MyController'
        })
        .when('/update', {
            templateUrl: 'templates/update.html',
            controller: 'MyController'
        })
        .when('/insert',{
            templateUrl: 'templates/insert.html',
            controller: 'MyController'
        })
       
        .otherwise({
            redirectTo: '/'
        });
});