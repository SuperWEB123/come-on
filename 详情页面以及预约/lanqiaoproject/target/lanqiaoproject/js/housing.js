var vue = new Vue({
    el:'#test',
    data:{
        products:null,
        totalCount : null
    }
});
//var totalCount = null;
//异步刷新
    $.ajax('/lanqiaoproject/HousingServlet',{
        type: 'POST',
        url: '/lanqiaoproject/HousingServlet',
        dataType: 'JSON',
        data:{"hid":1},
        async: false,
        success: function (msg) {
            vue.products = msg.photo;
            // alert(msg.photo)
            vue.totalCount = msg.housing;
            // alert(msg.housing.hmoney)
        }
    });
