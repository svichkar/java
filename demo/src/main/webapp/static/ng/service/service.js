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

	};

}]);