/**
 * Created by konstantin on 7/22/2016.
 */

define(['backbone'], function (Backbone) {
   var MainModel = Backbone.Model.extend({
       defaults: {
           content: 'Here my content'
       },
       initialize: function () {
           console.log("initialized model");
       }
   });
    return MainModel;
});