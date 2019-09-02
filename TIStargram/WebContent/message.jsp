<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${msg != null }">
<script type="text/javascript">
	alert('${msg}');
	location.href = '${loc}';
</script>
</c:if>
<c:if test = "${msg == null }">
<script type="text/javascript">
	alert('not value');
	location.href = history.back();
</script>
</c:if>