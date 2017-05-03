appCliente.controller("loginController", function($scope, $http){
	
	
	$scope.usuario ={};
	$scope.token = "";
	
	
	$scope.validar = function(){
		$http.post("/autenticar", $scope.usuario)
		.then(function(response){
			
			console.log(response);
			
			$scope.token= response.data.token;
			
			
			}, function(response){
				
				console.log(response.data);
				
			});
		};
	
	
});