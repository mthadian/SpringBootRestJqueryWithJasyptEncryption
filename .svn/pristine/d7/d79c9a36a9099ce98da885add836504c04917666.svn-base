$(document).ready(function()

    {

//  $('#tablesystem').DataTable();

        $.ajax
        ({
           	type:'GET',	
           	context:this,
        	url: '/api/systems',
        	
        	success: function(systems)
        	{
        		//console.log('success', systems);
        		var system_data='';
        		$.each(systems,function(key,system)
        			{
        				
        				system_data += '<tr>';
        				system_data += '<td id="Code">'+system.systemCode+'</td>';
        				system_data += '<td id="Name">'+system.systemName+'</td>';
        				system_data += '</tr>';
        			});


        	
        		$('#tablesystem tbody').append(system_data);
        		 
        		    $('#tablesystem').DataTable();       		

       		
        	},
        	cache: false,
        	
        	error: function()
        	{
        		console.log(error);
        	}

        });

   });