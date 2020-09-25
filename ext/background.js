// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

'use strict';

chrome.runtime.onInstalled.addListener(function() {
  var regId = Date.now() + "" + Math.floor(Math.random() * 100);
  chrome.storage.sync.set({deviceId: regId}, function() {

    console.log("Welcome to PanchTantra");

    console.log("Registering Device ID");
    // On login , Associate this with userId



  });
});

chrome.webNavigation.onCompleted.addListener(function() {

  console.log("Sesion Activated");
  chrome.pageAction.show(sender.tab.id);
      
  }, {url: [{urlMatches : 'https://*.netflix.com/*'}]});



chrome.runtime.onMessage.addListener(
    function(message, callback) {
      // chrome.pageAction.show(sender.tab.id);
              chrome.tabs.executeScript({
          file: 'cs.js'
        });
      
});

chrome.webRequest.onBeforeRequest.addListener(
        function(details) { return {cancel: true}; },
        {urls: ["*://www.google.com/history/*"]},
        ["blocking"]);



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
