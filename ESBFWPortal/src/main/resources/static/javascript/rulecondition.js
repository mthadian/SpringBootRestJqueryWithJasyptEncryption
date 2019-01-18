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
		$('#saverule_cond').on('click',function(){
						var selected_rule = $('#selectrule').inputpicker('element');
			        	var rule_id=selected_rule['ruleId'];
			        	var cond_id=$('#rulecondid').val(); 
			        	var cond_order=$('#rulecondorder').val();  
			        	var fild_opr=$('#fildoper').val(); 	
			        	var fild_nm=$('#fildname').val();
			        	var fild_val=$('#fildvalue').val();  


			      
			        		$.ajax({
			        		type: 'POST',
			        		url: '/api/ruleconditions',
							headers: {
								      'Accept': 'application/json',
								      'Content-Type': 'application/json'
								    },
			        		data: JSON.stringify({
			        			ruleConditionId:cond_id,
			        			ruleConditionOrder:cond_order,
			        			fieldOperation:fild_opr,
			        			fieldName:fild_nm,
			        			fieldValue:fild_val,
			        			ruleId:{ruleId:rule_id}
			        		
			        		}),
			        		success: function(result){
			                    console.log(result);
			                    
			                   },
				           	error: function(xhr, textStatus, error,result) {
				                    console.log(xhr.responseText);
				                   
                 					 }


			 

			        	}); 
			        		
			        }); 


			 $.ajax
			        ({
			           	type:'GET',	
			           	context:this,
			        	url: '/api/ruleconditions',
			        	
			        	success: function(ruleconditions)
			        	{
			        		//console.log('success', systemdomains);
			        		var rulecon_data='';
			        		$.each(ruleconditions,function(key,rulecondition)
			        			{
			        				//console.log(systemdomain.systemCode['systemName']);
			        				
			        				rulecon_data += '<tr>';
			        				rulecon_data += '<td id="rlcdid">'+rulecondition.ruleConditionId+'</td>';
			        				rulecon_data += '<td id="rlid">'+rulecondition.ruleId['ruleId']+'</td>';
			        				rulecon_data += '<td id="rlconord">'+rulecondition.ruleConditionOrder+'</td>';
			        				rulecon_data += '<td id="rlfldopr">'+rulecondition.fieldOperation+'</td>';
			        				rulecon_data += '<td id="rlfldnm">'+rulecondition.fieldName+'</td>';
			        				rulecon_data += '<td id="rlfldval">'+rulecondition.fieldValue+'</td>';
			        				rulecon_data += '</tr>';
			        			});


			        	
			        		$('#tablerulecond tbody').append(rulecon_data);
			        		  $('#tablerulecond').SetEditable(
			        		  	
			        		  			 {
						        	//columnsEd: "0,1,2",
											  onEdit: function(element) 
											  {
											  	//console.log('edited');
											  	var rule_con_id = $(element).closest('tr').find('#rlcdid').text();
											  	var rule_id = $(element).closest('tr').find('#rlid').text();
											  	var rule_con_ord = $(element).closest('tr').find('#rlconord').text();
											  	var rule_con_fldopr = $(element).closest('tr').find('#rlfldopr').text();
											  	var rule_con_fldnm = $(element).closest('tr').find('#rlfldnm').text();
											  	var rule_con_fldval = $(element).closest('tr').find('#rlfldval').text();

									
											  $.ajax({
											  	type:'PUT',
											  	url: '/api/ruleconditions',
			        							
			        							headers: {
													      'Accept': 'application/json',
													      'Content-Type': 'application/json'
													    },
												data: JSON.stringify({
									        			//systemCode:sCode,
									        			ruleConditionId:rule_con_id,
									        			ruleConditionOrder:rule_con_ord,
									        			fieldOperation:rule_con_fldopr,
									        			fieldName:rule_con_fldnm,
									        			fieldValue:rule_con_fldval,
									        			ruleId:{ruleId:rule_id}
									        			

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
											  	
											  	var rule_con_id = $(elem).closest('tr').find('#rlcdid').text();
											  

										  
																		           

												 $.confirm({
												 		//icon: 'fa fa-spinner fa-spin',
													    title: 'DELETE '+rule_con_id+ '?',
													    //content: 'Delete '+dName+ '?',
													    buttons: {
													        YES: {
													        	btnClass: 'btn-red',
													        	action:function () 
														        		{
														        			//
														        			$.ajax({
																				type:'DELETE',
																				url: '/api/ruleconditions/'+rule_con_id
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
			        		    $('#tablerulecond').DataTable();

			        		

			       		
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