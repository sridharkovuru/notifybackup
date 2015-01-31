<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Notify</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet" />
    <link href="resources/css/font-awesome.css" rel="stylesheet" />
    <link href="resources/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="resources/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.metisMenu.js"></script>
    <script src="resources/js/morris/raphael-2.1.0.min.js"></script>
    <script src="resources/js/morris/morris.js"></script>
	<script type="text/javascript" src="resources/js/custom.js"></script>	
    
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
</body>
</html>