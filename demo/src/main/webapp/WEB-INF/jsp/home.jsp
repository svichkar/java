<html>
<head>
    <link rel="shortcut icon" href="static/image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="static/css/style.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.icon-large.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
</head>
<body ng-app="myApp" class="ng-cloak" ng-controller="BookController as ctrl">
<h1>Books Management</h1>
        </br>
         <div class= "container">
                <div class="btn-group btn-group-justified">
                          <button class="btn btn-default btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Select Action <span class="caret"></span>
                          </button>
                          <ul class="dropdown-menu">
                            <li><a href="home#/">Show All Books</a></li>
                            <li><a href="home#/add">Add New Book</a></li>
                            <li><a href="home#/uploadFile">Upload Book</a></li>
                          </ul>
                </div>
         </div>
        </br>
        <div ng-view class="container"></div>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>

        <script src="static/ng/app.js"></script>
        <script src="static/ng/controller/controller.js"></script>
        <script src="static/ng/service/service.js"></script>
        <script src="static/ng/directive/ngRightClick.js"></script>
        <script src="static/ng/directive/fileModel.js"></script>
</body>
</html>