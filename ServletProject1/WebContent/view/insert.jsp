<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html　lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="view/style.css" rel="stylesheet">
<body>
    <i class="glyphicon glyphicon-user"></i>
    <div class="header">会社員管理システム</div>
    <div class="shain">社員追加/編集</div>
    <form action= "insert" method = "post">
        <label for="staff-name">名前：</label>
        <br>
        <input type="text" id="staff-name" name="staff-name" value="">
        <br>
        <label for="staff-sex">性別：</label>
        <br>
        <input type="text" id="staff-sex" name="staff-sex" value="">
        <br>
        <label for="staff-position">位置：</label>
        <br>
        <input type="text" id="staff-position" name="staff-position" value="">
        <br>
        <label for="">参考：</label>
      
        <br>
        <textarea type="text" id="marks" name="staff-marks" value="" rows="5" cols="20"></textarea>
         <br>
         <br>
    	<button class="button"　type = "submit">保存</button>
    </form>


</body>
</html>