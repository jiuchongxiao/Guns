/**
 * 应用管理管理初始化
 */
var AppInfo = {
    id: "AppInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
AppInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'version', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'enableFlag', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'itemOrder', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'dateCreated', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'code', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'lastUpdated', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'extention', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'description', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'createUser', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'updateUser', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
AppInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        AppInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加应用管理
 */
AppInfo.openAddAppInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加应用管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/AppInfo/AppInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看应用管理详情
 */
AppInfo.openAppInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '应用管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/AppInfo/AppInfo_update/' + AppInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除应用管理
 */
AppInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/AppInfo/delete", function (data) {
            Feng.success("删除成功!");
            AppInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("AppInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询应用管理列表
 */
AppInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    AppInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = AppInfo.initColumn();
    var table = new BSTable(AppInfo.id, "/AppInfo/list", defaultColunms);
    table.setPaginationType("client");
    AppInfo.table = table.init();
});
