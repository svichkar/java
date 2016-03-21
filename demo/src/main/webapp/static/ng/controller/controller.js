"use strict";

App.controller('BookController', ['$scope', 'BookService', '$filter', '$location', '$routeParams',
                                  function($scope, BookService, $filter, $location, $routeParams) {

                     var self = this;
                     self.books = [];

                     self.fetchBooks = function(){
                         BookService.fetchBooks()
                             .then(
                 					       function(d) {
                 						        self.books = d;
                 					       },
                       					function(errResponse){
                       						console.error('Error while fetching books');
                       					}
                 			       );
                     };

                     self.fetchBooks();

}]);