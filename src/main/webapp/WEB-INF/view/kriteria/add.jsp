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
                        <h4 class="card-title">Tambah Kriteria</h4>
                    </div>
                    <form method="POST" action="/kriteria/save">
                        <div class="card-body ">
                            <div class="form-group">
                                <label>Nama Kriteria</label>
                                <input type="text" placeholder="Nama Kriteria" name="nama" required="" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Bobot</label>
                                <input type="number" min="1" placeholder="Bobot" name="bobot" required="" class="form-control">
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
