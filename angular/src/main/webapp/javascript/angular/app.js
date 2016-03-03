"use strict";

var app = angular.module("app", ['app.services',
                                 'app.controllers',
                                 'ngRoute']
);

app.config(function($routeProvider){
	$routeProvider
		.when( '/allStudents', { controller: 'StudentListCtrl', templateUrl: 'javascript/angular/view/studentListView.html' } )
		.when( '/add', { controller: 'StudentCtrl', templateUrl: 'javascript/angular/view/addStudentView.html' } )
		.when( '/edit', { controller: 'StudentCtrl', templateUrl: 'javascript/angular/view/editStudentView.html' } )
		.otherwise( { redirectTo: '/' } );
});