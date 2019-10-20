<%--
  Created by IntelliJ IDEA.
  User: yosaf
  Date: 7/29/2019
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <a class="navbar-brand" style="padding-left: 10px">Kriteria</a>
            </div>
            <div class="col-md-6 text-right">
                <a href="/kriteria/add" class="btn btn-outline btn-round btn-wd">
                    <span class="btn-label">
                        <i class="fa fa-plus"></i>
                    </span> Tambah Data
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-body table-full-width">
                        <div class="toolbar">
                            <!--        Here you can write extra buttons/actions for the toolbar              -->
                        </div>
                        <table id="bootstrap-table" class="table table-hover table-striped">
                            <thead>
                            <th data-field="id" class="text-center">No</th>
                            <th data-field="nama_kriteria" data-sortable="true">Nama Kriteria</th>
                            <th data-field="bobot" data-sortable="true">Bobot</th>
                            <th data-field="actions" class="td-actions text-right">Actions
                            </th>
                            </thead>
                            <tbody>
                            <c:forEach items="${kriterias}" var="kriteria" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${kriteria.nama}</td>
                                    <td>${kriteria.bobot}</td>
                                    <td>
                                        <a rel="tooltip" title="Edit" class="btn btn-link btn-warning"
                                           href="/kriteria/${kriteria.id}/edit">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                        <a rel="tooltip" title="Remove"
                                           class="btn btn-link btn-danger"
                                           onclick="hapus('kriteria', ${kriteria.id})">
                                            <i class="fa fa-remove"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
<script type="text/javascript">
    var $table = $('#bootstrap-table');
    $().ready(function () {
        $table.bootstrapTable({
            clickToSelect: true,
            showRefresh: false,
            search: true,
            toolbar: ".toolbar",
            toolbarAlign: 'right',
            showToggle: false,
            showColumns: true,
            pagination: true,
            searchAlign: 'left',
            pageSize: 10,
            pageList: [10, 15, 20, 25, 30, 50, 100],

            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                //do nothing here, we don't want to show the text "showing x of y from..."
            },

            formatRecordsPerPage: function (pageNumber) {
                return pageNumber + " rows visible";
            },

            icons: {
                refresh: 'fa fa-refresh',
                toggle: 'fa fa-th-list',
                columns: 'fa fa-columns',
                detailOpen: 'fa fa-plus-circle',
                detailClose: 'fa fa-minus-circle'
            }
        });

        //activate the tooltips after the data table is initialized
        $('[rel="tooltip"]').tooltip();

        $(window).resize(function () {
            $table.bootstrapTable('resetView');
        });


    });
</script>
