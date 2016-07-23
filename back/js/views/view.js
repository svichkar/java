/**
 * Created by konstantin on 7/23/2016.
 */

define(['jquery', 'underscore', 'backbone', 'text!templates/template.html'], function ($, _, Backbone, Template) {

    var ViewView = Backbone.View.extend({
        template: _.template(Template),
        initialize: function (options) {
            console.log("view inited");
            this.render(options);
        },
        render: function (options) {
            console.log("view rendering");
            //$(this.el).html(options.model.get("content"));
            $(this.el).html(this.template({model: options.model}));
        }
    });
    return ViewView;
});