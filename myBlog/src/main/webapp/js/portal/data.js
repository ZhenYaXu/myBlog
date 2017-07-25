/**
 * Created by user on 2017/7/20.
 */


function showDetail(blogId) {

    document.getElementById('tmpId').value = blogId;
    bId = blogId;
    alert(bId);
    location.href = "../portal/showDetailByBlogId";
}