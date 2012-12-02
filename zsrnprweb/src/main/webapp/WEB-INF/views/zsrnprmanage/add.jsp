<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zsrnprmanage-list</title>
 

	   
	   <style type="text/css">
/*Grid needs an explicit height by default*/
#grid {
    height: 20em;
}</style>
   
<script src="http://zzf.m.srnpr.com/zsrnprstatic/lib/dojo/dojo/dojo.js"
	           data-dojo-config="async: true,parseOnLoad:true,isDebug:true"></script>
	           
<link rel="stylesheet" href="http://zzf.m.srnpr.com/zsrnprstatic/lib/dojo/dojo/resources/dojo.css" />      
<link href="http://zzf.m.srnpr.com/zsrnprstatic/lib/dojo/dijit/themes/claro/claro.css" rel="stylesheet"></link>
<link href="http://zzf.m.srnpr.com/zsrnprstatic/lib/dojo/dojox/grid/resources/claroGrid.css"
	   rel="stylesheet"></link>
	   
	   
	   
<script src="http://zzf.m.srnpr.com/zsrnprstatic/js/zsrnpr/zsrnpr.js"></script>	 
<script src="http://zzf.m.srnpr.com/zsrnprstatic/js/zsrnprmanage/zm.js"></script>	 	   
	   
	   
	   
<script>

//zsrnpr.zsrnprmanage.gridload();
 require(["dojo/ready","dojo/parser"]);
	   
//dojo.ready(function(){require(['zsrnpr/zsrnprmanage'],function(zsrnprmanage){zsrnprmanage.gridload('dd'); });});

</script>

</head>
<body  class="claro">

<div id="toolbar1" data-dojo-type="dijit/Toolbar">
<div data-dojo-type="dijit/form/Button" id="toolbar1.cut"
        data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconCut'">新建</div
    ><div data-dojo-type="dijit/form/Button" id="toolbar1.copy"
        data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconCopy', showLabel:false">Copy</div
    ><div data-dojo-type="dijit/form/Button" id="toolbar1.paste"
        data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconPaste', showLabel:false">Paste</div
    ><!-- The following adds a line between toolbar sections
        --><span data-dojo-type="dijit/ToolbarSeparator"></span
     ><div data-dojo-type="dijit/form/ToggleButton" id="toolbar1.bold"
        data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconBold', showLabel:false">Bold</div>
</div>


<div id="gridDiv"></div>



</body>
</html>