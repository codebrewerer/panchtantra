 

var url_slug = document.location.pathname;

var root_path = "";

if(url_slug.length > 1)
	 root_path = url_slug.split("/")[1];

// All this only if hhe hhas valid subscription

if(fetchBookingData){	

	if(url_slug.includes("/login")){
		var logo_url = chrome.runtime.getURL("images/icon_128.png"); 

		var img_str =  "<img src= 'https://cdn2.iconfinder.com/data/icons/hexagon-social-medias/462/Social_Hexagon_Icons-07-128.png' />";
		jQuery('.login-header').html(img_str);	
		jQuery('.login-wrapper-background').html("");

		//concord-img
		jQuery('.login-content').css("background-color", "aqua");
		jQuery('#id_userLoginId').focus();

		jQuery('#id_userLoginId').val("raunakkumar55@gmail.com");

		// await new Promise(r => setTimeout(r, 6000));

		jQuery('#id_password').focus();

		jQuery('#id_password').val("70624444");

		jQuery('#bxid_rememberMe_true').attr('checked', false);

		jQuery('.login-button').focus();

		setTimeout(function(){ jQuery('.login-button').trigger("click"); }, 5000);



	}else if(root_path.includes("browse") || url_slug.includes("search") || url_slug.includes("latest") || url_slug.includes("watch") || root_path.includes("in")){
		// Do nothing
	}else{

		jQuery('body').html("<h2>This page is blocked</h2>");
	}
}


function fetchBookingData(){
	return true;

}



