$(document).ready(function()

    {


//  $('#tablesystem').DataTable();
  $('#saveservicedestination').on('click',function(e){
        	

        	var sdId=$('#sd_Id').val();
        	var url=$('#uri').val();
        	var enabled_=$('#enabled :selected').val();
        	var name_=$('#name').val();
        	//var domaintype=$('#domaintype :selected').val();

        	console.log('saved');
        	console.log(sdId);
        	console.log(url);
        	console.log(enabled_);
        	console.log(name_);
        	//console.log(domaintype);

        	
        		//$('#domain_Id').after('<span style="color:red;">*Required</span>');
        	
        		$.ajax({
        		type: 'POST',
        		url: '/api/servicedestinations',
				headers: {
					      'Accept': 'application/json',
					      'Content-Type': 'application/json'
					    },
        		data: JSON.stringify({
        			serviceId:sdId,
        			uri:url,
        			name:name_,
        			enabled:enabled_
        			
        		}),
        		cache:false
 

        	});
        	



        	

        	//$("#tablediv" ).load("/domain #tablediv");
        	//$('#tabledomain').reload();
        	//location.reload();
        	

        		

        	


        	
        });





        $.ajax
        ({
           	type:'GET',	
           	context:this,
        	url: '/api/servicedestinations',
        	//cache: false,
        	success: function(servicedestinations)
        	{
        		//console.log('success', domains);
        		var sd_data='';
        		$.each(servicedestinations,function(key,servicedestination)
        			{
        				
        				sd_data += '<tr>';
        				sd_data += '<td id="sdid">'+servicedestination.serviceId+'</td>';
        				sd_data += '<td id="url">'+servicedestination.uri+'</td>';
        				sd_data += '<td id="name">'+servicedestination.name+'</td>';
        				sd_data += '<td id="enabled">'+servicedestination.enabled+'</td>';
        				sd_data += '</tr>';
        			});


        	
        		$('#tableservicedestination tbody').append(sd_data);
        		 $('#tableservicedestination').SetEditable(
			        {
			        	columnsEd: "0,1",
			        				

								  onEdit: function(elem) 
								  {
								  	//console.log('edited');
								  	var sd_id = $(elem).closest('tr').find('#sdid').text();
								  	var sUri = $(elem).closest('tr').find('#url').text();
								  	var sdName = $(elem).closest('tr').find('#name').text();
								  	var sdEnabled = $(elem).closest('tr').find('#enabled').text();
								  	
								  	
								  	
								   console.log("get row data ");
								   console.log(sd_id);
								   console.log(sUri);
								   console.log(sdName);
								   console.log(sdEnabled);


								  
								  $.ajax({
								  	type:'PUT',
								  	url: '/api/servicedestinations/',
        							//cache: false,
        							headers: {
										      'Accept': 'application/json',
										      'Content-Type': 'application/json'
										    },
									data: JSON.stringify({
						        			serviceId:sd_id,
						        			uri:sUri,
						        			name:sdName,
						        			enabled:sdEnabled
						        		}),
									success:function()
									{
										location.reload();
										console.log('refresh table');
										//$('#card1').hide('1000').show();
										//$('#tabledomain').DataTable().ajax.reload();
									}
        							

								  }); 
								  

								 

								  }, 

								  onDelete: function() 
								  {
								  	//var bid = this.id; // button ID 
  									 //var trid = $(this).closest('tr').attr('id');
  									 //console.log('on delete');
								 
								  }, 

								  onBeforeDelete: function(elem)
								  {
								  	
								  var sd_id = $(elem).closest('tr').find('#sdid').text();
								  	var sUri = $(elem).closest('tr').find('#url').text();
								  	var sdName = $(elem).closest('tr').find('#name').text();
								  	var sdEnabled = $(elem).closest('tr').find('#enabled').text();
								  	

								  console.log("delete this ");
								   console.log(sd_id);
								   console.log(sUri);
								   console.log(sdName);
								   console.log(sdEnabled);
															           

									 $.confirm({
									 		//icon: 'fa fa-spinner fa-spin',
										    title: 'DELETE '+sdName+ '?',
										    //content: 'Delete '+dName+ '?',
										    buttons: {
										        YES: {
										        	btnClass: 'btn-red',
										        	action:function () 
											        		{
											        			//
											        			$.ajax({
																	type:'DELETE',
																	url: '/api/servicedestinations/'+sd_id
																    // cache: false

																});
																location.reload();

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
					});
        		    $('#tableservicedestination').DataTable();
        		   // $( "#tablediv" ).load(window.location.href + "#tablediv" );

        		

       		
        	},
        	
        	error: function()
        	{
        		console.log(error);
        	}

        });
        

      


   /* $("#card1").toggle(300).toggle(300); */
   });