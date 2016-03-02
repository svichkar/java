"use strict";

var services = angular.module('app.services', ['ngResource']);

services.factory('StudentsFactory', function ($resource) {
    return $resource('ws/rest/studentService/students', {}, {
        query: {
                method: 'GET',
                isArray: true
        }
    })
});