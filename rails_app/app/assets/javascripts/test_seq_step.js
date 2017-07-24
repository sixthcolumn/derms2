$.getJSON('/test_seq_step/packages', function(data) {
	var tree = data;
	$('#message_tree').treeview({
		data: tree,
		levels: 5
	});

	$('#message_tree').on('nodeSelected', function(event, data) {
		$("#test_seq_step_in_message_id").val(data.id)
	});
});


