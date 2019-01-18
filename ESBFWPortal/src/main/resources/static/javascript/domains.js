$(document).ready(function()

    {
        var year = currentTime.getFullYear();
        console.log("the year is "+year);

        $.ajax
        ({
           	type:'GET',	
           	context:this,
        	url: '/api/domains',
        	//cache: false,
        	success: function(domains)
        	{
        		//console.log('success', domains);
        		var domain_data='';
        		$.each(domains,function(key,domain)
        			{
        				
        				domain_data += '<tr>';
        				domain_data += '<td id="dId">'+domain.domainId+'</td>';
        				domain_data += '<td id="dType">'+domain.domainType+'</td>';
        				domain_data += '<td id="dName">'+domain.domainName+'</td>';
        				domain_data += '</tr>';
        			});


        	
        		$('#tabledomain tbody').append(domain_data);
        		
        		    $('#tabledomain').DataTable();
        		   
        		

       		
        	},
        	
        	error: function(xhr, status, error) 
              {                        
                     
                  // $("#newusererror").empty();                
                   //$("#newusererror").append(xhr.responseText +"<br>");
                   console.log(xhr.responseText);
                
               }

        });

        
   
   });