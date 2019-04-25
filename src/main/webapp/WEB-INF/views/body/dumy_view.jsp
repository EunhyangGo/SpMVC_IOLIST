<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.view-box{
		width:60%;
		border : 1px solid blue;
		margin: 20px auto;
		padding-left: 20px;
	}
	
	.view-box h3, .view-box h5{
		text-align: center;
	}
	
	.view-box b{
		color:blue;
		
	}
	
	.view-box span{
		color: green;
	}
</style>
<article class="view-box">
	<h3>매입매출 정보 관리 v 1.0</h3>
	<h5>since: 2019년 04월 03일</h5>
	<p><b>서버명 :</b><span>${pageContext.request.serverName}</span>
	<p><b>포트번호 :</b><span>${pageContext.request.serverPort}</span>
	<p><b>Method :</b><span>${pageContext.request.method}</span>
	<p><b>Context path :</b><span>${pageContext.request.contextPath}</span>
	<p><b>path 정보 :</b><span>${pageContext.request.pathInfo}</span>
	<p><b>pat Translate:</b><span>${pageContext.request.pathTranslated}</span>
	<p><b>Query String :</b><span>${pageContext.request.queryString}</span>
	<p><b>Request URI :</b><span>${pageContext.request.requestURI}</span>
	<p><b>Request URL :</b><span>${pageContext.request.requestURL}</span>
	
	<h3>${MSG}</h3>
</article>