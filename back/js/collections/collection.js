define(['backbone', 'models/mainModel'], function (Backbone, MainModel) {
    var Col = Backbone.Collection.extend({
        model: MainModel,
        url: 'json/response.json',
        parse: function (data) {
            return data;
        }
    });
    return Col;
});