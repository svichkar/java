var services = angular.module('myApp.services', ['ngResource']);

services.factory('StudentsFactory', function ($resource) {
    return $resource('ws/rest/studentService/students', {}, {
        query: {
                method: 'GET',
                isArray: true
        }
    })
});