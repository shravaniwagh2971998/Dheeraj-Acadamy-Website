//var app=angular.module('myApp',[]);
//app.controller('contactDetailsCntrl', ['$scope', 'contactDetailsMasterService', function($scope, contactDetailsMasterService) {
app.controller("contactDetailsCntrl",function($scope,$state,contactDetailsMasterService){


//alert("contactDetails Cntrl");
$scope.mylist=[];





  $scope.getContact=function()
   {

    contactDetailsMasterService.getWebEnquiry().then(function(response)
    {

       $scope.mylist=response.data.result;

      //alert(" $scope.mylist"+JSON.stringify( $scope.mylist));
  
    })

   }


$scope.getContact();

$scope.delete=function(wenEnquiryId)
{
  contactDetailsMasterService.deleteContactDetails(wenEnquiryId).then(function(response)
  {
     if(response.data.statusCode==200)
      {
        alert("Contact deleted successfully");
        $scope.getContact();
        // $scope.profileobj=null;
      }
      else
      {
        alert("Contact not deleted");
      }
  })
}


});
// }]);




app.service("contactDetailsMasterService",function($http){



 this.getWebEnquiry=function()
{
      return $http.get(hostUrl+"webenquiry");

}
 this.deleteContactDetails=function(wenEnquiryId)
{
      return $http.delete(hostUrl+"deleteContact/"+wenEnquiryId);

}




 })






