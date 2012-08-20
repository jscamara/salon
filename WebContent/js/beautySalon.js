function showValidationMessages(title, messages){
	$("#dialog-message").attr('title', title);
	$("#dialog-message").html(messages);

	$("#dialog-message").dialog({
		modal: true,
		buttons: {
			Ok: function() {
				$(this).dialog("close");
			}
		}
	});
}