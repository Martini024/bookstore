$(document).ready(
    $(function () {
        $("#table1").DataTable({
            "paginate": true,  // page button
            "searching": true,  // search bar
            "autoWidth":true,  //automatically set the column width
            "lengthChange": true,  // record number in each row
            "displayLength": 5,  // row number in each page
            "lengthMenu":[[5,10,20,-1],[5,10,20,"All"]],
            "ordering":true ,  // sort
            "info": true,  // Showing info
            "scrollY": 300,
            "scrollCollapse": true,
            "pagingType": "full",  // page style
            "processing": true,
            "serverSide": false,
            "destroy": true
        });
    })
);