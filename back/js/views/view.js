/**
 * Created by konstantin on 7/23/2016.
 */

define(['jquery', 'underscore', 'backbone', 'dust', 'text!templates/template.html',
        'text!templates/dust/main.template.dust'], function ($, _, Backbone, Dust, Template, TemplateDust) {

    var ViewView = Backbone.View.extend({
        template: _.template(TemplateDust),
        initialize: function (options) {
            console.log("view inited");
            this.render(options);
        },
        render: function (options) {
            console.log("view rendering");

        }
    });
    return ViewView;
});