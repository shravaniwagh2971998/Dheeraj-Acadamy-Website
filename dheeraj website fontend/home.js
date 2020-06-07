
var app1=angular.module('myApphome',[]);
app1.controller("homeCntrl",['$scope','homeService',function($scope,homeService){


  //  // var hostUrl="http://172.104.179.8:9193/";
  // var hostUrl="http://localhost:9193/";
  //  $scope.ContactObj={};


//alert("homeCntrl");
$scope.addressList=[];
$scope.left=[];
$scope.right=[];
$scope.activeImageList=[];
$scope.leftlist=[];
$scope.rightlist=[];

$scope.getAddress=function()
{
  homeService.getAddressDetails().then(function(response)
    {

       $scope.addressList=response.data.result;

      var len = $scope.addressList.length,
      mid = len / 2;

      $scope.left = $scope.addressList.slice(0, mid);
      $scope.right = $scope.addressList.slice(mid, len);

        //alert("addressList is"+JSON.stringify($scope.addressList));
        //alert(" $scope.left"+JSON.stringify( $scope.left));
       // alert(" $scope.right"+JSON.stringify( $scope.right));

    })

}
$scope.getAddress();



  $scope.getActiveStatusImage=function()
   {

    homeService.getActiveStatusImageDetails().then(function(response)
    {

       $scope.activeImageList=response.data.result;

var len = $scope.activeImageList.length,
mid = len / 2;

$scope.leftlist = $scope.activeImageList.slice(0, mid);
$scope.rightlist = $scope.activeImageList.slice(mid, len);


  
    })

   }


$scope.getActiveStatusImage();


}]);




 app1.service("homeService",function($http){

this.getAddressDetails=function()
  {
    return $http.get("http://localhost:8050/"+"getAddress");
  }
this.getActiveStatusImageDetails=function()
{
      return $http.get("http://localhost:8050/"+"getActiveStatusImageDisplay");

}
//  this.insertContactService=function(feeObj)
// {
//       return $http.post(hostUrl+"insertContact",feeObj);

// }


//  this.updateContactService=function(feeObj)
// {
//       return $http.post(hostUrl+"updateContact",feeObj);

// }


//  this.getContactService=function()
// {
//       return $http.get(hostUrl+"getContact");

// }




 })






