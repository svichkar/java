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

services.factory('StudentFactory', function ($resource) {
    return $resource('ws/rest/studentService/student/:id', {}, {
        add: { method: 'POST' },
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});