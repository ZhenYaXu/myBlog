/**
 * Created by user on 2017/7/17.
 */
$(function () {
    $("#jqGrid").jqGrid({
        url: '../article/list',
        datatype: "json",
        colModel: [
            { label: '博客ID', name: 'blogId', width: 30, key: true },
            { label: '博客标题', name: 'title', width: 80 },
            { label: '博客摘要', name: 'summary', width: 180 },
            { label: '博客类型', name: 'typeId', width: 50 },
            { label: '博客发表时间', name: 'createDate', width: 80 },
            { label: '状态', name: 'state', width: 30, formatter: function(value, options, row){
                if(value === 0){
                    return '<span class="label label-primary">审核中</span>';
                }
                if(value === 1){
                    return '<span class="label label-success">已通过</span>';
                }
            }},
/*            { label: '操作', name: 'operation', width: 80,formatter:function(cellvalue, options, rowObject)
                {
                    var blogId=rowObject.blogId;
                    return "<button class='btn btn-default' onclick='update(\""+blogId+"\")'>"+"编辑"+"</button>";
                }
            },*/
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


//加载编辑器
$(document).ready(function() {
    $('#summernote').summernote({
        height: 300,
        minHeight: 300,
        maxHeight: 500,
        focus: true,
        lang:'zh-CN',
        // 重写图片上传
        onImageUpload: function(files, editor, $editable) {
            sendFile(files[0],editor,$editable);
        }
    });
});

//图片上传
function sendFile(file, editor, $editable){

    var filename = false;
    try{
        filename = file['name'];
    } catch(e){
        filename = false;
    }
    if(!filename){
        $(".note-alarm").remove();
    }

    //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误
    data = new FormData();
    data.append("file", file);
    data.append("key",filename); //唯一性参数

    $.ajax({
        data: data,
        type: "POST",
        url: "",
        cache: false,
        contentType: false,
        processData: false,
        success: function(url) {
            if(url=='200'){
                alert("上传失败！");
                return;
            }else{
                alert("上传成功！");
            }
            //alert(url);
            editor.insertImage($editable, url);
            //setTimeout(function(){$(".note-alarm").remove();},3000);
        },
        error:function(){
            alert("上传失败！");
            return;
            //setTimeout(function(){$(".note-alarm").remove();},3000);
        }
    });
}

var vm = new Vue({
    el: '#myblog',
    data: {
        showList: true,
        blog:{
            blogId:null,
            title:null,
            summary:null,
            typeId:null,
            content:null
        }
    },
    methods: {
        save: function (event) {
            vm.content = $('#summernote').summernote('code');
            var url = "../article/save";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.blog),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },

        update: function (event) {
            var blogId = getSelectedRow();
            if(blogId == null){
                return ;
            }
            $.ajax({
                url:"../article/transmitDataToUpdate?blogId=" + blogId,
                type: "GET",
                success:function (r) {
                    vm.showList = false;
                    vm.blog = r.blogArticle;
                    $('#summernote').summernote('code', vm.blog.content);
                    loadnote();
                },error:function (msg) {
                    alert(msg);
                }
            })
        },

        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                page:page
            }).trigger("reloadGrid");
        }
    }
});

//加载编辑器
function loadnote() {
    $('#summernote').summernote({
        height: 300,
        minHeight: 300,
        maxHeight: 500,
        focus: true,
        lang:'zh-CN',
        // 重写图片上传
        onImageUpload: function(files, editor, $editable) {
            sendFile(files[0],editor,$editable);
        }
    });
}