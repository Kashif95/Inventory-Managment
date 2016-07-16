var UIMod = angular.module("UIMod", []);

UIMod.directive('textBox',function(){
	return{
		restrict:"E",
		scope: {
            ngModel: '='
        },
        template: '<div><input type="text" ng-model="ngModel" placeholder="Mobile Number" class="form-control" numbers-only="numbers-only" name="mobileNumber" maxlength="10" autocomplete="off" required></div>', 
	};
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

UIMod.directive('autoComplete', function(inventoryService,orderService) {
    return {
    	   restrict: 'A',
    	   require: 'ngModel',
    	   link:  function(scope, elem, attr, ctrl) {
    		   elem.autocomplete({
                   source: function(searchTerm, response){
                	   inventoryService.getStockListBySearchTerm(searchTerm.term).then(function(data){
                			//var product =  JSON.stringify(data);
                		response($.map(data, function (value, key) {
                	                return {
                	                    label: value.productDetail.productName,
                	                    value: value
                	                }
                	            }));
                		});
                   },
                   minLength: 2,
                   focus: function(event, ui) {
                       $('#productSearch').val(ui.item.productName);
                       return false;
                   },
                   // Once a value in the drop down list is selected, do the following:
                  select: function(event, ui) {
                       // place the person.given_name value into the textfield called 'select_origin'...
                       $('#productSearch').val(ui.item.label);
                       // and place the person.id into the hidden textfield called 'link_origin_id'. 
                       $('#link_origin_id').val(ui.item.value);
                       orderService.setSearchedProduct(ui.item.value);
                           return false;
                   }
                  
               });
       }
    };
    
   
});

UIMod.directive('retailerComplete', function(retailerService,orderService) {
    return {
    	   restrict: 'A',
    	   require: 'ngModel',
    	   link:  function(scope, elem, attr, ctrl) {
    		   elem.autocomplete({
                   source: function(searchTerm, response){
                	   retailerService.getRetailerListBySearchTerm(searchTerm.term).then(function(data){
                			//var product =  JSON.stringify(data);
                		response($.map(data, function (value, key) {
                	                return {
                	                    label: value.retailerFirstName +" "+ value.retailerLastName ,
                	                    value: value
                	                }
                	            }));
                		});
                   },
                   minLength: 2,
                   focus: function(event, ui) {
                       $('#retailerSearch').val(ui.item.productName);
                       return false;
                   },
                   // Once a value in the drop down list is selected, do the following:
                  select: function(event, ui) {
                       // place the person.given_name value into the textfield called 'select_origin'...
                       $('#retailerSearch').val(ui.item.label);
                       // and place the person.id into the hidden textfield called 'link_origin_id'. 
                       orderService.setSearchedRetailer(ui.item.value);
                           return false;
                   }
                  
               });
       }
    };
    
   
});


UIMod.directive('logoFms',function(){
	return{
		restrict:"E",
		template:'<div class="">'
			  				+'<div class="header-logo">'+
			  				'<a href="#inventory"  class="navbar-brand" title="Prasad Fertilizer"><img src="../../images/tree-logo.jpg" alt="Prasad Fertilizer" class="img-responsive"/></a>'+
			  				'</div> </div>'
			
			
	};
});

UIMod.directive('datetimez', function() {
    return {
        restrict: 'A',
        require : 'ngModel',
        link: function(scope, element, attrs, ngModelCtrl) {
          element.datetimepicker({
           dateFormat:'dd-MM-yyyy',
           language: 'en',
           pickTime: false,
           startDate: '01-11-2013',      // set a minimum date
           endDate: '01-11-2030'          // set a maximum date
          }).on('changeDate', function(e) {
            ngModelCtrl.$setViewValue(e.date);
            scope.$apply();
          });
        }
    };
});

UIMod.directive("mydatepicker", function(){
	  return {
	    restrict: "E",
	    scope:{
	      ngModel: "=",
	      dateOptions: "=",
	      opened: "=",
	    },
	    link: function($scope, element, attrs,ngModelCtrl) {
	      $scope.open = function(event){
	        console.log("open");
	        event.preventDefault();
	        event.stopPropagation();
	        $scope.opened = true;
	      };

	      $scope.clear = function () {
	        $scope.ngModel = null;
	      };
	    },
	    templateUrl: 'datepicker.html'
	  }
	});
UIMod.directive('inputPrice', function () {
	return {
		require: 'ngModel',
	     link: function(scope, element, attrs, modelCtrl) {
	       modelCtrl.$parsers.push(function (inputValue) {
	    	   inputValue = inputValue.replace(/[^0-9]/g, ''); 
            scope.$watch(inputValue, function(newValue,oldValue) {
                if(String(newValue).indexOf(',') != -1)
                    scope.inputValue = String(newValue).replace(',', '.');
                else {
                    var index_dot,
                        arr = String(newValue).split("");
                    if (arr.length === 0) return;
                    if (arr.length === 1 && (arr[0] == '-' || arr[0] === '.')) return;
                    if (arr.length === 2 && newValue === '-.') return;
                    if (isNaN(newValue) || ((index_dot = String(newValue).indexOf('.')) != -1 && String(newValue).length - index_dot > 3 )) {
                        scope.inputValue = oldValue;
                    }
                }
                modelCtrl.$setViewValue(transformedInput);
	              modelCtrl.$render();
            });
	       });
		}
	};
});

UIMod.directive('phoneExist', function () {
	
	 return {
	      restrice: 'A',
	      require: 'ngModel',
			      link: function(scope, element, attrs, ctrl) {
			          angular.element(element).bind('blur', function() {
			        	  scope.phnValid = false; 
			          var phnNum = this.value;
			          if(phnNum!=null && phnNum != ''){
						      $.ajax({
								          url: '../../../user/getUserByphoneNum/'+phnNum,
								          dataType: 'application/json',
								          type: 'GET',
							
								     success: function( data, status, headers, cfg ){
									
								    	 	console.log("data " + textStatus);
							
								     },
								error: function( jqXHR, textStatus, errorThrown ){
									if(jqXHR.responseText==="TRUE"){
								        console.log("Valid mobile number. you can register now"); 
								        scope.phnValid=false;
								        scope.$apply();
								     }
								     else{
								        console.log("User with this number is already registered");
								        scope.phnValid=true;
								        scope.$apply();
							
								      }
									
								   }            
						  });  
			          }   
			
			 });
		}
	 }
});

UIMod.directive('loadPopup',function($compile){
		var productTemplate = '<div>'+
								'<div class = "popupCon">'+
									'<h1 class="popup_heading">{{content.header}}'+
									'</span></h1>'+
									 '<span class="poopup_content">'+
									 '<table   class="table table-striped table-hover">'+
									 '<tr>'+
	                    				 '<th>Agency Name</th>'+
	                    				 '<th >Product Name</th>'+
	                    				 '<th>Quantity</th>'+
	                    				 '<th>Price</th>'+
	                    			'</tr>'+
                    		 	    '<tr ng-repeat="product in productList">'+
                    		 		'<td ng-show="compType==1">{{product.productStock.agencyDetail.agencyName}}</td>'+
                    		 		'<td ng-show="compType==2">{{product.productStock.medicineAgencyDetail.agencyName}}</td>'+
                    		 		'<td>{{product.productStock.productDetail.productName}}</td>'+
                    		 		'<td>{{product.quantity}}</td>'+
                    		 		 '<td>{{product.price}}</td>'+
                    		 	
                    		 	    '</tr>'+
                    	'</table></span>'+
								 '</div>'+
								'<div class = "buttons pull-right">'+
								'<input type="button" class="btn btn-success" value="OK"  ng-click="hidePopup()" />'+
								'</div></div>';
		
		var transportTemplate = '<div>'+
									'<div class = "popupCon">'+
										'<h1 class="popup_heading">{{content.header}}'+
										'</span></h1>'+
										 '<span class="poopup_content">'+
										 '<table   class="table table-striped table-hover">'+
										 '<tr>'+
											 '<th>Source</th>'+
											 '<th>Destination</th>'+
											 '<th>Vehicle Number</th>'+
											 '<th>Transporter Name</th>'+
											 '<th>Transport Mode</th>'+
										'</tr>'+
								 	    '<tr>'+
								 		'<td>{{tranport.sourceLoaction}}</td>'+
								 		'<td>{{tranport.destinationLocation}}</td>'+
								 		'<td>{{tranport.vehicleNumber}}</td>'+
								 		'<td>{{tranport.transporterAddress}}</td>'+
								 		 '<td>{{tranport.transportMode}}</td>'+
								 	
								 	    '</tr>'+
							'</table></span>'+
									 '</div>'+
									'<div class = "buttons">'+
									'<input type="button" class="btn btn-default" value="OK"  ng-click="hidePopup()" />'+
									'</div></div>';
								
		var paymentTemplate = '<div>'+
								'<div class = "popupCon">'+
									'<h1 class="popup_heading">{{content.header}}</h1>'+
									'<span class="poopup_content" ng-show="payment">'+
									 '<table   class="table table-striped table-hover">'+
									 '<tr>'+
	                    				 '<th>Bank Name</th>'+
	                    				 '<th>Transaction Id</th>'+
	                    				 '<th>Amount Paid</th>'+
	                    				 '<th>Transaction Date</th>'+
	                    			'</tr>'+
                   		 	    '<tr ng-repeat="payment in paymentList">'+
                   		 		'<td>{{payment.bankName}}</td>'+
                   		 		'<td>{{payment.transactionId}}</td>'+
                   		 		'<td>{{payment.amountPaid}}</td>'+
                   		 		 '<td>{{payment.transactionDate | date:"dd/MM/yyyy"}}</td>'+
                   		 	
                   		 	    '</tr>'+
                   		 	    '</table></span>'+
                   		 	     '<span clas="alert alert-warning" ng-show="!payment"><strong>No Data Available</strong></span>'+
								 '</div>'+
								 '<div class = "buttons"><button type="button" class="btn-success btn-right-margin" value="Update Payment"  ng-click="updatePayment()" ng-disabled="complete" />'+
								 '<input type="button" class="btn btn-default" value="Ok"  ng-click="hidePopup()" />'+
								 '</div></div>'
	    var orderTemplate =    '<div>'+
	    							'<div class = "popupCon">'+
	    								'<h1 class="popup_heading">{{content.header}}</h1>'+
	    								 '<span class="poopup_content">{{content.text}}</span>'+
	    							 '</div>'+
	    						'<div class = "buttons"><input type="button" class="btn btn-default btn-right-margin" value="Ok"  ng-click="continueAction()" />'+
	    						 '</div></div>';
		var cancelOrderTemplate =    '<div>'+
										'<div class = "popupCon">'+
											'<h1 class="popup_heading">{{content.header}}</h1>'+
											 '<span class="poopup_content">{{content.text}}</span>'+
										 '</div>'+
									'<div class = "buttons"><input type="button" class="btn btn-default btn-right-margin" value="Yes"  ng-click="continueToCancelOrder(orderId)" />'+
									'<input type="button" class="btn btn-default btn-right-margin" value="No"  ng-click="hidePopup()" />'+
									 '</div></div>'
	    var updatePaymentTemplate =  '<div>'+ 
	    								'<div  class="panel panel-default">'+
	    									'<div class="panel-heading"> <h2>{{content.header}}</h2> </div>'+
	    									'<div  class="panel-body">'+
	    									  '<form class="form-horizontal" role="form">'+
	    										'<div class="form-group">'+
	    											'<label for="price" class="col-sm-3 control-label">Pending Amount: </label>'+
	    												'<div class="col-sm-3">'+
	    													'{{pendingAmount}}'+
	    												'</div>  </div>'+
	    		                       
		        								'<div class="form-group">'+
		        									'<label for="amount" class="col-sm-3 control-label">Amount  Paid:</label>'+
		        										'<div class="col-sm-3">'+
		        											'<input type="text" class="form-control" ng-model="transaction.amountPaid" placeholder="0" maxlength = "20" required  />'+
		        										'</div>'+   
		        									'<label for="agencyName" class="col-sm-2 control-label">Bank Name:</label>'+
		        									'<div class="col-sm-3">'+
		        										'<select  class="form-control" ng-model="transaction.bankName">'+ 
		        											'<option value="SBI" selected>State Bank Of India</option>'+
		        											 '<option value="BOB">Bank of Baroda</option>'+
		        											 '<option value="PNB">Panjab National Bank</option>'+
		        											 '<option value="ICICI">ICICI</option>'+
		        										 '</select>'+
		        									 '</div>'+
		        									'</div>'+
			        								'<div class="form-group">'+
			        									'<label for="agencyName" class="col-sm-3 control-label">Transaction Id:</label>'+
			        									'<div class="col-sm-3">'+
			        										'<input type="text" class="form-control" ng-model="transaction.transactionId" placeholder="Transaction Id" maxlength = "50"  required />'+
			        									'</div>'+
			        								   '<label for="agencyName" class="col-sm-2 control-label">Transaction Date:</label>'+
			        								   '<div class="col-sm-3">'+
			        								   		'<div class="input-group">'+
			        								   			'<mydatepicker data-ng-model="transaction.transactionDate" date-options="dateOptions" opened="opened"/>'+
			        								   		 '</div>'+
			        								   	'</div>'+
			        								 '</div>'+
			        							'</div></form></div>'+
        								 '<div class = "form-group last"><button type="button" class="btn btn-success btn-sm" ng-click="update()" >Update Payment</button>'+
        								 '<button type="button" class="btn btn-default"  ng-click="hidePopup()">Ok</button>'+
        								 '</div>'+
        						  '</div>' 						
   
	 var getTemplate = function(contentType) {
		 var template = '';
	        switch(contentType) {
	            case 'product':
	            	template = productTemplate;
	                break;
	            case 'payment':
	            	template = paymentTemplate;
	                break;
	            case 'order':
	            	template = orderTemplate;
	                break;    
	            case 'updatePayment':
	            	template = updatePaymentTemplate;
	                break; 
	            case 'transport':
	            	template = transportTemplate;
	                break;  
	            case 'cancelOrder':
	            	template = cancelOrderTemplate;
	                break;      
	        }

	        return template;
	}
	 var linker = function(scope, element, attrs) {
		 scope.$watch('popupType',function(newValue) {
			 			console.log(newValue);
					element.html(getTemplate(newValue)).show();
			 		$compile(element.contents())(scope);
		  		
		 },true); 
		
	 }
	return{
		restrict: "E",
        replace: true,
        link: linker
	};
});
