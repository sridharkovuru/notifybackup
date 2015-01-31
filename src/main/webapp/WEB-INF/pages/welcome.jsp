<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



 <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h4>Welcome  ${user.firstName} ${user.lastName}, Love to see you back.</h4>   
                        <c:url value="j_spring_security_logout" var="logoutUrl" />

<sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
    <li>${role}</li>
    </c:forEach>
</ul>                                        
     

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
	        <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit">Logout</button>
	
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
                    </div>
                </div>   
                </div>
                </div>         


