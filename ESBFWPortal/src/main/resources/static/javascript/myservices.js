$(document).ready(function()

    {
        var user=$('#user').text().trim();
        console.log('this user-> '+user);

///api/userservices/
                            
    $.ajax
        ({
            type:'GET', 
            context:this,
            url: '/api/userservices/'+user,
            //cache: false,
            success: function(services)
            {
                //console.log('success', domains);
                var service_data='';
                $.each(services,function(key,service)
                    {
                        
                        service_data += '<tr>';
                        service_data += '<td id="sId">'+service.serviceId+'</td>';
                        service_data += '<td id="sCode">'+service.serviceCode+'</td>';
                        service_data += '<td id="sdId">'+service.systemDomainId+'</td>';
                        service_data += '<td id="sType">'+service.serviceType+'</td>';
                        service_data += '<td id="sName">'+service.serviceName+'</td>';
                        service_data += '<td id="sOp">'+service.operation+'</td>';
                        service_data += '<td id="sVer">'+service.version+'</td>';
                        service_data += '<td id="sSync">'+service.sync+'</td>';
                        service_data += '<td id="sLlvl">'+service.logLevel+'</td>';
                        service_data += '<td id="sDup">'+service.duplicateCheck+'</td>';
                        service_data += '<td id="sGRep">'+service.genericReply+'</td>';
                        service_data += '<td id="stout">'+service.timeout+'</td>';
                        service_data += '<td id="sRmax">'+service.retryMax+'</td>';
                        service_data += '<td id="sRInter">'+service.retryInterval+'</td>';
                        service_data += '<td id="sRlsCode">'+service.prjReleaseCode+'</td>';
                        service_data += '<td id="sEAGroup">'+service.emailAlertGroup+'</td>';
                        service_data += '<td id="sSAGroup">'+service.smsAlertGroup+'</td>';
                        service_data += '<td id="sEAFlag">'+service.emailAlertFlag+'</td>';
                        service_data += '<td id="sSAFlag">'+service.smsAlertFlag+'</td>';
                        /**service_data += '<td id="scDate">'+service.creationDate+'</td>'; **/
                        /**service_data += '<td id="sCBy">'+service.createdBy+'</td>'; **/ 
                        service_data += '</tr>';
                    });


            
                $('#tableservice tbody').append(service_data);
                 
                    $('#tableservice').DataTable({
                        scrollX: true,
                       // scrollCollapse:true,
                        "columns": [
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" },
                            { "width": "20%" }
                          ]

                          
                        });
                                        //$('#tableservice').floatThead()
                   // $( "#tablediv" ).load(window.location.href + "#tablediv" );

                

            
            },
            
            error: function(xhr, status, error) 
              {                        
                     
                  // $("#newusererror").empty();                
                   //$("#newusererror").append(xhr.responseText +"<br>");
                   console.log(xhr.responseText);
                
               }

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
                                $('#tableservicedestination').DataTable(

                                    {
                                      
                                    });
                                   // $( "#tablediv" ).load(window.location.href + "#tablediv" );

                                

                            
                            },
                            
                           error: function(xhr, status, error) 
                              {                        
                                     
                                  // $("#newusererror").empty();                
                                   //$("#newusererror").append(xhr.responseText +"<br>");
                                   console.log(xhr.responseText);
                                
                               }

                        });


   });