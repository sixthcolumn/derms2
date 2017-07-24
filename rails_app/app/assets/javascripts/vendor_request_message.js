function setMessageText(message_id) {
	msg_text = $("#message_" + message_id).text();
	$("#vendor_request_message_message_txt").val(msg_text);
}

function resetMessageText() {
	setMessageText($("#vendor_request_message_message_id").val());
}

$(function() {
	// set the default text on page load
	resetMessageText();
});

