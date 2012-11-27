<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zsrnprmanage</title>

<link href="http://zzf.m.srnpr.com/static/zsrnprmanage/css/zmc_default.css"
	   rel="stylesheet"></link>
<link href="http://zzf.m.srnpr.com/static/zsrnprmanage/css/zmc_base.css"
	   rel="stylesheet"></link>
	   
	   
	   
<script src="http://zzf.m.srnpr.com/static/lib/dojo/dojo/dojo.js"
	           data-dojo-config="async: true,parseOnLoad:true"></script>
	     <link rel="stylesheet" href="http://zzf.m.srnpr.com/static/lib/dojo/dojo/resources/dojo.css" />      
	 <link href="http://zzf.m.srnpr.com/static/lib/dojo/dijit/themes/claro/claro.css"
	   rel="stylesheet"></link>
	   
	   <script>
	 
	   
	   require(["dojo/ready","dojo/parser", "dijit/layout/ContentPane","dijit/layout/TabContainer", "dijit/layout/BorderContainer"]);
	   
	   require(["dojo/ready"], function(ready){
		   ready(function(){setTimeout(function(){ var loader = dojo.byId("zmc_default_loader");loader.style.display = "none";},500) });
		   });
	   
	   </script>
	 
	   
</head>
<body  class="claro">
<div id="zmc_default_loader" class="zmc_default_loader"><div class="zmc_default_loaderInner"></div></div>



<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="liveSplitters: false" class="zmc_default_main">
 	<div id="zmc_default_head" data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top'">
        Hi, usually here you would have important information, maybe your company logo, or functions you need to access all the time..
    </div>
 <div data-dojo-type="dijit/layout/AccordionContainer" data-dojo-props="minSize:20, region:'leading', splitter:true" style="width: 300px;" id="leftAccordion">
        <div data-dojo-type="dijit/layout/AccordionPane" title="One fancy Pane">
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="Another one">
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="Even more fancy">
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="系统设置" selected="true">
        
        <div data-dojo-type="dojo/store/Memory" data-dojo-id="myStore">
    <!-- Create store with inlined data.
        For larger data sets should use dojo.store.JsonRest etc. instead of dojo.store.Memory. -->
    <script type="dojo/method">
         this.setData([
            { id: 'world', name:'The earth', type:'planet', population: '6 billion'},
            { id: 'AF', name:'Africa', type:'continent', population:'900 million', area: '30,221,532 sq km',
                    timezone: '-1 UTC to +4 UTC', parent: 'world'},
                { id: 'EG', name:'Egypt', type:'country', parent: 'AF' },
                { id: 'KE', name:'Kenya', type:'country', parent: 'AF' },
                    { id: 'Nairobi', name:'Nairobi', type:'city', parent: 'KE' },
                    { id: 'Mombasa', name:'Mombasa', type:'city', parent: 'KE' },
                { id: 'SD', name:'Sudan', type:'country', parent: 'AF' },
                    { id: 'Khartoum', name:'Khartoum', type:'city', parent: 'SD' },
            { id: 'AS', name:'Asia', type:'continent', parent: 'world' },
                { id: 'CN', name:'China', type:'country', parent: 'AS' },
                { id: 'IN', name:'India', type:'country', parent: 'AS' },
                { id: 'RU', name:'Russia', type:'country', parent: 'AS' },
                { id: 'MN', name:'Mongolia', type:'country', parent: 'AS' },
            { id: 'OC', name:'Oceania', type:'continent', population:'21 million', parent: 'world'},
            { id: 'EU', name:'Europe', type:'continent', parent: 'world' },
                { id: 'DE', name:'Germany', type:'country', parent: 'EU' },
                { id: 'FR', name:'France', type:'country', parent: 'EU' },
                { id: 'ES', name:'Spain', type:'country', parent: 'EU' },
                { id: 'IT', name:'Italy', type:'country', parent: 'EU' },
            { id: 'NA', name:'North America', type:'continent', parent: 'world' },
            { id: 'SA', name:'South America', type:'continent', parent: 'world' }
        ]);
    </script>
    <script type="dojo/method" data-dojo-event="getChildren" data-dojo-args="object">
         // Supply a getChildren() method to store for the data model where
         // children objects point to their parent (aka relational model)
         return this.query({parent: object.id});
    </script>
</div>

<!-- Create the model bridging the store and the Tree -->
<div data-dojo-type="dijit/tree/ObjectStoreModel" data-dojo-id="myModel"
  data-dojo-props="store: myStore, query: {id: 'world'}"></div>

<!-- Create the tree -->
<div data-dojo-type="dijit/Tree" id="myTree" data-dojo-props="model: myModel"></div>
        
        
        
        
        </div>
    </div>



	<div id="zmc_default_content" data-dojo-type="dijit/layout/TabContainer" data-dojo-props="region: 'center', tabStrip: true">
				<div id="zmc_default_baseTab" data-dojo-type="dijit/layout/ContentPane" data-dojo-props="title: 'Welcome'">
				<!-- Tags end on line afterwards to eliminate any whitespace -->

				<div id="foo" data-dojo-type="dijit/layout/ContentPane">
    
    <iframe src="zsrnprmanage/list/aa" style="width:100%;height:100%;" frameborder="0"></iframe>
</div>
				
				</div>
			</div>
 


   </div>
</body>
</html>