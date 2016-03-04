"use strict";

var app = angular.module('app.controllers', []);

app.controller('StudentListCtrl', ['$scope',
                                   'StudentsFactory',
                                   function ($scope, StudentsFactory) {
                                        $scope.students = StudentsFactory.query();
                                   }
]);


app.controller('StudentCtrl', ['$scope', 'StudentsFactory', 'StudentFactory', '$location',
  function ($scope, StudentsFactory, StudentFactory, $location) {

    /* callback for ng-click 'editStudent': */
    $scope.edit = function (studentId) {
      $location.path('/edit/' + studentId);
      StudentFactory.edit({ id: studentId });
    };

    /* callback for ng-click 'deleteUser': */
    $scope.delete = function (studentId) {
      StudentFactory.delete({ id: studentId });
      $scope.students = StudentsFactory.query();
    };

    /* callback for ng-click 'createUser': */
    $scope.add = function () {
      $location.path('/add');
    };




    $scope.students = StudentsFactory.query();
  }]);
