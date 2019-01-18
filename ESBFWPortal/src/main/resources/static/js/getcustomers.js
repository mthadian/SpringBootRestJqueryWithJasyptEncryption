$(document).ready(function()

    {

 $('#tablesystem').DataTable();

  
        $.ajax
        ({
           	type:'GET',	
           	context:this,
        	url: '/api/customers',
        	cache: false,
        	success: function(customers)
        	{
        		console.log('success', customers);
        		var customer_data='';
        		$.each(customers,function(key,customer)
        			{
        				
        				customer_data += '<tr>';
        				customer_data += '<td id="cId">'+customer.customerId+'</td>';
        				customer_data += '<td id="fName">'+customer.firstName+'</td>';
        				customer_data += '<td id="lName">'+customer.lastName+'</td>';
        				customer_data += '<td id="phoneId">'+customer.phone+'</td>';
        				customer_data += '</tr>';
        			});


        	
        		$('#tabledomain tbody').append(customer_data);
        		$('#tabledomain').DataTable();
        		 $('#tabledomain').SetEditable(
			        {
								  onEdit: function(elem) 
								  {
								  	//console.log('edited');
								  	var custId = $(elem).closest('tr').find('#cId').text();
								  	var fName = $(elem).closest('tr').find('#fName').text();
								  	var lName = $(elem).closest('tr').find('#lName').text();
								  	var phoneId = $(elem).closest('tr').find('#phoneId').text();
								  	
								   console.log("get row data ");
								   console.log(custId);
								   console.log(fName);
								   console.log(lName);
								   console.log(phoneId);


								  
								  $.ajax({
								  	type:'PUT',
								  	url: '/api/customers/',
        							cache: false,
        							headers: {
										      'Accept': 'application/json',
										      'Content-Type': 'application/json'
										    },
									data: JSON.stringify({
						        			customerId:custId,
						        			firstName:fName,
						        			lastName:lName,
						        			phone:phoneId
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
  									 console.log('on delete');
								 
								  }, 

								  onBeforeDelete: function(elem)
								  {
								  	var dataId = $(elem).closest('tr').find('#cId').text();
								  	var fName = $(elem).closest('tr').find('#fName').text();
								  	var lName = $(elem).closest('tr').find('#lName').text();
								  	var phoneId = $(elem).closest('tr').find('#phoneId').text();

								  console.log("beforeyyy delete ");
								  console.log(dataId);
								  
							  
															           

									 $.confirm({
									 		//icon: 'fa fa-spinner fa-spin',
										    title: 'DELETE A DOMAIN',
										    content: 'Delete '+fName+ '?',
										    buttons: {
										        confirm: {
										        	btnClass: 'btn-red',
										        	action:function () 
											        		{
											        			//
											        			$.ajax({
																	type:'DELETE',
																	url: '/api/customers/'+dataId,
																     cache: false

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
					});
        		

       		
        	},
        	
        	error: function()
        	{
        		console.log(error);
        	}

        });

        $('#savedomain').on('click',function(){
        	//preventDefault();

        	var customer_Id=$('#customer_Id').val();
        	var first_Name=$('#first_Name').val();
        	var last_Name=$('#last_Name').val();
        	var phone_No=$('#phone_no').val();

        	if(customer_Id=='')
				{
				alert("Please fill out the form");
				}



        	$.ajax({
        		type: 'POST',
        		url: '/api/customers',
				headers: {
					      'Accept': 'application/json',
					      'Content-Type': 'application/json'
					    },
        		data: JSON.stringify({
        			customerId:customer_Id,
        			firstName:first_Name,
        			lastName:last_Name,
        			phone:phone_No
        		})
 

        	});
        });


   /* $("#card1").toggle(300).toggle(300); */
   });