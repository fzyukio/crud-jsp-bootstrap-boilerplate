function addLog() {
    var addTipForm = document.addTipForm;
    var uid = addTipForm.uid;
    var workdate = addTipForm.workdate;
    var describe = addTipForm.describe;
    var worktime = addTipForm.worktime;
    var difficulty = addTipForm.difficulty;
    var remark = addTipForm.remark;
    var dd = {
        uid: uid.value,
        workdate: workdate.value,
        describe: describe.value,
        worktime: worktime.value,
        difficulty: difficulty.value,
        remark: remark.value
    };
    $.ajax({
        type: "POST",
        url: "/attend/addlog",
        dataType: "json",
        data: dd,
        success: function (msg) {
            if (msg == true) {
                alert("Success!");
            } else {
                alert("Failed");
            }

        }
    });
    workdate.value = "";
    describe.value = "";
    worktime.value = "";
    difficulty.value = "";
    remark.value = "";
    $("#closeModel").click();
    location.reload();

}

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}


$(document).ready(function () {
    var submitNewTipButton = $('#submitNewTip');
    var addTipForm = $("#addTipForm");

    addTipForm.validate({
        // Specify validation rules
        rules: {
            // The key name on the left side is the name attribute
            // of an input field. Validation rules are defined
            // on the right side
            // tipStart: "required",
            // tipEnd: "required",
            tipContent: {
                required: true,
                minlength: 10,
            },
        },
        // Specify validation error messages
        messages: {
            tipStart: "Please enter the first day this tip should show up",
            tipEnd: "Please enter the last day this tip should show up",
            tipContent: {
                required: "Please enter the tip's content",
                minlength: "The content is too short"
            },
        },
        // Make sure the form is submitted to the destination defined
        // in the "action" attribute of the form when valid
        submitHandler: function (form) {
            var url = form.getAttribute("url");

            $.ajax({
                type: "POST",
                url: url,
                dataType: "json",
                data: getFormData(addTipForm),
                success: function (msg) {
                    if (msg === true) {
                        alert("Success!");
                    } else {
                        alert("Failed");
                    }
                }
            });
        }
    });

    // addTipForm.submit(function (e) {
    //     e.preventDefault();
    //     console.log(e);
    //     let formData = new FormData(this);
    //     var url = this.getAttribute("url");
    //
    //     $.ajax({
    //         type: "POST",
    //         url: url,
    //         dataType: "json",
    //         data: getFormData(addTipForm),
    //         success: function (msg) {
    //             if (msg === true) {
    //                 alert("Success!");
    //             } else {
    //                 alert("Failed");
    //             }
    //         }
    //     });
    //
    // });

    submitNewTipButton.click(function (e) {
        e.preventDefault();
        addTipForm.submit();
    });
});

