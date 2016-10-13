/// <reference path="../../../typings/globals/angular/index.d.ts"/>
angular.
module('phoneList').
component('phoneList', {
    templateUrl: './../../js/tutorial/phone-list/phone-list.template.html',
    controller: function PhoneListController() {
        this.phones = [
            {
                name: 'Nexus S A',
                snippet: 'Fast just got faster with Nexus S.'
            }, {
                name: 'Motorola XOOM™ with Wi-Fi',
                snippet: 'The Next, Next Generation tablet.'
            }, {
                name: 'MOTOROLA XOOM™',
                snippet: 'The Next, Next Generation tablet.'
            }
        ];

        // this.orderProp = 'age';
    }
});