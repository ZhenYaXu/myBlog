/**
 * Created by user on 2017/7/19.
 */

var vu = new Vue({
    el: '#blog-detail',
    data: {
        showList: true,
        title: null,
        blog: {
            blogId: null,
            title: null,
            type: null,
            summary: null,
            content: null
        },
        blogs: []
    },
    created: function () { //created方法，页面初始调用
        
    },
    methods: {
        showDetail: function () {
            eventBus.$on('blogId', function(val) {
                vu.blog.blogId = val;
                console.log(val)
            })
            $.ajax({
                url: "../blog/article/transmitDataToUpdate",
                type: "POST",
                data: {blogId: vu.blog.blogId},
                dataType: "json",
                success: function (r) {
                    location.href = "../portal/showPost"
                }, error: function (msg) {
                    alert(msg);
                }
            })
        }
    }
});


/*
$(function () {

    $.ajax({
        url: "../blog/article/transmitDataToUpdate",
        type: "POST",
        data: {blogId: blogId},
        dataType: "json",
        success: function (r) {
            vu.blog.title = r.blogArticle.title;
            vu.blog.summary = r.blogArticle.summary;
            vu.blog.content = r.blogArticle.content;
        }, error: function (msg) {
            alert(msg);
        }
    })
});*/
