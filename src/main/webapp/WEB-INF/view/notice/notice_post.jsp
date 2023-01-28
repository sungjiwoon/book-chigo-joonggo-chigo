<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../main/IncludeTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림 : ${no.title }</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
</head>
<script>

</script>
<style>
@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
#communi_btn {
      margin-left : 50px;
      
      border : 1px solid #ffdbe4;
      background-color : #ffdbe4;
      color : grey;
      border-radius : 4px;
      font-size: 8px;
   }

   td.form-control {
      width : 500px;
   
   }
   button.btn1 {
    width: 500px;
    /* height: 29px; */
    border: 1px solid #DDDDDD;
    /* font-size: 12px; */
    /* padding: 9px; */
    /* display: block; */
    margin-top: 0px;
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 0px;
    text-align: center;
    /* margin-top: 20px; */
    cursor:pointer;
    padding: 9px 10px 9px 10px;
    background-color: #DDDDDD;
    color: #424242;
    display: inline-block;      
}

</style>
<body>
<table class = "form"> 
<tr> 
<td class="form-control"  style = "border:0">
       <p style = "font-size:10pt;"> ${no.noticeId}</p> 
    
</td></tr>
<tr> <td class="form-control" style = "height:50px; padding-top:10px;">
       <text style = "font-size:14pt;"> ${no.title} </text>
       <input type="hidden" name="title" value= "${no.title}">
    
    </td></tr>  
     <tr> <td style = "height:20px;" > </td> </tr> 
    <tr>
    <td class="form-control" style = "height:150px; padding-top:10px;">
          ${no.content }
         <input type="hidden" name="content" value= "${no.content}">
    </td></tr> <tr> <td style = "height:20px;" > </td> </tr> 
    <tr> <td> 
    <button class = "btn1" onclick="location.href='<c:url value='/notice/list.do'/>'" >  알림 목록   </button> </td> </tr> </table>
    
</body>
</html>