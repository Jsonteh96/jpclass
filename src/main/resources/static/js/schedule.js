$(function () {
    function showToast(event, value, type) {
        DevExpress.ui.notify(event + " \"" + value + "\"" + " task", type, 800);
    }

    var scheduler = $("#scheduler").dxScheduler({
        dataSource: data,
        views: ["day", "week", "month"],
        currentView: "week",
		showAllDayPanel: true,
        currentDate: new Date(2019, 9, 24),
        startDayHour: 9,
        endDayHour: 18,
        onAppointmentAdded: function(e) {
            showToast("Added",e.appointmentData.text, "success");
        },
        onAppointmentUpdated: function(e) {
            showToast("Edited",e.appointmentData.text, "info");
        },
        onAppointmentDeleted: function(e) {
            showToast("Deleted",e.appointmentData.text, "warning");
        },
        height: 540
		
    }).dxScheduler("instance");

    $("#allow-adding").dxCheckBox({
        text: "Allow adding",
        value: true,
        onValueChanged: function(data) {
            scheduler.option("editing.allowAdding", data.value);
        }
    });

    $("#allow-deleting").dxCheckBox({
        text: "Allow deleting",
        value: true,
        onValueChanged: function(data) {
            scheduler.option("editing.allowDeleting", data.value);
        }
    });
    
    var resizing = $("#allow-resizing").dxCheckBox({
        text: "Allow resizing",
        value: true,
        onValueChanged: function(data) {
            scheduler.option("editing.allowResizing", data.value);
        }
    }).dxCheckBox("instance");
    
    var dragging = $("#allow-dragging").dxCheckBox({
        text: "Allow dragging",
        value: true,
        onValueChanged: function(data) {
            scheduler.option("editing.allowDragging", data.value);
        }
    }).dxCheckBox("instance");
    
    $("#allow-updating").dxCheckBox({
        text: "Allow updating",
        value: true,
        onValueChanged: function(data) {
            var value = data.value;
            scheduler.option("editing.allowUpdating", value);
            dragging.option("disabled", !value);
            resizing.option("disabled", !value);
        }
    });
});