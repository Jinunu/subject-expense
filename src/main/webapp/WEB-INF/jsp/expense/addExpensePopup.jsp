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
        <span class="title">경비 등록/수정</span>
        <div class="button" style="display: inline-block">
            <button id="save" >저장</button>
            <button id="close">닫기</button>
        </div>

        <form id="saveExpense" action="/expense/save" method="POST" enctype="multipart/form-data">
            <div>
                <div style="display: inline-block">사용내역</div>
                <div style="display: inline-block">
                    <select id="usageType" name="usageType">

                        <option selected value="">선택</option>
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
                    <input id="useDate" name="useDate" type="date"/>
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

                    <label for="file" class="btn" style="border: solid; background: white;">찾아보기..</label>
                    <input id="file" name="receiptImage" type="file" accept="image/*" style="visibility:hidden;">


                <div style="display: inline-block">
                </div>
            </div>


            </div>
        </form>
    </div>
</div>
<script src="../js/expensePopup.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        // process..
    });
    let getFormData = function (){
        let formData = new FormData;
        let usageType = $('#usageType').val();
        let expense = $('#expense').val();
        let useDate = $('#useDate').val();

        formData.append('usageType', usageType);
        formData.append('expense', expense);
        formData.append('useDate', useDate)
        formData.append('receiptImage', $('input[type=file]')[0].files[0])
        return formData;
    }
    $('#save').click(function (){
        // validate  사용내역, 사용일, 금액, 이미지 null 체크
        if (saveFormValidator()) {
            let formData = getFormData();
            $.ajax({

                type: 'POST',
                url: '/api/expense/save',
                data: formData,
                processData: false,
                contentType: false,
                success: function (data){
                    if (data == "success"){
                        window.close();
                    }

                }
            });

        }


    }) // save end

    $('#close').click(function (){

        window.close();
    })

</script>
</body>
</html>