(function() {
  'use strict';

  angular
    .module('app')
    .controller('CourseListController', CourseListController);

  angular.module('app')
    .config(courseListConfig);


  function courseListConfig($stateProvider){
    $stateProvider
      .state('courseList', {
        url: '/courseList',
        templateUrl: 'app/course/list/courseList.html',
        controller: 'CourseListController',
        controllerAs: 'vm'
      });
  }
  CourseListController.$inject = ['courseQueryService'];
  /** @ngInject */
  function CourseListController(courseQueryService) {
  //function CourseListController() {
     var vm = this;
    vm.searchText = '';

    vm.onSearchBarChange = function(){
      courseQueryService.query({query:vm.searchText},function(data){
        // success
        vm.courses = data;
      })
    }
    vm.onSearchBarChange();


  }


})();
