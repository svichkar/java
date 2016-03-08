"use strict";

App.controller('StudentController', ['$scope', 'StudentService', function($scope, StudentService) {
          var self = this;
          self.students = [];
          self.student = {};

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

          self.createStudent = function(student){
              StudentService.createStudent(student)
		              .then(
                      self.fetchAllStudents,
				              function(errResponse){
					               console.error('Error while creating Student');
				              }
                  );
          };

          self.updateStudent = function(student, id){
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

          self.add = function() {
              console.log('Saving New Student', self.student);
              self.createStudent(self.student);
         };

          self.edit = function(id){
              self.updateStudent(self.student, self.student.id);
              console.log('Student updated with id ', id);
          };

          self.remove = function(id){
              self.deleteStudent(id);
              console.log('id deleted', id);
          };

}]);