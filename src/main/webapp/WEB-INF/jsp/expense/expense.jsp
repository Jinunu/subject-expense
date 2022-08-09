<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet"/>
    <link href="css/expense.css" rel="stylesheet">
</head>

<body>
<%--    <header>--%>
<%--        <div class=""></div>--%>

<%--    </header>--%>
<%--    <section >--%>
<%--        <div class="inner">--%>

<%--        </div>--%>
<%--    </section>--%>

<%--    <div>--%>


<%--    </div>--%>

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

