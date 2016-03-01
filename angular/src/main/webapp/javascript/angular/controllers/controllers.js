'use strict';

/* Controllers */
var app = angular.module('myApp.controllers', []);

app.controller('StudentListCtrl', ['$scope', 'StudentsFactory', '$location',
  function ($scope, StudentsFactory, $location) {
    $scope.students = StudentsFactory.query();
  }]);

