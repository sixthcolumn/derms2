function emailReport() {
    $(function () {
        $('#email_dialog').dialog({
            resizable: false,
            modal: true,
            width: 400,
            buttons: {
                Okay: {
                    text: 'Okay',
                    class: "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only",
                      click: function () {
                        $(this).dialog("close");
                    },
                    id: "email-ok"
                },
                Cancel: {
                    click: function () {
                        $(this).dialog("close");
                    },
                    text: 'Cancel',
                    class: "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
                }
            }
        });
    });
}