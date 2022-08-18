<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>경비 등록/수정</title>
</head>

<body>
<div class="container">
    <div class="control-box">
        <span class="title">경비 상세/수정</span>
        <div class="button" style="display: inline-block">
            <button id="edit" >수정</button>
            <button id="delete" >삭제</button>
            <button id="close">닫기</button>
        </div>

        <form id="saveExpense" action="/expense/save" method="POST" enctype="multipart/form-data">
            <input type="hidden" id="expenseId" name="expenseId" value="${detail.expenseId}">
            <label>청구내역</label>
            <div>

                <div style="display: inline-block">사용내역</div>
                <div style="display: inline-block">

                    <select id="usageType" name="usageType">선택
                        <option selected value="" >선택</option>
                        <option value="MEALS_NIGHT" >식대(야근)</option>
                        <option value=TAXI_NIGHT>택시비(야근)</option>
                        <option value="TAXI_DINING_TOGETHER">택시비(회식)</option>
                        <option value="OFFICE_EQUIPMENT">사무용품 구매</option>
                        <option value="EDUCATIONAL_EXPENSES">교육비</option>
                        <option value="ENTERTAINMENT">접대비</option>
                    </select>
                </div>
            <div>
                <div style="display: inline-block">사용일</div>
                <div style="display: inline-block">
                    <input id="useDate" name="useDate" type="date" />
                </div>
            </div>
            <div>
                <div style="display: inline-block">금액</div>
                <div style="display: inline-block">
                    <input type="text" id="expense" name="expense"
                           oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />

                </div>
            </div>
            <div>
                <div style="display: inline-block">영수증</div>
                    <input type="hidden" id="fileId" name="fileId" value="${detail.fileId}">
                    <label for="file" class="btn" style="border: solid; background: white;">찾아보기..</label>
                    <input id="file" name="receiptImage" type="file" accept="image/*" value="${detail.originalName}" style="visibility:hidden;">
                <div  style="display: inline-block">
                    <img id="preview" src="/uploadFile/${detail.fileName}" width="200" height="200">
                </div>

                <div style="display: inline-block">
                </div>
            </div>


            </div>
        </form>
        <label>처리내역</label>
        <div>
            <div style="display: inline-block">처리상태</div>
            <div style="display: inline-block">

                <input id="prcessingState" name="prcessingState" value="${detail.processingState.title}" disabled="true">
                </input>
            </div>
            <div>
                <div style="display: inline-block">처리일자</div>
                <div style="display: inline-block">
                    <input id="processingDate" name="processingDate" type="text" value="${detail.processingDate}" disabled="true"/>
                </div>
            </div>
            <div>
                <div style="display: inline-block">승인금액</div>
                <div style="display: inline-block">
                    <input type="text" id="approvalExpense" name="approvalExpense"  disabled="true" value="${detail.approvalExpense}"
                           oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />

                </div>
            </div>
            <div>
                <div style="display: inline-block">비고</div>
                <div style="display: inline-block">
                    <input id="message" name="message" type="text" value="${detail.message}" disabled="true" />
                </div>
            </div>

        </div>
        <label>영수증</label>

    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){


        let initExpenseDetail = function () {
            $('#usageType').val('${detail.usageType}');
            $('#expense').val(${detail.expense});
            $('#useDate').val('${detail.useDate}');
        };


        if( '${detail.processingState}' == 'REGISTER' ){
            initExpenseDetail();
        }
        if( '${detail.processingState}' != 'REGISTER' ){
            $('#edit').remove();
            $('#delete').remove();
        }
        $("#delete").on('click', function () {
            if (confirm("삭제 하시겠습니까?")) {
                const expenseId = $('#expenseId').val()

                $.ajax({
                    type: 'DELETE',
                    url: '/expense/'+expenseId,
                    success: function (data) {
                        if (data == 'success') {
                            // 부모창의 테이블 row를 삭제 하고 싶다...
                            opener.deleteExpense(expenseId);
                            window.close();
                            // parentWindow.window.parentFn();
                        }
                    }
                })

            }else {
                alert("N")
            }

        });

    });

    $("#file").on("change", function(event) {

        var file = event.target.files[0];

        var reader = new FileReader();
        reader.onload = function(e) {

            $("#preview").attr("src", e.target.result);
        }

        reader.readAsDataURL(file);
    });
    let getFormData = function (){
        let formData = new FormData;
        let usageType = $('#usageType').val();
        let expense = $('#expense').val();
        let useDate = $('#useDate').val();
        let expenseId = $('#expenseId').val();
        let fileId = $('#fileId').val();

        formData.append('usageType', usageType);
        formData.append('expense', expense);
        formData.append('useDate', useDate)
        formData.append('expenseId', expenseId)
        formData.append('fileId', fileId)
        if ($('input[type=file]')[0].files[0] != null) {
            formData.append('receiptImage', $('input[type=file]')[0].files[0]);
        }

        return formData;
    }
    $('#edit').click(function (){
        let formData = getFormData();
        $.ajax({
                type: 'PUT',
                url: '/expense',
                data: formData,
                processData: false,
                contentType: false,
                success: function (data){
                    if (data == "success"){
                        window.close();
                    }

                }
            });

    })

    $('#close').click(function (){

        window.close();
    })



</script>
</body>
</html>