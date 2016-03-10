"use strict";

var App = angular.module('myApp',['ngRoute'])
            .config(['$routeProvider', function($routeProvider){
                    $routeProvider
                    .when('/',{templateUrl:'javascript/angular/view/studentListView.html'})
                    .when('/add',{templateUrl:'javascript/angular/view/addStudentView.html'})
                    .when('/edit/:id',{templateUrl:'javascript/angular/view/editStudentView.html'})
                    .otherwise({redirectTo:'/'});
}]);