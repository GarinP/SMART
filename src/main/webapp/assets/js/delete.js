function hapus(type, id) {
    swal({
        title: "Are you sure?",
        text: "You will not be able to recover this data!",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn btn-info btn-fill",
        confirmButtonText: "Yes, delete it!",
        cancelButtonClass: "btn btn-danger btn-fill",
        closeOnConfirm: false,
    }, function (isConfirm) {
        if (isConfirm) {
            swal("Deleted!", "This data has been deleted.", "success");
            window.location.href = "/"+type+"/" + id + "/delete";
        }
    });
}
