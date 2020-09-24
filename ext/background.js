// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

'use strict';

chrome.runtime.onInstalled.addListener(function() {
  chrome.storage.sync.set({color: '#3aa757'}, function() {

    console.log("Welcome to PanchTantra");
  });
});


chrome.webNavigation.onCompleted.addListener(function() {

	alert("This site is not allowed")
	chrome.pageAction.show(sender.tab.id);
      
  }, {url: [{urlMatches : 'https://*.netflix.com/*'}]});



chrome.runtime.onMessage.addListener(
    function(message, callback) {
    	// chrome.pageAction.show(sender.tab.id);
              chrome.tabs.executeScript({
          file: 'cs.js'
        });
      
   });



  chrome.runtime.onInstalled.addListener(function() {
    // Replace all rules ...
    chrome.declarativeContent.onPageChanged.removeRules(undefined, function() {
      // With a new rule ...
      chrome.declarativeContent.onPageChanged.addRules([
        {
          // That fires when a page's URL contains a 'g' ...
          conditions: [
            new chrome.declarativeContent.PageStateMatcher({
              pageUrl: { urlContains: 'netflix.com' },
            })
          ],
          // And shows the extension's page action.
          actions: [ new chrome.declarativeContent.ShowPageAction() ]
        }
      ]);
    });
  });
