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
    $scope.editStudent = function (studentId) {
      $location.path('/user-detail/' + userId);
    };

    /* callback for ng-click 'deleteUser': */
    $scope.deleteUser = function (userId) {
      UserFactory.delete({ id: userId });
      $scope.users = UsersFactory.query();
    };

    /* callback for ng-click 'createUser': */
    $scope.createNewUser = function () {
      $location.path('/user-creation');
    };

    $scope.users = UsersFactory.query();
  }]);
