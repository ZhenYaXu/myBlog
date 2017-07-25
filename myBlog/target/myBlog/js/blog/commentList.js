/**
 * Created by user on 2017/7/17.
 */
$(function () {
    $("#jqGrid").jqGrid({
        url: '../comment/list',
        datatype: "json",
        colModel: [
            { label: '评论ID', name: 'comId', width: 30, key: true,hidden:true },
            { label: '评论内容', name: 'content', width: 80 },
            { label: '评论时间', name: 'comTime', width: 180 },
            { label: '状态', name: 'state', width: 30, formatter: function(value, options, row){
                if(value === 0){
                    return '<span class="label label-primary">审核中</span>';
                }
                if(value === 1){
                    return '<span class="label label-success">已通过</span>';
                }
            }},
            { label: '操作', name: 'operation', width: 80,formatter:function(cellvalue, options, rowObject)
                {
                    var blogId=rowObject.blogId;
                    return "<button class='btn btn-default' onclick='update(\""+blogId+"\")'>"+"编辑"+"</button>";
                }
            },
        ],
        viewrecords: true,
        height: 520,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el: '#myblog',
    data: {
        showList: true,
        title: null,
        qrmanage: {}
    },
    methods: {}
});