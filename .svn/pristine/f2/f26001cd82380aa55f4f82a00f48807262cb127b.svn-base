$(document).ready(function()

    {
    	
    	$('#selectrule').inputpicker({
		    url: '/api/rules',
		    fields:['ruleId'],
		    fieldText:'ruleId',
		    fieldValue:'ruleId',
		    filterOpen: true,
		    autoOpen: true
		});

		//console.log('sdcode--->', system.systemCode['systemCode']);
		$('#saverule_dest').on('click',function(){
						var selected_service = $('#selectrule').inputpicker('element');
						
			        	
						var rule_dest_id=$('#ruledestid').val();

			        	var serviceArray=selected_service['serviceId'];
			        	var rule_id=selected_service['ruleId'];
			        	var service_id=serviceArray['serviceId'];
			        	//var service_name=selected_service['serviceName'];        	

			        	console.log('RULE--->');
			        	console.log(rule_dest_id);
			        	console.log(rule_id);
			        	//console.log(rule_order);
			        	//console.log(service_id);
			        	console.log(service_id);
			        	console.log('SERVICE--->');
			      
			        		$.ajax({
			        		type: 'POST',
			        		url: '/api/ruledestinations',
							headers: {
								      'Accept': 'application/json',
								      'Content-Type': 'application/json'
								    },
			        		data: JSON.stringify({
			        			ruleDestinationId:rule_dest_id,
			        			serviceId:{serviceId:service_id},
			        			ruleId:{ruleId:rule_id}
			        			
			        			
			        			
			        		})
			 

			        	}); 
			        		
			        }); 


			 $.ajax
			        ({
			           	type:'GET',	
			           	context:this,
			        	url: '/api/ruledestinations',
			        	
			        	success: function(ruledestinations)
			        	{
			        		//console.log('success', systemdomains);
			        		var ruledest_data='';
			        		$.each(ruledestinations,function(key,ruledestination)
			        			{
			        				//console.log(systemdomain.systemCode['systemName']);
			        				
			        				ruledest_data += '<tr>';
			        				ruledest_data += '<td id="rldid">'+ruledestination.ruleDestinationId+'</td>';
			        				ruledest_data += '<td id="rlid">'+ruledestination.ruleId['ruleId']+'</td>';
			        				ruledest_data += '<td id="rldsid">'+ruledestination.serviceId['serviceId']+'</td>';
			        				
			        				ruledest_data += '</tr>';
			        			});


			        	
			        		$('#tableruledest tbody').append(ruledest_data);
			        		  $('#tableruledest').SetEditable(
			        		  							      {
						        	//columnsEd: "0,1,2",
											  onEdit: function(element) 
											  {
											  	//console.log('edited');
											  	var rule_des_id = $(element).closest('tr').find('#rldid').text();
											  	var rule_id = $(element).closest('tr').find('#rlid').text();
											  	var service_id = $(element).closest('tr').find('#rldsid').text();
											  	var servId;
												  	$.get(  
										                  '/api/ruledestinations/rule/'+rule_id,
										                  function(data) {

										                    var servId=data.serviceId.serviceId;
										                    console.log(servId);
										                  }
										               );
												  	console.log(servId);
												  	//console.log(serv);
									
											  $.ajax({
											  	type:'PUT',
											  	url: '/api/ruledestinations',
			        							
			        							headers: {
													      'Accept': 'application/json',
													      'Content-Type': 'application/json'
													    },
												data: JSON.stringify({
									        			//systemCode:sCode,
									        			ruleDestinationId:rule_des_id,
									        			serviceId:{serviceId:service_id},
			        									ruleId:{ruleId:rule_id}

															     }),
												
												success:function()
												{
													location.reload();
													console.log('refresh table');
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
											  	
											  	var rule_des_id = $(elem).closest('tr').find('#rldid').text();
											  

										  
																		           

												 $.confirm({
												 		//icon: 'fa fa-spinner fa-spin',
													    title: 'DELETE '+rule_des_id+ '?',
													    //content: 'Delete '+dName+ '?',
													    buttons: {
													        YES: {
													        	btnClass: 'btn-red',
													        	action:function () 
														        		{
														        			//
														        			$.ajax({
																				type:'DELETE',
																				url: '/api/ruledestinations/'+rule_des_id
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
											  	console.log('on add');
											  } 
								}
								

								); 
			        		    $('#tableruledest').DataTable();

			        		

			       		
			        	},

			        	//cache:false,
			        	
			        	error: function()
			        	{
			        		console.log(error);
			        	}

			        });

   });