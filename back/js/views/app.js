/**
 * Created by konstantin on 7/22/2016.
 */

define(['jquery', 'backbone', 'views/view', 'models/mainModel', 'collections/collection'],
    function ($, Backbone, ViewView, MainModel, Col) {
    var AppView = Backbone.View.extend({
        el: function () {
            return $("#picker");
        },
        initialize: function (options) {
            console.log("init done");
            this.col = new Col();
            this.col.bind('all', this.render, this);
            this.col.fetch();
        },
        render: function () {
            console.log('data is fetching');
            var view = new ViewView();
        }
    });
    return AppView;
});