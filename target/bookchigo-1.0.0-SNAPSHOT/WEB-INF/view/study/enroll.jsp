<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>스터디원 모집</title>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        @import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
        * {
           margin-left: auto; margin-right: auto;
        }
        .bookimg {
            width:100px;
            height:150px;
        }
        table {
            width:500px;
        }
        input[type=text] {
            width:200px;
        }
        textarea {
            width:100%;
            height:200px;
        }

</style>
</head>

<body>
    <div align="center">
        <div class="title">
            <h2 style="font-family: 'Jeju Myeongjo', sans-serif; font-size : 40px; font-weight: 800;">북 치고 중고 치고</h2>
            <h3 style="font-family: 'Jeju Myeongjo', sans-serif; font-size : 30px; font-weight: 500; margin-top:-25px;">스터디 등록</h3>
        </div>
        <div class="post">
            <form action="register.do" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>스터디 이름</td>
                    <td><input type="text" name="studyName"></td>
                </tr>
                
                <tr>
                    <td>토론 일정</td>
                    <td><input type="text" name="discussionDate"></td>
                </tr>
                <tr>
                    <td>도서 이름</td>
                    <td><input type="text" name="bookName"></td>
                </tr>
                <tr>
                    <td>작가</td>
                    <td><input type="text" name="bookAuthor"></td>
                </tr>
                <tr>
                    <td>스터디 소개</td>
                    <td><textarea name="introduction"></textarea></td>
                </tr>
                <tr>
                    <td>사진</td>
                    <td><input type="file" name="file" value="첨부하기"><br>
                </tr>
                <tr>
                    <td>정원</td>
                    <td>
                        <select name="maxMemberCnt">
                        <option value="5">5명</option>
                        <option value="6">6명</option>
                        <option value="7">7명</option>
                        <option value="8">8명</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td style="text-align: center;" colspan="2">
                        <input type="submit" value="등록하기">
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
    </div>
</body>