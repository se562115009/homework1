(function() {
  angular
    .module('app')
    .factory('courseQueryService', courseQueryService);
  courseQueryService.$inject = ['$resource'];
  function courseQueryService($resource) {
    return $resource('/course/?query=:query', {},
      {
        query:{method:'GET',params:{query:''},isArray:true}
      });
  }
})()

