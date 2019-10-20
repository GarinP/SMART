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
            <div class="col-md-6">
                <div class="card stacked-form">
                    <div class="card-header ">
                        <h4 class="card-title">Edit Mahasiswa</h4>
                    </div>
                    <form method="POST" action="/alternatif/edit">
                        <div class="card-body ">
                            <input type="hidden" name="id" value="${alternatif.id}">
                            <div class="form-group">
                                <label>Nama</label>
                                <input type="text" placeholder="Nama Mahasiswa" name="nama" required="" class="form-control" value="${alternatif.nama}">
                            </div>
                        </div>
                        <div class="card-footer ">
                            <button type="submit" class="btn btn-fill btn-info btn-round">Simpan</button>
                            <button class="btn btn-fill btn-danger btn-round" type="button" onclick="window.history.back()">Kembali</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
