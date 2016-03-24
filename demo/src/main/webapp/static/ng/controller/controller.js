"use strict";

App.controller('BookController', ['$scope', 'BookService', '$filter', '$location', '$routeParams',
                                  function($scope, BookService, $filter, $location, $routeParams) {

                     var self = this;
                     self.books = [];
                     self.book = {};
                     self.newBook = {};

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
                        self.createBook(self.newBook);
                        self.newBook = {};
                     };

                     self.updateBook = function(id, book){
                                                      BookService.updateBook(id, book)
                                                           .then(
                                                                   self.fetchBooks,
                                                                   function(errResponse){
                                                                        console.error('Error while updating book');
                                                                   }
                                                            );
                     };

                     self.commit = function() {
                        self.updateBook(self.book.id, self.book);
                     };

                     self.edit = function(book) {
                        self.book = book;
                        $location.path("/edit/" + book.id);
                     };

                     self.deleteBook = function(id){
                                                      BookService.deleteBook(id)
                                                           .then(
                                                                   self.fetchBooks,
                                                                   function(errResponse){
                                                                        console.error('Error while deleting book');
                                                                   }
                                                            );
                     };

                     self.delete = function(id) {
                        self.deleteBook(id);
                        $location.path("/");
                     };

}]);