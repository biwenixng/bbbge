$(function () {
	$("#F1").on("click", function (e) {
		// var grid = $("#ef_grid_result").data("kendoGrid");
 		var formEname =  $("#inqu_status-0-formEname").val();
        CallFormHelper.Call4CForm(formEname);
    });
});