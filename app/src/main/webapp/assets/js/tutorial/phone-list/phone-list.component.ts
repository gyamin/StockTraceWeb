/// <reference path="../../../typings/globals/angular/index.d.ts"/>
angular.
module('phoneList').
component('phoneList', {
    templateUrl: './../../js/tutorial/phone-list/phone-list.template.html',
    controller: function PhoneListController($http) {
        var self = this;
        self.orderProp = 'age';
        $http.get('./../../js/tutorial/phones/phones.json').then(function(response) {
            self.phones = response.data;
        })
    }
});