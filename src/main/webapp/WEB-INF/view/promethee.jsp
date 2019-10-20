<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"></jsp:include>
<!-- End Navbar -->
<div class="content">
    <div class="container-fluid">
        <%--    NILAI AKHIR--%>
        <div class="row">
            <div class="col-md-12">
                <div class="card bootstrap-table">
                    <div class="card-header ">
                        <h4 class="card-title">Nilai Akhir Promethee)</h4>
                        <p class="card-category">Here is a subtitle for this table</p>
                    </div>
                    <div class="card-body table-full-width">
                        <div class="toolbar">
                            <!--        Here you can write extra buttons/actions for the toolbar              -->
                        </div>
                        <table id="bootstrap-table" class="table table-hover table-striped">
                            <thead>
                            <th data-field="id" data-sortable="true" class="text-center">No</th>
                            <th data-field="nama" data-sortable="true">Nama</th>
                            <th data-field="jenis_suara" data-sortable="true">Jenis Suara</th>
                            <th data-field="ef" data-sortable="true">Entering Flow</th>
                            <th data-field="lf" data-sortable="true">Leaving Flow</th>
                            <th data-field="nf" data-sortable="true">Net Flow</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${promethee}" var="pr" varStatus="i">
                                <tr>
                                    <td>${i.index+1}</td>
                                    <td>${pr.alternatif.nama}</td>
                                    <td>${pr.alternatif.jenisSuara}</td>
                                    <td><fmt:formatNumber type="number" minFractionDigits="2"
                                                                              value="${pr.entering}"/></td>
                                    <td><fmt:formatNumber type="number" minFractionDigits="2"
                                                                              value="${pr.leaving}"/></td>
                                    <td><fmt:formatNumber type="number" minFractionDigits="2"
                                                                              value="${pr.net}"/></td>
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
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript">
    var $table = $('#bootstrap-table');

    $().ready(function() {
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
            pageSize: 50,
            pageList: [50, 100],

            formatShowingRows: function(pageFrom, pageTo, totalRows) {
                //do nothing here, we don't want to show the text "showing x of y from..."
            },
            formatRecordsPerPage: function(pageNumber) {
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

        $(window).resize(function() {
            $table.bootstrapTable('resetView');
        });
    });
</script>

