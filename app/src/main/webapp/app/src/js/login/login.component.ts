/// <reference path="../../typings/globals/angular/index.d.ts"/>
/// <reference path="../../typings/globals/jquery/index.d.ts"/>
/// <reference path="./login.model.ts"/>

angular.
module('login').
component('login', {
    templateUrl: './../../js/login/login.template.html',
    controller: function loginController($http) {
        var self = this;

        // postデータオブジェクトを定義
        // var login: {
        //     id : string,
        //     password : string
        // };

        self.doLogin = function() {

            var loginModel = new LoginModel();
            loginModel.id = self.id;
            loginModel.password = self.password;
            console.log(loginModel);

            // データを設定
            loginModel = {
                id: self.id,
                password: self.password
            }

            console.log(loginModel);
            $http.post('/login', loginModel).then(
                // success callback
                function(response) {
                    console.log("success");
                    console.log(JSON.stringify(response));
                },
                // error callback
                function(response) {
                    console.log("error");
                    console.log(JSON.stringify(response));
            })
        };
    }
});