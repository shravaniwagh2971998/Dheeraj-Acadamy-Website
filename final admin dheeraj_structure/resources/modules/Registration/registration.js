
//var newapp=angular.module('apppp',[]);
// newapp.controller("newcntrl",['$scope',function($scope){
app.controller("registrationCtrl",function($scope,$state,$http,registrationService){

$scope.registerObj={};
$scope.registerList=[];
$scope.status=["active","inactive"];

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

$scope.clear=function(registerObj)
{
	$scope.registerObj=null;
}

$scope.save=function(registerObj)
{
	registrationService.insertRegisterRecord(registerObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Registered successfully");
        $scope.getRegistration();
        $scope.registerObj=null;
      }
      else
      {
        alert("Registration Failed");
      }
    
    })

}

$scope.getRegistration=function()
   {

    registrationService.getRegistrationDetails().then(function(response)
    {
        $scope.registerList=response.data.result;
    })

   }
$scope.getRegistration();

$scope.edit=function(loginId)
{
  registrationService.editRegistrationRecord(loginId).then(function(response)
  {
    $scope.registerObj=response.data.result;
  })
}

$scope.update=function(registerObj)
{
  registrationService.updateRegistrationDetails(registerObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Registration Record updated successfully");
        $scope.getRegistration();
        $scope.registerObj=null;
      }
      else
      {
        alert("Registration Record not updated");
      }
    
    })
}
$scope.delete=function(loginId)
{
  registrationService.deleteRegistrationDetails(loginId).then(function(response)
  {
     if(response.data.statusCode==200)
      {
        alert("Registration Record deleted successfully");
        $scope.getRegistration();
        // $scope.profileobj=null;
      }
      else
      {
        alert("Registration Record not deleted");
      }
  })
}



});
// }]);




app.service("registrationService",function($http){



 this.insertRegisterRecord=function(registerObj)
{
      return $http.post(hostUrl+"insertRegister",registerObj);
}
 this.getRegistrationDetails=function()
{
      return $http.get(hostUrl+"getRegistration");

}
this.editRegistrationRecord=function(loginId)
  {
    return $http.post(hostUrl+"editRegistrationDetails/"+loginId);
  }
   this.updateRegistrationDetails=function(registerObj)
{
      return $http.post(hostUrl+"updateRegistration",registerObj);

}
 this.deleteRegistrationDetails=function(loginId)
{
      return $http.delete(hostUrl+"deleteRegistration/"+loginId);

}
// this.editProfileRecord=function(profileId)
//   {
//     return $http.post(hostUrl+"editProfileDetails/"+profileId);
//   }
//    this.updateProfileDetails=function(registerObj)
// {
//       return $http.post(hostUrl+"updateProfile",registerObj);

// }
//  this.deleteProfileDetails=function(profileId)
// {
//       return $http.delete(hostUrl+"deleteProfile/"+profileId);

// }


})






