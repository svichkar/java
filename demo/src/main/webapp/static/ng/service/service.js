'use strict';

App.factory('BookService', ['$http', '$q', function($http, $q){

	return {

			fetchBooks: function() {
					return $http.get('books')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching books');
										return $q.reject(errResponse);
									}
							);
			},

		    createBook: function(book) {
            					return $http.post('book', book)
            							.then(
            									function(response){
            										return response.data;
            									},
            									function(errResponse){
            										console.error('Error while creating book');
            										return $q.reject(errResponse);
            									}
            							);
            },

		    updateBook: function(id, book) {
            					return $http.put('book/' + id, book)
            							.then(
            									function(response){
            										return response.data;
            									},
            									function(errResponse){
            										console.error('Error while updating book');
            										return $q.reject(errResponse);
            									}
            							);
            },

		    deleteBook: function(id) {
            					return $http.delete('book/' + id)
            							.then(
            									function(response){
            										return response.data;
            									},
            									function(errResponse){
            										console.error('Error while deleting book');
            										return $q.reject(errResponse);
            									}
            							);
            },

		    uploadBook: function(file) {
		                        var fd = new FormData();
                                fd.append('file', file);
            					return $http.post('book/upload', fd, {
                                       transformRequest: angular.identity,
                                       headers: {'Content-Type': undefined}
                                })
            							.then(
            									function(response){
            										return response.data;
            									},
            									function(errResponse){
            										console.error('Error while uploading book');
            										return $q.reject(errResponse);
            									}
            							);
            }

	};

}]);