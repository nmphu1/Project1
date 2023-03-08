<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html　lang="ja">
<head>
<meta charset="UTF-8">
<title>Update</title>
<link href="../view/style.css" rel="stylesheet">
<body>
    <i class="glyphicon glyphicon-user"></i>
    <div class="header">会社員管理システム</div>
    <div class="shain">社員編集</div>
    <form action= "../update" method = "post"> 	 
        <label for="staff-name">名前：</label>
        <br>
        <input type="text" id="staff-name" name="staff-name" value="${staff.getName()}">
        <br>
        <label for="staff-sex">性別：</label>
        <br>
        <input type="text" id="staff-sex" name="staff-sex" value="${staff.getSex()}">
        <br>
        <label for="staff-position">位置：</label>
        <br>
        <input type="text" id="staff-position" name="staff-position" value="${staff.getPosition()}">
        <br>
        <label for="">参考：</label>
        <br>
        <textarea type="text" id="marks" name="staff-marks" rows="5" cols="20">${staff.getMarks()}</textarea>
         <br>
         <br>
          <input type="hidden" id="staff-id" name="staff-id" value="${staff.getId()}">
    	<button class="button"　type = "submit">更新</button>
    </form>


</body>
</html>