var app=angular.module('galapp',[]);
app.controller('galleryCtrl', ['$scope','galleryMasterService', function($scope, galleryMasterService) {
//alert("Contact ctrl");
$scope.galleryObj={};


$scope.MainList=[];
$scope.leftList=[];
$scope.rightList=[];

 $scope.getActiveGalleryImages=function()
   {

    galleryMasterService.getActiveGalleryDetails().then(function(response)
    {

       $scope.MainList=response.data.result;

var len = $scope.MainList.length,
mid = len / 2;

$scope.leftList= $scope.MainList.slice(0, mid);
$scope.rightList= $scope.MainList.slice(mid, len);






 // alert("activeImageList"+JSON.stringify($scope.activeImageList));



 //       alert("left"+JSON.stringify($scope.left));




      

 // alert("right"+JSON.stringify($scope.right));


      // alert(response.data.message);
  
    })

   }


$scope.getActiveGalleryImages();






}]);

app.service("galleryMasterService",function($http)
{
   this.getActiveGalleryDetails=function()
{
      return $http.get("http://localhost:8050/"+"getActiveGalleryImages");

}

})  