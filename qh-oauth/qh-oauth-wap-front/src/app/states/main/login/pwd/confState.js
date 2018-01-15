import Controller from "./Controller";
import html from "!html-loader?minimize=true!./view.html";

confState.$inject = ['$stateProvider'];
function confState($stateProvider) {

    /**
     * 测试
     */
    $stateProvider.state("main.login.pwd", {
        url: "/pwd?backUrl",  //不写则会默认显示  ?providerID&client_id&redirect_uri&scope&state
        params: {

        },

        sticky: true,
        deepStateRedirect: true,
        views: {
            "pwd@main.login": {
                template: html,
                controller: Controller,
                controllerAs: "vm"
            }
        }
    });
}

export default confState ;


