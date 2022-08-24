<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet"/>
    <link href="css/expense.css" rel="stylesheet">
</head>

<body>

    <section >
        <form id="searchForm">
            <div class="inner" for="regDate">
                <label>등록연월</label>
                <input id="rgeDateYearMonth" type="month" value="">
                <label>사용내역</label>
                <select id="usageType" name="usageType">
                    <option selected value="">전체</option>
                    <option value="MEALS_NIGHT" >식대(야근)</option>
                    <option value=TAXI_NIGHT>택시비(야근)</option>
                    <option value="TAXI_DINING_TOGETHER">택시비(회식)</option>
                    <option value="OFFICE_EQUIPMENT">사무용품 구매</option>
                    <option value="EDUCATIONAL_EXPENSES">교육비</option>
                    <option value="ENTERTAINMENT">접대비</option>
                </select>

                <label>처리상태</label>
                <select id="processingState" name="processingState">
                    <option selected value="">전체</option>
                    <option value="REGISTER" >접수</option>
                    <option value=APPROVAL>승인</option>
                    <option value="DONE">지급완료</option>
                    <option value="REJECT">반려</option>
                </select>
                <button id="init" type="button">초기화</button>
                <button id="search"  type="button" >검색</button>
            </div>

        </form>
    </section>
    <form id="excelDownload" style="display: none" action="/expense/export/excel" method="POST">
    </form>

    <section >
        <div class="inner">
            <div class="table-container">
            <div class="table-title-container">
                총 x건

            </div>
            <div class="table-button-container">
                <button id="excelExport">엑셀 다운로드</button>
                <button id="save" onclick="openPopup('expense/expensePopup', '경비 등록/수정')">등록</button>
            </div>
            </div>
            <table>
                <thead>
                    <th>순번</th>
                    <th>사용일</th>
                    <th>사용내역</th>
                    <th>사용금액</th>
                    <th>승인금액</th>
                    <th>처리상태</th>
                    <th>등록일</th>
                </thead>
                <tbody id="tbody">

                </tbody>
                <tfoot>
                <td>합계</td>
                <td>-</td>
                <td>-</td>
                <td id="sumExpense" name="sumExpense">-</td>
                <td id="sumApprovalExpense" name="sumApprovalExpense">-</td>
                <td>-</td>
                <td>-</td>
                </tfoot>

            </table>
        </div>
    </section>



<script src="js/expense.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js" integrity="sha512-Gn0tSSjkIGAkaZQWjx3Ctl/0dVJuTmjW/f9QyB302kFjU4uTNP4HtA32U2qXs/TRlEsK5CoEqMEMs7LnzLOBsA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $(document).ready(function (){


        function initSearchCondition() {
            const currentYear = new Date().getFullYear();
            const currentMonth = new Date().getMonth() + 1;
            const yearMonth = currentYear + "-" + (("00" + currentMonth.toString()).slice(-2));
            $('#rgeDateYearMonth').val(yearMonth);
            $('#usageType').val("");
            $('#processingState').val("");
        }

        initSearchCondition();


        $('#search').on('click', function () {
            let searchFormData = getSearchFormData();
            $.ajax({
                type: 'patch',
                url: '/api/expense/search',
                data: searchFormData,
                processData: false,
                contentType: false,
                success: function (data) {
                    tableList(data)
                }
            });
        });

        $('#excelExport').on('click', function (e) {
            e.preventDefault();
            let rgeDateYearMonth = $('#rgeDateYearMonth').val();
            let usageType = $('#usageType').val();
            let processingState = $('#processingState').val();
          postForm("/expense/export/excel", {rgeDateYearMonth: rgeDateYearMonth,
          usageType: usageType, processingState: processingState}), "post"


        });


        $('table tbody tr').click(function(){
        });

        $('#init').on('click', function (){
            initSearchCondition();
            clearTable();
        });




    })// document


        function getSearchFormData() {
            let formData = new FormData();
            formData.append('rgeDateYearMonth', $('#rgeDateYearMonth').val());
            formData.append('usageType', $('#usageType').val());
            formData.append('processingState', $('#processingState').val());
            return formData;
        }
    let clearTable = function (){
        $('tbody tr').remove();
        $('tfoot td').html('-');
        $('tfoot td').first().html('합계');
    }






    let tableList = function (results) {

        let sumExpense = 0;
        let sumApprovalExpense = 0;
        clearTable();
        for (let result of results) {
            sumExpense += result.expense
            sumApprovalExpense += result.approvalExpense
            $('#tbody').append(
               `
                 <tr onclick="openPopup('expense/detail/\${result.expenseId}', '경비 상세 수정/삭제')">
                    <td id="rowNo\${result.expenseId}">\${result.expenseId}</td>
                    <td>\${result.useDate}</td>
                    <td>\${result.usageType.title}</td>
                    <td name="expense">\${result.expense}</td>
                    <td name="approvalExpense">\${result.approvalExpense}</td>
                    <td>\${result.processingState.title}</td>
                    <td>\${result.regDate}</td>
                </tr>
                `
            )
            $('#sumExpense').html(sumExpense);
            $('#sumApprovalExpense').html(sumApprovalExpense);

        }

    };

    window.deleteExpense = function (expenseId) {
        const rowNo = 'rowNo'+expenseId
        afterDeleteExpenseSum(rowNo)

        $('#'+rowNo).parent().remove();
    };

    let afterDeleteExpenseSum = function (rowNo) {
        let expense = $('#'+rowNo).parent().find('td[name="expense"]').html();
        let approvalExpense = $('#'+rowNo).parent().find('td[name="approvalExpense"]').html();
        let sumApprovalExpense = $('#sumApprovalExpense').html();
        let sumExpense = $('#sumExpense').html();
        sumApprovalExpense = eval(sumApprovalExpense-approvalExpense);
        sumExpense = eval(sumExpense-expense);
        $('#sumApprovalExpense').html(sumApprovalExpense);
        $('#sumExpense').html(sumExpense);
    };
</script>
</body>
</html>

