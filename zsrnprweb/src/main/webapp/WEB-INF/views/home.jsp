<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
	<script src="http://zzf.m.srnpr.com/static/lib/dojo/dojo/dojo.js"
	           data-dojo-config="async: true"></script>
	           
	 <link href="http://zzf.m.srnpr.com/static/lib/dojo/dijit/themes/claro/claro.css"
	   rel="stylesheet"></link>
	<style type="text/css">html, body {
    width: 100%;
    height: 100%;
    margin: 0;
}

#borderContainerThree {
    width: 100%;
    height: 100%;
    overflow:hidden;
    border: none;
}</style>
	<script>dojoConfig = {parseOnLoad: true}</script>
	<script>
	
	
	require(["dojo/ready", "dijit/layout/AccordionContainer", "dijit/layout/ContentPane"], function(ready, AccordionContainer, ContentPane){
	    ready(function(){
	        var aContainer = new AccordionContainer({style:"height: 300px"}, "markup");
	        aContainer.addChild(new ContentPane({
	            title: "This is a content pane",
	            content: "Hi!"
	        }));
	        aContainer.addChild(new ContentPane({
	            title:"This is as well",
	            content:"Hi how are you?"
	        }));
	        aContainer.addChild(new ContentPane({
	            title:"This too",
	            content:"Hello im fine.. thnx"
	        }));
	        aContainer.startup();
	    });
	});
	
	
</script>
</head>
<body  class="claro">

<div id="markup" style="width: 300px; height: 300px"></div>



<div dojoType="dijit.layout.BorderContainer" id="main">
</div>



</body>
</html>
