angular.module("rootApp", [])
	.controller("clientes", ["$scope", function($scope){
		
		$scope.msg="";
		$scope.cliente = {};
		$scope.clientes[];
		
		$scope.salvarCliente(){
			$scope.clientes.push($scope.cliente);
		}
		


	
	}]);