var app=angular.module('myApp',[]);
app.controller('whyCtrl',['$scope','whyService',function($scope,whyService){


  //  // var hostUrl="http://172.104.179.8:9193/";
  // var hostUrl="http://localhost:9193/";
  //  $scope.ContactObj={};


//alert("whyCtrl");
$scope.addressList=[];
$scope.left=[];
$scope.right=[];


$scope.getAddress=function()
{
  whyService.getAddressDetails().then(function(response)
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


}]);




 app.service("whyService",function($http){

this.getAddressDetails=function()
  {
    return $http.get("http://localhost:8050/"+"getAddress");
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






