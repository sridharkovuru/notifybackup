
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:loading></tag:loading>

<div class="wrapper">
<div class="page-wrapper">
<div class="page-inner">

        <div id="loginbox" style="margin-top:110px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" class="pagination-centered"> 
                           
            <div class="panel panel-info" >
           
                    <div class="panel-heading">
                        <div class="panel-title">Recover Password</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body " >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12">
                        
                        
                        </div>
                            
                        <form id="forgotPwd" class="form-horizontal" role="form"  name='forgotPwd' action="<c:url value='forgotPwd' />" method="POST">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                           
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="email" id="forgotpwdEmail" value="" placeholder="username@email.com" required="required">   
                                        <form:errors path="email"></form:errors>
                                                                     
                                    </div>
                                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                
                          
                                
   

                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <button type="submit" class="btn btn-success" id="forgotPwdButton" >Submit </button>
                                      <button type="reset" class="btn btn-danger">Reset </button>
                                    </div>
										                                    
                                    </div>
                              


              </form>     



                        </div>                     
                    </div>  
        </div>
        </div>
        </div>
        </div>
 
		 
       