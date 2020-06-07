
//var newapp=angular.module('apppp',[]);
// newapp.controller("newcntrl",['$scope',function($scope){
app.controller("profileCtrl",function($scope,$state,$http,profileService){

$scope.profileobj={};
$scope.Detailtable=[];
$scope.profileList=[];
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

$scope.clear=function(profileobj)
{
	$scope.profileobj=null;
}

$scope.save=function(profileobj)
{
	profileService.insertProfileDetails(profileobj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Profile Uploaded successfully");
        $scope.getProfile();
        $scope.profileobj=null;
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert("Upload Failed");
      }
    
    })
}

$scope.getProfile=function()
   {

    profileService.getProfileDetails().then(function(response)
    {

      $scope.profileList=response.data.result;


//        var len = $scope.profileList.length,
// mid = len / 2;

// $scope.left = $scope.profileList.slice(0, mid);
// $scope.right = $scope.profileList.slice(mid, len);

    // alert(" $scope.mylist"+JSON.stringify( $scope.left));
    //   alert(" $scope.mylist"+JSON.stringify( $scope.right));
  //console.log("list is"+JSON.stringify($scope.profileList));
    })

   }
$scope.getProfile();

$scope.edit=function(profileId)
{
  profileService.editProfileRecord(profileId).then(function(response)
  {
    $scope.profileobj=response.data.result;
  })
}

$scope.update=function(profileobj)
{
  profileService.updateProfileDetails(profileobj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Profile Record updated successfully");
        $scope.getProfile();
        $scope.profileobj=null;
      }
      else
      {
        alert("Profile Record not updated");
      }
    
    })
}
$scope.delete=function(profileId)
{
  profileService.deleteProfileDetails(profileId).then(function(response)
  {
     if(response.data.statusCode==200)
      {
        alert("Profile Record deleted successfully");
        $scope.getProfile();
        // $scope.profileobj=null;
      }
      else
      {
        alert("Profile Record not deleted");
      }
  })
}


$scope.doUploadFile = function(profileobj){


    $scope.loadingFlag=true;
   //alert("Sdfg");
       var file =profileobj.profileImg;
       //alert(file);
       var url = hostUrl+"uploadProfile";
       
       var data = new FormData();
       data.append('uploadfile', file);
       //alert(data);
    
       var config = {
          transformRequest: angular.identity,
          transformResponse: angular.identity,
        headers : {
          'Content-Type': undefined
          }
       }
       
       $http.post(url, data, config).then(function (response) {
      $scope.uploadResult=response.data;
          var img=$scope.uploadResult;
        /*var imgUrl=img.result.imageUrl;*/
        profileobj.profileImg=img;
       // alert(obj.documents);
        if(profileobj.profileImg!=null){
          $scope.loadingFlag=false;
        }
      
    }, function (response) {
      $scope.uploadResult=response.data.result;
        
    });

    };

});
// }]);




app.service("profileService",function($http){



 this.insertProfileDetails=function(profileobj)
{
      return $http.post(hostUrl+"insertProfile",profileobj);

}
 this.getProfileDetails=function()
{
      return $http.get(hostUrl+"getProfile");

}
this.editProfileRecord=function(profileId)
  {
    return $http.post(hostUrl+"editProfileDetails/"+profileId);
  }
this.updateProfileDetails=function(profileobj)
{
      return $http.post(hostUrl+"updateProfile",profileobj);

}
this.deleteProfileDetails=function(profileId)
{
      return $http.delete(hostUrl+"deleteProfile/"+profileId);

}




// this.uploadprofileCtrl=function(profileobj)
// {
//       return $http.post("http://localhost:8050/"+"uploadProfile",profileobj);

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






