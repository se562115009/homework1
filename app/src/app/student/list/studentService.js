(function() {
  angular
    .module('app')
    .factory('studentQueryService', studentQueryService);
  studentQueryService.$inject = ['$resource'];
  function studentQueryService($resource) {
    return $resource('/student/?query=:query', {},
      {
        query:{method:'GET',params:{query:''},isArray:true}
      });
  }
  angular
    .module('app')
    .factory('studentDataService',studentDataService);
  function studentDataService($resource){
    return  $resource('/student/:id', {id:'@_id'},
      {
        update:{
          method:'PUT'
        }
      });
  }

  angular.module('app')
    .factory('studentQueryByGpa',studentQueryByGpa)
  function studentQueryByGpa($resource) {
    return $resource('/student/gradehigherthan/?value=:query', {},
      {
        query:{method:'GET',params:{query:''},isArray:true}
      });
  }


})()

