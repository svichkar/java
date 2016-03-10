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

			fetchStudent: function(id) {
					return $http.get('ws/rest/studentService/student/' + id)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching student');
										return $q.reject(errResponse);
									}
							);
			},

			fetchAllGroups: function() {
					return $http.get('ws/rest/studentService/group')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching groups');
										return $q.reject(errResponse);
									}
							);
			},

			fetchAllStatuses: function() {
					return $http.get('ws/rest/studentService/status')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching statuses');
										return $q.reject(errResponse);
									}
							);
			},

			fetchAllTerms: function() {
					return $http.get('ws/rest/studentService/term')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching terms');
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