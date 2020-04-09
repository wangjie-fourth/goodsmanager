mini.parse();

const grid = mini.get("datagrid");
grid.load();


/**
 * 操作列的渲染器
 * @param e
 * @returns {string}
 */
function operate(e) {
    return onAddIcon('icon-edit', 'edit()', '编辑') + onAddIcon('icon-remove', 'remove()', '删除');

}

/* 返回指定点击事件的指定图标的a标签 */
function onAddIcon(icon, fun, value) {
    return '<a class="mini-button mini-state-default mini-corner-all mini-button-plain" href="javascript:' + fun + '">'
        + '<span class = "mini-button-inner mini-button-icon-text" >' + '<span class="mini-button-icon mini-icon mini-iconfont ' + icon + '" style></span>'
        + '<span class="mini-button-text">' + value + '</span>' + '</span>' + '</a>';
}

function add() {
    mini.open({
        targetWindow: window,
        url: "../good/add.html",
        title: "新增商品", width: 600, height: 400,
        onload: function () {
            var iframe = this.getIFrameEl();
            var data = {action: "new"};
            iframe.contentWindow.SetData(data);
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

function edit(e) {
    const good = grid.getSelected();
    mini.open({
        targetWindow: window,
        url: "../good/edit.html",
        title: "修改商品", width: 600, height: 400,
        onload: function () {
            var iframe = this.getIFrameEl();
            iframe.contentWindow.setData(good);
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

function remove() {
    const goodId = grid.getSelected().goodId;
    const inventory = grid.getSelected().inventory;
    if (inventory > 0) {
        mini.alert("库存大于0，不能删除！");
    } else {
        const goodsmanage = {"goodId": goodId};
        mini.confirm(" 确定删除？", "确定", function (action) {
            if ("ok" == action) {
                debugger;
                $.ajax({
                    url: "/good/remove",
                    type: "post",
                    contentType: 'application/json',
                    data: JSON.stringify(goodsmanage),
                    success: function (text) {
                        mini.alert(" 删除成功");
                        setTimeout(function () {
                            window.CloseOwnerWindow();
                        }, 1500);
                        grid.reload();
                    },
                    error: function () {
                        mini.alert("删除失败");
                    }
                });
            }
        });
    }

}