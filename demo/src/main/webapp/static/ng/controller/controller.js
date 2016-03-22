"use strict";

App.controller('BookController', ['$scope', 'BookService', '$filter', '$location', '$routeParams',
                                  function($scope, BookService, $filter, $location, $routeParams) {

                     var self = this;
                     self.books = [];
                     self.book = {};

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

                     self.createBook = function(book){
                                 BookService.createBook(book)
                                      .then(
                                              self.fetchBooks,
                                              function(errResponse){
                                                   console.error('Error while creating book');
                                              }
                                       );
                     };

                     self.add = function() {
                        self.createBook(self.book);
                     };

}]);