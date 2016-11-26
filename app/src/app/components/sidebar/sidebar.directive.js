(function() {
  'use strict';

  angular
    .module('app')
    .directive('camtSideBar', camtSideBar);

  /** @ngInject */
  function camtSideBar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/sidebar/sidebar.html',
      scope: {

      },
      controller: SidebarController,
      controllerAs: 'vm',
      bindToController: true
    };

    return directive;

    /** @ngInject */
    function SidebarController($location) {
      var vm = this;

      // "vm.creation" is avaible by directive option "bindToController: true"
      //vm.relativeDate = moment(vm.creationDate).fromNow();
      vm.isActive = function(viewLocation){
        return viewLocation == $location.path();
      }
    }
  }

})();
