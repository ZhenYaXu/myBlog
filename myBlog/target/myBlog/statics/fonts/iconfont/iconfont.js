(function(window){var svgSprite="<svg>"+""+'<symbol id="icon-cncsdnnet" viewBox="0 0 1142 1024">'+""+'<path d="M1141.35068 39.056567c-9.628592 72.769757-18.164903 137.223495-28.913312 218.47449-126.144648-19.927238-251.600884-38.376684-377.754711-27.67417-115.460491 9.802989-227.40549 32.180975-309.124606 122.987131-150.018782 166.696715-68.391455 396.461164 158.252192 437.462994 141.115318 25.526324 283.919541 11.785617 425.447907-8.123264-5.452224 112.440656-5.764305 95.303782-10.674978 205.229439-1.073923 24.057711 4.277334 14.612696-161.648359 31.914789-176.004048 9.004431-351.879591 11.188993-520.549755-52.888413C156.54493 905.721609 30.675647 809.160327 5.17686 630.815678c-26.251451-183.594939 48.803834-331.796313 192.516761-446.127808C413.368567 13.098839 790.802019-47.27032 1141.35068 39.056567z"  ></path>'+""+"</symbol>"+""+'<symbol id="icon-csdn" viewBox="0 0 1024 1024">'+""+'<path d="M906.475693 943.728792c-49.491181 17.325597-152.164608 28.913517-295.537993 28.913517-412.545894 0-635.223462-193.912431-608.80579-450.249611C33.545364 216.96445 363.386627 45.025473 724.595296 45.025473c139.829675 0 222.1301 11.388375 299.383578 30.263258l-24.720008 205.822692c-51.434439-17.35118-171.688267-33.208333-269.12032-33.208333-212.388225 0-392.96493 63.425541-413.440264 263.878946-18.429745 179.328271 108.114346 265.024026 347.120812 265.024026 83.251076 0 205.89944-11.884678 262.580371-29.214369L906.475693 943.728792z"  ></path>'+""+"</symbol>"+""+'<symbol id="icon-footer_ico-csdn" viewBox="0 0 1024 1024">'+""+'<path d="M0 512v512h1024V0H0v512z m810.666667-192c0 38.4-14.933333 42.666667-153.6 46.933333-85.333333 0-166.4 2.133333-181.333334 2.133334-14.933333 0-23.466667 8.533333-21.333333 21.333333 2.133333 12.8-10.666667 23.466667-27.733333 25.6-19.2 0-29.866667 17.066667-25.6 40.533333 4.266667 21.333333-2.133333 32-14.933334 25.6-25.6-17.066667 6.4 106.666667 38.4 145.066667 12.8 14.933333 19.2 32 12.8 36.266667-12.8 12.8 85.333333 25.6 209.066667 27.733333 81.066667 2.133333 100.266667 8.533333 100.266667 38.4 0 34.133333-21.333333 38.4-157.866667 38.4-172.8 0-232.533333-12.8-211.2-49.066667 8.533333-12.8 2.133333-14.933333-12.8-4.266666-44.8 27.733333-130.133333-72.533333-130.133333-153.6 0-85.333333 36.266667-162.133333 66.133333-145.066667 10.666667 8.533333 17.066667 2.133333 14.933333-14.933333-4.266667-14.933333 36.266667-49.066667 89.6-74.666667 72.533333-38.4 130.133333-49.066667 249.6-49.066667 140.8 0 155.733333 4.266667 155.733334 42.666667z" fill="" ></path>'+""+'<path d="M469.333333 320c-21.333333 12.8-4.266667 14.933333 53.333334 6.4 104.533333-14.933333 123.733333-27.733333 40.533333-27.733333-34.133333 0-76.8 10.666667-93.866667 21.333333zM704 307.2c0 4.266667 19.2 12.8 42.666667 19.2 23.466667 6.4 38.4 2.133333 29.866666-8.533333-10.666667-19.2-72.533333-27.733333-72.533333-10.666667zM258.133333 503.466667c0 23.466667 6.4 29.866667 12.8 12.8 6.4-14.933333 4.266667-34.133333-2.133333-40.533334-6.4-8.533333-12.8 4.266667-10.666667 27.733334z" fill="" ></path>'+""+"</symbol>"+""+'<symbol id="icon-csdn1" viewBox="0 0 1024 1024">'+""+'<path d="M906.475693 943.728792c-49.491181 17.325597-152.164608 28.913517-295.537993 28.913517-412.545894 0-635.223462-193.912431-608.80579-450.249611C33.545364 216.96445 363.386627 45.025473 724.595296 45.025473c139.829675 0 222.1301 11.388375 299.383578 30.263258l-24.720008 205.822692c-51.434439-17.35118-171.688267-33.208333-269.12032-33.208333-212.388225 0-392.96493 63.425541-413.440264 263.878946-18.429745 179.328271 108.114346 265.024026 347.120812 265.024026 83.251076 0 205.89944-11.884678 262.580371-29.214369L906.475693 943.728792z" fill="#d81e06" ></path>'+""+"</symbol>"+""+"</svg>";var script=function(){var scripts=document.getElementsByTagName("script");return scripts[scripts.length-1]}();var shouldInjectCss=script.getAttribute("data-injectcss");var ready=function(fn){if(document.addEventListener){if(~["complete","loaded","interactive"].indexOf(document.readyState)){setTimeout(fn,0)}else{var loadFn=function(){document.removeEventListener("DOMContentLoaded",loadFn,false);fn()};document.addEventListener("DOMContentLoaded",loadFn,false)}}else if(document.attachEvent){IEContentLoaded(window,fn)}function IEContentLoaded(w,fn){var d=w.document,done=false,init=function(){if(!done){done=true;fn()}};var polling=function(){try{d.documentElement.doScroll("left")}catch(e){setTimeout(polling,50);return}init()};polling();d.onreadystatechange=function(){if(d.readyState=="complete"){d.onreadystatechange=null;init()}}}};var before=function(el,target){target.parentNode.insertBefore(el,target)};var prepend=function(el,target){if(target.firstChild){before(el,target.firstChild)}else{target.appendChild(el)}};function appendSvg(){var div,svg;div=document.createElement("div");div.innerHTML=svgSprite;svgSprite=null;svg=div.getElementsByTagName("svg")[0];if(svg){svg.setAttribute("aria-hidden","true");svg.style.position="absolute";svg.style.width=0;svg.style.height=0;svg.style.overflow="hidden";prepend(svg,document.body)}}if(shouldInjectCss&&!window.__iconfont__svg__cssinject__){window.__iconfont__svg__cssinject__=true;try{document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>")}catch(e){console&&console.log(e)}}ready(appendSvg)})(window)