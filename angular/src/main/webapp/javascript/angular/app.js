'use strict';

angular.module('myApp', [
  'myApp.services',
  'myApp.controllers'
  ])
.config(function ($routeProvider, $httpProvider) {
  $routeProvider.when('/angular.html', {templateUrl: 'angular.html', controller: 'StudentListCtrl'});
  $routeProvider.otherwise({redirectTo: '/angular.html'});
});
