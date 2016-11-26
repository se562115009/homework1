(function() {
  'use strict';

  angular
    .module('app')
    .directive('camtNavBar', camtNavbar);

  /** @ngInject */
  function camtNavbar() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/components/navbar/navbar.html',
      scope: {
          creationDate: '='
      },
      controller: NavbarController,
      controllerAs: 'vm',
      bindToController: true
    };

    return directive;

    /** @ngInject */
    function NavbarController() {

    }
  }

})();
