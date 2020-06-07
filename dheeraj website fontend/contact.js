var app=angular.module('myApp',[]);
app.controller('contactCtrl', ['$scope', 'contactMasterService', function($scope, contactMasterService) {
//alert("Contact ctrl");
$scope.contactObj={};
$scope.addressList=[];
$scope.left=[];
$scope.right=[];


$scope.save=function(contactObj)
{
	contactMasterService.addEnquiry(contactObj).then(function(response)
	{
		if(response.data.statusCode==200)
		{
			alert("Contact Saved!!!");
			$scope.contactObj=null;
			
			//$scope.getWebEnquiry();
		}
		else
		{
			alert("Contact not Saved");
		}
	})
}
 //$scope.getWebEnquiry();

$scope.getAddress=function()
{
	contactMasterService.getAddressDetails().then(function(response)
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

app.service("contactMasterService",function($http)
{
	this.addEnquiry=function(contactObj)
	{
		return $http.post("http://localhost:8050/"+"webenquiry",contactObj);
	}

	this.getAddressDetails=function()
	{
		return $http.get("http://localhost:8050/"+"getAddress");
	}
})	