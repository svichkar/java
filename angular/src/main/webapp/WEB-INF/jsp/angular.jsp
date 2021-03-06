<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>RoutingDemo App</title>
        <link rel="stylesheet" href="style/style.css" type="text/css" media="all">
    </head>
    <body ng-app="myApp" class="ng-cloak"  ng-controller="StudentController as ctrl">

        <h2>Student Management Application</h2>
        <ul>
            <li><a href="#/">List of Students</a></li>
            <li><a href="#/add">Add NEW Student</a></li>
        </ul>

        <div ng-view></div>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.js"></script>

        <script src="javascript/angular/app.js"></script>
        <script src="javascript/angular/services/services.js"></script>
        <script src="javascript/angular/controllers/controllers.js"></script>
        <script src="javascript/angular/filters/filter.js"></script>
    </body>
</html>