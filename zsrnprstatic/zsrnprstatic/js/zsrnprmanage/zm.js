


zsrnpr.e({

	zm:{
		gridcreate:/**
			 * @param oResult
			 */
			function(oResult)
			{
				
				require(['dojo/_base/lang', 'dojox/grid/DataGrid', 'dojo/data/ItemFileWriteStore'],
					    function(lang, DataGrid, ItemFileWriteStore){

					    /*set up data store*/
					    var data = {
					      identifier: "id",
					      items: []
					    };
					    var data_list = oResult.data;
					    var rows = oResult.size;
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
		father:parent.zsrnpr.zm_default,
		gridload:function()
		{
			require(["dojo/request","dojo/json"],
					function(request,JSON){
				dojo.ready(
				function()
				{
					request("../json/grid/aaa").then
					(
						function(data)
						{
							var oResult=JSON.parse(data, true);
							zsrnpr.zm.gridcreate(oResult); 
						
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
		
		
		
		
		
	}
		
});




require(["dojo/ready"], function(ready){
	   ready(function(){
		  
		  zsrnpr.zm.father.hiddenload();
		   
		   
	   });
});










