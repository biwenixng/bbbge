
$(function () {
    IPLATUI.EFTree = {
        "tree01": { //tree01对应jsp中EFTree的bindId属性
            // ROOT: "root", // 虚拟节点不渲染，仅作为初始查询条件
            ROOT: {label: "root", text: "地区分布", leaf: true, icon: "folder"},
            select: function (e) {
                var _data = this.dataItem(e.node);
                $("#inqu_status-0-parentEname").val(_data.id);
                resultGrid.dataSource.page(1);
            }
        }
    };
});