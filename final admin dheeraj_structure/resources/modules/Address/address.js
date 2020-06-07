app.controller("addressCtrl",function($scope,$state,addressService){

$scope.status=["active","inactive"];
$scope.addressObj={};
$scope.addressList=[];

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

$scope.clear=function(addressObj)
{
	$scope.addressObj=null;
}

$scope.save=function(addressObj)
{
	addressService.insertAddress(addressObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Address saved successfully");
        $scope.addressObj=null;
        $scope.getAddress();
        //$scope.profileobj.profileImg=null;
      }
      else
      {
        alert("Address not saved");
      }
    
    })
}

$scope.getAddress=function()
{
  addressService.getAddressDetails().then(function(response)
    {

       $scope.addressList=response.data.result;

    })

}


$scope.getAddress();

$scope.edit=function(addressId)
{
  addressService.editAddressRecord(addressId).then(function(response)
  {
    $scope.addressObj=response.data.result;
  })
}

$scope.update=function(addressObj)
{
  addressService.updateAddressDetails(addressObj).then(function(response)
    {
      if(response.data.statusCode==200)
      {
        alert("Address Record updated successfully");
        $scope.getAddress();
        $scope.addressObj=null;
      }
      else
      {
        alert("Address Record not updated");
      }
    
    })
}
$scope.delete=function(addressId)
{
  addressService.deleteAddressDetails(addressId).then(function(response)
  {
     if(response.data.statusCode==200)
      {
        alert("Address deleted successfully");
        $scope.getAddress();
        // $scope.profileobj=null;
      }
      else
      {
        alert("Address Record not deleted");
      }
  })
}


});

app.service("addressService",function($http){

this.insertAddress=function(addressObj)
{
      return $http.post(hostUrl+"insertAddressDetails",addressObj);

}
this.getAddressDetails=function()
  {
    return $http.get("http://localhost:8050/"+"getAddress");
  }
this.editAddressRecord=function(addressId)
  {
    return $http.post(hostUrl+"editAddressDetails/"+addressId);
  }
this.updateAddressDetails=function(addressObj)
{
      return $http.post(hostUrl+"updateAddress",addressObj);

}
this.deleteAddressDetails=function(addressId)
{
      return $http.delete(hostUrl+"deleteAddress/"+addressId);

}


})