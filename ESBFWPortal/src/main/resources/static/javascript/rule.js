$(document).ready(function()

    {
    	
    	$('#selectservice').inputpicker({
		    url: '/api/services',
		    fields:['serviceId','serviceName'],
		    fieldText:'serviceName',
		    fieldValue:'serviceId',
		    filterOpen: true,
		    autoOpen: true
		});

		//console.log('sdcode--->', system.systemCode['systemCode']);
		$('#saverule').on('click',function(){
						var selected_service = $('#selectservice').inputpicker('element');
						
			        	
						var rule_id=$('#ruleid').val();
						var rule_order=$('#ruleorder').val();

			        	var service_id=selected_service['serviceId'];
			        	var service_name=selected_service['serviceName'];

			        	

			        	
			        	
			 

			        		$.ajax({
			        		type: 'POST',
			        		url: '/api/rules',
							headers: {
								      'Accept': 'application/json',
								      'Content-Type': 'application/json'
								    },
			        		data: JSON.stringify({
			        			ruleId:rule_id,
			        			ruleOrder:rule_order,
			        			serviceId:{serviceId:service_id}
			        			//serviceId:service_id
			        			
			        		}),
			        		error: function(xhr, status, error) 
				              {                        
				                     
				                  // $("#newusererror").empty();                
				                   //$("#newusererror").append(xhr.responseText +"<br>");
				                   console.log(xhr.responseText);
				                
				               }
							        		
			        		//cache:false
			 

			        	}); 
			        	
			        	

			        	
			        }); 


			 $.ajax
			        ({
			           	type:'GET',	
			           	context:this,
			        	url: '/api/rules',
			        	
			        	success: function(rules)
			        	{
			        		//console.log('success', systemdomains);
			        		var rules_data='';
			        		$.each(rules,function(key,rule)
			        			{
			        				//console.log(systemdomain.systemCode['systemName']);
			        				
			        				rules_data += '<tr>';
			        				rules_data += '<td id="rlId">'+rule.ruleId+'</td>';
			        				rules_data += '<td id="rlsid">'+rule.serviceId['serviceId']+'</td>';
			        				rules_data += '<td id="rlsnam">'+rule.serviceId['serviceName']+'</td>';
			        				rules_data += '<td id="rlorder">'+rule.ruleOrder+'</td>';
			        				rules_data += '</tr>';
			        			});


			        	
			        		$('#tablerule tbody').append(rules_data);
			        		  $('#tablerule').SetEditable(
			        		  							      {
						        	columnsEd: "0,1,3",
											  onEdit: function(element) 
											  {
											  	//console.log('edited');
											  	var rule_id = $(element).closest('tr').find('#rlId').text();
											  	var service_id = $(element).closest('tr').find('#rlsid').text();
											  	var service_name = $(element).closest('tr').find('#rlsnam').text();
											  	var rule_order = $(element).closest('tr').find('#rlorder').text();
										
											  
											  $.ajax({
											  	type:'PUT',
											  	url: '/api/rules',
			        							
			        							headers: {
													      'Accept': 'application/json',
													      'Content-Type': 'application/json'
													    },
												data: JSON.stringify({
									        			//systemCode:sCode,
									        			ruleId:rule_id,
									        			ruleOrder:rule_order,
									        			serviceId:{serviceId:service_id}
															     }),
												
												success:function()
												{
													location.reload();
													//$('#card1').hide('1000').show();
													//$('#tabledomain').DataTable().ajax.reload();
												}
												//cache: false
			        							

											  }); 
											  

											 

											  }, 

											  onDelete: function() 
											  {
											 
											  }, 

											  onBeforeDelete: function(elem)
											  {
											  	
											  	var rule_id = $(elem).closest('tr').find('#rlId').text();
											  

										  
																		           

												 $.confirm({
												 		//icon: 'fa fa-spinner fa-spin',
													    title: 'DELETE '+rule_id+ '?',
													    //content: 'Delete '+dName+ '?',
													    buttons: {
													        YES: {
													        	btnClass: 'btn-red',
													        	action:function () 
														        		{
														        			//
														        			$.ajax({
																				type:'DELETE',
																				url: '/api/rules/'+rule_id
																			     //cache: false

																			});

														        		}
													        		},

													        cancel:{ 
													        	btnClass: 'btn-blue',
													        	action:function () {
													        		location.reload();
													            //$.alert('Canceled!');
													        }},
													        
													    }
													});

										      //var nameTxt = $(elem).closest('tr').find('td:first-child').text();
											

											  },

											  onAdd: function() 
											  {
											  	//console.log('on add');
											  } 
								}
								

								); 
			        		    $('#tablerule').DataTable();

			        		

			       		
			        	},

			        	//cache:false,
			        	
			        	error: function(xhr, status, error) 
			              {                        
			                     
			                  // $("#newusererror").empty();                
			                   //$("#newusererror").append(xhr.responseText +"<br>");
			                   console.log(xhr.responseText);
			                
			               }

			        });

   });