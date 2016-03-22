"use strict";

App.controller('BookController', ['$scope', 'BookService', '$filter', '$location', '$routeParams',
                                  function($scope, BookService, $filter, $location, $routeParams) {

                     var self = this;
                     self.books = [];
                     self.book;

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

                   self.createStudent = function(book){
                                 BookService.createStudent(student)
                                      .then(
                                         self.fetchAllStudents,
                                              function(errResponse){
                                                   console.error('Error while creating Student');
                                              }
                                     );
                                 self.newAdmissionDate = null;
                                 self.newStudent = {};
                             };
}]);