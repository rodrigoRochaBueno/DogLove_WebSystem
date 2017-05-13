appDogLove.controller("loginController", function($scope, $http, $window) {

	$scope.usuario = {};
	$scope.token = "";

	$scope.validar = function() {
		$http({
			method : "POST",
			url : "http://localhost:8092/autenticar",
			data : $scope.usuario
		}).then(function(response) {

			console.log(response.data);

			$scope.token = response.data.token;
			localStorage.setItem("userToken", response.data.token);
			window.alert("Bem - Vindo");

		}, function(response) {

			console.log(response.data);

		});

	};

});