<%--
  Created by IntelliJ IDEA.
  User: yosaf
  Date: 7/29/2019
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card stacked-form">
                    <div class="card-header ">
                        <h4 class="card-title">Edit Nilai Alternatif ${samples.get(0).alternatif.nama}</h4>
                    </div>
                    <form method="POST" action="/alternatif/nilai/save">
                        <div class="card-body ">
                            <div class="container-fluid">
                                <div class="row">
                                    <c:forEach items="${samples}" var="smp" varStatus="i">
                                        <div class="col-md-3" style="padding: 6px">
                                            <input type="hidden" name="samples[${i.index}].id" value="${smp.id}">
                                            <input type="hidden" name="samples[${i.index}].kriteria.id"
                                                   value="${smp.kriteria.id}">
                                            <input type="hidden" name="samples[${i.index}].alternatif.id"
                                                   value="${smp.alternatif.id}">
                                            <div class="form-group">
                                                <label>${smp.kriteria.nama}</label>
                                                <input type="number" step="0.1" placeholder="Nilai ${smp.kriteria.nama}" name="samples[${i.index}].nilai"
                                                       required="" class="form-control" value="${smp.nilai}">
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer ">
                            <button type="submit" class="btn btn-fill btn-info btn-round">Submit</button>
                            <button class="btn btn-fill btn-danger btn-round" type="button" onclick="window.history.back()">Kembali</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>

