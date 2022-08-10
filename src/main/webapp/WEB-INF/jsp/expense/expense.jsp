<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet"/>
    <link href="css/expense.css" rel="stylesheet">
</head>

<body>

    <section >
        <form>
            <div class="inner" for="regDate">
                <label>등록연월</label>
                <input id="regDate" type="month" value="">
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
            </div>
        </form>
    </section>


    <section >
        <div class="inner">
            <div class="table-container">
            <div class="table-title-container">
                총 x건

            </div>
            <div class="table-button-container">
                <button>엑셀 다운로드</button>
                <button id="save" onclick="openPopup('expense/expensePopup', '경비 등록/수정')">등록</button>
            </div>
            </div>
            <table>
                <tr>
                    <th>순번</th>
                    <th>사용일</th>
                    <th>사용내역</th>
                    <th>사용금액</th>
                    <th>승인금액</th>
                    <th>처리상태</th>
                    <th>등록일</th>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                    <td>Germany</td>
                </tr>
                <tfoot>
                <td>합계</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                <td>-</td>
                </tfoot>

            </table>
        </div>
    </section>


<script src="js/expense.js" ></script>
</body>
</html>

