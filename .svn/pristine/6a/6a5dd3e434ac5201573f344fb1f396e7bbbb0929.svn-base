$(document).ready(function()

    {
			 $.ajax
			        ({
			           	type:'GET',	
			           	context:this,
			        	url: '/api/systemdomains',
			        	
			        	success: function(systemdomains)
			        	{
			        		//console.log('success', systemdomains);
			        		var systemdomain_data='';
			        		$.each(systemdomains,function(key,systemdomain)
			        			{
			        				
			        				
			        				systemdomain_data += '<tr>';
			        				systemdomain_data += '<td id="sdId">'+systemdomain.systemDomainId+'</td>';
			        				systemdomain_data += '<td id="sCode">'+systemdomain.systemCode['systemCode']+'</td>';
			        				systemdomain_data += '<td id="sName">'+systemdomain.systemCode['systemName']+'</td>';
			        				systemdomain_data += '<td id="dId">'+systemdomain.domainId+'</td>';
			        				systemdomain_data += '</tr>';
			        			});


			        	
			        		$('#tablesystemdomain tbody').append(systemdomain_data);
			        		  
			        		    $('#tablesystemdomain').DataTable();

			        		

			       		
			        	},

			        	//cache:false,
			        	
			        	error: function()
			        	{
			        		console.log(error);
			        	}

			        });

   });