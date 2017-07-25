/**
 * Created by user on 2017/7/18.
 */

Vue.use(VueResource);

var vm = new Vue({
    el: '#myblog',
    data: {
        showList: true,
        title: null,
        blog: {
            blogId:null,
            title: null,
            type: null,
            createDate: null,
            summary: null,
            content: null
        },
        blogs: []
    },
    created: function () { //created方法，页面初始调用
/*        var url = "../blog/article/pageList?page=1&limit=5";
        this.$http.get(url).then(function (r) {  //ajax请求封装

            this.blogs = r.blogList;
            alert(r.blogList);
        }, function (response) {   //返回失败方法调用，暂不处理
            console.info(response);
        })*/
    },
    methods: {
        getBlogs: function () {
            $.ajax({
                url: "../blog/article/list",
                success: function (r) {
                    this.blogs = r.page.articleList;
                    alert(vm.blogs);
                }, error: function (msg) {
                    alert(msg);
                }
            })
        },
        showDetail: function (blogId) {
            location.href = "../portal/showDetailByBlogId?blogId=" + blogId;
        }
    }
});

$(function () {
    var element = $('#bp-3-element-test');//获得数据装配的位置
    //初始化所需数据

    $.ajax({
        url: "../blog/article/pageList",
        type: "POST",
        data: {page:1,limit:5},
        dataType: "json",
        success: function (r) {
            for(var i = 0; i < r.blogList.length; i++){
                vm.blogs.push({
                    blogId: r.blogList[i].blogId,
                    title: r.blogList[i].title,
                    createDate: r.blogList[i].createDate,
                    summary: r.blogList[i].summary
                });
            }

            var curPage = r.curPage;
            var totalPage = r.totalPage;
            var pageSize = r.pageSize;
            var options = {
                bootstrapMajorVersion: 3,//版本号。3代表的是第三版本
                currentPage: curPage, //当前页数
                numberOfPages: 5, //显示页码数标个数
                totalPages: totalPage, //总共的数据所需要的总页数
                itemTexts: function (type, page, current) {
                    //图标的更改显示可以在这里修改。
                    switch (type) {
                        case "first":
                            return "<<";
                        case "prev":
                            return "<";
                        case "next":
                            return ">";
                        case "last":
                            return ">>";
                        case "page":
                            return page;
                    }
                },
                tooltipTitles: function (type, page, current) {
                    //如果想要去掉页码数字上面的预览功能，则在此操作。例如：可以直接return。
                    switch (type) {
                        case "first":
                            return "Go to first page";
                        case "prev":
                            return "Go to previous page";
                        case "next":
                            return "Go to next page";
                        case "last":
                            return "Go to last page";
                        case "page":
                            return (page === current) ? "Current page is " + page : "Go to page " + page;
                    }
                },
                //单击当前页码触发的事件。若需要与后台发生交互事件可在此通过ajax操作。page为目标页数。
                onPageClicked: function (e, originalEvent, type, page) {
                    $.ajax({
                        url: "../blog/article/pageList",
                        type: "POST",
                        data: {page:page,limit:5},
                        dataType: "json",
                        success: function (r) {
                            if(r.blogList.length > 0){
                                vm.blogs = [];
                            }
                            for(var i = 0; i < r.blogList.length; i++){
                                vm.blogs.push({
                                    blogId: r.blogList[i].blogId,
                                    title: r.blogList[i].title,
                                    createDate: r.blogList[i].createDate,
                                    summary: r.blogList[i].summary
                                });
                            }
                        }
                    })
                    //console.log(e);
                    //console.log(originalEvent);
                    // console.log(type);
                }
            }
            element.bootstrapPaginator(options);	//进行初始化
        }
    });

});

