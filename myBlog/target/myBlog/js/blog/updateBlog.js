/**
 * Created by user on 2017/7/17.
 */

//加载编辑器
/*$(document).ready(function() {
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
            type:null,
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

        update: function () {
            vm.showList = false;
            var blogId = getSelectedRow();
            $.ajax({
                url:"../article/transmitDataToUpdate?blogId=" + blogId,
                type: "GET",
                success:function (r) {
                    vm.blog = r.blogArticle;
                    location.href = "../article/showUpdate";
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

function update(blogId) {
    vm.showList = false;
    $.ajax({
        url:"../article/transmitDataToUpdate?blogId=" + blogId,
        type: "GET",
        success:function (r) {
            vm.blog = r.blogArticle;
            location.href = "../article/showUpdate";
        },error:function (msg) {
            alert(msg);
        }
    })

}*/

