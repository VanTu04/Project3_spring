<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/27/2024
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
  <title>Thêm tòa nhà</title>
</head>
<body>
  <div class="main-content">
    <div class="main-content-inner">
      <div class="page-content">
        <div class="page-header">
          <h1>
            Dashboard
            <small>
              <i class="ace-icon fa fa-angle-double-right"></i>
              Building
            </small>
          </h1>
        </div><!-- /.page-header -->

        <form:form modelAttribute="buildingEdit" id="listForm" method="GET">
          <div class="row">
            <div class="col-xs-12">
              <form class="form-horizontal" role="form" id="form-edit">
                <div class="form-group">
                  <label class="col-xs-2" for="name">Tên tòa nhà</label>
                  <div class="col-xs-10">
                    <form:input path="name" type="text" id="name" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2">Quận</label>
                  <div class="col-xs-2">
                    <form:select name="district" id="district" class="form-control" path="district">
                      <form:option value="">-- Chọn quận --</form:option>
                      <form:options items="${districtCode}" />
                    </form:select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="ward">Phường</label>
                  <div class="col-xs-10">
                    <form:input path="ward" type="text" id="ward" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="street">Đường</label>
                  <div class="col-xs-10">
                    <form:input path="street" type="text" id="street" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="numberofbasement">Số tầng hầm</label>
                  <div class="col-xs-10">
                    <form:input path="numberofbasement" id="numberofbasement" name="numberofbasement" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="floorarea">Diện tích sàn</label>
                  <div class="col-xs-10">
                    <form:input path="floorarea" id="floorarea" name="floorarea" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="direction">Hướng</label>
                  <div class="col-xs-10">
                    <form:input path="direction" type="text" id="direction" name="direction" class="col-xs-9 form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="level">Hạng</label>
                  <div class="col-xs-10">
                    <form:input path="level" class="col-xs-9 form-control" type="number" id="level" name="level"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="rentarea">Diện tích thuê</label>
                  <div class="col-xs-10">
                    <form:input path="rentarea" class="col-xs-9 form-control" type="text" id="rentarea" name="rentarea"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="rentprice">Giá thuê</label>
                  <div class="col-xs-10">
                    <form:input path="rentprice" class="col-xs-9 form-control" type="number" id="rentprice" name="rentprice"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="rentpricedescription">Mô tả giá</label>
                  <div class="col-xs-10">
                    <form:input path="rentpricedescription" class="col-xs-9 form-control" type="text" id="rentpricedescription" name="rentpricedescription"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="servicefee">Phí dịch vụ</label>
                  <div class="col-xs-10">
                    <form:input path="servicefee" class="col-xs-9 form-control" type="text" id="servicefee" name="servicefee"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="carfee">Phí ô tô</label>
                  <div class="col-xs-10">
                    <form:input path="carfee" class="col-xs-9 form-control" type="text" id="carfee" name="carfee"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="overtimefee">Thời hạn thuê</label>
                  <div class="col-xs-10">
                    <form:input path="overtimefee" class="col-xs-9 form-control" type="text" id="overtimefee" name="overtimefee"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="managername">Tên quản lý</label>
                  <div class="col-xs-10">
                    <form:input path="managername" class="col-xs-9 form-control" type="text" id="managername" name="managername"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="managerphone">SĐT quản lý</label>
                  <div class="col-xs-10">
                    <form:input path="managerphone" class="col-xs-9 form-control" type="text" id="managerphone" name="managerphone"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="brokeragefee">Phí môi giới</label>
                  <div class="col-xs-10">
                    <form:input path="brokeragefee" class="col-xs-9 form-control" type="text" id="brokeragefee" name="brokeragefee"/>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2">Loại tòa nhà</label>
                  <div class="col-xs-6">
                    <form:checkboxes items="${typeCode}" path="typeCode" id="typeCode" />
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-xs-2" for="note">Ghi chú</label>
                  <div class="col-xs-10">
                    <form:input path="note" class="col-xs-9 form-control" type="text" id="note" name="note"/>
                  </div>
                </div>
                <form:hidden path="id" id="buildingId" />
                <div class="form-group">
                  <div class="col-xs-2"></div>
                  <div class="col-xs-9">
                    <c:if test="${not empty buildingEdit.id}">
                      <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Sửa tòa nhà</button>
                      <button type="button" class="btn btn-primary" id="btnCancelAddOrUpdateBuilding">Hủy thao tác</button>
                    </c:if>
                    <c:if test="${empty buildingEdit.id}">
                      <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
                      <button type="button" class="btn btn-primary" id="btnCancelAddOrUpdateBuilding">Hủy thao tác</button>
                    </c:if>
                  </div>
                </div>
              </form>
          </div>
        </div>

        </form:form>
      </div>
    </div>
  </div><!-- /.page-content -->


  <script>
      $('#btnAddOrUpdateBuilding').click(() => {
          var data = {};
          var typeCode = [];
          var formData = $('#listForm').serializeArray();
          $.each(formData, (index,value) => {
              if(value.name != 'typeCode'){
                  data["" + value.name + ""] = value.value;
              }
              else{
                  typeCode.push(value.value);
              }
          });
          data['typdeCode'] = typeCode;

          // call api
          $.ajax({
              type: "POST",
              url: "${buildingAPI}",
              data: JSON.stringify(data), // định dạng data gửi đi
              contentType: "Application/JSON", // định dạng data gửi đi
              dataType: JSON, //định dạng data server gửi về
              success: function (respond) {
                  console.log("success");
              },
              error: function (respond) {
                  console.log("failed");
                  console.log(respond);
              }
          })
      });

      $('#btnCancelAddOrUpdateBuilding').click(function (){
        window.location.href = "/admin/building-list";
      })
  </script>
</body>
</html>
