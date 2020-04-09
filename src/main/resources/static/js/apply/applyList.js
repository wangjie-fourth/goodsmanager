mini.parse();

const grid = mini.get("datagrid");

function applyExplain(e) {
    let note = e.row.applyExplain;

    if ("" != note && null != note) {
        if (note.length>10){
            note = note.substring(0,10) + "......";
        }
        return note;
    } else {
        return "无";
    }
}
grid.load();
function add(){
    mini.open({
        targetWindow: window,
        url: "../apply/add.html",
        title: "新增商品", width: 600, height: 400,
        onload: function () {
            const iframe = this.getIFrameEl();
            const data = {action: "new"};
            iframe.contentWindow.SetData(data);
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

