<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zsrnprmanage-list</title>

<link href="http://zzf.m.srnpr.com/static/zsrnprmanage/css/zmc_default.css"
	   rel="stylesheet"></link>
	   <link href="http://zzf.m.srnpr.com/static/lib/dojo/dojox/grid/resources/Grid.css"
	   rel="stylesheet"></link>
<link href="http://zzf.m.srnpr.com/static/lib/dojo/dojox/grid/resources/claroGrid.css"
	   rel="stylesheet"></link>
	   
	   <style type="text/css">
/*Grid needs an explicit height by default*/
#grid {
    height: 20em;
}</style>
	   
<script src="http://zzf.m.srnpr.com/static/lib/dojo/dojo/dojo.js"
	           data-dojo-config="async: true,parseOnLoad:true"></script>
<link rel="stylesheet" href="http://zzf.m.srnpr.com/static/lib/dojo/dojo/resources/dojo.css" />      
<link href="http://zzf.m.srnpr.com/static/lib/dojo/dijit/themes/claro/claro.css" rel="stylesheet"></link>
<script>

require(["dojo/ready","dojo/parser"]);


require(['dojo/_base/lang', 'dojox/grid/DataGrid', 'dojo/data/ItemFileWriteStore', 'dojo/dom', 'dojo/domReady!'],
	    function(lang, DataGrid, ItemFileWriteStore, dom){

	    /*set up data store*/
	    var data = {
	      identifier: "id",
	      items: []
	    };
	    var data_list = [
	      { col1: "normal", col2: false, col3: 'But are not followed by two hexadecimal', col4: 29.91},
	      { col1: "important", col2: false, col3: 'Because a % sign always indicates', col4: 9.33},
	      { col1: "important", col2: false, col3: 'Signs can be selectively', col4: 19.34}
	    ];
	    var rows = 60;
	    for(var i = 0, l = data_list.length; i < rows; i++){
	        data.items.push(lang.mixin({ id: i+1 }, data_list[i%l]));
	    }
	    var store = new ItemFileWriteStore({data: data});

	    /*set up layout*/
	    var layout = [[
	      {'name': 'Column 1', 'field': 'id', 'width': '100px'},
	      {'name': 'Column 2', 'field': 'col2', 'width': '100px'},
	      {'name': 'Column 3', 'field': 'col3', 'width': '200px'},
	      {'name': 'Column 4', 'field': 'col4', 'width': '150px'}
	    ]];

	    /*create a new grid*/
	    var grid = new DataGrid({
	        id: 'grid',
	        store: store,
	        structure: layout,
	        rowSelector: '20px'});

	        /*append the new grid to the div*/
	        grid.placeAt("gridDiv");

	        /*Call startup() to render the grid*/
	        grid.startup();
	});

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