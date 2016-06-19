<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>${param.title}</title>
</head>
<body>
<header>
  <jsp:include page="_header.jsp"/>
</header>

<main>
  ${param.main}
</main>

<footer>

</footer>
<jsp:include page="_scripts.jsp"/>
<jsp:include page="_styles.jsp"/>
</body>
</html>