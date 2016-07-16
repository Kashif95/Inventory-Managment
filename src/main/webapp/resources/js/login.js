var loginMod = angular.module('loginMod', ['UIMod']);

loginMod.controller('loginCtrl',function($scope,sessionService,$window){
	
		$scope.loginUser  = function(){
			var mobileNum = $scope.login.mobileNumber;
			var password = $scope.login.password;
			sessionService.login($scope.login)
			.then(
			        function(data) {
			        	if(data.status==200){
			        		 var url=  "../../home";
			        		sessionService.getHomePage(url).then(
			        				function(response){
			        					if(response.status==200){
			        						var usrSession = {};
			        						usrSession.userName  = response.data.username;
			        						usrSession.userRole = response.data.role.authority;
			        						usrSession.compType = response.data.company;
			        						usrSession.isLogged = true;
			        						sessionStorage.setItem("session", JSON.stringify(usrSession));
			        						sessionStorage.setItem("activeMenu", "home");
			        	        			sessionService.setSession(usrSession);
			        	        			if(usrSession.compType==1){
			        	        				$window.location.href = "../../resources/html/fms/home.html";
			        	        			}else{
			        	        				$window.location.href = "../../resources/html/medicine/home.html";
			        	        			}
			        	        			
			        	        		}
			        				}
			        		)
			        	}
			        })
			        .catch(function(){
			        	document.getElementById('errorDiv').style.display='block';
			        });
		};
		ga('send','event','Log In','login','event.target.href');
	
});
loginMod.service('sessionService', function($http,$window) {
    var session = null;
    /*session.isLogged = false;
    session.userName = '';
    session.userRole = '';*/
    
    this.getSession = function(){
		return session;
	}
	
	this.setSession = function(session){
		
		this.session = session;
	}
    
    this.login = function(data) {
     return $http.post("/inventory/login?companyType="+data.companyType,"username=" + data.mobileNumber + "&password=" + data.password, {
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function(data) {
            var url=  "../../home";
            
        }).error(function(data) {
        	console.log("No page found");
        });
    };
    this.logout = function() {
        sessionStorage.removeItem("session");
        sessionStorage.removeItem("activeMenu");
        var url=  '/inventory/logout';
		var logdetail =  $http.post(url,null).then(function(response){
			if(response.status==200){
				$window.location.href = "../../../login";
			}
		});
		ga('send','event','Log Out','logOut','event.target.href');
        
    };
    this.isLoggedIn = function() {
        return sessionStorage.getItem("session") !== null;
    };
    this.getHomePage = function(url){
    	return $http.get(url).success(function(data){
    		
    	}).error(function(data) {
        	console.log("No page found");
        });
    	
    }
    
})
/*loginMod.service('LoginService', function($http,$window){
	 
	 this.loginUser = function(login){
		 
		
		$http({
				method:'PUT',
				url: '../../authenticate',
				data:login
		 }).success(function(data, status, headers, config){
			 	if(data.status=="error"){
			 		document.getElementById('errorDiv').style.display='block';
					//alert("Invalid User")
			 	}
			 	else{
			 		$window.location.href = "../../"+data.status;
			 	}
			 	
	          	
		    })
		    .error(function(data) {
		    	console.log(data);
		    	
		    });
		 };
		 
});*/