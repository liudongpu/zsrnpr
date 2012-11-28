



define(
		
		function(){  
 

	
	var zsrnprmanage={
			
			
			gridcreate:/**
			 * @param oResult
			 */
			function(oResult)
			{
				
				require(['dojo/_base/lang', 'dojox/grid/DataGrid', 'dojo/data/ItemFileWriteStore', 'dojo/dom', 'dojo/domReady!'],
					    function(lang, DataGrid, ItemFileWriteStore, dom){

					    /*set up data store*/
					    var data = {
					      identifier: "id",
					      items: []
					    };
					    var data_list = oResult.data;
					    var rows = 60;
					    for(var i = 0, l = data_list.length; i < rows; i++){
					        data.items.push(lang.mixin({ id: i+1 }, data_list[i%l]));
					    }
					    var store = new ItemFileWriteStore({data: data});

					    /*set up layout*/
					    var layout = oResult.layout;

					    /*create a new grid*/
					    var grid = new DataGrid({
					        id: 'grid',
					        store: store,
					        autoHeight:true,
					        structure: layout});

					        /*append the new grid to the div*/
					        grid.placeAt("gridDiv");

					        /*Call startup() to render the grid*/
					        grid.startup();
					});
				
				}
		,

		gridload:/**
		 * 
		 */
		function()
		{
			require(["dojo/request","dojo/ready","dojo/json"],
					function(request,ready,JSON){
				ready(
				function()
				{
					request("../json/grid/aaa").then
					(
						function(data)
						{
							
							var oResult=JSON.parse(data, true);
							
							zsrnprmanage.gridcreate(oResult); 
						
							
						},
						function(err)
						{
							alert(err);
						}
					);
				}
				
				);
			});
			
		}
		
			
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	return zsrnprmanage;
	
	
	
	
	
	
	
	
	
	
	
	
 
}); 