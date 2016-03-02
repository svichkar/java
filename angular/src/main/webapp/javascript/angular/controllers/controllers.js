"use strict";

var app = angular.module('app.controllers', []);

app.controller('StudentListCtrl', ['$scope',
                                   'StudentsFactory',
                                   function ($scope, StudentsFactory) {
                                        $scope.students = StudentsFactory.query();
                                   }
]);

