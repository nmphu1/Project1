<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>delete thông tin</title>
</head>
<body>
	<form action="../delete" method="post">
		<p>本当に削除したいですか？</p> 
		<input type="hidden" id="staff-id" name="staff-id" value="${deleteId}">
		<input type="submit" name="" value="削除">
	</form>

</body>
</html>