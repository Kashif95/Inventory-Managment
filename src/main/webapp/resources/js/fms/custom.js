var globalMod = angular.module('globalMod', ['ngRoute','UIMod','angularUtils.directives.dirPagination','ui.bootstrap','loginMod','angulartics', 'angulartics.google.analytics']);



globalMod.controller('globalCtrl',function($scope,sessionService){
	
	var session = JSON.parse(sessionStorage.getItem("session"));
	$scope.userName = session.userName;
	$scope.role = session.userRole;
	$scope.compType = session.compType;
	$scope.isAdmin = false;
	if($scope.role=='Admin'){
		$scope.isAdmin = !$scope.isAdmin;
	}
	//$scope.popupType = "product";
	$scope.content=null;
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
  }
	$scope.isLoggedIn = sessionService.isLoggedIn();
    $scope.logout = function(){
    	sessionService.logout();
    }

});
globalMod.service('globalService',function(MenuService){
	
	
	
});


globalMod.controller('menuCtrl',function($scope,MenuService){

	

});

globalMod.service('MenuService',function(){

	
	
});
globalMod.controller('agencyCtrl',function($scope,agencyService){

	var globalScope = angular.element(document.getElementById('mainBody')).scope();
	
	var session = JSON.parse(sessionStorage.getItem("session"));
	$scope.role = session.userRole;
	
	agencyService.getAgencyList().then(function(data){
		$scope.agencyList = data;
	});
	
	//globalScope.Title = "Agency";
	document.getElementById('agency').className ="active";
	$scope.saveAgency = function(){
		var mobileNum = $scope.agency.mobileNumber;
		if(mobileNum.length==10){
			
			//document.getElementById('agencySaveBtn').className ="disabled";
			agencyService.saveAgency($scope.agency).then(function(data){
				$scope.addAgencyInfo = !$scope.addAgencyInfo;
				$scope.agencyList = data;
			});	
			
		}
	}
	$scope.addAgency = function(){
		//$("agencySaveBtn").removeClass("disabled");
		var agency = {};
		agency.agencyId = null;
		agency.agencyName = "";
		agency.ownerName = 	"";
		agency.email="";
		agency.addressLine1 = "";
		agency.addressLine2 = "";
		agency.city = "";
		agency.state = "";
		agency.agencySupervisor = "";
		agency.mobileNumber = "";
		agency.alternateNumber = "";
		agency.addressId = null;
		$scope.agency = agency;
	}
	$scope.editAgency = function(agency){
		
		$scope.agency = agencyService.editAgency(agency);
		$scope.addAgencyInfo = true;
			
	}
	$scope.deleteAgency = function(agency){
		
		agencyService.deleteAgency(agency).then(function(data){
			//$scope.addAgencyInfo = !$scope.addAgencyInfo;
			$scope.agencyList = data;
		});	
	}
	
	
});


globalMod.service('agencyService',function($http,$q){
	
	var agencyList = null;	
	var agency = {};
	this.getAgencyList = function(){
		
		/*agencyList = this.getAgencyList().then(function(data){
			return data;
		});*/
		
		return this.getAllAgencyList();
	}
	this.setAgencyList = function(agencyList){
		
			 this.agencyList = agencyList;
	}
	
	this.getAgency = function(){
		return agency;
	}
	
	this.setAgency = function(agency){
		
		this.agency = agency;
	}
	
	this.saveAgency = function(agency){
		
		
		var url=  '../../../agency/saveAgency';
		agencyList =  $http.put(url,agency).then(function(response){
			
			return response.data;
			
		});
		
		return agencyList;
	}
	this.editAgency = function(agencyObj){
		
		
		agency.agencyId = agencyObj.agencyId;
		agency.agencyName = agencyObj.agencyName;
		agency.ownerName = 	agencyObj.ownerName;
		agency.addressLine1 = agencyObj.address.addressLine1
		agency.addressLine2 = agencyObj.address.addressLine2
		agency.city = agencyObj.address.city
		agency.state = agencyObj.address.state
		agency.agencySupervisor = agencyObj.agencySupervisor;
		agency.mobileNumber = agencyObj.mobileNumber;
		agency.alternateNumber = agencyObj.alternateNumber;
		agency.addressId = agencyObj.address.addressId;
		agency.email = agencyObj.email;
	    
		
		
		return agency;
	}
	
	this.deleteAgency = function(agency){
		
		var url=  '../../../agency/deleteAgency';
		agencyList =  $http.put(url,agency).then(function(response){
			return response.data;
		});
		return agencyList;
	}
	
	this.getAllAgencyList = function(){
		var url=  '../../../agency/getAgencyList';
		agencyList =  $http.get(url).then(function(response){
			return response.data;
		});
		
		return agencyList;
	}
	
	
});

globalMod.controller('retailerCtrl',function($scope,retailerService){

	var globalScope = angular.element(document.getElementById('mainBody')).scope();
	retailerService.getRetailerList().then(function(data){
		$scope.retailerList = data;
	});
	$scope.saveRetailer = function(){
		var mobileNum = $scope.retailer.mobileNumber;
		if(mobileNum.length==10){
			retailerService.saveRetailer($scope.retailer).then(function(data){
				
				$scope.addRetailerInfo = !$scope.addRetailerInfo;
				$scope.retailerList = data;
			});	
			
		}
	}
	
	$scope.addRetailer = function(){
		var retailer = {};
		retailer.retailerId = null;
		retailer.retailerFName = "";
		retailer.retailerLName = "";
		retailer.retailerPanNumber = 	"";
		retailer.addressLine1 = "";
		retailer.addressLine2 = "";
		retailer.city = "";
		retailer.state = "";
		retailer.mobileNumber = "";
		retailer.alternateNumber = "";
		retailer.addressId = null;
		retailer.email="";
		$scope.retailer = retailer;
	}
	$scope.editRetailer = function(retailer){
		
		$scope.retailer = retailerService.editRetailer(retailer);
		$scope.addRetailerInfo = true;
			
	}
	$scope.deleteRetailer = function(retailer){
		
		retailerService.deleteRetailer(retailer).then(function(data){
			$scope.retailerList = data;
		});	
	}
	
});


globalMod.service('retailerService',function($http){
	
	var retailerList = null;
	var retailer = {};
	this.getRetailerList = function(){
		
		return this.getAllRetailerList();
	}
	this.setRetailerList = function(retailerList){
		
		this.retailerList = retailerList;
	}
	
	this.getRetailer = function(){
		return retailer;
	}
	
	this.setRetailer = function(retailer){
		
		this.retailer = retailer;
	}
	
	
	this.saveRetailer = function(retailer){
		
		var url = '../../../retailer/saveRetailer';
		retailerList =  $http.put(url,retailer).then(function(response){
			
			return response.data;
			
		});
		return retailerList;
		
	}
	this.editRetailer = function(retailerObj){
		
		retailer.retailerId = retailerObj.retailerId;
		retailer.retailerFName = retailerObj.retailerFirstName;
		retailer.retailerLName = retailerObj.retailerLastName;
		retailer.retailerPanNumber = retailerObj.retailerPanNumber;
		retailer.addressLine1 = retailerObj.address.addressLine1;
		retailer.addressLine2 = retailerObj.address.addressLine1;
		retailer.city = retailerObj.address.city;
		retailer.state = retailerObj.address.state;
		retailer.mobileNumber = retailerObj.mobileNumber;
		retailer.alternateNumber = retailerObj.alternateNumber;
		retailer.addressId = retailerObj.address.addressId;
		retailer.email = retailerObj.email;
		return retailer;
	}
	
	this.deleteRetailer = function(retailer){
		
		var url=  '../../../retailer/deleteRetailer';
		retailerList =  $http.put(url,retailer).then(function(response){
			return response.data;
		});
		return retailerList;
	}
	this.getAllRetailerList = function(){
		
		var url = '../../../retailer/getRetailerList';
		retailerList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return retailerList;
		
	}
	
	this.getRetailerListBySearchTerm = function(searchKey){
		
		var url = '../../../retailer/getSerchedRetailerList?searchKey='+searchKey;
		var searchedRetailerList =  $http.get(url).then(function(response){
			
			var orderScope = angular.element(document.getElementById('fmsSaleOrder')).scope();
			orderScope.retailer = null;
			orderScope.validateRetailer = false;
			$("#selectRetailer").attr('checked', false);
			return response.data;
			
		});
		return searchedRetailerList;
	};
	
	
})
globalMod.config(['$routeProvider',
                  function($routeProvider,$locationProvider,$analyticsProvider) {
                    $routeProvider.
                      when('/agency', {
                        templateUrl: '../../html/fms/agency.html',
                        controller: 'agencyCtrl'
                      }).
                      when('/retailer', {
                        templateUrl: '../../html/fms/retailer.html',
                        controller: 'retailerCtrl'
                      }).
                      when('/products', {
                          templateUrl: '../../html/fms/products.html',
                          controller: 'productsCtrl'
                        }).
                     when('/inventory', {
                            templateUrl: '../../html/fms/updateStock.html',
                            controller: 'inventoryCtrl'
                          }).  
                     when('/user', {
                              templateUrl: '../../html/fms/users.html',
                              controller: 'userCtrl'
                            }).  
                     when('/saleOrder', {
                                templateUrl: '../../html/fms/salesOrder.html',
                                controller: 'saleOrderCtrl'
                              }).         
                     when('/reports', {
                                  templateUrl: '../../html/fms/report.html',
                                  controller: 'reportCtrl'
                              }). 
                        
                      otherwise({
                        redirectTo: '/inventory'
                      });
                      
}]);


globalMod.controller('productsCtrl',function($scope,agencyService,productsService){
	
	 productsService.getProductTypeList().then(function(data){
			$scope.productTypeList = data;
		});
	
    productsService.getProductList().then(function(data){
		$scope.productList = data;
	});
    agencyService.getAgencyList().then(function(data){
		$scope.agencyList = data;
	});
    
    $scope.addProduct = function(){
    	var product = {};
    	product.productId = null;
    	product.agencyId = null;
    	product.productName = "";
    	product.productTypeId=null;
    	$scope.product = product;
    }
    
    $scope.editProduct = function(product){
		
		$scope.product = productsService.editProduct(product);
		$scope.addProductInfo = true;
			
	}
	$scope.deleteProduct = function(product){
		
		productsService.deleteProduct(product).then(function(data){
			$scope.productList = data;
		});	
	}
	
    $scope.saveProduct = function(){
    	
    	if($scope.product.agencyId==undefined || $scope.product.agencyId==""){
    		
    		console.log("no agency");
    	}
    	else{
    		
    		productsService.saveProduct($scope.product).then(function(data){
    			
    			$scope.addProductInfo = !$scope.addProductInfo;
    			$scope.productList = data;
    		});	
    	}
    		
    		
        	
    }
    
    
	var globalScope = angular.element(document.getElementById('mainBody')).scope();
	document.getElementById('products').className ="active"
});

globalMod.service('productsService',function($http){
	
	var productList = null;
	var product = {};
	var productTypeList=null;
	this.getProductList = function(){
		
		return this.getAllProductsList();
	}
	this.setProductList = function(productList){
		
		this.productList = productList;
	}
	
	this.getProduct = function(){
		return product;
	}
	
	this.setProduct = function(product){
		
		this.product = product;
	}
	
	this.editProduct = function(productObj){
		
		product.agencyId = productObj.agencyId;
    	product.productName = productObj.productName;
    	product.productId = productObj.productId;
    	product.productTypeId = productObj.typeId;
    	
		return product;
	}
	
	this.deleteProduct = function(product){
		
		var url=  '../../../product/deleteProduct';
		productList =  $http.put(url,product).then(function(response){
			return response.data;
		});
		return productList;
	}
	this.saveProduct = function(product){
		
		var url = '../../../product/saveProduct';
		productList =  $http.put(url,product).then(function(response){
			
			return response.data;
			
		});
		return productList;
		
	}
	this.getAllProductsList = function(){
		
		var url = '../../../product/getProductList';
		productList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return productList;
		
	}
	
	this.getProductListByAgencyId = function(agencyId){
		
		var url = '../../../product/getProductListByAgencyId';
		productList =  $http.put(url,agencyId).then(function(response){
			
			return response.data;
			
		});
		return productList;
		
	}
	
	this.getProductTypeList = function(){
		
		var url = '../../../product/getProductTypeList';
		productTypeList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return productTypeList;
		
	}
	
})


/*globalMod.directive('menuClick',function(MenuService,$location){
	return{
		restrict: 'A',
		link:function(scope, element, attrs){
			element.on('click',function(e){
				MenuService.setSelectedMenu(e.target.id);
				scope.menuItem = MenuService.getSelectedMenu();
				e.target.className='select';
				var globalScope = angular.element(document.getElementById('mainBody')).scope();
				globalScope.menuName = MenuService.getMenuName();
				console.log(MenuService.getMenuName());
				$location.path( "/"+globalScope.menuName);
				globalScope.apply(function () {
					$location.path( "/"+globalScope.menuName);
				});
			});
		}
	};
});*/

globalMod.controller('inventoryCtrl',function($scope,agencyService,productsService,inventoryService){

    
	  $scope.opened = false;
		//Datepicker
		$scope.dateOptions = {
			'year-format': "'yy'",
			'show-weeks' : false
		};
    
    agencyService.getAgencyList().then(function(data){
		$scope.agencyList = data;
	});
    
    inventoryService.getStockList().then(function(data){
		$scope.stockList = data;
	});
    
    $scope.populateProduct= function(){
    	var agencyId ;
    	if($scope.compType==1){
    		agencyId = $scope.stock.agencyId;
    	}
    	else{
    		agencyId = $scope.stock.medicineAgencyId;
    	}
    	if(agencyId!=undefined && agencyId!=null){
    		
    		productsService.getProductListByAgencyId(agencyId).then(function(data){
        		$scope.productList = data;
        	});
    	}
    	
    }
    $scope.addStock =  function(){
    	$scope.qunatityToAdd = "";
		$scope.qunatityToRemove = 0;
    	var stock = {};
    	stock.agencyId = null;
    	stock.productId = null;
    	stock.quantity = 0;
    	stock.costPrice = "";
    	stock.sellingPrice = "";
    	stock.arrivalDate= "";
    	$scope.stock = stock;
    }
    $scope.editStock = function(stock){
    	
    	productsService.getProductListByAgencyId(stock.agencyId).then(function(data){
    		$scope.productList = data;
    	});
		
    	$scope.qunatityToAdd = "";
		$scope.qunatityToRemove = "";
		$scope.stock = inventoryService.editStock(stock);
		$scope.addStockInfo = true;
		$scope.editStockInfo = true;
		
    } 
    
    $scope.saveProductStock = function(){
    	
    	if($scope.stock.agencyId==undefined || $scope.stock.productId==""){
    		
    		console.log("no agency");
    	}
    	else{
    		
    		if($scope.quantityToRemove==undefined || $scope.quantityToRemove==" "){
    			$scope.quantityToRemove = 0;
    		}
    		if($scope.quantityToAdd==undefined || $scope.quantityToAdd==" "){
    			$scope.quantityToAdd = 0;
    		}
    		$scope.stock.quantity= parseInt($scope.stock.quantity)+parseInt($scope.quantityToAdd)-parseInt($scope.quantityToRemove);
    		inventoryService.saveProductStock($scope.stock).then(function(data){
    			
    			$scope.addStockInfo = !$scope.addStockInfo;
    			$scope.stockList = data;
    		});	
    	}
    		
    		
        	
    }
    
    
});

globalMod.service('inventoryService',function($http){
	
	var productList = null;
	var stock = {};
	this.getStockList = function(){
		
		var url = '../../../stock/getStockList';
		stockList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return stockList;
	}
	this.setStockList = function(stockList){
		
		this.stockList = stockList;
	}
	
	this.getStock = function(){
		return stock;
	}
	
	this.setStock = function(stock){
		
		this.stock = stock;
	}
	
	this.editStock = function(stockObj){
		
		stock.agencyId = stockObj.agencyId;
    	stock.productId = stockObj.productId;
    	stock.quantity = stockObj.quantity;
    	stock.costPrice = stockObj.costPrice;
    	stock.sellingPrice = stockObj.sellingPrice;
    	stock.arrivalDate= stockObj.arrivalDate;
    	stock.productStockId = stockObj.productStockId;
    	
		return stock;
	}
	
	this.saveProductStock = function(stock){
		
		var url = '../../../stock/saveStock';
		stock.costPrice = parseFloat(stock.costPrice);
		stock.sellingPrice = parseFloat(stock.sellingPrice);
		stockList =  $http.put(url,stock).then(function(response){
			
			return response.data;
			
		});
		return stockList;
	}
	
	this.getStockListBySearchTerm = function(productSearchKey){
		var url = '../../../stock/getProductList?prodSearchKey='+productSearchKey;
		var serachedList = $http.get(url).then(function(response){
			var orderScope = angular.element(document.getElementById('fmsSaleOrder')).scope();
			orderScope.product = {};
			orderScope.isProductAdded = true;
			return response.data;
			
		});
		return serachedList;
	};
	
});

globalMod.controller('userCtrl',function($scope,userService){
	
	userService.getUserRoleList().then(function(data){
		$scope.userRoleList = data;
	});
	
	userService.getUserList().then(function(data){
		$scope.userList = data;
	});
	
	 $scope.addUser =  function(){
	    	var user = {};
	    	user.mobileNumber = "";
	    	user.userFirstName = "";
	    	user.userLastName = "";
	    	user.userEmail = "";
	    	user.password = "";
	    	user.userTypeId = null;
	    	$scope.user = user;
	    }
	
	$scope.saveUser =  function(){
		userService.saveUser($scope.user).then(function(data){
			
			$scope.addUserInfo = !$scope.addUserInfo;
			$scope.userList = data;
		});	
	}
	
	 $scope.editUser = function(user){
		 
		 $scope.user = userService.editUser(user);
		 $scope.addUserInfo = true;
	    	
	 } 

});

globalMod.service('userService',function($http){
	
	var userRoleList = null;
	
	var userList = null;
	var user = {};
	this.getUserList = function(){
		
		var url = '../../../user/getUserList';
		userList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return userList;
	}
	this.setUserList = function(userList){
		
		this.userList = userList;
	}
	
	this.getUser = function(){
		return user;
	}
	
	this.setUser = function(user){
		
		this.user = user;
	}
	
	this.editUser = function(userObj){
		
		
		user.mobileNumber = userObj.mobileNumber;
    	user.userFirstName = userObj.userFirstName;
    	user.userLastName = userObj.userLastName;
    	user.userEmail = userObj.userEmail;
    	user.password = userObj.password;
    	user.userTypeId = userObj.userTypeId;
		
    	
		return user;
	}
	
	this.saveUser = function(user){
		
		var url = '../../../user/saveUser';
		userList =  $http.put(url,user).then(function(response){
			
			return response.data;
			
		});
		return userList;
	}
	
	this.getUserRoleList = function(){
		
		var url = '../../../user/getUserRoleList';
		userRoleList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return userRoleList;
	}
	
	
});

globalMod.controller('saleOrderCtrl',function($scope,inventoryService,retailerService,orderService){

	orderService.getGeneratedOrderList().then(function(data){
		$scope.generatedOrderList = data;
	});
	
	$scope.isProductAdded = true;
	$scope.product = orderService.getSearchedProduct();
	
	$scope.selectedProductList = [];
	$scope.addThisProduct = function(product){
		//sessionStorage.setItem("selectedProduct",JSON.stringify(product));
		document.getElementById('infoDiv').style.display='none';
		for (var i = $scope.selectedProductList.length - 1; i >= 0; i--) {
		    var obj = $scope.selectedProductList[i];

		    if (product.productStockId==obj.stockId) {
		    	$scope.selectedProductList.splice(i, 1);
		    }
		}
		var selectedProduct = {};
		selectedProduct.stockId = product.productStockId;
		selectedProduct.productName = product.productDetail.productName;
		selectedProduct.orderedQuantity = product.orderedQuantity;
		selectedProduct.price = product.price;
		selectedProduct.availableQuantity = product.quantity;
		selectedProduct.sellingPrice = product.sellingPrice;
		selectedProduct.productType = product.productDetail.productType.typeDesc;
		$scope.selectedProductList.push(selectedProduct);
		$scope.showOrderDetails=true;
		calculateTotalPrice();
	}
	$scope.deleteThisProduct = function(selectedProduct){
		
		for (var i = $scope.selectedProductList.length - 1; i >= 0; i--) {
		    var obj = $scope.selectedProductList[i];

		    if (selectedProduct.stockId==obj.stockId) {
		    	$scope.selectedProductList.splice(i, 1);
		    }
		}
		if($scope.selectedProductList.length==0){
			$scope.showOrderDetails=false;
		}
		calculateTotalPrice();
	};
	$scope.validate = false;
	$scope.calculatePrice = function(selectedProduct){
		if(selectedProduct.orderedQuantity == null || selectedProduct.orderedQuantity == undefined || selectedProduct.orderedQuantity == ""){
			selectedProduct.price = 0;
			$scope.isProductAdded = true;
		}else{
			selectedProduct.price = selectedProduct.sellingPrice*parseFloat(selectedProduct.orderedQuantity);
			$scope.isProductAdded = false;
			if(selectedProduct.orderedQuantity > selectedProduct.quantity){
				$scope.validate = true;
			}else{
				$scope.validate = false;
			}
			
		}
		calculateTotalPrice();
	}
	function calculateTotalPrice(){
		$scope.totalPrice = 0;
		for (var i = 0; i < $scope.selectedProductList.length; i++) {
			var obj = $scope.selectedProductList[i];
			$scope.totalPrice = $scope.totalPrice+obj.price;
		}
	}
	
	$scope.continueToRetailer = function(){
		//$("#retailerInfo").slideToggle();
		sessionStorage.setItem("selectedProductList",JSON.stringify($scope.selectedProductList));
		sessionStorage.setItem("totalPrice",$scope.totalPrice);
	};
	
	$scope.saveRetailer = function(retailer){
		
		if(retailer==null || retailer== undefined ){
			$scope.validateRetailer = false;
		}else{
			
			if($("#selectRetailer").is(":checked")){
				sessionStorage.setItem("selectedRetailer",JSON.stringify(retailer));
				$scope.retailerName = retailer.retailerFirstName+" "+retailer.retailerLastName;
				$scope.validateRetailer = true;
			}
			else{
				$scope.validateRetailer = false;
			}
			
		}
		
		
	};
	
	$scope.continueToPayment =  function(){
		
		var order = {};
		order.shippingFee = 0;
		order.labourFee = 0;
		order.orderTotalPrice  = $scope.totalPrice;
		order.orderPrice = $scope.totalPrice;
		$scope.order = order;
		orderService.setOrder(order);
	};
	 
	
	$scope.calcOrderPriceWithLabour = function(){
		
		$scope.order.orderTotalPrice = $scope.order.orderTotalPrice+parseFloat($scope.order.labourFee);
	};
	
	$scope.calcOrderPriceWithShipping = function(){
		$scope.order.orderTotalPrice = $scope.order.orderTotalPrice+parseFloat($scope.order.shippingFee);
	};
	
	$scope.saveOrderDetails = function(){
		orderService.saveOrderDetails($scope.order,$scope.transaction);
	};
	$scope.showProductDetails = function(orderedProduct){
		
		orderService.getPopup("product",orderedProduct);
		
	}
	$scope.showPaymentDetails = function(transactions,order){
		
		$scope.paymentList = transactions;
		orderService.getPopup("payment",transactions);
		$scope.payorderId= order.orderId;
		
		
	}
	$scope.hidePopup = function(){
		orderService.hidePopup();
		
	}
	$scope.updatePayment = function(){
		var details = {};
		details.payorderId = $scope.payorderId;
		var globalScope = angular.element(document.getElementById('mainBody')).scope();
		orderService.getOrderByOrderId($scope.payorderId).then(function(data){
			details.pendingorderPrice = data.pendingAmount;
			orderService.getTransaction();
			orderService.getPopup("updatePayment",details)
		})
		/*.then(function(data){
			globalScope.transaction.amountPaid = details.payorderPrice;
		})*/;
	}
	
	$scope.update = function(){
		
		if($scope.transaction.amountPaid!=null || $scope.transaction.amountPaid!=""){
			
			orderService.updateOrderPayment($scope.transaction,$scope.payorderId).then(function(data){
				$scope.paymentList = data;
				orderService.getPopup("payment",data);
			});
			
		}
	}
	$scope.cancelOrder = function(orderId){
		orderService.cancelOrder(orderId).then(function(data){
			$scope.generatedOrderList = data;
		});	
	}
	
});

globalMod.service('orderService',function($http,LoadConf){
	
	var order = {};
	var orderList = null;
	var productList = null;
	var searchedProduct = {};
	this.getOrder = function(){
		return order;
	}
	
	this.setOrder = function(order){
		
		this.order = order;
	}
	var transaction = {};
	
	this.getTransaction = function(){
		transaction.amountPaid = 0;
		transaction.transactionDate="";
		transaction.transactionId="";
		transaction.bankName="";
		return transaction;
	}
	
	this.setTransaction = function(transaction){
		
		this.transaction = transaction;
	};
	this.setSearchedProduct = function(product){
		this.searchedProduct = product;
		var orderScope = angular.element(document.getElementById('fmsSaleOrder')).scope();
		orderScope.product = product;
		document.getElementById('infoDiv').style.display='block';
		orderScope.$apply();
	};
	
	this.getSearchedProduct = function(){
		
		return searchedProduct;
	}
	
	this.setSearchedRetailer = function(retailer){
		var orderScope = angular.element(document.getElementById('fmsSaleOrder')).scope();
		orderScope.retailer = retailer;
		orderScope.$apply();
	};
	
	
	this.saveOrderDetails = function(order,transaction){
		
		var selectedProductList = JSON.parse(sessionStorage.getItem('selectedProductList'));
		var orderedProductList = [];
		for (var i = 0; i < selectedProductList.length; i++) {
			var product = selectedProductList[i];
			var orderedProduct = {};
			orderedProduct.stockId = product.stockId;
			orderedProduct.quantity = product.orderedQuantity;
			orderedProduct.price = product.price;
			orderedProductList.push(orderedProduct);
		}
		var selectedRetailer = JSON.parse(sessionStorage.getItem('selectedRetailer'));
		
		order.retailerId = parseInt(selectedRetailer.retailerId);
		var orderDetails = {};
		orderDetails.order = order;
		orderDetails.orderedProductList = orderedProductList;
		var self  = this;
		var url = '../../../order/saveOrderDetails';
		$http.put(url,orderDetails).then(function(response){
			
			if(response.status==200){
				self.getPopup('order',null);
				console.log("Your Orders Generated Successfully");
		 	}
		 	/*else{
		 		$window.location.href = "../../"+data.status;
		 	}*/
			
		});
	}
	
	this.getGeneratedOrderList = function(){
		
		var url = '../../../order/getOrderDetailsList';
		orderList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return orderList;
	}
	
	this.setGeneratedOrderList = function(orderList){
		
		this.orderList = orderList;
	}
	
	this.getOrderByOrderId = function(orderId){
		
		var url = '../../../order/getOrderByOrderId/'+orderId;
		order =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return order;
	}
	
	this.getPaymentDetails = function(orderId){
		
		var url =  '../../../order/getPaymentDetails/'+orderId;
		var paymnetDetails =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return paymnetDetails;
	}
	this.getPopup = function(popupType,details){
		var orderScope = angular.element(document.getElementById('fmsSaleOrder')).scope();
		LoadConf.setPopupType().then(function(data){
			orderScope.popupType = popupType;
			orderScope.content = data.popup[popupType];
			LoadConf.showPopup();
			if(popupType=='product'){
				orderScope.productList = details;
			}
			else if(popupType=='payment'){
				if(details.length==0){
					orderScope.payment = false;
					
				}else{
					orderScope.payment = true;
					orderScope.paymentList = details;
				}
				
			}else{
				
				orderScope.pendingAmount = details.pendingorderPrice;
			}
			
			
		});
		return 1;
	}
	this.hidePopup = function(){
		LoadConf.hidePopup();
	}
	
	this.updateOrderPayment = function(transaction,orderId){
		
		var url =  '../../../order/savePaymentDetails/';
		transaction.orderId = orderId
		var paymnetList =  $http.put(url,transaction).then(function(response){
			
			return response.data;
			
		});
		return paymnetList;
	}
	
	this.cancelOrder = function(orderId){
		
		var url = '../../../order/cancelOrderByOrderId/'+orderId;
		orderList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return orderList;
	}
	
	
});

globalMod.service('LoadConf',function($http,$q) {
	this.showPopup = function(){
    	document.getElementById('loadOverlay').style.display = 'block';
    	document.getElementById('loadingCon').style.display = 'block';
	};
	this.hidePopup = function(){
		document.getElementById('loadOverlay').style.display = 'none';
    	document.getElementById('loadingCon').style.display = 'none';
	};
	this.setPopupType = function() {
		var defer = $q.defer();
		$http.get("../../js/popupText.json")
		.success(function(data) {
            defer.resolve(data);
		});
			return defer.promise;
		
	};
});	


globalMod.controller('reportCtrl',function($scope,reportService){
	
	
	 $scope.downloadReport = function(){
		 
		 reportService.downloadReport(user);
	 } 
	 

});

globalMod.service('reportService',function($http){
	
	this.downloadReport = function(){
		
		var url = '../../../report/fms/orderReport';
		
		  $http({
	            url: url,
	            method: "POST",
	            data: null, //this is your json data string
	            headers: {
	               'Content-type': 'application/json'
	            },
	            responseType: 'arraybuffer'
	        }).success(function (data, status, headers, config) {
	            var blob = new Blob([data], {type: "application/vnd.ms-excel"});
	            var objectUrl = URL.createObjectURL(blob);
	            window.open(objectUrl);
	        }).error(function (data, status, headers, config) {
	            console.log('Failed to download Excel')
	        });
	}
});
	






