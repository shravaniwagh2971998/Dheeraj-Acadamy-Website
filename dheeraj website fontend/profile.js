
var newapp=angular.module('apppp',['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);
newapp.controller("newcntrl",['$scope',function($scope){
// alert("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

$scope.profileobj={};
$scope.Detailtable=[];

//$scope.Detailtable=[{"Profile":"Priya","name":"p@gmail.com","qualification":"Hiiiiii"},{"Profile":"piu","name":"p@gmail.com","qualification":"Hiiiiii"}];


$scope.initBtn=function()
{
  // alert("init");
  $scope.btnSave=true;
  $scope.btnUpdate=false;
}
$scope.initBtn();

$scope.editbtn=function()
{
  $scope.btnSave=false;
  $scope.btnUpdate=true;
}







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

    
  



//   $scope.insertContact=function(feeObj)
//    {

//     contactService.insertContactService($scope.feeObj).then(function(response)
//     {

//       alert(response.data.message);
       
//       location.reload();
//     })

//    }



//   $scope.updateContact=function(feeObj)
//    {

//     contactService.updateContactService($scope.feeObj).then(function(response)
//     {

//       alert(response.data.message);
       
//       location.reload();
//     })

//    }





//   $scope.getContact=function()
//    {

//     contactService.getContactService().then(function(response)
//     {

//        $scope.mylist=response.data.result;

//       // alert(response.data.message);
  
//     })

//    }


// $scope.getContact();





}]);




// app.service("contactService",function($http){



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




// })






