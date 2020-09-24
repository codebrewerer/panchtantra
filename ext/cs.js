 
var logo_url = chrome.runtime.getURL("images/icon_128.png"); 

var img_str =  "<img src= 'https://cdn2.iconfinder.com/data/icons/hexagon-social-medias/462/Social_Hexagon_Icons-07-128.png' />";
alert("dd"+img_str);
jQuery('.login-header').html(img_str);	
jQuery('.login-wrapper-background').html("");

//concord-img
jQuery('.login-content').css("background-color", "aqua");

jQuery('#id_userLoginId').val("rau@hh.com");

//jQuery('#id_password').val("fff@dW12");

jQuery('#bxid_rememberMe_true').attr('checked', false);

//jQuery('.login-button').trigger("click");

