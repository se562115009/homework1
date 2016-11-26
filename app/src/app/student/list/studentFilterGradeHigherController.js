(function () {
  'use strict';

  angular
    .module('app')
    .controller('StudentFilterGradeHigherController', StudentFilterGradeHigherController);

  angular.module('app')
    .config(studentListHigherConfig);


  function studentListHigherConfig($stateProvider) {
    $stateProvider
      .state('studentListHigher', {
        url: '/studentListHigher',
        templateUrl: 'app/student/list/studentList.html',
        controller: 'StudentFilterGradeHigherController',
        controllerAs: 'vm',
        resolve: {
          ctitle: function () {
            return 'find student whose grade is greater than ';
          }
        }
      });
  }


  /** @ngInject */
  function StudentFilterGradeHigherController($modal, studentQueryByGpa, ctitle) {
    var vm = this;
    vm.searchText = '';
    vm.title = ctitle;
    vm.hideEdit = true;
    vm.onSearchBarChange = function () {

      studentQueryByGpa.query({query: vm.searchText}, function (data) {
        // success
        vm.students = data;
      })
    }
    vm.onSearchBarChange();
  }

})();
