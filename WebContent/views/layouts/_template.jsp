<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <title>Iniciar Sesión</title>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- Le fav icons -->
    <link rel="shortcut icon" href="/assets/images/favicon.ico">
  </head>
  
  <body>
  		<tiles:insertAttribute name="body" ignore="true"></tiles:insertAttribute>
  </body>
  
   <script type="text/javascript" src="assets/js/jquery.min.js"></script>
   <script type="text/javascript" src="assets/js/bootstrap-modal.js"></script>
   <script type="text/javascript" src="assets/js/bootstrap-twipsy.js"></script>
   <script type="text/javascript" src="assets/js/bootstrap-popover.js"></script>
   <script type="text/javascript" src="assets/js/nota.js"></script>
</html>