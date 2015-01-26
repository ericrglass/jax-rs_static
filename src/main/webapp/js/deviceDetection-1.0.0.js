
// Copyright 2015 - ScientiaMobile, Inc., Reston, VA
// WURFL Device Detection
// Terms of service:
// http://web.wurfl.io/license
eval(function(p,a,c,k,e,d){e=function(c){return c};if(!''.replace(/^/,String)){while(c--){d[c]=k[c]||c}k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};while(c--){if(k[c]){p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c])}}return p}('3 2={"1":0,"4":"5 8 7","6":"9"};',10,10,'false|is_mobile|WURFL|var|complete_device_name|generic|form_factor|browser|web|Desktop'.split('|'),0,{}))

function _deviceDetectionConetxtUri() {
  var href = location.href;
  var pos = href.indexOf('://');
  if ((pos > -1) && (pos + 3 < href.length)) {
    pos =  href.indexOf('/', pos + 3);
  } else {
    pos = -1;
  }
  if ((pos > -1) && (pos + 1 < href.length)) {
    pos =  href.indexOf('/', pos + 1);
  } else {
    pos = -1;
  }
  if (pos > -1) {
    href =  href.substring(0, pos);
  }
  return href;
}
function deviceDetectionPost() {
  if (!jQuery || (jQuery === null) || !deviceDetection || (deviceDetection === null)) {
    return;
  }
  jQuery.ajax({
    type: 'POST',
    url: _deviceDetectionConetxtUri() + '/resource/deviceDetection',
    cache: false,
    processData: false,
    contentType: 'application/json',
    dataType: 'json',
    data: '{"isMobile":' + deviceDetection.isMobile
      + ',"formFactor":"' + deviceDetection.formFactor + '"'
      + ',"completeDeviceName":"' + deviceDetection.completeDeviceName + '"'
      + ',"isHighDensity":' + deviceDetection.isHighDensity
      + ',"isRetina":' + deviceDetection.isRetina
      + ',"clientWidth":' + deviceDetection.clientWidth
      + ',"canResizeBrowserWindow":' + deviceDetection.canResizeBrowserWindow
      + ',"orientation":"' + deviceDetection.orientation + '"'
      + ',"htmlClass":"' + deviceDetection.htmlClass + '"'
      + '}'
  });
}
function deviceDetectionGet(callbackFunction) {
  if (!jQuery || (jQuery === null) || !callbackFunction || (typeof(callbackFunction) !== 'function')) {
    return;
  }
  var ajaxResults = null;
  jQuery.ajax({
    type: 'GET',
    url: _deviceDetectionConetxtUri() + '/resource/deviceDetection',
    cache: false,
    dataType: 'json'
  }).success(function(data) {
    ajaxResults = data;
  }).done(function() {
    callbackFunction(ajaxResults);
  });
}
var deviceDetection = {};
deviceDetection.isMobile = false;
deviceDetection.formFactor = 'N/A';
deviceDetection.completeDeviceName = 'N/A';
if (WURFL && (WURFL !== null)) {
  deviceDetection.isMobile = WURFL.is_mobile;
  deviceDetection.formFactor = WURFL.form_factor;
  deviceDetection.completeDeviceName = WURFL.complete_device_name;
}
deviceDetection.isHighDensity = ((window.matchMedia && (window.matchMedia('only screen and (min-resolution: 124dpi), only screen and (min-resolution: 1.3dppx), only screen and (min-resolution: 48.8dpcm)').matches || window.matchMedia('only screen and (-webkit-min-device-pixel-ratio: 1.3), only screen and (-o-min-device-pixel-ratio: 2.6/2), only screen and (min--moz-device-pixel-ratio: 1.3), only screen and (min-device-pixel-ratio: 1.3)').matches)) || (window.devicePixelRatio && window.devicePixelRatio > 1.3));
deviceDetection.isRetina = ((window.matchMedia && (window.matchMedia('only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx), only screen and (min-resolution: 75.6dpcm)').matches || window.matchMedia('only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min--moz-device-pixel-ratio: 2), only screen and (min-device-pixel-ratio: 2)').matches)) || (window.devicePixelRatio && window.devicePixelRatio > 2)) && /(iPad|iPhone|iPod)/g.test(navigator.userAgent);
deviceDetection.clientWidth = document.documentElement.clientWidth;
deviceDetection.canResizeBrowserWindow = (deviceDetection.clientWidth < screen.width);
deviceDetection.orientation = '';
if (window.innerWidth > window.innerHeight) {
  deviceDetection.orientation = 'landscape';
} else {
  deviceDetection.orientation = 'portrait';
}
deviceDetection.htmlClass = (' '+document.getElementsByTagName('html')[0].className+' ').toLowerCase();
deviceDetectionPost();
var deviceDetectionWindowOnresize = window.onresize;
var deviceDetectionEventHandlersWinResizeTimeout;
window.onresize = function() {
  clearTimeout(deviceDetectionEventHandlersWinResizeTimeout);
  deviceDetectionEventHandlersWinResizeTimeout = setTimeout(function() {
    deviceDetection.clientWidth = document.documentElement.clientWidth;
    deviceDetection.canResizeBrowserWindow = (deviceDetection.clientWidth < screen.width);
    deviceDetection.orientation = '';
    if (window.innerWidth > window.innerHeight) {
      deviceDetection.orientation = 'landscape';
    } else {
      deviceDetection.orientation = 'portrait';
    }
    deviceDetection.htmlClass = (' '+document.getElementsByTagName('html')[0].className+' ').toLowerCase();
    deviceDetectionPost();
    if (deviceDetectionWindowOnresize && (deviceDetectionWindowOnresize !== null)) {
      deviceDetectionWindowOnresize();
    }
  }, 250);
};
