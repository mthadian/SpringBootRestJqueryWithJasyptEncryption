$(document).ready(function()
{
	$('#btnnewservicebus').on('click',function()
	{
		 $('#selectServiceBusiness').inputpicker
          ({
              url: '/api/businessservices',
              fields:['serviceId','serviceName','operation','serviceCode'],
              fieldText:'serviceName',
              fieldValue:'serviceId',
              width:'300%',
              filterOpen:true,
              selectMode :'empty',
              headShow:true,
              autoOpen: true
          });


          $('#B_selectsystem_T').inputpicker
          ({
              url: '/api/systems',
              fields:['systemName','systemCode'],
              fieldText:'systemName',
              fieldValue:'systemCode',
              width:'100%',
              filterOpen: true,
              selectMode : 'empty',
              headShow:true,
              autoOpen: true
          });

          $('#B_selectdomain_T').inputpicker
          ({
              url: '/api/domains',
              fields:['domainName','domainType','domainId'],
              fieldText:'domainName',
              fieldValue:'domainId',
              width:'100%',
              filterOpen: true,
              selectMode : 'empty',
              headShow:true,
              autoOpen: true
          });


	});


var form = $("#form_new_service_business").show();
$('#serviceBusModal').on('click',function()
  {

  	var selected_B_service = $('#selectServiceBusiness').inputpicker('element');
  	var B_serv_id=selected_B_service['serviceId'];
  	var B_serv_code=selected_B_service['serviceCode'];
  	var B_serv_sysdom=selected_B_service['systemDomainId'];
  	var B_serv_name=selected_B_service['serviceName'];
  	var B_serv_operation=selected_B_service['operation'];


  	$("#txtB_service_id").empty();
    $("#txtB_service_id").append( "SERVICE ID: " +B_serv_id);

    $("#txtB_service_code").empty();
    $("#txtB_service_code").append( "SERVICE CODE: " +B_serv_code);

    $("#txtB_service_sysdomid").empty();
    $("#txtB_service_sysdomid").append( "SYSDOMAIN: " +B_serv_sysdom);

    $("#txtB_service_name").empty();
    $("#txtB_service_name").append( "NAME: " +B_serv_name);

    $("#txtB_service_operation").empty();
    $("#txtB_service_operation").append( "OPERATION: " +B_serv_operation);


    var B_selected_system_T = $('#B_selectsystem_T').inputpicker('element');
    var Bsystem_code_T=B_selected_system_T['systemCode'];
    var Bsystem_name_T=B_selected_system_T['systemName'];




    var B_selected_domain_T = $('#B_selectdomain_T').inputpicker('element');
    var Bdomain_id_T=B_selected_domain_T['domainId'];
    var Bdomain_name_T=B_selected_domain_T['domainName'];

    $.get( 
      '/api/systemdomain/'+Bsystem_code_T+'/'+Bdomain_id_T,
        function(data) {

         if(data===null)
         {
          alert("THERE IS NO SYSTEMDOMAIN FOR "+Bsystem_name_T+ " AND "+Bdomain_name_T);
         }
         else
         {
          var BsysdomId_T=data.systemDomainId;
          $("#B_sysdomid_T").empty();
          $("#B_sysdomid_T").append(BsysdomId_T);
         }
          
        });


  });
 
form.steps({
    headerTag: "h3",
    bodyTag: "fieldset",
    transitionEffect: "slideLeft",
    onStepChanging: function (event, currentIndex, newIndex)
    {
        // Allways allow previous action even if the current form is not valid!
        if (currentIndex > newIndex)
        {
            return true;
        }
       
       
        // Needed in some cases if the user went back (clean up)
        if (currentIndex < newIndex)
        {
            // To remove error styles
            form.find(".body:eq(" + newIndex + ") label.error").remove();
            form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
        }
        form.validate().settings.ignore = ":disabled,:hidden";
        return form.valid();
    },
    onStepChanged: function (event, currentIndex, priorIndex)
    {
    	   if (currentIndex === 5)
              {
              	var selected_B_service = $('#selectServiceBusiness').inputpicker('element');
			  	var B_serv_id=selected_B_service['serviceId'];
			  	var B_serv_code=selected_B_service['serviceCode'];
			  	var B_serv_sysdom=selected_B_service['systemDomainId'];
			  	var B_serv_name=selected_B_service['serviceName'];
			  	var B_serv_type=selected_B_service['serviceType'];
			  	var B_serv_timeout=selected_B_service['timeout'];

			  	var B_serv_operation=selected_B_service['operation'];
           
                
                $("#B_txtsysdom_sum_B").empty();
                $("#B_txtsysdom_sum_B").append( "SYSTEM DOMAIN: " +B_serv_sysdom);

                var servi_sysdom_T=document.getElementById('B_sysdomid_T').innerHTML;   
                $("#B_txtsysdom_sum_T").empty();
                $("#B_txtsysdom_sum_T").append( "SYSTEM DOMAIN: " +servi_sysdom_T);

                 
                $("#B_txtserviceoper_sum_B").empty();
                $("#B_txtserviceoper_sum_B").append( "SERVICE OPERATION: " +B_serv_operation);

                var servi_oper_T=$('#B_operation_T').val();   
                $("#B_txtserviceoper_sum_T").empty();
                $("#B_txtserviceoper_sum_T").append( "SERVICE OPERATION: " +servi_oper_T);


           
                $("#B_txtservicetype_sum_B").empty();
                $("#B_txtservicetype_sum_B").append( "SERVICE TYPE: " +B_serv_type);

                var servi_type_T=$('#B_servicetype_T :selected').val();  
                $("#B_txtservicetype_sum_T").empty();
                $("#B_txtservicetype_sum_T").append( "SERVICE TYPE: " +servi_type_T);

                
                $("#B_txtservicename_sum_B").empty();
                $("#B_txtservicename_sum_B").append( "SERVICE NAME: " +B_serv_name);

                var servi_name_T=$('#B_servicename_T').val();   
                $("#B_txtservicename_sum_T").empty();
                $("#B_txtservicename_sum_T").append( "SERVICE NAME: " +servi_name_T);

                 $("#B_txtservicedestname_sum").empty();
                $("#B_txtservicedestname_sum").append( "NAME: " +servi_name_T);
  
                $("#B_txtservicetimeout_sum_B").empty();
                $("#B_txtservicetimeout_sum_B").append( "TIMEOUT: " +B_serv_timeout);

                var servi_tmout_T=$('#B_timeout_T').val();   
                $("#B_txtservicetimeout_sum_T").empty();
                $("#B_txtservicetimeout_sum_T").append( "TIMEOUT: " +servi_tmout_T);

 
                $("#B_txtservicecode_sum").empty();
                $("#B_txtservicecode_sum").append( "SERVICE CODE: " +B_serv_code);

                

                /**
                var servi_sync=$('#sync :selected').val();  
                $("#B_txtservicesync_sum").empty();
                $("#B_txtservicesync_sum").append( "SYNC: " +servi_sync);
                **/

              
              }
        
    },
    onFinishing: function (event, currentIndex)
    {
        form.validate().settings.ignore = ":disabled";
        return form.valid();
    },
    onFinished: function (event, currentIndex)
    {
    	$.get('/api/lastruleid',
    		function(data)
    		{
    			//GET LAST RULEDestination ID AND INCREMENT
    			var rulId=data.ruleId;
	             var ruleid=rulId+1;

	             var user= $('#B_current_user').text(); 
	             

	             //Get serviceId of the business service selected
	            var selected_B_service = $('#selectServiceBusiness').inputpicker('element');
			  	var serv_id=selected_B_service['serviceId'];  
			  	var B_serv_code=selected_B_service['serviceCode']; 
			  	var B_version=selected_B_service['version'];
			  	var B_sync=selected_B_service['sync']; 
			  	var B_loglevel=selected_B_service['logLevel'];
			  	/**

			  	var B_dupcheck=selected_B_service['duplicateCheck'];
			  	var B_genreply=selected_B_service['genericReply'];
			  	var B_retrymax=selected_B_service['retryMax'];
			  	var B_retyInterval=selected_B_service['retryInterval'];
			  	var B_releaseCode=selected_B_service['prjReleaseCode'];
			  	var B_emailAlerGroup=selected_B_service['emailAlertGroup'];
			  	var B_loglevel=selected_B_service['logLevel'];
			  	**/
			  	

				  	$.get(
				  		'/api/rules/service/'+serv_id+'/',
			    		function(ruleservicedata)
			    		{
			    			//get the last rule order of the same service id and increment by 1
			    			var rlorder=ruleservicedata.ruleOrder;
		             		var rule_Order=rlorder+1;

		             		$.get(
		             			'/api/lastserviceid',
                        		function(servicedata)
                        		 {
                        		 	//get the last service id and increment by 1
                        		 	var servId=servicedata.serviceId;
		                          	var serviceidT=servId+1;

		                          	$.get(
		                          		'/api/lastrulecondid',
                                              function(rulcondata) 
                                              {
                                              	var rulcon_Id=rulcondata.ruleConditionId;
                                                var rulecondt_id=rulcon_Id+1; 
                                                $.get(
                                                	'/api/lastruledestid',
                                                      function(ruledestdata) 
                                                      {
                                                      	var ruldest_Id=ruledestdata.ruleDestinationId;
                                                        var ruledest_id=ruldest_Id+1;

                                                        var dateToday=new Date().toJSON().slice(0,10);
                                                        var dt=new Date().toJSON();

                                                        $.ajax({   type: 'POST',
                                                                      url: '/api/technicalservices',
                                                                     headers: {
                                                                          'Accept': 'application/json',
                                                                          'Content-Type': 'application/json'
                                                                        },
                                                                      data: JSON.stringify
                                                                      (
                                                                      {
                                                                     services_T:{serviceId:serviceidT,
                                                                        systemDomainId:document.getElementById('B_sysdomid_T').innerHTML,
                                                                        serviceType:$('#B_servicetype_T :selected').val(),
                                                                        operation:$('#B_operation_T').val(),
                                                                        timeout:$('#B_timeout_T').val(),
                                                                        serviceCode:B_serv_code,
                                                                        serviceName:$('#B_servicename_T').val(),
                                                                        version:$('#B_version').val(),
                                                                        sync:$('#B_sync :selected').val(),
                                                                        logLevel:$('#B_loglevel').val(),
                                                                        duplicateCheck:$('#B_dupcheck :selected').val(),
                                                                        genericReply:$('#B_genreply :selected').val(),
                                                                        retryMax:$('#B_retrymax').val(),
                                                                        retryInterval:$('#B_retryinterval').val(),
                                                                        prjReleaseCode:$('#B_prjrlscode').val(),
                                                                        emailAlertGroup:$('#B_emailalertgroup').val(),
                                                                        smsAlertGroup:$('#B_smsalertgroup').val(),
                                                                        emailAlertFlag:$('#B_emailalertflag :selected').val(),
                                                                        smsAlertFlag:$('#B_smsalertflag :selected').val(),
                                                                       createdBy:$('#B_current_user').text(),
                                                                        creationDate:dateToday                          
                                                                     },                      
                                                                     
                                                                        rules:{ruleId:ruleid,
                                                                          ruleOrder:rule_Order,
                                                                          serviceId:{serviceId:serv_id}
                                                                        },
                                                                        
                                                                        ruleConditions:{ruleConditionId:rulecondt_id,
                                                                          ruleConditionOrder:1,
                                                                          fieldOperation:"'='",
                                                                          fieldName:$('#B_ruleconfieldname').val(),
                                                                          fieldValue:$('#B_ruleconfieldvalue').val(),
                                                                          ruleId:{ruleId:ruleid}
                                                                        },
                                                                        
                                                                        ruleDestinations:{ruleDestinationId:ruledest_id,
                                                                          ruleId:{ruleId:ruleid},
                                                                          serviceId:{serviceId:serviceidT}
                                                                        },
                                                                        
                                                                        serviceDestinations:{serviceId:serviceidT,
                                                                          uri:$('#B_servicedestination_uri').val(),
                                                                          name:$('#B_servicename_T').val(),
                                                                          enabled:$('#B_servicedestination_enabled :selected').val()
                                                                        }
                                                                        
                                                                      }
                                                                      ),
                                                                      error: function(xhr, status, error) 
                                                                          {
                                                                               $("#B_txt_allservice_error").empty(); 
                                                                               //console.log(xhr.responseText); 
                                                                             
                                                                                                 
                                                                               $("#B_txt_allservice_error").append(xhr.responseText);
                                                                            
                                                                           },
                                                                        success: function(data)
                                                                        {
                                                                           $('#serviceBusModal').modal('toggle');
                                                                            data1 = $.parseJSON(JSON.stringify(data));
                                                                            // console.log(data1);

                                                                        }
                                                                
                                                                  

                                                               

                                                                        }); 











                                                      });

                                              });


		                          
                        		});
		             		





			    		});                                   
			            

    		});

//homr
    }
})












});