/**
 * Created by user on 2017/7/17.
 */
$("body").keydown(function() {
    if (event.keyCode == "13") {//keyCode=13是回车键
        $('#submit').click();
    }
});

var vm = new Vue({
    el: '#myblog',
    data: {
        accountCode: '',
        password: '',
        captcha: '',
        error: false,
        errorMsg: '',
        src: 'captcha.jpg'
    },
    beforeCreate: function() {
        if(self != top) {
            top.location.href = self.location.href;
        }
    },
    methods: {
        refreshCode: function() {
            this.src = "captcha.jpg?t=" + $.now();
        },
        login: function(event) {
            var data = "username=" + vm.accountCode + "&password=" + vm.password;
            $.ajax({
                type: "POST",
                url: "blogger/login",
                data: data,
                dataType: "json",
                success: function(result) {
                    if(result.code == 0) { //登录成功

                        //主页
                        parent.location.href = 'index.html';

                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;

                        vm.refreshCode();
                    }
                }
            });
        }
    }
});
