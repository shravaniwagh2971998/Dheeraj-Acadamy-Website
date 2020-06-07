
var app2=angular.module('myAppabout',[]);
app2.controller("aboutCntrl",['$scope','aboutUsService',function($scope,aboutUsService){


  //  // var hostUrl="http://172.104.179.8:9193/";
  // var hostUrl="http://localhost:9193/";
    // $scope.ContactObj={};


//alert("website aboutUsService");


$scope.profileList=[];
$scope.left =[];
$scope.right=[];
$scope.addressList=[];
$scope.leftList=[];
$scope.rightList=[];

$scope.activeContentList=[];
// $scope.profileList=[{"img":"img/cute.gif","name":"shravani","qualification":"msc"},{"img":"img/card21.jpg","name":"avani","qualification":"msc"},
// {"img":"img/cute.gif","name":"pavani","qualification":"msc"},
// {"img":"img/card21.jpg","name":"abc","qualification":"msc"},{"img":"img/cute.gif","name":"xyz","qualification":"msc"},
// {"img":"img/card21.jpg","name":"abc","qualification":"cx"},{"img":"img/cute.gif","name":"sax","qualification":"msc"},
// {"img":"img/card21.jpg","name":"abc","qualification":"da"},{"img":"img/cute.gif","name":"xz","qualification":"msc"}];
// alert("list"+JSON.stringify($scope.profileList));

// var len = $scope.profileList.length,
// mid = len / 2;

// $scope.left = $scope.profileList.slice(0, mid);
// $scope.right = $scope.profileList.slice(mid, len);

//alert("left list"+JSON.stringify($scope.left));
//alert("right list"+JSON.stringify($scope.right));

  //    $scope.initBtn=function(){
  //       $scope.btnSave=true;
  //       $scope.btnUpdate=false;
  //    }

  //    $scope.updateBtn=function(){
  //       $scope.btnSave=false;
  //       $scope.btnUpdate=true;
  //    }
  //    $scope.initBtn();


  
  // $scope.clear1 = function() {
  //     $scope.Contactobj={};
   
  // };  

  
$scope.getProfile=function()
   {

    aboutUsService.getProfileDetails().then(function(response)
    {

       $scope.profileList=response.data.result;

      var len = $scope.profileList.length,
      mid = len / 2;

      $scope.left = $scope.profileList.slice(0, mid);
      $scope.right = $scope.profileList.slice(mid, len);

    // alert(" $scope.mylist"+JSON.stringify( $scope.left));
    //   alert(" $scope.mylist"+JSON.stringify( $scope.right));
  //console.log("list is"+JSON.stringify($scope.profileList));
    })

   }


$scope.getProfile();
  
$scope.getAddress=function()
{
  aboutUsService.getAddressDetails().then(function(response)
    {

       $scope.addressList=response.data.result;

      var len = $scope.addressList.length,
      mid = len / 2;

      $scope.leftList = $scope.addressList.slice(0, mid);
      $scope.rightList = $scope.addressList.slice(mid, len);

        //alert("addressList is"+JSON.stringify($scope.addressList));
        //alert(" $scope.left"+JSON.stringify( $scope.left));
       // alert(" $scope.right"+JSON.stringify( $scope.right));

    })

}
$scope.getAddress();  

$scope.getActiveContent=function()
   {

    aboutUsService.getActiveContentdetails().then(function(response)
    {

       $scope.activeContentList=response.data.result;
})
}


$scope.getActiveContent();



}]);





app2.service("aboutUsService",function($http){



 this.getProfileDetails=function()
{
      return $http.get("http://localhost:8050/"+"getProfile");

}

this.getAddressDetails=function()
  {
    return $http.get("http://localhost:8050/"+"getAddress");
  }

this.getActiveContentdetails=function()
{
      return $http.get("http://localhost:8050/"+"getActiveContentData");

}


})






