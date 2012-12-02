



zsrnpr.e({
	
	zm_default:
		{
		
		
			temp:{processbar:null},
		
		
			init:function()
			{
				
				
				this.addtab('系统数据库列表','zsrnprmanage/list/aa');

			},
			
			
			
			
			showload:function()
			{
				//zsrnpr.zm_default.temp.processbar.show();
				
				dijit.byId('zmc_default_processbar').show();
				
				
			},
			hiddenload:function()
			{
				//zsrnpr.zm_default.temp.processbar.hide();
				setTimeout(function(){ dijit.byId('zmc_default_processbar').hide();},500);
				
				
			},
			
			addtab:function(title,url)
			{
				var rrr=document.createElement("DIV"); 
				   var tmp = new dijit.layout.ContentPane({title:title,closable:true},rrr);
				   tmp.setContent('<iframe src="'+url+'" style="width:100%;height:100%;" frameborder="0"></iframe>');
				   
				   
				  // tmp.onclose(function(){alert('');});
				   
				   //require(["dojo/on"],function(on){ on(tmp,'DownloadEnd',function(){alert('')});});
				  
				   
				   dijit.byId("zmc_default_content").addChild(tmp);
				   dijit.byId("zmc_default_content").selectChild(tmp);
				   this.showload();
			}
		
		}
	
});










require(["dojo/ready","dojo/parser", "dijit/layout/ContentPane","dijit/layout/TabContainer","dojo/_base/array","dojo/topic", "dijit/layout/BorderContainer"],
		   
		   function(ready,parser,ContentPane,TabContainer,array,topic)
		   {
			   
			 //Monkey-patch TabContainer so closing a pane selects the adjacent one, rather than the first one.
			 //Remove this for 1.9 since it's fixed in #9776
			 TabContainer.prototype.removeChild = function(/*dijit/_WidgetBase*/ page){
			 	// Overrides StackContainer.removeChild() so closing the selected tab selects the adjacent tab,
			 	// rather than the first one
			 	
			 	// new line
			 	var idx = array.indexOf(this.getChildren(), page);

			 	// this.inherited(arguments) doesn't work, is there a better way to override TabContainer.removeChild() so it does?
			 	require("dijit/_Container").prototype.removeChild.apply(this, arguments);

			 	if(this._started){
			 		// this will notify any tablists to remove a button; do this first because it may affect sizing
			 		topic.publish(this.id + "-removeChild", page);	// publish
			 	}

			 	// If all our children are being destroyed than don't run the code below (to select another page),
			 	// because we are deleting every page one by one
			 	if(this._descendantsBeingDestroyed){ return; }

			 	// Select new page to display, also updating TabController to show the respective tab.
			 	// Do this before layout call because it can affect the height of the TabController.
			 	if(this.selectedChildWidget === page){
			 		this.selectedChildWidget = undefined;
			 		if(this._started){
			 			var children = this.getChildren();
			 			if(children.length){
			 				this.selectChild(children[Math.max(idx-1, 0)]);	// changed line
			 			}
			 		}
			 	}

			 	if(this._started){
			 		// In case the tab titles now take up one line instead of two lines
			 		// (note though that ScrollingTabController never overflows to multiple lines),
			 		// or the height has changed slightly because of addition/removal of tab which close icon
			 		this.layout();
			 	}
			 };
			   
			   
		   }
		   
		   );
		   
		   
		   
		   
		   /*加载完成**************/
		   require(["dojo/ready","dijit/Dialog"], function(ready,Dialog){
			   ready(function(){
				   setTimeout(function(){ var loader = dojo.byId("zmc_default_loader");loader.style.display = "none";},500);
				   
				   zsrnpr.zm_default.init();
				 
				  
				   
				   
			   });
			   });





