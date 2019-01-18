$(document).ready(function()
{

  $('#btnnewservice').on('click',function(){


          $('#selectsystem_B').inputpicker
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

          $('#selectdomain_B').inputpicker
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

          $('#selectsystem_T').inputpicker
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

          $('#selectdomain_T').inputpicker
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




  $('#serviceModal').on('click',function()
  {
    var selected_system_B = $('#selectsystem_B').inputpicker('element');
    var system_code_B=selected_system_B['systemCode'];
    var system_name_B=selected_system_B['systemName'];



    var selected_domain_B = $('#selectdomain_B').inputpicker('element');
    var domain_id_B=selected_domain_B['domainId'];
    var domain_name_B=selected_domain_B['domainName'];
   
    

    var selected_system_T = $('#selectsystem_T').inputpicker('element');
    var system_code_T=selected_system_T['systemCode'];
    var system_name_T=selected_system_T['systemName'];




    var selected_domain_T = $('#selectdomain_T').inputpicker('element');
    var domain_id_T=selected_domain_T['domainId'];
    var domain_name_T=selected_domain_T['domainName'];
   
      $.get( 
          '/api/systemdomain/'+system_code_B+'/'+domain_id_B,
            function(data) {

             if(data===null)
             {
              alert("THERE IS NO SYSTEMDOMAIN FOR "+system_name_B+ " AND "+domain_name_B);
             }
             else
             {
              var sysdomId_B=data.systemDomainId;
              $("#sysdomid_B").empty();
              $("#sysdomid_B").append(sysdomId_B);
             }
              
            });
      $.get( 
          '/api/systemdomain/'+system_code_T+'/'+domain_id_T,
            function(data) {

             if(data===null)
             {
              alert("THERE IS NO SYSTEMDOMAIN FOR "+system_name_T+ " AND "+domain_name_T);
             }
             else
             {
              var sysdomId_T=data.systemDomainId;
              $("#sysdomid_T").empty();
              $("#sysdomid_T").append(sysdomId_T);
             }
              
            });



  });


  $('#operation_B').bind('click keyup', function() {
  alert( "Handler for .focus() called." );
});


   



	var form = $("#form_new_service").show();
/*
	form.validate({ // initialize the plugin
        // your rules and options,
        rules:{
          operation_B:{
            required:true

          }

        },
        messages:{
          operation_B:"Enter Operation"

          
        },

        errorPlacement: function(){
            return false;  // suppresses error message text
        }
        
    });
  **/
 
          form.steps({
            headerTag: "h3",
            bodyTag: "fieldset",
            transitionEffect: "slideLeft",            
            onStepChanging: function (event, currentIndex, newIndex)
            {
              // Allways allow previous action even if the current form is not valid!
              if (currentIndex === 0)
              {
                //SERVICE 

               
                  
                                
              
              }

               if (currentIndex === 4)
              {
                //SERVICE 
              
             
              
              }

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
              
              
              
               if (currentIndex === 0)
              {

                
                
              
              }
              if (currentIndex === 3)
              {
                //RULE DESTINATION
               
               
              
              }
              if (currentIndex === 4)
              {
                //SERVICE DESTINATION
               
              
              }
               if (currentIndex === 5)
              {
                //SUMMARY
                 /*service start*/


                var servi_sysdom_B=document.getElementById('sysdomid_B').innerHTML;   
                $("#txtsysdom_sum_B").empty();
                $("#txtsysdom_sum_B").append( "SYSTEM DOMAIN: " +servi_sysdom_B);

                var servi_sysdom_T=document.getElementById('sysdomid_T').innerHTML;   
                $("#txtsysdom_sum_T").empty();
                $("#txtsysdom_sum_T").append( "SYSTEM DOMAIN: " +servi_sysdom_T);

                var servi_oper_B=$('#operation_B').val();   
                $("#txtserviceoper_sum_B").empty();
                $("#txtserviceoper_sum_B").append( "SERVICE OPERATION: " +servi_oper_B);
                var servi_oper_T=$('#operation_T').val();   
                $("#txtserviceoper_sum_T").empty();
                $("#txtserviceoper_sum_T").append( "SERVICE OPERATION: " +servi_oper_T);


                 
                var servi_type_B=$('#servicetype_B :selected').val();  
                $("#txtservicetype_sum_B").empty();
                $("#txtservicetype_sum_B").append( "SERVICE TYPE: " +servi_type_B);
                var servi_type_T=$('#servicetype_T :selected').val();  
                $("#txtservicetype_sum_T").empty();
                $("#txtservicetype_sum_T").append( "SERVICE TYPE: " +servi_type_T);

                var servi_name_B=$('#servicename_B').val();   
                $("#txtservicename_sum_B").empty();
                $("#txtservicename_sum_B").append( "SERVICE NAME: " +servi_name_B);
                var servi_name_T=$('#servicename_T').val();   
                $("#txtservicename_sum_T").empty();
                $("#txtservicename_sum_T").append( "SERVICE NAME: " +servi_name_T);

                 $("#txtservicedestname_sum").empty();
                $("#txtservicedestname_sum").append( "NAME: " +servi_name_T);



                var servi_tmout_B=$('#timeout_B').val();   
                $("#txtservicetimeout_sum_B").empty();
                $("#txtservicetimeout_sum_B").append( "TIMEOUT: " +servi_tmout_B);
                var servi_tmout_T=$('#timeout_T').val();   
                $("#txtservicetimeout_sum_T").empty();
                $("#txtservicetimeout_sum_T").append( "TIMEOUT: " +servi_tmout_T);




                var servi_code=$('#servicecode').val();   
                $("#txtservicecode_sum").empty();
                $("#txtservicecode_sum").append( "SERVICE CODE: " +servi_code);

                

                
                var servi_sync=$('#sync :selected').val();  
                $("#txtservicesync_sum").empty();
                $("#txtservicesync_sum").append( "SYNC: " +servi_sync);


                
                /*service end*/

                /*rule start
                var rule_ruleid=document.getElementById('txtruleid').innerHTML;   
                $("#txtruleid_sum").empty();
                $("#txtruleid_sum").append( "ID: " +rule_ruleid);
                

                var rule_ruleorder=$('#ruleorder').val();   
                $("#txtruleorder_sum").empty();
                $("#txtruleorder_sum").append( "RULE ORDER: " +rule_ruleorder);
                */

                /*rule end*/

                /*rule condition start
                var rulecon_id=document.getElementById('txtrulecondid').innerHTML;
                $("#txtruleconid_sum").empty();
                $("#txtruleconid_sum").append( "ID: " +rulecon_id);
               

                var rulecon_order=$('#ruleconorder').val();   
                $("#txtruleconorder_sum").empty();
                $("#txtruleconorder_sum").append( "ORDER: " +rulecon_order);

                var rulecon_fieldoperation=$('#ruleconfieldoperation').val();   
                $("#txtruleconfieldoper_sum").empty();
                $("#txtruleconfieldoper_sum").append( "FIELD OPERATION: " +rulecon_fieldoperation);
                */

                var rulecon_fieldname=$('#ruleconfieldname').val();   
                $("#txtruleconfieldname_sum").empty();
                $("#txtruleconfieldname_sum").append( "FIELD NAME: " +rulecon_fieldname);

                var rulecon_fieldvalue=$('#ruleconfieldvalue').val();   
                $("#txtruleconfieldvalue_sum").empty();
                $("#txtruleconfieldvalue_sum").append( "FIELD VALUE: " +rulecon_fieldvalue);


                /*rule condition end*/

                /*rule destination start

                var ruledest_id=document.getElementById('txtruledestid').innerHTML;    
                $("#txtruledestid_sum").empty();
                $("#txtruledestid_sum").append( "ID: " +ruledest_id);
                */

                /*rule destination end*/

                /*service destination start*/

             

             
                var servicedestination_enabled=$('#servicedestination_enabled :selected').val();   
                $("#txtservicedestenabled_sum").empty();
                $("#txtservicedestenabled_sum").append( "ENABLED: " +servicedestination_enabled);

                var servicedestination_uri=$('#servicedestination_uri').val();   
                $("#txtservicedesturl_sum").empty();
                $("#txtservicedesturl_sum").append( "URL: " +servicedestination_uri);

                /*service destination end*/

              
              }
              
              // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
              if (currentIndex === 2 && priorIndex === 3)
              {
              
                form.steps("previous");
              }
              
            },
            onFinishing: function (event, currentIndex)
            {
              form.validate().settings.ignore = ":disabled";
              return form.valid();
              
            },
            onFinished: function (event, currentIndex)
            {

              $.get(
                '/api/lastserviceid',
                        function(data) {

                          var servId=data.serviceId;
                          var serviceidB=servId+1;
                          var serviceidT=servId+2;                     
                         
                          //GET LAST RULE ID AND INCREMENT
                              $.get(  
                                    '/api/lastruleid',
                                    function(data) {

                                      var rulId=data.ruleId;
                                      var ruleid=rulId+1;
                                      var user= $('#current_user').text();                                
                                     


                                       //GET LAST RULECondition ID AND INCREMENT
                                        $.get(  
                                              '/api/lastrulecondid',
                                              function(data) {

                                                var rulcon_Id=data.ruleConditionId;
                                                var rulecondt_id=rulcon_Id+1;                                     
                                                //GET LAST RULEDestination ID AND INCREMENT
                                                $.get(  
                                                      '/api/lastruledestid',
                                                      function(data) 
                                                      {

                                                        var ruldest_Id=data.ruleDestinationId;
                                                        var ruledest_id=ruldest_Id+1;                                                  


                                                              var sysdom_Id_B = $('#systemdomainid_B').val();
                                                              var sysdom_Id_T = $('#systemdomainid_T').val();              
                                                              var service_type_B=$('#servicetype_B :selected').val();
                                                              var service_type_T=$('#servicetype_T :selected').val();
                                                               var time_out_B=$('#timeout_B').val();
                                                               var time_out_T=$('#timeout_T').val();
                                                               var oper_B=$('#operation_B').val();
                                                               var oper_T=$('#operation_T').val();              
                                                              var service_name_B=$('#servicename_B').val(); 
                                                              var service_name_T=$('#servicename_T').val();
                                                                           
                                                              var ver=$('#version').val();
                                                              var sync_=$('#sync :selected').val();
                                                              var log_level=$('#loglevel').val();
                                                              var dupcheck=$('#dupcheck :selected').val();
                                                              var genreply=$('#genreply :selected').val();
                                                     
                                                              var service_code=$('#servicecode').val();
                                                              var retry_max=$('#retrymax').val();
                                                              var retry_interval=$('#retryinterval').val();
                                                              var prjrlscode=$('#prjrlscode').val();
                                                              var emalertgrp=$('#emailalertgroup').val();
                                                              var smsalertgrp=$('#smsalertgroup').val();
                                                              var emalertflag=$('#emailalertflag :selected').val();
                                                              var smsalertflag=$('#smsalertflag :selected').val();

                                                              var dateToday=new Date().toJSON().slice(0,10);
                                                              var dt=new Date().toJSON();                                                          
                                                        
                                                              
                                                              //rule start
                                                             
                                                              var rule_order=$('#ruleorder').val();

                                                              //rule condition start
                                                              var cond_order=$('#rulecondorder').val();  
                                                              var cond_fild_opr_raw=$('#ruleconfieldoperation').val();
                                                              var cond_fild_opr='"'+cond_fild_opr_raw+'"';   
                                                              var cond_fild_nm=$('#ruleconfieldname').val();
                                                              var cond_fild_val=$('#ruleconfieldvalue').val(); 

                                                              //rule destinations

                                                              //service destination

                                                              var sdId=$('#servicedestinationid').val();
                                                              var serv_dest_url_raw=$('#servicedestination_uri').val();
                                                              var serv_dest_url='"'+serv_dest_url_raw+  '"'; 
                                                              var serv_dest_enabled=$('#servicedestination_enabled :selected').val();




                                                                    $.ajax({
                                                                          type: 'POST',
                                                                          url: '/api/allservices',
                                                                         headers: {
                                                                              'Accept': 'application/json',
                                                                              'Content-Type': 'application/json'
                                                                            },
                                                                          data: JSON.stringify
                                                                          (
                                                                          {
                                                                            services_B:{serviceId:serviceidB,
                                                                                        systemDomainId:document.getElementById('sysdomid_B').innerHTML,
                                                                                        serviceType:service_type_B,
                                                                                        operation:oper_B,
                                                                                        timeout:time_out_B,
                                                                                        serviceCode:service_code,
                                                                                        serviceName:service_name_B,
                                                                                        version:ver,sync:sync_,
                                                                                        logLevel:log_level,
                                                                                        duplicateCheck:dupcheck,
                                                                                        genericReply:genreply,
                                                                                        retryMax:retry_max,
                                                                                        retryInterval:retry_interval,
                                                                                        prjReleaseCode:prjrlscode,
                                                                                        emailAlertGroup:emalertgrp,
                                                                                        smsAlertGroup:smsalertgrp,
                                                                                        emailAlertFlag:emalertflag,
                                                                                        smsAlertFlag:smsalertflag,
                                                                                        createdBy:$('#current_user').text(),
                                                                                        creationDate:dateToday                          
                                                                                     },
                                                                         services_T:{serviceId:serviceidT,
                                                                            systemDomainId:document.getElementById('sysdomid_T').innerHTML,
                                                                            serviceType:service_type_T,
                                                                            operation:oper_T,
                                                                            timeout:time_out_T,
                                                                            serviceCode:service_code,
                                                                            serviceName:service_name_T,
                                                                            version:ver,sync:sync_,
                                                                            logLevel:log_level,
                                                                            duplicateCheck:dupcheck,
                                                                            genericReply:genreply,
                                                                            retryMax:retry_max,
                                                                            retryInterval:retry_interval,
                                                                            prjReleaseCode:prjrlscode,
                                                                            emailAlertGroup:emalertgrp,
                                                                            smsAlertGroup:smsalertgrp,
                                                                            emailAlertFlag:emalertflag,
                                                                            smsAlertFlag:smsalertflag,
                                                                           createdBy:$('#current_user').text(),
                                                                            creationDate:dateToday                          
                                                                         },                      
                                                                         
                                                                            rules:{ruleId:ruleid,
                                                                              ruleOrder:1,
                                                                              serviceId:{serviceId:serviceidB}
                                                                            },
                                                                            
                                                                            ruleConditions:{ruleConditionId:rulecondt_id,
                                                                              ruleConditionOrder:1,
                                                                              fieldOperation:"'='",
                                                                              fieldName:cond_fild_nm,
                                                                              fieldValue:cond_fild_val,
                                                                              ruleId:{ruleId:ruleid}
                                                                            },
                                                                            
                                                                            ruleDestinations:{ruleDestinationId:ruledest_id,
                                                                              ruleId:{ruleId:ruleid},
                                                                              serviceId:{serviceId:serviceidT}
                                                                            },
                                                                            
                                                                            serviceDestinations:{serviceId:serviceidT,
                                                                              uri:serv_dest_url,
                                                                              name:service_name_T,
                                                                              enabled:serv_dest_enabled
                                                                            }
                                                                            
                                                                          }
                                                                          ),
                                                                          error: function(xhr, status, error) 
                                                                              {
                                                                                   $("#txt_allservice_error").empty(); 
                                                                                   //console.log(xhr.responseText); 
                                                                                 
                                                                                                     
                                                                                   $("#txt_allservice_error").append(xhr.responseText);
                                                                                
                                                                               },
                                                                            success: function(data)
                                                                            {
                                                                               $('#serviceModal').modal('toggle');
                                                                                data1 = $.parseJSON(JSON.stringify(data));
                                                                                // console.log(data1);

                                                                            }
                                                                
                                                                  

                                                               

                                                                        }); 


                                                      });


                                              }
                                           );


                                    }
                                 );

                        }
                    );
    
              
            }
          })

});