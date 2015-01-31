$(document).ready(function() {
	// navigation click actions	
	/*$('.scroll-link').on('click', function(event){
		event.preventDefault();
		var sectionID = $(this).attr("data-id");
		scrollToID('#' + sectionID, 750);
	});
	
	function scrollToID(id, speed){
		var offSet = 50;
		var targetOffset = $(id).offset().top - offSet;
		var mainNav = $('#main-nav');
		$('html,body').animate({scrollTop:targetOffset}, speed);
		if (mainNav.hasClass("open")) {
			mainNav.css("height", "1px").removeClass("in").addClass("collapse");
			mainNav.removeClass("open");
		}
	}*/
	$('#logout').click(function(event) {

		$("#logoutForm").submit();
	});

	$('#forgotPwd').submit(function(event) {
		$('#loadingProgressBar').modal('show');
		event.preventDefault();

		var postData = $(this).serializeArray();
	    var formURL = $(this).attr("action");
	    jQuery.ajax(
	    	    {
	    	        url : formURL,
	    	        type: "POST",
	    	        data : postData,
	    	        success:function(data, textStatus, jqXHR) 
	    	        {
	    	        	if(data.status =="SUCCESS")
	    	        	{
	    	        		$('#displaybox').removeClass('alertFailureMessage');
	    	        		$('#displaybox').addClass('alertSuccessMessage');
	    	        		$('#displaybox').html(data.message);
	    	        		$('#displaybox').show();
	    	        		$('#loadingProgressBar').modal('hide');
	    	        		
	    	        	}else
	    	        	{
	    	        		$('#displaybox').addClass('alertFailureMessage');
	    	        		$('#displaybox').removeClass('alertSuccessMessage')
	    	        		$('#displaybox').html(data.message);
	    	        		$('#displaybox').show();
	    	        		$('#loadingProgressBar').modal('hide');
	    	        		
	    	        	}
                    	
	    	        },
	    	        error: function(jqXHR, textStatus, errorThrown) 
	    	        {
	    	        	$('#displaybox').addClass('alertFailureMessage')
                    	$('#displaybox').show();

	    	        }
	    	    });
	    	    e.preventDefault(); //STOP default action
	    	    e.unbind(); //unbind. to stop multiple form submit.
	    	    return false;
	    	});
	    
	 
});
