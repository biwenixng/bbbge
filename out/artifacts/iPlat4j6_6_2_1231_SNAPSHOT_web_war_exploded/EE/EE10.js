$(function () {
	$("#F1").on("click", function (e) {
		// var grid = $("#ef_grid_result").data("kendoGrid");

		resultGrid.dataSource.query();
	});
});