appCliente.controller("loginController", function($scope, $http){
	
	
	$scope.usuario ={};
	
	
	$scope.validar = function(){
		$http.post("/autenticar", $scope.usuario)
		.then(function(response){
			
			console.log(response);
			console.status(response.data);
			
			
			}, function(response){
				
				console.log(response.data);
				console.status(response.data);
				
			});
		};
	
	
});