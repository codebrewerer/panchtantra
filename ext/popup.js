


 chrome.storage.local.get(['loggedIn'], function(result) {
          console.log('Value currently is ' + result.loggedIn);
          var loggedInFlag = result.loggedIn ;

          if(loggedInFlag){
          	jQuery('body').html("<center> <img src='./images/icon_64.png' id='logoImage'> </center><div class=\"container\"><p>Logged In !! Head over to your favourites</p>  <br> <button id=\"btn_logout\">Logout</button </div>");
          	jQuery('#btn_logout').click(function(){

          			alert("Successfully logged out !! You won't abe able to use ott sites for free")

					chrome.storage.local.clear();
					window.close();

				});
          }else
          {
          		var htmlStr = "<center> <img src='./images/icon_64.png' id='logoImage'> </center> <form><div class=\"container\"><label>Username : </label><input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required><label>Password : </label> <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" required>";  
    			htmlStr += "<button id=\"punch-login-btn\" type=\"button\">Login</button> </div></form> ";

    			jQuery('body').html(htmlStr);


				jQuery('#punch-login-btn').click(function(){

					chrome.storage.local.set({loggedIn: true}, function() {

				    		console.log("Setting Token here");
				 	});
					window.close();

				});
          }
  });


 

// if(loggedInFlag != undefined && loggedInFlag){
// 	alert("gg");
// 	jQuery('body').html("Logged In !! Head over to your favourites");
// }

// else{

// 	alert("value" + loggedInFlag);

// 	var htmlStr = "<center> <img src='./images/icon_64.png' id='logoImage'> </center> <form><div class=\"container\"><label>Username : </label><input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required><label>Password : </label> <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" required>";  
//     htmlStr += "<button id=\"punch-login-btn\" type=\"button\">Login</button> </div></form> ";

//     jQuery('body').html(htmlStr);


// 	jQuery('#punch-login-btn').click(function(){

// 		alert("in set token - "+ loggedInFlag);

// 	chrome.storage.local.set({loggedIn: true}, function() {

//     		console.log("Setting Token here");
//  	});
// 	window.close();

// });

// }






