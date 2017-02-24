
myApplication.factory('myCache', function($cacheFactory) {
    return $cacheFactory('myData');
});
 

myApplication.controller('MyController', ['$scope', '$location','myCache',function($scope, $location,myCache) {
      
       $scope.people =[{name:'merve', surname:'Sahin'},
					   {name:'Uraz',  surname:'Turker'},
					   {name:'Begm',   surname:'Sozen'}];

      $scope.indis = 0;
      var cache = myCache.get('indis');
      $scope.keys = [];
  
    
    
      $scope.put = function(key, value) {
      myCache.put(key, value);
      $scope.keys.push(key);
     };
     
     
      if ( myCache.get('myArray')) { // If there’s something in the cache, use it!
        $scope.people =  myCache.get('myArray');
      }
      else { // Otherwise, let’s generate a new instance
        $scope.put('myArray', $scope.people);
        $scope.people = myCache.get('myArray');
      }
      console.log(myCache.get("myArray")[0].name);
     

    
   $scope.tempUpdateMetod = function(ind){
        console.log("indissss"+ind);
       
        myCache.put('indis', ind);
        $location.path('/update/');         
   };
  
    $scope.personUpdate = function () {
         $scope.temp =  myCache.get("myArray");
        
        $scope.temp[myCache.get('indis')].name =  $scope.personname;
        $scope.temp[myCache.get('indis')].surname =  $scope.personsurname;
        $scope.put("myArray1", $scope.temp);
             
       /*myCache.get("myArray")[myCache.get('indis')].name =  $scope.personname;
       myCache.get("myArray")[myCache.get('indis')].surname =  $scope.personsurname;*/   
        $location.path('/mainView/');    
   };
     
    $scope.personInsert = function(){
        
       $scope.people.push({
            "name":$scope.newpersonname,
            "surname":$scope.newpersonsurname
        });
        $scope.newpersonname = "";
        $scope.newpersonsurname = "";
        $location.path('/mainView/'); 
    }
    
    
    /*Delete Method*/
    $scope.persondelete = function (ind) {
        $scope.people.splice(ind, 1);          
	};	
 
}]);
