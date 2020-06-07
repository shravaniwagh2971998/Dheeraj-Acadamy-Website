
//var newapp=angular.module('apppp',[]);
// newapp.controller("newcntrl",['$scope',function($scope){
app.controller("contentCtrl",function($scope,$state,$http,contentService){

$scope.contentObj={};

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

$scope.clear=function(contentObj)
{
	$scope.contentObj=null;
}

$scope.save=function(contentObj)
{
	contentService.insertContentDetails(contentObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Upload Profile successfully");
        $scope.getContent();
        $scope.contentObj=null;
      }
      else
      {
        alert("Upload Failed");
      }
    
    })
}

$scope.getContent=function()
   {

    contentService.getContentdetails().then(function(response)
    {

      $scope.contentList1=response.data.result;

         // alert(JSON.stringify($scope.contentList1));
//        var len = $scope.profileList.length,
// mid = len / 2;

// $scope.left = $scope.profileList.slice(0, mid);
// $scope.right = $scope.profileList.slice(mid, len);

    // alert(" $scope.mylist"+JSON.stringify( $scope.left));
    //   alert(" $scope.mylist"+JSON.stringify( $scope.right));
  //console.log("list is"+JSON.stringify($scope.profileList));
    })

   }
$scope.getContent();

$scope.edit=function(contentId)
{
  contentService.editContentRecord(contentId).then(function(response)
  {
    $scope.contentObj=response.data.result;
  })
}

$scope.update=function(contentObj)
{
  contentService.updateContentDetails(contentObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Profile updated successfully");
        $scope.getContent();
        $scope.contentObj=null;
      }
      else
      {
        alert("Profile not updated");
      }
    
    })
}




});
// }]);




app.service("contentService",function($http){



 this.insertContentDetails=function(contentObj)
{
      return $http.post(hostUrl+"InsertContentData",contentObj);

}
 this.getContentdetails=function()
{
      return $http.get(hostUrl+"getContentData");

}
this.editContentRecord=function(contentId)
  {
    return $http.post(hostUrl+"editContentDetails/"+contentId);
  }
   this.updateContentDetails=function(contentObj)
{
      return $http.post(hostUrl+"updateContent",contentObj);

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






