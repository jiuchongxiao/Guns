/**
 * 初始化应用管理详情对话框
 */
var AppInfoInfoDlg = {
    AppInfoInfoData : {}
};

/**
 * 清除数据
 */
AppInfoInfoDlg.clearData = function() {
    this.AppInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AppInfoInfoDlg.set = function(key, val) {
    this.AppInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AppInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AppInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.AppInfo.layerIndex);
}

/**
 * 收集数据
 */
AppInfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('version')
    .set('enableFlag')
    .set('itemOrder')
    .set('dateCreated')
    .set('code')
    .set('lastUpdated')
    .set('name')
    .set('extention')
    .set('description')
    .set('createUser')
    ;
}

/**
 * 提交添加
 */
AppInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/AppInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.AppInfo.table.refresh();
        AppInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.AppInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AppInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/AppInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.AppInfo.table.refresh();
        AppInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.AppInfoInfoData);
    ajax.start();
}

$(function() {

});
