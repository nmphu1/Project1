<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.StaffInfo"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>会社員管理システム</title>
<link href="view/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<i class="glyphicon glyphicon-user"></i>
	<div class="header">会社員管理システム</div>
	<div>
		<div class="shain">社員一覧</div>

		<button class="my-btn my-btn-logout">ログアウト</button>
		<a href="http://localhost:8080/ServletProject1/insert" class="my-btn my-btn-insert">追加</a>
	</div>

	<br>
	<br>

	<table class="table" style="width: 96%">
		<tr>
			<th class=" title-table ">ID</th>
			<th class="title-table ">名前</th>
			<th class="title-table ">性別</th>
			<th class="title-table ">部署</th>
			<th class="title-table ">備考</th>
			<th class="title-table "></th>
		</tr>
		<%
		ArrayList<StaffInfo> list_staff = (ArrayList<StaffInfo>) request.getAttribute("list_staff");
		for (StaffInfo staff : list_staff) {
		%>
		<tr>
			<td><%=staff.getId()%></td>
			<td><%=staff.getName()%></td>
			<td><%=staff.getSex()%></td>
			<td><%=staff.getPosition()%></td>
			<td><%=staff.getMarks()%></td>
			<td>
			<a href="/ServletProject1/update/?id=<%=staff.getId()%>" class="my-btn sua">編集</a>
			<a href="/ServletProject1/delete" class="my-btn xoa">削除</a>
			</td>
		</tr>
		<%
		}
		%>

	</table>



</body>
</html>