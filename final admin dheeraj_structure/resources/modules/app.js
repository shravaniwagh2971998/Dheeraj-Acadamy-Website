var app=angular.module('myApp', ['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);


var hostUrl="http://localhost:8050/";


app.config(function($stateProvider, $urlRouterProvider) 
{

	$urlRouterProvider.otherwise('/login');
 	$stateProvider

 	

 

.state('login', {
    
    url : '/login',

    templateUrl : 'resources/modules/Login/login.html'

    })

.state('adminDashboard', {
    
    url : '/adminDashboard',

    templateUrl : 'resources/modules/AdminDashboard/adminDashboard.html'

    })


.state('sideBar', {
    
    url : '/sideBar',

    templateUrl : 'resources/modules/SideBar/sideBar.html',

    params:
    {
        stateGoObj:null
    }


    })

.state('profile', {
    
    url : '/profile',

    templateUrl : 'resources/modules/Profile/profile.html'

    })

.state('contactDetails', {
    
    url : '/contactDetails',

    templateUrl : 'resources/modules/ContactDetails/contactDetails.html'

    })
.state('registration', {
    
    url : '/registration',

    templateUrl : 'resources/modules/Registration/registration.html'

    })
.state('address', {
    
    url : '/address',

    templateUrl : 'resources/modules/Address/address.html'

    })
.state('activeImages', {
    
    url : '/activeImages',

    templateUrl : 'resources/modules/ActiveImage/activeImages.html'

    })
.state('galleryMaster', {
    
    url : '/galleryMaster',

    templateUrl : 'resources/modules/Gallery/galleryMaster.html'

    })
.state('contentMaster', {
    
    url : '/contentMaster',

    templateUrl : 'resources/modules/AboutContent/contentMaster.html'

    })



 });

app.directive("fileRead", [ function($compile) {
return {
scope : {
fileRead : "="
},
link : function(scope, element, attributes) {
element.bind("change", function(changeEvent) {
var reader = new FileReader();
reader.onload = function(loadEvent) {
scope.$apply(function() {
scope.fileRead = loadEvent.target.result;

});
}
reader.readAsDataURL(changeEvent.target.files[0]);
});
}
}
} ]);
app.directive('fileModel', ['$parse', function ($parse) {
return {
restrict: 'A',
link: function(scope, element, attrs) {
var model = $parse(attrs.fileModel);
var modelSetter = model.assign;

element.bind('change', function(){
scope.$apply(function(){
modelSetter(scope, element[0].files[0]);
});
});
}
};
}]);