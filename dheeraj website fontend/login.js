
var newapp1=angular.module('loginapp',[]);
newapp1.controller("newcntrl1",['$scope',function($scope){
// alert("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");


 $scope.pencil=true;

  // $scope.pencil1=true;
     $scope.showfun=function(){
        $scope.pencil=false;
        // $scope.pencil1=false;
        
     }

  $scope.cancelbtn=function(){
        $scope.pencil=true;
        // $scope.pencil1=false;
        
     }


$(".toggle").on("click", function() {
  $(".container")
    .stop()
    .addClass("active");
});

$(".close").on("click", function() {
  $(".container")
    .stop()
    .removeClass("active");
});







var eye = document.querySelector('.eye'), ripple = document.querySelector('.ripple'), toggle = document.querySelector('.toggle1'), input = document.querySelector('input[type=password]');
function click(e) {
    // Ripple Effect
    ripple.classList.add('animate');
    // Push Effect
    input.classList.add('animate');
    // Toggle input type between: password / text 
    input.classList.toggle('password');
    input.type === 'text' ? input.type = 'password' : input.type = 'text';
    toggle.dataset.state = input.type === 'text' ? 'visible' : 'hidden';
}
toggle.addEventListener('click', click);
// Remove all after animation ends
function removeAnimate() {
    ripple.classList.remove('animate');
    input.classList.remove('animate');
    toggle.style.pointerEvents = 'all';
}
ripple.addEventListener('animationend', removeAnimate);



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






