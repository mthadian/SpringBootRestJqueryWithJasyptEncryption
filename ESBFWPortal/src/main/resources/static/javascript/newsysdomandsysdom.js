$(document).ready(function()

    {
        $('#selectsystem').inputpicker
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

        $('#selectdomain').inputpicker
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



       

        $('#savesysdom').on('click',function()
        {
          var selected_system = $('#selectsystem').inputpicker('element');
          var system_code=selected_system['systemCode'];



          var selected_domain = $('#selectdomain').inputpicker('element');
          var domain_id=selected_domain['domainId'];


          $.get( 
              '/api/lastsysdomid',
                        function(data) {

                         var sysdomid=data.systemDomainId;
                          var sys_dom_id = sysdomid+1;
                           $.ajax
                           ({
                                        type: 'POST',
                                        url: '/api/systemdomains',
                                        headers: {
                                                  'Accept': 'application/json',
                                                  'Content-Type': 'application/json'
                                                },
                                        data: JSON.stringify({
                                            systemDomainId:sys_dom_id,
                                            domainId:domain_id,
                                            systemCode:{systemCode:system_code}
                                            
                                        }),
                                        success: function()
                                        {
                                            alert("SYSTEM DOMAIN SUCCESSFULLY SAVED");
                                            location.reload();
                                           
                                            $('#sysdomModal').modal('hide');
                                           
                                        } ,
                                        error: function(xhr, status, error) {
                                          
                                           
                                             $("#systemdomainerror").append(xhr.responseText);
                                            
                                         }

                                    });
                          

                          
                        });

        });





$('#savesystem').on('click',function(e)
      {


    		$.get( 
    	  		  '/api/lastsystemid',
                        function(data) {

                         var system_code=data.systemCode;
                          var syscode = parseInt(system_code)+1;
                          var sysname=$('#systemname').val();

                         
                          $.ajax
                                        ({
                                        type: 'POST',
                                        url: '/api/systems',
                                        headers: {
                                                  'Accept': 'application/json',
                                                  'Content-Type': 'application/json'
                                                },
                                        data: JSON.stringify({
                                            systemCode:syscode,
                                            systemName:sysname
                                            
                                        }),
                                        success: function()
                                        {
                                            $('#systemname').val('');
                                            alert("SYSTEM SUCCESSFULLY SAVED");
                                            location.reload();
                                           
                                            $('#systemModal').modal('hide');
                                           
                                        } ,
                                        error: function(xhr, status, error) {
                                          

                                            
                                             $("#systemerror").append(xhr.responseText);
                                            
                                         }

                                     });




                          }

                );

          });
                          

            

                          

                          

                            $('#savedomain').on('click',function(e)
                            {
                              $.get( 
                                      '/api/lastdomainid',
                                            function(data) 
                                            {

                                             var dom_id=data.domainId;
                                              var domain_id = dom_id+1;
                                              var domain_name=$('#domainname').val();
                                              var domain_Type=$('#domainType :selected').val();

                                             

                                              $.ajax
                                                  ({
                                                  type: 'POST',
                                                  url: '/api/domains',
                                                  headers: {
                                                            'Accept': 'application/json',
                                                            'Content-Type': 'application/json'
                                                          },
                                                  data: JSON.stringify({
                                                      domainId:domain_id,
                                                      domainName:domain_name,
                                                      domainType:domain_Type


                                                      
                                                  }),
                                                  success: function()
                                                  {
                                                     
                                                      $('#domainType').prop('selectedIndex', 0);
                                                      $('#domainname').val('');
                                                      alert("DOMAIN SUCCESSFULLY SAVED");
                                                      location.reload();
                                                     
                                                      $('#domainModal').modal('hide');
                                                     
                                                  } ,
                                                  error: function(xhr, status, error) {
                                                    

                                                      
                                                       $("#domainerror").append(xhr.responseText);
                                                      
                                                   }

                                               });





                         
                                         });

                            });
                               
                                        
        

   
   });