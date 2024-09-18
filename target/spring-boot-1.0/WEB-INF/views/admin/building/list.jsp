<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/27/2024
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingListURL" value="/admin/building-list"/>\
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
  <title>Danh sách tòa nhà</title>
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

        <div class="row">
          <div class="col-xs-12" >
            <div class="widget-box" >
              <div class="widget-header" >
                <h4 class="widget-title">Tìm kiếm tòa nhà</h4>
                <span class="widget-toolbar">
											<a href="#" data-action="collapse">
												<i class="ace-icon fa fa-chevron-up"></i>
											</a>
										</span>
              </div>

              <div class="widget-body" >
                <form:form id="form-list" action="${buildingListURL}" method="GET" modelAttribute="modelSearch">
                  <div class="widget-main">
                  <div class="row">
                    <div class="col-xs-12">
                      <div class="col-xs-6">
                        <label for="namebuilding">Tên tòa nhà</label>
<%--                       <input type="text" id="namebuilding" name="name" class="form-control" value="${modelSearch.name}">--%>
                          <form:input id="namebuilding" class="form-control" path="name"/>
                      </div>
                      <div class="col-xs-6">
                        <label for="floorarea">Diện tích sàn</label>
                        <form:input id="floorarea" class="form-control" path="floorArea"/>
                      </div>
                    </div>
                    <div class="col-xs-12">
                      <div class="col-xs-2">
                        <label for="district">Quận</label>
<%--                        <form:select>--%>
<%--                          <form:form:options></form:form:options>--%>
<%--                        </form:select>--%>
                        <form:select name="district" id="district" class="form-control" path="district">
                          <form:option value="">-- Chọn quận --</form:option>
                          <form:options items="${districtCode}" />
                        </form:select>
                      </div>
                      <div class="col-xs-5">
                        <label for="ward">Phường</label>
                        <form:input type="text" id="ward" name="ward" class="form-control" path="ward"/>
                      </div>
                      <div class="col-xs-5">
                        <label for="street">Đường</label>
                        <form:input type="text" id="street" name="street" class="form-control" path="street"/>
                      </div>
                    </div>

                    <div class="col-xs-12">
                      <div class="col-xs-4">
                        <label for="numberofbasement">Số tầng hầm</label>
                        <form:input type="number" id="numberofbasement" name="numberofbasement" class="form-control" path="numberOfBasement"/>
                      </div>
                      <div class="col-xs-4">
                        <label for="direction">Hướng</label>
                        <form:input type="number" id="direction" name="direction" class="form-control" path="direction"/>
                      </div>
                      <div class="col-xs-4">
                        <label for="level">Hạng</label>
                        <form:input type="number" id="level" name="level" class="form-control" path="level"/>
                      </div>
                    </div>

                    <div class="col-xs-12">
                      <div class="col-xs-3">
                        <label for="areafrom">Diện tích từ</label>
                        <form:input type="text" id="areafrom" name="areafrom" class="form-control" path="areaFrom"/>
                      </div>
                      <div class="col-xs-3">
                        <label for="areato">Diện tích đến</label>
                        <form:input type="text" id="areato" name="areato" class="form-control" path="areaTo"/>
                      </div>
                      <div class="col-xs-3">
                        <label for="rentpricefrom">Giá thuê từ</label>
                        <form:input type="number" id="rentpricefrom" name="rentpricefrom" class="form-control" path="rentPriceFrom"/>
                      </div>
                      <div class="col-xs-3">
                        <label for="rentpriceto">Giá thuê đến</label>
                        <form:input type="number" id="rentpriceto" name="rentpriceto" class="form-control" path="rentPriceTo" />
                      </div>
                    </div>

                    <div class="col-xs-12">
                      <div class="col-xs-4">
                        <label for="managername">Tên quản lý</label>
                        <form:input type="text" id="managername" name="managername" class="form-control" path="managerName"/>
                      </div>
                      <div class="col-xs-4">
                        <label for="managerphone">Điện thoại quản lý</label>
                        <form:input type="text"  id="managerphone" name="managerphone" class="form-control" path="managerPhone"/>
                      </div>
                      <div class="col-xs-2">
                        <label for="staff">Nhân viên phụ trách</label>
                        <form:select name="staffid" id="staff" class="form-control" path="staffId">
                          <form:option value="">--Chọn nhân viên--</form:option>
                          <form:options items="${listStaffs}" />
                        </form:select>
                      </div>
                    </div>

                    <div class="col-xs-12">
                      <div class="col-xs-6">
                        <form:checkboxes items="${typeCode}" path="typeCode" id="typeCode" />
                      </div>
                    </div>

                    <div class="col-xs-12">
                      <div class="col-xs-6">
                        <button type="button" class="btn btn-danger" id="btnSearchbuilding">Tìm Kiếm</button>
                      </div>
                    </div>
                  </div>
                </div>
                </form:form>


              </div>
            </div>
          </div>
          <div class="col-xs-12">
            <div class=" pull-right">
              <a class="btn  btn-purple btn-sm" title="Thêm tỏa nhà" href="/admin/building-edit">
                <i class="ace-icon fa fa-cloud-upload"></i>
              </a>
              <button class="btn  btn-danger btn-sm" title="Xóa tất cả tòa nhà" id="btnDeleteBuilding">
                <i class="ace-icon fa fa-trash-o"></i>
              </button>
            </div>
          </div>
        </div><!-- /.row -->
        <br>
        <br>
        <!-- Bảng kết quả -->
        <div class="row">
          <div class="col-xs-12" bis_skin_checked="1">
            <table id="tableList" class="table table-striped table-bordered table-hover">
              <thead>
              <tr>
                <th></th>
                <th>Tên tòa nhà</th>
                <th>Địa chỉ</th>
                <th>Số tầng hầm</th>
                <th>Tên quản lý</th>
                <th>SĐT quản lý</th>
                <th>D.Tích sàn</th>
                <th>D.Tích Trống</th>
                <th>D.Tích thuê</th>
                <th>Phí môi giới</th>
                <th>Thao tác</th>
              </tr>
              </thead>

              <tbody>
              <c:forEach var="item" items="${result}">
                <tr>
                  <td>
                    <input type="checkbox" value="${item.id}"/>
                  </td>
                  <td class="center">
                    ${item.name}
                  </td>
                  <c:if test="${not empty item.street}">
                    <td>${item.street},${item.ward},${item.district}</td>
                  </c:if>
                  <c:if test="${empty item.street}">
                    <td></td>
                  </c:if>
                  <td>${item.numberofbasement}</td>
                  <td>${item.managername}</td>
                  <td>${item.managerphone}</td>
                  <td>${item.floorarea}</td>
                  <td></td>
                  <td>${item.rentarea}</td>

                  <td></td>

                  <td>
                    <div class="hidden-sm hidden-xs btn-group" bis_skin_checked="1">
                      <button class="btn btn-xs btn-success" title="Giao tòa nhà" onclick="assignmentbuilding(${item.id})">
                        <i class="ace-icon fa fa-check bigger-120"></i>
                      </button>

                      <a class="btn btn-xs btn-info" title="Sửa tòa nhà" href="/admin/building-edit-${item.id}">
                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                      </a>

                      <button class="btn btn-xs btn-danger" title="Xóa tòa nhà" onclick="deleteBuilding(${item.id})">
                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                      </button>
                    </div>
                  </td>
                </tr>

              </c:forEach>

              </tbody>
            </table>
          </div>
        </div> <!--Bảng kết quả-->

      </div><!-- /.page-content -->
    </div>
  </div><!-- /.main-content -->


<!-- Model -->
<div id="assignmentbuildingmodal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Danh sách nhân viên</h4>
      </div>
      <div class="modal-body">
        <table id="stafflist" class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <th class="center">Chọn</th>
            <th class="center">Tên nhân viên</th>
          </tr>
          </thead>

          <tbody>
          </tbody>

        </table>
<%--        <input type="hidden" id="buildingid" name="buildingid" value="">--%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="btnAsignmentbuilding">Giao tòa nhà</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
      </div>
    </div>

  </div>
</div>
<!-- end model -->

  <script>
    function assignmentbuilding(buildingid){
        $('#assignmentbuildingmodal').modal();
        $('#buildingid').val();
        loadStaff(buildingid);
    }

    function loadStaff(data){
      $.ajax({
        type: "GET",
        url: "${buildingAPI}/" + data + "/staff",
        data: JSON.stringify(data), // định dạng data gửi đi
        contentType: "Application/JSON", // định dạng data gửi đi
        dataType: "JSON", //định dạng data server gửi về
        success: function (response) {
            var row = ``;
            $.each(response.data, function (index,item){
                console.log(item);
              row += `<tr>`;
              row += `<td class="center">`;
              row += `<input type="checkbox" value=` + item.staffId + ` id="checkbox_`+ item.staffId + `class="check-box-element" `+ item.checked +`/>`;
              row += `</td>`;
              row += `<td class="text-center">` + item.fullName + `</td>`;
              row += `<tr>`;
            });
            row += `<input type="hidden" id="buildingid" name="buildingid" value=` + data + ` />`;
            $('#stafflist tbody').html(row);
        },
        error: function (response) {
            console.log("failed");
            console.log(response);
        }
      });
    }

    $('#btnAsignmentbuilding').click((e) => {
        e.preventDefault();
        var data = {};
        data['buildingid'] = $('#buildingid').val();
        var staffs = $('#stafflist').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['staffid'] = staffs;
    });

    $('#btnSearchbuilding').click((e) => {
      e.preventDefault();
      $('#form-list').submit();
    });

    //xoa 1 item building
    function deleteBuilding(id){
      var buildingid = [id];
      deleteBuildings(buildingid);
    }

    //xoa nhieu item building
    $("#btnDeleteBuilding").click(function (e){
      e.preventDefault();
      var data = {};
      var buildingids = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
          return $(this).val();
      }).get();
      deleteBuildings(buildingids);
    })

    function deleteBuildings(data){
      $.ajax({
        type: "DELETE",
        url: "${buildingAPI}/" + data,
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
      });
    }
  </script>

</body>
</html>
