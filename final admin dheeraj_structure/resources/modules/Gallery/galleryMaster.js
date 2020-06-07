app.controller("galleryCtrl",function($scope,$state,$http,gallaryImagesService){

$scope.galleryObj={};
$scope.galleryImageList1=[];
$scope.galleryImageList=[];
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

$scope.clear=function(galleryObj)
{
  $scope.galleryObj=null;
}

$scope.save=function(galleryObj)
{
  gallaryImagesService.insertGalleryImageDetails(galleryObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Upload Profile successfully");
        $scope.getGalleryImage();
        $scope.galleryObj=null;
      }
      else
      {
        alert("Upload Failed");
      }
    
    })
}

$scope.getGalleryImage=function()
   {

    gallaryImagesService.getGalleryImagedetails().then(function(response)
    {

      $scope.galleryImageList1=response.data.result;

         // alert(JSON.stringify($scope.galleryImageList1));
//        var len = $scope.profileList.length,
// mid = len / 2;

// $scope.left = $scope.profileList.slice(0, mid);
// $scope.right = $scope.profileList.slice(mid, len);

    // alert(" $scope.mylist"+JSON.stringify( $scope.left));
    //   alert(" $scope.mylist"+JSON.stringify( $scope.right));
  //console.log("list is"+JSON.stringify($scope.profileList));
    })

   }
$scope.getGalleryImage();




$scope.edit=function(galleryId)
{
  gallaryImagesService.editGalleryRecord(galleryId).then(function(response)
  {
    $scope.galleryObj=response.data.result;
  })
}



$scope.update=function(galleryObj)
{
  gallaryImagesService.updateGalleryDetails(galleryObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Profile updated successfully");
        $scope.getGalleryImage();
        $scope.galleryObj=null;
      }
      else
      {
        alert("Profile not updated");
      }
    
    })
}




$scope.doUploadFile = function(galleryObj){


    $scope.loadingFlag=true;
   //alert("Sdfg");
       var file =galleryObj.galleryName;
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
        galleryObj.galleryName=img;
       // alert(obj.documents);
        if(galleryObj.galleryName!=null){
          $scope.loadingFlag=false;
        }
      
    }, function (response) {
      $scope.uploadResult=response.data;
        
    });

    };

});
// }]);




app.service("gallaryImagesService",function($http){



 this.insertGalleryImageDetails=function(galleryObj)
{
      return $http.post(hostUrl+"InsertGalleryImages",galleryObj);

}
 this.getGalleryImagedetails=function()
{
      return $http.get(hostUrl+"getGalleryImages");

}


this.editGalleryRecord=function(galleryId)
  {
    return $http.post(hostUrl+"editGalleryDetails/"+galleryId);
  }
  this.updateGalleryDetails=function(galleryObj)
{
      return $http.post(hostUrl+"updateGallery",galleryObj);

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






