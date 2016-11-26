(function () {
  'use strict';

  angular
    .module('app')
    .controller('StudentListController', StudentListController);

  angular.module('app')
    .config(studentListConfig);


  function studentListConfig($stateProvider) {
    $stateProvider
      .state('studentList', {
        url: '/studentList',
        templateUrl: 'app/student/list/studentList.html',
        controller: 'StudentListController',
        controllerAs: 'vm',
        resolve: {
          ctitle: function () {
            return 'find student';
          }
        }
      });
  }

  //StudentListController.$inject = ['studentQueryService'];
  /** @ngInject */
  function StudentListController($modal, studentQueryService, studentDataService, ctitle) {
    //function CourseListController() {
    var vm = this;
    vm.searchText = '';
    vm.title = ctitle;
    vm.onSearchBarChange = function () {
      studentQueryService.query({query: vm.searchText}, function (data) {
        // success
        vm.students = data;
      })
    }
    vm.onSearchBarChange();

    vm.onEditStudent = function (student) {
      $modal.open({
        animation: true,
        templateUrl: 'app/student/dialog/editModal.html',
        controller: 'studentUpdateController',
        controllerAs: 'vm',
        resolve: {
          initialEntity: function () {
            return student;

          }, parentController: function () {
            return vm;


          }
        }
      });

    }

  }

  angular
    .module('app')
    .controller('studentUpdateController', studentUpdateController);
  //studentUpdateController.$inject = ['$scope', '$modalInstance', 'StudentSchema', 'studentDataService',
  //'initialEntity', 'updateOp'];
  function studentUpdateController($scope, $modalInstance, StudentSchema, studentDataService, initialEntity,parentController) {
    var vm = this;
    vm.schema = StudentSchema;
    vm.entity = initialEntity;
    vm.form = [
      {
        key: 'studentId',
        title: 'Student id'
      },
      {
        key: 'name',
        title: 'Student name'
      }
    ];
    vm.title = "Edit Student";
    vm.save = function () {
      //faculty.organizers.push($scope.entity);
      studentDataService.update({id: initialEntity.id}, vm.entity, function () {
        parentController.searchText='';
        parentController.onSearchBarChange();
      });
      $modalInstance.close(vm.entity);
    }
  }

  angular
    .module('app')
    .constant('StudentSchema', {
      type: 'object',
      properties: {
        studentId: {type: 'string', title: 'Student id', placeholder: 'id'},
        name: {type: 'string', title: 'Student name', placeholder: 'student name'}
      }
    })
})();
