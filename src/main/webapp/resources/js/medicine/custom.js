var globalMod = angular.module("globalMod", ['ngRoute','UIMod','angularUtils.directives.dirPagination','loginMod','ui.bootstrap','angulartics', 'angulartics.google.analytics']);

globalMod.controller('globalCtrl',function($scope,sessionService){

	var session = JSON.parse(sessionStorage.getItem("session"));
	$scope.userName = session.userName;
	$scope.role = session.userRole;
	$scope.compType = session.compType;
	//$scope.popupType = "product";
	$scope.isAdmin = false;
	if($scope.role=='Admin'){
		$scope.isAdmin = !$scope.isAdmin;
	}
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
	
	agencyService.getAgencyList().then(function(data){
		$scope.agencyList = data;
	});
	
	//globalScope.Title = "Agency";
	document.getElementById('agency').className ="active";
	$scope.saveAgency = function(){
		var mobileNum = $scope.agency.contactNumber;
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
		agency.agencyEmail = 	"";
		agency.address = "";
		agency.contactNumber = "";
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
	
	 $scope.sort = function(keyname){
	        $scope.sortKey = keyname;   //set the sortKey to the param passed
	        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
	  }
	
});


globalMod.service('agencyService',function($http,$q){
	
	var agencyList = null;	
	var agency = {};
	this.getAgencyList = function(){
		
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
		
		
		var url=  '../../../medicine/agency/saveAgency';
		agency = JSON.stringify(agency);
		agencyList =  $http.put(url,agency).then(function(response){
			
			return response.data;
			
		});
		
		return agencyList;
	}
	this.editAgency = function(agencyObj){
		
		
		agency.agencyId = agencyObj.agencyId;
		agency.agencyName = agencyObj.agencyName;
		agency.agencyEmail = 	agencyObj.agencyEmail;
		agency.address = agencyObj.address
		agency.contactNumber = agencyObj.contactNumber;
		
		return agency;
	}
	
	this.deleteAgency = function(agency){
		
		var url=  '../../../medicine/agency/deleteAgency';
		agencyList =  $http.put(url,agency).then(function(response){
			return response.data;
		});
		return agencyList;
	}
	
	this.getAllAgencyList = function(){
		var url=  '../../../medicine/agency/getAgencyList';
		agencyList =  $http.get(url).then(function(response){
			return response.data;
		});
		
		return agencyList;
	}
	
	
});


globalMod.config(['$routeProvider',
                  function($routeProvider,$locationProvider,$analyticsProvider) {
                    $routeProvider.
                      when('/MedAgency', {
                        templateUrl: '../../html/medicine/agency.html',
                        controller: 'agencyCtrl'
                      }).
                      when('/MedProducts', {
                          templateUrl: '../../html/fms/products.html',
                          controller: 'productsCtrl'
                        }).
                        when('/MedHome', {
                            templateUrl: '../../html/medicine/salesOrder.html',
                            controller: 'saleOrderCtrl'
                          }).
                      when('/MedInventory', {
                          templateUrl: '../../html/fms/updateStock.html',
                          controller: 'inventoryCtrl'
                        }).
                        when('/MedReports', {
                            templateUrl: '../../html/fms/report.html',
                            controller: 'reportCtrl'
                        }). 
                          
                        
                      otherwise({
                        redirectTo: '/MedHome'
                      });
                      
}]);


globalMod.controller('productsCtrl',function($scope,agencyService,productsService){  
    
    productsService.getProductList().then(function(data){
		$scope.productList = data;
	});
    
    productsService.getProductTypeList().then(function(data){
    	$scope.productTypeList = data;
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
	var typeList = null;
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
		
	};
	
	this.getProductTypeList = function(){
		
		var url = '../../../product/getProductTypeList';
		typeList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return typeList;
		
	};
	
	this.getProductListByAgencyId = function(agencyId){
		
		var url = '../../../product/getProductListByAgencyId';
		productList =  $http.put(url,agencyId).then(function(response){
			
			return response.data;
			
		});
		return productList;
		
	};
	
	
	
});

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
    	if(agencyId!=undefined && agencyId!=null ){
    		
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
    	
    	if(($scope.stock.agencyId==undefined && $scope.stock.medicineAgencyId == undefined) || $scope.stock.productId==""){
    		
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
    		
    		
        	
    };
    
    $scope.deleteStock = function(stock){
    	
    	inventoryService.deleteStock(stock).then(function(data){
			$scope.stockList = data;
		});	
    };
    
    
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
	};
	
	this.getStockListBySearchTerm = function(productSearchKey){
		var url = '../../../stock/getProductList?prodSearchKey='+productSearchKey;
		var serachedList = $http.get(url).then(function(response){
			
			var orderScope = angular.element(document.getElementById('saleOrder')).scope();
			orderScope.product = {};
			orderScope.isProductAdded = true;
			return response.data;
			
		});
		return serachedList;
	};
	
	this.deleteStock = function(stock){
		
		var url = '../../../stock/deleteStock';
		stockList =  $http.put(url,stock).then(function(response){
			return response.data;
		});
		return stockList;
		
	}
	
});



globalMod.controller('saleOrderCtrl',function($scope,inventoryService,orderService){

	$scope.isProductAdded = true;
	
	orderService.getGeneratedOrderList().then(function(data){
		$scope.generatedOrderList = data;
	});
	
		
	$scope.product = orderService.getSearchedProduct();
	
	orderService.getOrderNumber().then(function(data){
		$scope.billNumber = data;
	});
	
	
	
	$scope.selectedProductList = [];
	$scope.addThisProduct = function(product){
		//sessionStorage.setItem("selectedProduct",JSON.stringify(product));
		for (var i = $scope.selectedProductList.length - 1; i >= 0; i--) {
		    var obj = $scope.selectedProductList[i];

		    if (product.stockId==obj.stockId) {
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
	}
	$scope.validate = false;
	$scope.calculatePrice = function(selectedProduct){
		if(selectedProduct.orderedQuantity == null || selectedProduct.orderedQuantity == undefined || selectedProduct.orderedQuantity == " "){
			selectedProduct.price = 0;
			$scope.isProductAdded = true;
		}else{
			selectedProduct.price = selectedProduct.sellingPrice*parseFloat(selectedProduct.orderedQuantity);
			$scope.isProductAdded = false;
			if(selectedProduct.orderedQuantity > selectedProduct.availableQuantity){
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
	
	$scope.continueToCustomer = function(){
		//$("#retailerInfo").slideToggle();
		sessionStorage.setItem("selectedProductList",JSON.stringify($scope.selectedProductList));
		sessionStorage.setItem("totalPrice",$scope.totalPrice);
		var order = {};
		order.discountPercentage = 0;
		order.orderTotalPrice  = $scope.totalPrice;
		order.orderPrice = $scope.totalPrice;
		order.billNumber = $scope.billNumber;
		$scope.order = order;
		orderService.setOrder(order);
	};
	
	
	$scope.calcOrderPriceWithDiscount = function(){
		
		$scope.order.orderTotalPrice = $scope.order.orderPrice- $scope.order.orderPrice*parseFloat($scope.order.discountPercentage)/100;
	};
	
	/*$scope.calcOrderPriceWithTax = function(){
		$scope.order.orderTotalPrice = $scope.order.orderTotalPrice+parseFloat($scope.order.shippingFee);
	}*/
	$scope.calcBalanceAmnt = function(){
		$scope.order.balanceAmount = parseFloat($scope.order.orderTotalPrice)-parseFloat($scope.order.payment);
	}
	$scope.saveOrderDetails = function(){
		orderService.saveOrderDetails($scope.order,$scope.transaction);
	}
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
		.then(function(data){
			globalScope.transaction.amountPaid = details.payorderPrice;
		});
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
	};
	
});

globalMod.service('orderService',function($http,LoadConf){
	
	var order = {};
	var orderList = null;
	var productList = null;
	var orderNumber;
	var searchedProduct = {};
	var transaction = {};
	this.getOrder = function(){
		return order;
	}
	
	this.setOrder = function(order){
		
		this.order = order;
	};
	
	this.setSearchedProduct = function(product){
		this.searchedProduct = product;
		var orderScope = angular.element(document.getElementById('saleOrder')).scope();
		orderScope.product = product;
		orderScope.$apply();
	};
	
	this.getSearchedProduct = function(){
		
		return searchedProduct;
	}
	
	
	this.getTransaction = function(){
		transaction.amountPaid = 0;
		transaction.transactionDate="";
		transaction.transactionId="";
		transaction.bankName="";
		return transaction;
	};
	
	this.setTransaction = function(transaction){
		
		this.transaction = transaction;
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
		
		var orderDetails = {};
		orderDetails.order = order;
		orderDetails.orderedProductList = orderedProductList;
		
		var url = '../../../medicine/order/saveOrderDetails';
		$http.put(url,orderDetails).then(function(response){
			
			if(response.status==200){
				//alert("Your Orders Generated Successfully.")
				this.getPopup('order',null);
				console.log("Your Orders Generated Successfully");
		 	}
		 	/*else{
		 		$window.location.href = "../../"+data.status;
		 	}*/
			
		});
	}
	
	this.getOrderNumber = function(){
		
		var url = '../../../medicine/order/getOrderNumber';
		orderNumber =  $http.get(url).then(function(response){
			
			return response.data.orderNum;
			
		});
		return orderNumber;
	}
	
	this.setOrderNumber = function(orderNumber){
		
		this.orderNumber = orderNumber;
	};
	
	this.getGeneratedOrderList = function(){
		
		var url = '../../../medicine/order/getOrderDetailsList';
		orderList =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return orderList;
	}
	
	this.setGeneratedOrderList = function(orderList){
		
		this.orderList = orderList;
	}
	
	this.getOrderByOrderId = function(orderId){
		
		var url = '../../../medicine/order/getOrderByOrderId/'+orderId;
		order =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return order;
	}
	
	this.getPaymentDetails = function(orderId){
		
		var url =  '../../../medicine/order/getPaymentDetails/'+orderId;
		var paymnetDetails =  $http.get(url).then(function(response){
			
			return response.data;
			
		});
		return paymnetDetails;
	};
	this.getPopup = function(popupType,details){
		var orderScope = angular.element(document.getElementById('mainBody')).scope();
		
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



var UIMod = angular.module("UIMod", []);

UIMod.directive('textBox',function(){
	return{
		restrict:"E",
		scope: {
            ngModel: '='
        },
        template: '<div><input type="text" ng-model="ngModel" placeholder="Mobile Number" class="form-control" numbers-only="numbers-only" maxlength="10" required></div>', 
	}
})
UIMod.directive('numbersOnly', function(){
	   return {
	     require: 'ngModel',
	     link: function(scope, element, attrs, modelCtrl) {
	       modelCtrl.$parsers.push(function (inputValue) {
	    	   
	           // this next if is necessary for when using ng-required on your input. 
	           // In such cases, when a letter is typed first, this parser will be called
	           // again, and the 2nd time, the value will be undefined
	           if (inputValue == undefined) return '' 
	           var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
	           if (transformedInput!=inputValue) {
	              modelCtrl.$setViewValue(transformedInput);
	              modelCtrl.$render();
	           }         

	           return transformedInput;         
	       });
	       element.on('onfocusout',function(e){
	    	   document.getElementById('errorDiv').style.display='none';
	    	   document.getElementById('mobileDiv').style.display='none';
	       });
	     }
	   };
	});


UIMod.directive('logoFms',function(){
	return{
		restrict:"E",
		template:'<div class="">'
			  				+'<div class="header-logo">'+
			  				'<a href="#"  class="navbar-brand" title="Prasad Fertilizer"><img src="../images/tree-logo.jpg" alt="Prasad Fertilizer" class="img-responsive"/></a>'+
			  				'</div> </div>'
			
			
	};
});