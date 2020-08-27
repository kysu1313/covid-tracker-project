<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sample JSP Page</h1>
<%@ page import="java.util.*" %>
<%@ page import="classes.CovidHistory" %>
<%@ page import="apiConnections.HistoryApiConn" %>
<%@ page import="classes.HistoryObject" %>


<%
HistoryApiConn histCon = new HistoryApiConn();
String body = histCon.getBody();
CovidHistory historyObject = new CovidHistory(body);
LinkedList<HistoryObject> histList = historyObject.getLinkedElements();
%>

<h2>Time on server: <%= new Date() %></h2>
<p>
This is a simple JSP page. I'm trying to figure out a good way to present the
api data. http://localhost/<i>appName</i>/javaHtml.jsp.
</p>
<div>
	<table>
		<a class="twitter-timeline" data-width="220" data-height="400" data-theme="dark" href="https://twitter.com/CDCgov?ref_src=twsrc%5Etfw">Tweets by CDCgov</a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
		
		<tr>
			<th colspan="1">Dates</th>
			<th colspan="2">Critical Cases</th>
		</tr>
		
			<% for (int i = 0; i < histList.size(); i++){ %>
			<tr>
				<td><% out.print(histList.get(i).getDate()); %>
				<td> ---->  
				<td><% out.print(histList.get(i).getCritical()); %>
			</tr>
			<% } %>
	</table>
</div>
</body></html>