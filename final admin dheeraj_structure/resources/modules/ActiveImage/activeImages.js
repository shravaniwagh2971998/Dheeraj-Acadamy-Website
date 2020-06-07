
//var newapp=angular.module('apppp',[]);
// newapp.controller("newcntrl",['$scope',function($scope){
app.controller("activeImageCtrl",function($scope,$state,$http,activeImageService){

$scope.activeImgObj={};
$scope.activeImageList1=[];
$scope.activeImageList=[];
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

$scope.clear=function(activeImgObj)
{
	$scope.activeImgObj=null;
}

$scope.save=function(activeImgObj)
{
	activeImageService.insertImageStatus(activeImgObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Upload Profile successfully");
        $scope.getActiveImage();
        $scope.activeImgObj=null;
      }
      else
      {
        alert("Upload Failed");
      }
    
    })
}

$scope.getActiveImage=function()
   {

    activeImageService.getImageDisplayDetails().then(function(response)
    {

      $scope.activeImageList1=response.data.result;

         // alert(JSON.stringify($scope.activeImageList1));
//        var len = $scope.profileList.length,
// mid = len / 2;

// $scope.left = $scope.profileList.slice(0, mid);
// $scope.right = $scope.profileList.slice(mid, len);

    // alert(" $scope.mylist"+JSON.stringify( $scope.left));
    //   alert(" $scope.mylist"+JSON.stringify( $scope.right));
  //console.log("list is"+JSON.stringify($scope.profileList));
    })

   }
$scope.getActiveImage();

$scope.edit=function(imageId)
{
  activeImageService.editImageRecord(imageId).then(function(response)
  {
    $scope.activeImgObj=response.data.result;
  })
}

$scope.update=function(activeImgObj)
{
  activeImageService.updateImageDetails(activeImgObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Profile updated successfully");
        $scope.getActiveImage();
        $scope.activeImgObj=null;
      }
      else
      {
        alert("Profile not updated");
      }
    
    })
}


$scope.doUploadFile = function(activeImgObj){


    $scope.loadingFlag=true;
   //alert("Sdfg");
       var file =activeImgObj.homePageImg;
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
        activeImgObj.homePageImg=img;
       // alert(obj.documents);
        if(activeImgObj.homePageImg!=null){
          $scope.loadingFlag=false;
        }
      
    }, function (response) {
      $scope.uploadResult=response.data.result;
        
    });

    };

});
// }]);




app.service("activeImageService",function($http){



 this.insertImageStatus=function(activeImgObj)
{
      return $http.post(hostUrl+"insertImageStatusDetails",activeImgObj);

}
 this.getImageDisplayDetails=function()
{
      return $http.get(hostUrl+"getImageDisplay");

}
this.editImageRecord=function(imageId)
  {
    return $http.post(hostUrl+"editImage/"+imageId);
  }
   this.updateImageDetails=function(activeImgObj)
{
      return $http.post(hostUrl+"updateImage",activeImgObj);

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






