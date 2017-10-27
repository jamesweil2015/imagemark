<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<title>图片水印制作</title>
  	<meta name="keyword" content="图片水印制作">
  	<meta name="description" content="图片水印制作">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="图片水印制作">
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css?2024" rel="stylesheet" type="text/css" />
    <!--[if lte IE 6]>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-ie6.css?2024">
    <![endif]-->
    <!--[if lte IE 7]>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/ie.css?2024">
    <![endif]-->
    <link href="${pageContext.request.contextPath}/static/site.css?2024" rel="stylesheet" type="text/css" />
</head>
<body>
	<fieldset>
		<div id="legend">
	    	<legend class="leipiplugins-orgvalue">图片文字水印</legend>
	  	</div>
	  	<div class="controls">
		  ${message}&nbsp;
		  <c:if test='${not empty outfilename}'>
		  	<a href="${pageContext.request.contextPath}/servlet/downloadServlet?filename=${outfilename}">下载</a>&nbsp;
		  </c:if>
		  <a href="${pageContext.request.contextPath}">返回</a>&nbsp;
		</div>
	</fieldset>
</body>
</html>