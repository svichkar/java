var app = angular.module('myApp.controllers', []);

app.controller('StudentListCtrl', ['$scope',
                                   'StudentsFactory',
                                   function ($scope, StudentsFactory) {
                                        $scope.students = StudentsFactory.query();
                                   }
]);

