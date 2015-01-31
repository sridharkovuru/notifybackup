  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header" style="padding-top:14px">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand " href="home">Notify</a> 
            </div>
           
 <%--    <sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
    <li>${role}</li>
    </c:forEach>
</ul>   --%>        
           
 <div style="
padding: 15px 5px 5px 50px;
float: right;
font-size: 20px;width:40%"> 
<a href="home" class="navbar-brand" data-id="about" style="font-size:18px">About</a> 

<sec:authorize access="hasRole('ROLE_USER')">
 <c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
<!-- 	        <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Logout</button> -->
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	<a href='#' class="navbar-brand"id="logout" style="font-size:18px">Logout</a>
	<a href='welcome' class="navbar-brand"id="logout" style="font-size:18px">Account</a>

	</form> 
	
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
<a href='login' class="navbar-brand" data-id="login" style="font-size:18px">Login</a>
</sec:authorize>

</div>  
        </nav> 