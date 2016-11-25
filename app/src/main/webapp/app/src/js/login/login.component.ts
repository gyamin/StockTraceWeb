/// <reference path="../../typings/globals/angular/index.d.ts"/>
/// <reference path="./../common/config.ts"/>
/// <reference path="./../common/logger.ts"/>
/// <reference path="./login.model.ts"/>

angular.
module('login').
component('login', {
    templateUrl: './../../js/login/login.template.html',

    controller: ['$http', '$window', function loginController($http, $window) {

        var self = this;
        self.message = "";

        self.doLogin = function() {
            var logger = new Common.Logger();
            var loginModel = new Login.LoginModel();
            loginModel.id = self.id;
            loginModel.password = self.password;

            logger.debug(JSON.stringify(loginModel));

            $http.post(Common.Config.URL_PREFIX + '/login', loginModel).then(
                // success callback
                function(response) {
                    if(response.error) {

                    }

                    logger.debug("success");
                    logger.debug(JSON.stringify(response));
                    $window.location.href = '/stocks';
                },
                // error callback
                function(response) {
                    logger.debug("error");
                    logger.debug(JSON.stringify(response));
                    self.message = "サーバ通信に失敗しました。"
            })
        };
    }]
});