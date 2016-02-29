var StudentModel = Backbone.Model.extend({
    url: function() {
    return "ws/rest/studentService/student/" + (this.id ? this.id : '');
}
});

var StudentsCollection = Backbone.Collection.extend({
     model: StudentModel,
     url: "ws/rest/studentService/students"
    });

var StatusCollection = Backbone.Collection.extend({
                            url: "ws/rest/studentService/status"
});

var TermCollection = Backbone.Collection.extend({
                            url: "ws/rest/studentService/term"
});

var GroupCollection = Backbone.Collection.extend({
                            url: "ws/rest/studentService/group"
});

var student = new StudentModel();
var students = new StudentsCollection();
var statusList = new StatusCollection();
var termList = new TermCollection();
var groupList = new GroupCollection();