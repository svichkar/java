"use strict";

App.controller('StudentController', ['$scope', 'StudentService', '$filter', '$location', '$routeParams', function($scope, StudentService, $filter, $location, $routeParams) {
                     var self = this;
                     self.students = [];
                     self.groupList = [];
                     self.statusList = [];
                     self.termList = [];
                     self.student = {};
                     self.admissionDate = {};
                     self.newStudent = {};
                     self.newAdmissionDate;

                     self.fetchAllStudents = function(){
                         StudentService.fetchAllStudents()
                             .then(
                 					       function(d) {
                 						        self.students = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching students');
                       					}
                 			       );
                     };

                     self.fetchStudent = function(id){
                         StudentService.fetchStudent(id)
                             .then(
                 					       function(d) {
                 						        self.student = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching student');
                       					}
                 			       );
                     };

                     self.fetchAllGroups = function(){
                         StudentService.fetchAllGroups()
                             .then(
                 					       function(d) {
                 						        self.groupList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching groups');
                       					}
                 			       );
                     };

                     self.fetchAllStatuses = function(){
                         StudentService.fetchAllStatuses()
                             .then(
                 					       function(d) {
                 						        self.statusList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching statuses');
                       					}
                 			       );
                     };

                     self.fetchAllTerms = function(){
                         StudentService.fetchAllTerms()
                             .then(
                 					       function(d) {
                 						        self.termList = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching terms');
                       					}
                 			       );
                     };

                     self.createStudent = function(student){
                         student.admissionDate = $filter('date')(self.newAdmissionDate, "yyyy-MM-dd");
                         StudentService.createStudent(student)
           		              .then(
                                 self.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while creating Student');
           				              }
                             );
                         self.newAdmissionDate = null;
                         self.newStudent = {};
                     };

                     self.updateStudent = function(student, id){
                         student.admissionDate = $filter('date')(self.admissionDate, "yyyy-MM-dd");
                         StudentService.updateStudent(student, id)
           		              .then(
           				              self.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while updating Student');
           				              }
                             );
                     };

                     self.deleteStudent = function(id){
                         StudentService.deleteStudent(id)
           		              .then(
           				              self.fetchAllStudents,
           				              function(errResponse){
           					               console.error('Error while deleting Student');
           				              }
                             );
                    };

          self.fetchAllStudents();
          self.fetchAllGroups();
          self.fetchAllStatuses();
          self.fetchAllTerms();

          self.add = function() {
              self.createStudent(self.newStudent);
              $location.path("/");
         };

          self.edit = function(student){
          self.student = student;
          self.admissionDate = new Date(student.admissionDate);
          $location.path('/edit/' + student.id);
          };

          self.commit = function(){
          self.updateStudent(self.student, self.student.id);
          $location.path('/');
          };

          self.remove = function(id){
          self.deleteStudent(id);
          console.log('id deleted', id);
          };

}]);