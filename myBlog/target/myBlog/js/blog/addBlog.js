/**
 * Created by user on 2017/7/17.
 */

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
    el:'#blog-add',
    data:{
        showList: true,
        title: null,
        blog:{
            title:null,
            type_id:null,
            summary:null,
            content:null
        }
    },
    methods: {
        save: function () {
            if(vm.blog.title === null || vm.blog.title === ""){
                alert("标题不能为空");
                return
            }else if(vm.blog.summary === null || vm.blog.summary === ""){
                alert("摘要不能为空");
                return
            }else if($('#summernote').summernote("isEmpty")){
                alert("内容不能为空");
                return
            }
            
            vm.blog.content = $('#summernote').summernote('code');

            console.log(vm.blog.content);

            var url = "../article/save";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.blog),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            location.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },

        reload: function () {
            location.reload();
        }
    }
});