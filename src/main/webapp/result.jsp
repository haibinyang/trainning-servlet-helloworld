<%@ page import="java.util.*" %>

<html>
<body>
<h1 align="center">JSP </h1>
<p>

	<br/> This is JSP22 <br/>
<%
	List styles = (List)request.getAttribute("styles");
	Iterator it = styles.iterator();
	while(it.hasNext()) {
		out.print("<br>try: " + it.next());
	}
	%>
	
</body>
</html>
