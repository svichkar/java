'use strict';

App.factory('StudentService', ['$http', '$q', function($http, $q){

	return {

			fetchAllStudents: function() {
					return $http.get('ws/rest/studentService/students')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching students');
										return $q.reject(errResponse);
									}
							);
			},

		    createStudent: function(student){
					return $http.post('ws/rest/studentService/student', student)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating student');
										return $q.reject(errResponse);
									}
							);
		    },

		    updateStudent: function(student, id){
					return $http.put('ws/rest/studentService/student/' + id, student)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating student');
										return $q.reject(errResponse);
									}
							);
			},

			deleteStudent: function(id){
					return $http.delete('ws/rest/studentService/student/' + id)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while deleting student');
										return $q.reject(errResponse);
									}
							);
			}

	};

}]);