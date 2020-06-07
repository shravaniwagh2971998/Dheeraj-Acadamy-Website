
//var newapp1=angular.module('loginapp',[]);
//newapp1.controller("newcntrl1",['$scope',function($scope){
app.controller("loginCtrl",function($scope,$state,loginService){

$scope.registerObj={};
$scope.loginObj={};
$scope.backendLoginObj={};

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

    
  



  // $scope.save=function(registerObj)
  //  {

  //   loginService.insertRegisterRecord(registerObj).then(function(response)
  //   {
  //     if(response.data.statusCode==200)
  //     {
  //       alert("Register successfully");
  //       $scope.registerObj=null;
  //     }
  //     else
  //     {
  //       alert("Register Failed");
  //     }
    
  //   })

  //  }

$scope.go=function(loginObj)
{
      loginService.insertLoginRecord(loginObj).then(function(response)
    {

        $scope.backendLoginObj=response.data.result;
    //alert("backendLoginObj"+JSON.stringify($scope.backendLoginObj));
   
     if($scope.backendLoginObj.username!=null && $scope.backendLoginObj.password!=null)
    {
      if($scope.backendLoginObj.username!="inactiveUser" && $scope.backendLoginObj.password!="inactivePass")
      {
      alert("Login Successfully!");
        $scope.loginObj=null;
        $state.go('adminDashboard',{'stateGoObj':loginObj});
      }
      else
        {
      alert("Login Failed!");
        $scope.loginObj=null;
      }
    }
    

    if($scope.backendLoginObj.username=="inactiveUser")
    {
        alert("Username incorrect");
        $scope.loginObj=null;
    }

     else if($scope.backendLoginObj.password=="inactivePass")
    {
        alert("Password incorrect");
        $scope.loginObj=null;                        
    }



    //   $scope.res=response.data.result;
    //   if($scope.res==1)
    //   {
    //     alert("Login Successfully!!!");
    //     $scope.loginObj=null;
    //     $state.go('adminDashboard',{'stateGoObj':loginObj});
    //   }
    //   else if($scope.res==2)
    //   {
    //     alert("Username incorrect");
    //     $scope.loginObj=null;
    //   }
    //   else if($scope.res==3)
    //   {
    //     alert("Password incorrect");
    //     $scope.loginObj=null;
    //   }
    //   else if($scope.res==5)
    //   {
    //     // alert("Username & Password incorrect");
    //     alert("cannot login");
    //     $scope.loginObj=null;
    //   }
    
    

})
}

$scope.forgotFun=function(forgotobj)
{
   loginService.insertNewPassword(forgotobj).then(function(response)
    {
      if(response.data.result==1)
      {
        alert("Password Changed Successfully!!!");
        $scope.forgotobj=null;
      }
      else
      {
        alert("Password could not changed");
        $scope.forgotobj=null;        
      }
    
    })
}

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





});


app.service("loginService",function($http){



//  this.insertRegisterRecord=function(registerObj)
// {
//       return $http.post(hostUrl+"insertRegister",registerObj);

// }
this.insertLoginRecord=function(loginObj)
{
      return $http.post(hostUrl+"insertLogin",loginObj);

}
this.insertNewPassword=function(forgotobj)
{
      return $http.post(hostUrl+"forgotPassword",forgotobj);

}

//  this.updateContactService=function(feeObj)
// {
//       return $http.post(hostUrl+"updateContact",feeObj);

// }


//  this.getContactService=function()
// {
//       return $http.get(hostUrl+"getContact");

// }

 })






