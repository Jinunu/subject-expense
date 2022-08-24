<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<head>
    <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet"/>
</head>

<body>

<div>
    <form id="signupForm" method="post" action="/member/signup">
        <label>유저이름</label>
        <input type="text" id="username" name="username" value="" >
        <label>비밀번호</label>
        <input type="password" id="password" name="password" value="">
        <button id="save" type="button">가입</button>
        <button id="encode" type="button" >인코딩</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js" integrity="sha512-Gn0tSSjkIGAkaZQWjx3Ctl/0dVJuTmjW/f9QyB302kFjU4uTNP4HtA32U2qXs/TRlEsK5CoEqMEMs7LnzLOBsA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha512/0.8.0/sha512.js" integrity="sha512-i4HLZ1JUoWLoDfgFlZGjzoWJYa55JAGr9XMxpH2k7OxtvF2qI02P+V2c8Z39s9SjxWGCJ04zMXrq106juXOywA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>

    $(document).ready(function (){

        $('#encode').on('click', function (e) {
            e.preventDefault();
            let encodedPassword = sha512($('#password').val()).toString();
            alert(encodedPassword);
            console.log(encodedPassword);
        });
        $('#save').on('click', function (e) {
            e.preventDefault();
            let encodedPassword = sha512($('#password').val()).toString();
            $('#password').val(encodedPassword);
            $('#signupForm').submit();
        });







    })// document

</script>
</body>
</html>

