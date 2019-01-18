$(document).ready(function()

    {

    	$('#saveuser').on('click',function()
    	{
    		

    		if($('#inputPassword').val()=="" || $('#firstName').val()=="" || $('#lastName').val()==""  || $('#inputEmail').val()=="" || $('#username').val()=="" || $("#role")[0].selectedIndex <= 0 || $("#enabled")[0].selectedIndex <= 0)
    		{
    			//$("#newusererror").empty();                
                $("#newusererror").append("Fill all the Fields" +"<br>");
    		}
    		else
    		{
    				if($('#inputPassword').val()!=$('#confirmPassword').val())
		    		{
		    			//alert("no match");
		    			$("#newusererror").append("passwords don't match" +"<br>");
		    		}
		    		else
		    		{

		    			$.get(  
				          '/api/getlastroleid',
				          function(data) {

				            var current_authorityid=data.authorityid;
				            var authority_id=current_authorityid+1; 
				            console.log("Incremented authorityid "+authority_id);

				            var first_Name = $('#firstName').val(); 
				            var last_Name = $('#lastName').val();  
				            var email_ = $('#inputEmail').val(); 
				            var userName_ = $('#username').val();
				            var password_raw=$('#inputPassword').val();
				            var password_='"'+password_raw+  '"';
				            var role=$('#role :selected').val();
				            var enabled_=$('#enabled :selected').val();

				            

				            $.ajax({
					        		type: 'POST',
					        		url: '/api/users',
									headers: {
										      'Accept': 'application/json',
										      'Content-Type': 'application/json'
										    },
					        		data: JSON.stringify({
					        			users:{
						        				username:userName_,
						        				password:password_,
						        				enabled:enabled_,
						        				firstname:first_Name,
						        				lastname:last_Name,
						        				email:email_
					        				},
					        			roles:
						        			{
						        				authorityid:authority_id,
						        				authority:role,
						        				username:{username:userName_}

						        			}
					        			
					        			
					        			
					        		}),
					        		 error: function(xhr, status, error) 
				                      {                        
				                             
				                          // $("#newusererror").empty();                
				                           $("#newusererror").append(xhr.responseText +"<br>");
				                          // console.log(xhr.responseText);
				                        
				                       },
				                    success: function(data)
				                    {
				                       $('#newUserModal').modal('toggle');
				                       // data1 = $.parseJSON(JSON.stringify(data));
				                        // console.log(data1);
				                        location.reload();

				                    }
					 

					        	});

				         	 });
		    		}
    			

    		}










    	


    	});

	




			 $.ajax
			        ({
			           	type:'GET',	
			           	context:this,
			        	url: '/api/usersandroles',
			        	
			        	success: function(users)
			        	{
			        		//console.log('success', systemdomains);
			        		var users_data='';
			        		$.each(users,function(key,user)
			        			{
			        				//console.log(systemdomain.systemCode['systemName']);
			        				
			        				users_data += '<tr>';
			        				users_data += '<td id="username">'+user.username['username']+'</td>';
			        				users_data += '<td id="fname">'+user.username['firstname']+'</td>';
			        				users_data += '<td id="lname">'+user.username['lastname']+'</td>';
			        				users_data += '<td id="email_id">'+user.username['email']+'</td>';
			        				users_data += '<td id="auth">'+user.authority+'</td>';
			        				users_data += '<td id="enabl">'+user.username['enabled']+'</td>';
			        			
			        							        				
			        				users_data += '</tr>';
			        			});


			        	
			        		$('#tableusers tbody').append(users_data);
			        		  $('#tableusers').SetEditable(
			        		  	
			        		  							      {
						        	//columnsEd: "0,1,2",
											  onEdit: function(element) 
											  {
											  	//console.log('edited');
											  	var edit_username = $(element).closest('tr').find('#username').text();
											  	var edit_fname = $(element).closest('tr').find('#fname').text();
											  	var edit_lname = $(element).closest('tr').find('#lname').text
											  	var edit_email = $(element).closest('tr').find('#email_id').text();
											  	var edit_role = $(element).closest('tr').find('#auth').text();	
											  	var edit_enabled= $(element).closest('tr').find('#enabl').text();										  	
											  
											/**
									
											  $.ajax({
											  	type:'PUT',
											  	url: '/api/users',
			        							
			        							headers: {
													      'Accept': 'application/json',
													      'Content-Type': 'application/json'
													    },
												data: JSON.stringify({
									        			//systemCode:sCode,
									        			users:{
										        				username:edit_username,
										        				enabled:edit_enabled,
										        				firstname:edit_fname,
										        				lastname:edit_lname,
										        				email:edit_email
									        				},
									        			roles:
										        			{
										        				authority:edit_role,
										        				username:{username:edit_username}

										        			}
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
											  **/
											  

											 

											  }, 

											  onDelete: function() 
											  {
											 
											  }, 

											  onBeforeDelete: function(elem)
											  {
											  	/**

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
												 **/

										      //var nameTxt = $(elem).closest('tr').find('td:first-child').text();
											

											  },

											  onAdd: function() 
											  {
											  	console.log('on add');
											  } 
								}
								
								

								); 
			        		    $('#tableusers').DataTable();

			        		

			       		
			        	},

			        	//cache:false,
			        	
			        	error: function()
			        	{
			        		console.log(error);
			        	}

			        });

   });