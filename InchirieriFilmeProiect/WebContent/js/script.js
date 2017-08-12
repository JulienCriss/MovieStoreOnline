/** span close **/
$('.success span, .warning span, .attention span, .information span').live('click', function() {
$(this).parent().fadeOut('slow', function() {
$(this).remove();
});
});

/** prettyphoto **/
    $(document).ready(function(){
       $("a[data-gal^='prettyPhoto']").prettyPhoto({
  animationSpeed:'slow',theme:'facebook',slideshow:5000, autoplay_slideshow: false,
		   animation_speed:'fast',slideshow:5000,autoplay_slideshow:false,opacity:0.80,show_title:true,allow_resize:true,default_width:500,default_height:344,counter_separator_label:'/',theme:'pp_default',horizontal_padding:20,hideflash:false,wmode:'opaque',autoplay:true,modal:false,deeplinking:true,overlay_gallery:true,keyboard_shortcuts:true,
		  
        });
    });

/** menu **/
	jQuery(document).ready(function() { 
	(function($){ //create closure so we can safely use $ as alias for jQuery
      $(document).ready(function(){
        var exampleOptions = {
          speed: 'fast'
        }
        // initialise plugin
        var example = $('#menu').superfish(exampleOptions);
      });

    })(jQuery);
}); 

$(document).ready(function() {		
	if($('#menu').height() > 60 && $('body').width() > 1173 && $('body').width() < 1420){
		$('ul.sf-menu>li>a').css({fontSize:'16px'});
		$('ul.sf-menu>li>a').css({paddingRight:'10px'});
		$('ul.sf-menu>li>a').css({paddingLeft:'10px'});
		};
	if($('#menu').height() > 60 && $('body').width() > 1419){
		$('ul.sf-menu>li>a').css({fontSize:'20px'});
		$('ul.sf-menu>li>a').css({paddingRight:'16px'});
		$('ul.sf-menu>li>a').css({paddingLeft:'16px'});
		};
});
		
/** backtotop **/
	jQuery(document).ready(function(){
	var IE='\v'=='v';
	// hide #back-top first
	jQuery("#back-top").hide();
	// fade in #back-top
	jQuery(function () {
		jQuery(window).scroll(function () {
			if (!IE) {
				if (jQuery(this).scrollTop() > 100) {
					jQuery('#back-top').fadeIn();
				} else {
					jQuery('#back-top').fadeOut();
				}
			}
			else {
				if (jQuery(this).scrollTop() > 100) {
					jQuery('#back-top').show();
				} else {
					jQuery('#back-top').hide();
				}	
			}
		});

		// scroll body to 0px on click
		jQuery('#back-top a').click(function () {
			jQuery('body,html').animate({
				scrollTop: 0
			}, 800);
			return false;
		});
	});

});/**-------------------------------------**/
$(function(){
$('header .links li').last().addClass('last');
$('.breadcrumb a').last().addClass('last');
$('.cart tr').eq(0).addClass('first');
});
  
/**----------------------------------------**/
$(document).ready(function() {
$('.jcarousel-list li a img').css({opacity:'0.3'});
$('.jcarousel-list li a img').hover(function(){
     jQuery(this).stop(true,false).animate({opacity:'1'}, {duration: 250});
    },function(){
     jQuery(this).stop(true,false).animate({opacity:'0.3'}, {duration: 250});
   }
   )   

	$('.camera_caption h1').pxgradient({ 
	  step: 10,
	  colors: ["#fff","#efefef","#dadada"], 
	  dir: "y" 
	});
	$('.banner h1').pxgradient({ 
	  step: 10,
	  colors: ["#fff","#efefef","#dadada"], 
	  dir: "y" 
	});

});

/**---------------------------------------------**/
/* AddToCart */
$(document).ready(function() {
         var fl=true;

$('.addToCart').click(function() {

 if (fl) {
   fl=false;
   var tis = $(this);
   $.ajax({
   url: 'index.php?route=checkout/cart/add',
   type: 'post',
   data: 'product_id=' + tis.attr("data-id"),
   dataType: 'json',
   content: this,
   success: $.proxy(function(json) {
   $('.success, .warning, .attention, .information, .error').remove();
   if (json['redirect']) {
   location = json['redirect'];
   }
   if (json['error']) {
   if (json['error']['warning']) {
   $('#notification').html('<div class="warning" style="display: none;">' + json['error']['warning'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');
   }
   }
   if (json['success']) {
     $('#notification').html('<div class="success" style="display: none;"><i class="fa fa-thumbs-up"></i>' + json['success'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');

       $('.success').fadeIn('slow');
   $('#cart-total').html(json['total']);
   $('#cart-total2').html(json['total']);
   $('#cart .content').html(json['output']);
	$('#cart').load('index.php?route=module/cart #cart > *');
	   
   animateProduct(tis.parents('li').find(".image2 img") , $("#cart"));
   }
   setTimeout(function() {$('.success').fadeOut(1000)},3000)
   }, this)
   });
 }
});


function animateProduct(image,cart){
var image_offset = image.offset();
$("body").append('<img src="' + image.attr('src') + '" id="temp" style="position: absolute; z-index:9999; top:'+image_offset.top+'px; left:'+image_offset.left+'px" />');
var cart_offset = cart.offset();
params = {
top : cart_offset.top + 'px',
left : cart_offset.left + 'px',
opacity : 0.0,
width : cart.width(),
height : cart.height()
};
$('#temp').animate(params, 'slow', false, function () {
$('#temp').remove();
fl=true;
});
}

});

/**------------------------------------------------------**/
/* AddToCart */
$(document).ready(function() {
         var fl=true;

$('.addToCart-1').click(function() {

 if (fl) {
   fl=false;
   var tis = $(this);
   $.ajax({
   url: 'index.php?route=checkout/cart/add',
   type: 'post',
   data: 'product_id=' + tis.attr("data-id"),
   dataType: 'json',
   content: this,
   success: $.proxy(function(json) {
   $('.success, .warning, .attention, .information, .error').remove();
   if (json['redirect']) {
   location = json['redirect'];
   }
   if (json['error']) {
   if (json['error']['warning']) {
   $('#notification').html('<div class="warning" style="display: none;">' + json['error']['warning'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');
   }
   }
   if (json['success']) {
     $('#notification').html('<div class="success" style="display: none;"><i class="fa fa-thumbs-up"></i>' + json['success'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');

       $('.success').fadeIn('slow');
   $('#cart-total').html(json['total']);
   $('#cart-total2').html(json['total']);
   $('#cart .content').html(json['output']);
	$('#cart').load('index.php?route=module/cart #cart > *');
	   
   animateProduct(tis.parents('.preview').find(".image3 img") , $("#cart"));
   }
   setTimeout(function() {$('.success').fadeOut(1000)},3000)
   }, this)
   });
 }
});


function animateProduct(image,cart){
var image_offset = image.offset();
$("body").append('<img src="' + image.attr('src') + '" id="temp" style="position: absolute; z-index:9999; top:'+image_offset.top+'px; left:'+image_offset.left+'px" />');
var cart_offset = cart.offset();
params = {
top : cart_offset.top + 'px',
left : cart_offset.left + 'px',
opacity : 0.0,
width : cart.width(),
height : cart.height()
};
$('#temp').animate(params, 'slow', false, function () {
$('#temp').remove();
fl=true;
});
}

});

/** related coroucel **/
$(document).ready(function() {
$('.related-carousel .box-product ul').jcarousel({
	vertical: false,
	visible: 4,
	scroll: 1
});
});
$(document).ready(function() {
$('div.image-caroucel').jcarousel({
	vertical: false,
	visible: 3,
	scroll: 1
});
/**--------------------------------------------------**/
jQuery('.header-button').on("click", function(){
    var ul=jQuery(this).find('.ul')
    if(ul.is(':hidden'))
     ul.slideDown()
     ,jQuery(this).addClass('active')
    else
     ul.slideUp()
     ,jQuery(this).removeClass('active')
    jQuery('.header-button').not(this).find('.ul').slideUp()
    return false
   });
   jQuery(document).click(function(){
    jQuery('.header-button').removeClass('active').find('.ul').slideUp()
   });
/**--------------------------------------------------**/

jQuery(document).ready(function(){
	if ($(body).width() < 768) {
   jQuery('.top-search').on("click", function(){
		if ( $('#search').css('display') == 'none' ) {
		$('#search').animate({height: 'show'}, 400);
		} else {
		$('#search').animate({height: 'hide'}, 200);
		}
   });
   
	jQuery(document).on("click touchstart", function(){
		$('#search').animate({height: 'hide'}, 200);
	});
		jQuery('#search').on("click touchstart", function(event){
		event.stopPropagation();
	});
	jQuery('.top-search').on("click touchstart", function(event){
		event.stopPropagation();
	});
};
 
});

jQuery("#menu-icon").on("click", function(){
  jQuery(".sf-menu-phone").slideToggle();
  jQuery(this).toggleClass("active");
 });

  jQuery('.sf-menu-phone').find('li.parent').append('<i class="fa fa-chevron-down"></i>');
  jQuery('.sf-menu-phone li.parent i').on("click", function(){
   if (jQuery(this).hasClass('fa-chevron-up')) { jQuery(this).removeClass('fa-chevron-up').addClass('fa-chevron-down').parent('li.parent').find('> ul').slideToggle(); } 
    else {
     jQuery(this).removeClass('fa-chevron-down').addClass('fa-chevron-up').parent('li.parent').find('> ul').slideToggle();
    }
  });



});
/** shadow height **/
var sect = 1;
		$(document).ready(function() {
            $('.shadow').height($('#page').height());

            $(window).resize(function() {
                $('.shadow').height($('#page').height());
            });

            var sects = $('.shadow').size();
			 
			$('.swipe').height($(window).height()-50);

            $(window).resize(function() {
                $('.swipe').height($(window).height()-50);
            });

            var sects = $('.swipe').size();

        });

/** wrap span **/
var fl2=true;
function addToCart(product_id) {
	if (fl2) {
		fl2=false;
		$.ajax({
		url: 'index.php?route=checkout/cart/add',
		type: 'post',
		data: 'product_id=' + product_id,
		dataType: 'json',
		success: function(json) {
		$('.success, .warning, .attention, .information, .error').remove();
		if (json['redirect']) {
		location = json['redirect'];
		}
		if (json['error']) {
		if (json['error']['warning']) {
		$('#notification').html('<div class="warning" style="display: none;">' + json['error']['warning'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');
		}
		}
		if (json['success']) {
		$('#notification').html('<div class="success" style="display: none;"><i class="fa fa-thumbs-up"></i>' + json['success'] + '<span class="close"><i class="fa fa-times-circle"></i></span></div>');
						
		$('.success').fadeIn('slow');
		$('#cart-total').html(json['total']);
		$('#cart-total2').html(json['total']);
		$('#cart').load('index.php?route=module/cart #cart > *');
		
		$('#cart .content').html(json['output']);
		var image = $('#img_'+product_id).offset();
		if (image) {
		var cart = $('#cart').offset();
		$('<img src="' + $('#img_'+product_id).attr('src') + '" id="temp" style="position: absolute; z-index:9999; top: ' + image.top + 'px; left: ' + image.left + 'px;" />').appendTo('body');
		params = {
		top : cart.top + 'px',
		left : cart.left + 'px',
		opacity : 0.2,
		width :$('#img_'+product_id).width(),
		height : $('#img_'+product_id).height()
		};
		// uncomment line below if you also want to scroll up
		//$('html, body').animate({ scrollTop: 0 }, 'slow');
		$('#temp').animate(params, 'slow', false, function () {
		$('#temp').remove();
		fl2=true;
		});
} else {
fl2=true;
}


}
setTimeout(function() {$('.success').fadeOut(1000)},3000)
}
});
}
}
/**------------------------------------------**/
$(document).ready(function() {
	if ($('body').width() < 768) {
		leftColumn = $('body').find('#column-left');
		leftColumn.remove().insertAfter('#content');
jQuery('.col-sm-3 .box-heading').append('<i class="fa fa-plus-circle"></i>');
  jQuery('.col-sm-3 .box-heading').on("click", function(){
   if (jQuery(this).find('i').hasClass('fa-minus-circle')) { jQuery(this).find('i').removeClass('fa-minus-circle').parents('.col-sm-3 .box').find('.box-content').slideToggle(); }
   else {
    jQuery(this).find('i').addClass('fa-minus-circle').parents('.col-sm-3 .box').find('.box-content').slideToggle();
   }
  })
  
  };
  if ($('body').width() > 767) {
	// tooltip demo
		$('.tooltip-toggle').tooltip({
		selector: "a[data-toggle=tooltip]"
		})
		$('.tooltip-1').tooltip({
			placement:'bottom'
		})
		$('.tooltip-2').tooltip({
			placement:'top'
		})
		$('.tooltip-3').tooltip({
			placement:'left'
		})
		$('.tooltip-4').tooltip({
			placement:'right'
		})
		}
			
/** products info **/
		if ($('body').width() < 768) {
	jQuery('.tab-heading').append('<i class="fa fa-plus-circle"></i>');
	jQuery('.tab-heading').on("click", function(){
	if (jQuery(this).find('i').hasClass('fa-minus-circle')) { jQuery(this).find('i').removeClass('fa-minus-circle').parents('.tabs').find('.tab-content').slideToggle(); }
	else {
    jQuery(this).find('i').addClass('fa-minus-circle').parents('.tabs').find('.tab-content').slideToggle();
   }
  })
};
		
		
		
		
});
/** add icon aside li **/
    $(document).ready(function(){
       $('body').find('.box-category > ul > li > a').prepend('<i class="fa fa-angle-right"></i>');
       $('aside').find('.box-content .afine li > a').prepend('<i class="fa fa-angle-right "></i>');
       $('aside').find('.box-content .info li > a').prepend('<i class="fa fa-angle-right "></i>');
       $('aside').find('.box-content .info-list li > a').prepend('<i class="fa fa-angle-right "></i>');
       $('aside').find('.box-content .acount li > a').prepend('<i class="fa fa-angle-right "></i>');
       $('#content').find('.manufacturer-list ul>li>a').prepend('<i class="fa fa-angle-right"></i>');
       $('#content').find('.sitemap-info ul>li>a').prepend('<i class="fa fa-angle-right "></i>');
       $('#content').find('.content ul li>a').prepend('<i class="fa fa-angle-right "></i>');
       
    });
/** Aside box category **/
$(document).ready(function(){
		jQuery('.box .box-category').find('li.parent').prepend('<i class="fa fa-angle-down"></i>');
		jQuery('.box .box-category li.parent i').on("click", function(){
		if (jQuery(this).hasClass('fa-angle-up')) { jQuery(this).removeClass('fa-angle-up').parent('li.parent').find('> ul').slideToggle(); } 
			else {
			jQuery(this).addClass('fa-angle-up').parent('li.parent').find('> ul').slideToggle();
			}
		});

		/** bx-slider **/
		$('.related-slider').bxSlider({
			pager:false,
			controls:true,
			slideMargin:30,
			minSlides: 1,
			maxSlides: 4,
			slideWidth: 170,
			infiniteLoop:false,
			moveSlides:1
			});
		$('#gallery').bxSlider({
			pager:false,
			controls:true,
			minSlides: 1,
			maxSlides: 1,
			infiniteLoop:false,
			moveSlides:1
			});
		$('#image-additional').bxSlider({
			pager:false,
			controls:true,
			slideMargin:10,
			minSlides: 3,
			maxSlides: 3,
			slideWidth:70,
			infiniteLoop:false,
			moveSlides:1
			});
		
		
    });

/** swipe **/
   jQuery(document).ready(function(){
    
	jQuery('#page').click(function(){
      if(jQuery(this).parents('body').hasClass('ind')){
      jQuery(this).parents('body').removeClass('ind');
      return false
     }
	 })
    jQuery('.swipe-control').click(function(){
     if(jQuery(this).parents('body').hasClass('ind')){
      jQuery(this).parents('body').removeClass('ind');
      return false
     }
     else{
      jQuery(this).parents('body').addClass('ind');
      return false
     }
    })

$("#zoom_01").elevateZoom({gallery:'image-additional', cursor: 'pointer', galleryActiveClass: 'active', imageCrossfade: true}); 
//pass the images to Fancybox
$("#zoom_01").bind("click", function(e) {  
  var ez =   $('#zoom_01').data('elevateZoom');	
	$.fancybox(ez.getGalleryList());
  return false;
});

});
   
   
   
   
   
   
   /*---------------------------------*/
   
   (function($) {

	   $.fn.menumaker = function(options) {
	       
	       var cssmenu = $(this), settings = $.extend({
	         title: "Menu",
	         format: "dropdown",
	         breakpoint: 768,
	         sticky: false
	       }, options);

	       return this.each(function() {
	         cssmenu.find('li ul').parent().addClass('has-sub');
	         if (settings.format != 'select') {
	           cssmenu.prepend('<div id="menu-button">' + settings.title + '</div>');
	           $(this).find("#menu-button").on('click', function(){
	             $(this).toggleClass('menu-opened');
	             var mainmenu = $(this).next('ul');
	             if (mainmenu.hasClass('open')) { 
	               mainmenu.hide().removeClass('open');
	             }
	             else {
	               mainmenu.show().addClass('open');
	               if (settings.format === "dropdown") {
	                 mainmenu.find('ul').show();
	               }
	             }
	           });

	           multiTg = function() {
	             cssmenu.find(".has-sub").prepend('<span class="submenu-button"></span>');
	             cssmenu.find('.submenu-button').on('click', function() {
	               $(this).toggleClass('submenu-opened');
	               if ($(this).siblings('ul').hasClass('open')) {
	                 $(this).siblings('ul').removeClass('open').hide();
	               }
	               else {
	                 $(this).siblings('ul').addClass('open').show();
	               }
	             });
	           };

	           if (settings.format === 'multitoggle') multiTg();
	           else cssmenu.addClass('dropdown');
	         }

	         else if (settings.format === 'select')
	         {
	           cssmenu.append('<select style="width: 100%"/>').addClass('select-list');
	           var selectList = cssmenu.find('select');
	           selectList.append('<option>' + settings.title + '</option>', {
	                                                          "selected": "selected",
	                                                          "value": ""});
	           cssmenu.find('a').each(function() {
	             var element = $(this), indentation = "";
	             for (i = 1; i < element.parents('ul').length; i++)
	             {
	               indentation += '-';
	             }
	             selectList.append('<option value="' + $(this).attr('href') + '">' + indentation + element.text() + '</option');
	           });
	           selectList.on('change', function() {
	             window.location = $(this).find("option:selected").val();
	           });
	         }

	         if (settings.sticky === true) cssmenu.css('position', 'fixed');

	         resizeFix = function() {
	           if ($(window).width() > settings.breakpoint) {
	             cssmenu.find('ul').show();
	             cssmenu.removeClass('small-screen');
	             if (settings.format === 'select') {
	               cssmenu.find('select').hide();
	             }
	             else {
	               cssmenu.find("#menu-button").removeClass("menu-opened");
	             }
	           }

	           if ($(window).width() <= settings.breakpoint && !cssmenu.hasClass("small-screen")) {
	             cssmenu.find('ul').hide().removeClass('open');
	             cssmenu.addClass('small-screen');
	             if (settings.format === 'select') {
	               cssmenu.find('select').show();
	             }
	           }
	         };
	         resizeFix();
	         return $(window).on('resize', resizeFix);

	       });
	   };
	 })(jQuery);

	 (function($){
	 $(document).ready(function(){

	 $(document).ready(function() {
	   $("#cssmenu").menumaker({
	     title: "Menu",
	     format: "dropdown"
	   });

	   $("#cssmenu a").each(function() {
	   	var linkTitle = $(this).text();
	   	$(this).attr('data-title', linkTitle);
	   });
	 });

	 });
	 })(jQuery);

