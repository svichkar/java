"use strict";

var app = angular.module("app", ['app.services',
                                 'app.controllers',
                                 'ngRoute']
);

app.config(function($routeProvider){
	$routeProvider
		.when( '/allStudents', { controller: 'StudentListCtrl', templateUrl: 'javascript/angular/view/studentListView.html' } )
		.when( '/new', { controller: 'StudentCtrl', templateUrl: 'javascript/angular/view/addStudentView.html' } )
		.otherwise( { redirectTo: '/' } );
});