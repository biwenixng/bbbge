$(function () {
    $('#QUERY').on('click', function() {
        resultGrid.dataSource.query()
    });
    // 通过JS改变EFInput的cname
    // $("label[data-for='inqu_status-0-studentName']  span")[0].innerHTML='HAHA';
    //新增前事件
    // IPLATUI.EFGrid = {
    //     "result": {
    //         beforeAdd: function (e) {
    //             //弹框
    //             testWindow.open().center()
    //             //阻止新增事件
    //             e.preventDefault()
    //         },
            // toolbarConfig:{
            //
            // }
            // ,
            // loadComplete: function (grid) {
            //     // 获取勾选数据，
            //     $("#IMPORT").on("click", function (e) {
            //         var checkedRows = resultGrid.getCheckedRows(),
            //             eiInfo = new EiInfo();
            //
            //         if (checkedRows.length > 0) {
            //             // 将checkedRows数组，组装成EiBlock
            //             var block = resultGrid.model2EiBlock(checkedRows);
            //
            //             eiInfo.setByNode("inqu");
            //             eiInfo.addBlock(block);
            //             console.log(resultGrid.model2EiBlock(checkedRows));
            //             console.log(eiInfo);
            //             console.log(resultGrid.getCheckedRows())
            //         }
            //     });
            // }
    //     }
    // }


    //点击弹框的保存按钮新增数据
    // $(document.body).on("click", "#DIV_BTN", function (e) {
    //     var inInfo = new EiInfo();
    //     //将id为window的EFRegion中的输入框的内容作为查询条件，设置到inInfo中
    //     inInfo.setByNode("window");
    //     EiCommunicator.send("AABB01","insert", inInfo, {
    //         onSuccess: function(response){
    //             window.parent['testWindow'].close();
    //             console.log(inInfo.getStatus())
    //             console.log(inInfo)
    //         },
    //         onFail: function(errorMsg, status, e) {
    //             // 调用发生异常
    //             console.log(errorMsg);
    //             console.log(inInfo)
    //         }}, {async: true});
    //     //设置Input为空数据
    //     IPLAT.EFInput.value($("#result-0-studentId"), "")
    //     IPLAT.EFInput.value($("#result-0-studentName"), "")
    //     IPLAT.EFInput.value($("#result-0-studentTime"), "")
    //     resultGrid.dataSource.query()
    // });

    $(document).ready(function() {
        var validator1 = IPLAT.Validator({
            id: "inqu",
            groupName: "group2,group3"
        });
    });

    IPLATUI.EFGrid = {
        "result": {
            toolbarConfig: {
                buttons: [ // 不允许覆盖默认的4个按钮，可以设置自定义的按钮
                    {
                        name: "admin",
                        text: "新增增",
                        icon: "fa-edit",
                        layout: "3",
                        click: function () {
                            console.log(IPLAT.EFInput.value($("#inqu_status-0-studentName")))
                        }
                    }
                ]
            }
        }
    }

});



