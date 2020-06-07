app.controller('sideBar', function($scope,$window) 
{
//alert("sidebar");


// $scope.sidebarObj=angular.copy($stateParams.stateGoObj);


$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });


});