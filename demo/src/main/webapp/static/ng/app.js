"use strict";

var App = angular.module('myApp',['ngRoute'])
            .config(['$routeProvider', function($routeProvider){
                    $routeProvider
                    .when('/',{templateUrl:'static/ng/view/booksList.html'})
                    .when('/add',{templateUrl:'static/ng/view/addBook.html'})
                    .when('/edit/:id',{templateUrl:'static/ng/view/editBook.html'})
                    .when('/uploadFile',{templateUrl:'static/ng/view/uploadFile.html'})
                    .otherwise({redirectTo:'/'});
}]);