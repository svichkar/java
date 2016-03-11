"use strict";

App.controller('StudentController', ['$scope', 'StudentService', '$filter', '$location', '$routeParams', function($scope, StudentService, $filter, $location, $routeParams) {                   

                     $scope.students = [];
                     $scope.groupList = [];
                     $scope.statusList = [];
                     $scope.termList = [];
                     $scope.student = {};
                     $scope.admissionDate;

                     $scope.fetchAllStudents = function(){
                         StudentService.fetchAllStudents()
                             .then(
                 					       function(d) {
                 						        $scope.students = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching students');
                       					}
                 			       );
                     };

                     $scope.fetchStudent = function(id){
                         StudentService.fetchStudent(id)
                             .then(
                 					       function(d) {
                 						        $scope.student = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching student');
                       					}
                 			       );
                     };

                     $scope.fetchAllGroups = function(){
                         StudentService.fetchAllGroups()
                             .then(
                 					       function(d) {
                 						        $scope.groupList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching groups');
                       					}
                 			       );
                     };

                     $scope.fetchAllStatuses = function(){
                         StudentService.fetchAllStatuses()
                             .then(
                 					       function(d) {
                 						        $scope.statusList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching statuses');
                       					}
                 			       );
                     };

                     $scope.fetchAllTerms = function(){
                         StudentService.fetchAllTerms()
                             .then(
                 					       function(d) {
                 						        $scope.termList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching terms');
                       					}
                 			       );
                     };

                     $scope.createStudent = function(student){
                         student.admissionDate = $filter('date')($scope.admissionDate, "yyyy-MM-dd");
                         StudentService.createStudent(student)
           		              .then(
                                 $scope.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while creating Student');
           				              }
                             );
                         $location.path("/");
                     };

                     $scope.updateStudent = function(student, id){
                         student.admissionDate = $filter('date')($scope.student.admissionDate, "yyyy-MM-dd");
                         StudentService.updateStudent(student, id)
           		              .then(
           				              $scope.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while updating Student');
           				              }
                             );
                     };

                     $scope.deleteStudent = function(id){
                         StudentService.deleteStudent(id)
           		              .then(
           				              $scope.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while deleting Student');
           				              }
                             );
                    };

          $scope.fetchAllStudents();
          $scope.fetchAllGroups();
          $scope.fetchAllStatuses();
          $scope.fetchAllTerms();

          $scope.add = function() {
              $scope.createStudent($scope.student);
         };

          $scope.edit = function(student){
          $scope.student = student;
          $scope.student.admissionDate = new Date(student.admissionDate);
          $location.path('/edit/' + student.id);
          };

          $scope.commit = function(){
          $scope.updateStudent($scope.student, $scope.student.id);
          $location.path('/');
          };

          $scope.remove = function(id){
          $scope.deleteStudent(id);
          console.log('id deleted', id);
          };

}]);