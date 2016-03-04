<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>RoutingDemo App</title>
        <link rel="stylesheet" href="style/style.css" type="text/css" media="all">
    </head>
    <body ng-app='routingDemoApp'>

        <h2>AngularJS Routing Application</h2>
        <ul>
            <li><a href="#/">Default Route</a></li>
            <li><a href="#/add">Add NEW Student</a></li>
            <li><a href="#/edit">Edit Student</a></li>
            <li><a href="#/blabla">Go away</a></li>
        </ul>

        <div ng-view></div>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
        <script>
            angular.module('routingDemoApp',['ngRoute'])
            .config(['$routeProvider', function($routeProvider){
                $routeProvider
                .when('/',{templateUrl:'javascript/angular/view/studentListView.html'})
                .when('/add',{templateUrl:'javascript/angular/view/addStudentView.html'})
                .when('/edit',{templateUrl:'javascript/angular/view/editStudentView.html'})
                .otherwise({redirectTo:'/'});
            }]);
        </script>


    </body>
</html>