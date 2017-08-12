<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
<meta charset="UTF-8" />
<title>Creare cont</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
<script>
            if (navigator.userAgent.match(/Android/i)) {
                var viewport = document.querySelector("meta[name=viewport]");
            }
            if(navigator.userAgent.match(/Android/i)){
            window.scrollTo(0,1);
            }
        </script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<style>
body, html, .main {
	height: 100%;
}

section {
	min-height: 100%;
}
</style>



<link href="stylesheet/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/custom.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/cloud-zoom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="stylesheet/stylesheet.css" />
<link href="stylesheet/font-awesome.css" rel="stylesheet"
	type="text/css" />
<link href="stylesheet/slideshow.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/jquery.prettyPhoto.css" rel="stylesheet"
	type="text/css" />
<link href="stylesheet/camera.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/superfish.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/responsive.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/photoswipe.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/jquery.bxslider.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="stylesheet/colorbox.css"
	media="screen" />
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,900'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="stylesheet/jquery-ui-1.8.16.custom.css" />
<link rel="stylesheet" type="text/css"
	href="stylesheet/jquery.fancybox-1.3.4.css" media="screen" />
<link rel="stylesheet" type="text/css" href="stylesheet/livesearch.css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/jquery.fancybox-1.3.4.pack.js"></script>
<script src="js/jquery.colorbox.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.cycle.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/tabs.js"></script>
<script src="js/jQuery.equalHeights.js"></script>
<script src="js/jquery.elevatezoom.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/jscript_zjquery.anythingslider.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.nivo.slider.pack.js"></script>
<script src="js/jquery.mobile-events.js"></script>
<script src="js/superfish.js"></script>
<script src="js/tm-stick-up.js"></script>
<script src="js/script.js"></script>
<script src="js/camera.js"></script>
<script src="js/jquery.bxslider.js"></script>
<script src="js/klass.min.js"></script>
<script src="js/code.photoswipe.jquery-3.0.5.js"></script>
<script src="js/pxgradient-1.0.2.jquery.js"></script>
<script type="text/javascript" src="js/custom.js"></script>

</head>
<body>
	<div id="body">



		<div class="swipe">


			<div class="swipe-menu">
				<ul class="links">
					<li class="grow"><a href="#"><i class="fa fa-home"></i>Home</a></li>
					<li><a class=" wishlist-total" href=""><i
							class="fa fa-star"></i>Wish List (0)</a></li>
					<li><a class="" href="#"><i class="fa fa-user"></i>My
							Account</a></li>
					<li><a class="" href="#"><i class="fa fa-shopping-cart"></i>Shopping
							Cart</a></li>
					<li><a class="" href="?route=checkout/checkout"><i
							class="fa fa-check"></i>Checkout</a></li>
					<li><a href="?route=account/register"><i
							class="fa fa-user"></i>Create an account</a></li>
					<li class="login_h"><a href="?route=account/login"><i
							class="fa fa-lock"></i>Login</a></li>
				</ul>
				<div class="language header-button">
					<div class="heading">
						en<i class="fa fa-angle-down"></i>
					</div>
					<div class="heading1">
						<i class="fa fa-globe"></i>Language<i class="fa fa-angle-down"></i>
					</div>
					<form action="?route=module/language" method="post"
						enctype="multipart/form-data">
						<div class="ul">
							<a title="English"
								onClick="$('input[name=\'language_code\']').attr('value', 'en').submit(); $(this).parent().parent().submit();"><span>en</span></a>
							<a title="German"
								onClick="$('input[name=\'language_code\']').attr('value', 'de').submit(); $(this).parent().parent().submit();"><span>de</span></a>
							<a title="Spanish"
								onClick="$('input[name=\'language_code\']').attr('value', 'es').submit(); $(this).parent().parent().submit();"><span>es</span></a>
							<input type="hidden" name="language_code" value="" /> <input
								type="hidden" name="redirect" value="?route=common/home" />
						</div>
					</form>
				</div>

				<ul class="foot">
					<li><a
						href="?route=information/information&amp;information_id=4">About</a></li>
					<li><a
						href="?route=information/information&amp;information_id=6">Delivery</a></li>
					<li><a
						href="?route=information/information&amp;information_id=3">Privacy
							Policy</a></li>
					<li><a
						href="?route=information/information&amp;information_id=5">Terms
							&amp; Conditions</a></li>
				</ul>
				<ul class="foot foot-1">
					<li><a href="?route=information/contact">Contact Us</a></li>
					<li><a href="?route=account/return/insert">Returns</a></li>
					<li><a href="?route=information/sitemap">Site Map</a></li>
				</ul>
				<ul class="foot foot-2">
					<li><a href="?route=product/manufacturer">Brands</a></li>
					<li><a href="?route=account/voucher">Gift Vouchers</a></li>
					<li><a href="?route=affiliate/account">Affiliates</a></li>
					<li><a href="?route=product/special">Specials</a></li>
				</ul>
				<ul class="foot foot-3">
					<li><a href="?route=account/order">Order History</a></li>
					<li><a href="?route=account/newsletter">Newsletter</a></li>
				</ul>
			</div>
		</div>

		<div id="page">
			<div id="shadow">
				<div class="shadow"></div>
				<header id="header">
					<div class="toprow-1">
						<a class="swipe-control" href="#"><i
							class="fa fa-align-justify"></i></a>
						<div class="top-search">
							<i class="fa fa-search"></i>
						</div>
					</div>
					<div id="logo">
						<a href="#"><img src="image/logo2.png"
							title="Look &amp; Listen" alt="Look &amp; Listen" /></a>
					</div>
					<script type="text/javascript">
                            jQuery(document).ready(function(){
                            	if ($('body').width() > 1173) { 
                            		$('.nav__primary').tmStickUp({correctionSelector: $('#wpadminbar')});				
                            	};
                            });		
                        </script>

					<!-- MAIN MENU START -->
					<div class="cart-position nav__primary" style="display:none">
						<div class="cart-inner">
							<div id="cart" class="">
								<div class="heading">
									<span class="link_a"> <i class="fa fa-shopping-cart"></i>
										<span class="sc-button"></span> <span id="cart-total2">3</span>
										<span id="cart-total">3</span> <i class="fa fa-angle-down"></i>
										<span class="clear"></span>
									</span>
								</div>

								<!-- cos cumpraturi start -->
								<div id="cart" class="">
									
								</div>
								
								<!-- cos cumpraturi end -->
							</div>
						</div>
					</div>


					<div class="toprow" style="padding-right: 50px;">

						<script type="text/javascript">
						
						$(document).ready(
								function() {
									var user = '<%= session.getAttribute("userLoged") %>';
									
									if(user != 'null')
									{
										document.getElementById('search').style.display = "block";
										document.getElementById('creareCont').style.display = "none";
										document.getElementById('loginCont').style.display = "none";
									}
									else
									{
										document.getElementById('search').style.display = "none";
									}
									
								});
						
						</script>
						
						<div id="search">
							<div id="cssmenu" class="dropdown">
								<div id="menu-button">Menu</div>
								<ul>
									<li><a href="#" data-title=" Contul meu"><i class="fa fa-user"></i> Bine ai venit, <%= session.getAttribute("userLoged") %></a></li>
									<li><a href="#" onclick="logout_user()"><i class="fa fa-sign-out"></i> Sign out</a></li>
								</ul>
							</div>
						</div>
						
						
						<br>


						<div align="left" id="cssmenu" class="dropdown"
							style="padding-top: 10%; min-width: 700px;">
							<ul>
								<li class="active"><a href="index.jsp"><i
										class="fa fa-home"></i> Acasa</a></li>
								<li><a href="cos-cumparaturi.jsp"><i class="fa fa-opencart"></i> Cos
										Cumparaturi</a></li>
								
								<li id="creareCont"><a href="creare-cont.jsp"><i class="fa fa-users"></i>
										Creaza cont</a></li>
								<li id="loginCont"><a href="login.jsp"><i class="fa fa-lock"></i>
										Login</a></li>
							</ul>
						</div>

						<div class="clear"></div>
					</div>

					<!-- MAIN MENU END -->



					<div class="clear"></div>
				</header>
				<section>
					<!-- SECOND MENU START -->
					<form id="categorieFilm" method="get" action="categorie.jsp">
                        	<input name="category" id="category" value="" style="display:none">
	                        <div id="menu">
	                            <ul class="sf-menu">
	                                <li class="cat_1">
	                                    <a href="#" onclick="getCat('actiune');" ><i class="fa fa-play-circle-o"></i> Actiune</a>
	                                </li>
	                                <li class="cat_2">
	                                    <a href="#" onclick="getCat('comedie');"><i class="fa fa-play-circle-o"></i> Comedie</a>
	                                </li>
	                                <li class="cat_3">
	                                    <a href="#" onclick="getCat('drama');"><i class="fa fa-play-circle-o"></i> Drama</a>
	                                </li>
	                                <li class="cat_4">
	                                    <a href="#" onclick="getCat('horror');"><i class="fa fa-play-circle-o"></i> Horror</a>
	                                </li>
	                                <li class="cat_5">
	                                    <a href="#" onclick="getCat('sf');"><i class="fa fa-play-circle-o"></i> S.F</a>
	                                </li>
	                                <li class="cat_6">
	                                    <a href="#" onclick="getCat('animatie');"><i class="fa fa-play-circle-o"></i> Animatie</a>
	                                </li>
	                            </ul>
	                            <div class="clear"></div>
	                        </div>
                        </form>

					<!-- SECOND MENU END -->
					<div class="clear"></div>
					<div id="container">
						<p id="back-top">
							<a href="#top"><span></span></a>
						</p>
						<div class="container">
							<div id="notification"></div>
							<div class="row">
								<div class=" col-sm-12   " id="content">
									<script type="text/javascript">
                                            if ($('body').width() > 767) {
                                            	(function($){$.fn.equalHeights=function(minHeight,maxHeight){tallest=(minHeight)?minHeight:0;this.each(function(){if($(this).height()>tallest){tallest=$(this).height()}});if((maxHeight)&&tallest>maxHeight)tallest=maxHeight;return this.each(function(){$(this).height(tallest)})}})(jQuery)
                                            $(window).load(function(){
                                            	if($(".maxheight").length){
                                            	$(".maxheight").equalHeights()}
                                            });	
                                            };
                                        </script>
									<script type="text/javascript">
                                            $(document).ready(function(){
                                            $(function(){
                                            $('.new-products  li ').last().addClass('last');
                                            });
                                            }); 
                                        </script>


									<div align="center" style="margin-left: 32%; width: 100%;">
										<div class="row">
											<div class="col-sm-9 col-sm-12">
												<div class="box-container">
													<div class="login-content row">

														<div class="col-sm-6" id="formRegister">
															<div class="right">
																<div class="heading">
																	<i class="fa fa-key"></i>
																	<div class="extra-wrap">
																		<h2>Autentificare</h2>
																	</div>
																</div>
																<form class="form-horizontal" action="" method="post" enctype="multipart/form-data" id="formRegister">
																	<div class="content">
																		<div class="form-group">
																			<label class="padd-form control-label col-sm-5">Username:</label>
																			<div class="controls col-sm-7">
																				<input class="q1 margen-bottom" type="text" id="username" name="username" value="" placeholder="Username">
																			</div>
																		</div>
																		<div class="form-group">
																			<label class="padd-form control-label col-sm-5">Password:</label>
																			<div class="controls col-sm-7">
																				<input class="q1 margen-bottom" id="parola" type="password"
																					name="parola" value="" placeholder="Password">
																			</div>
																		</div>
																		<div class="login-buttons">
																			<a onclick="login_user()"
																				class="button-cont-right">Login<i
																				class="fa fa-arrow-circle-right"></i></a> 
																		</div>
																	</div>
																</form>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="clear"></div>
										</div>

									</div>
									
									<div id="mesaj_salut" align="center"></div>


								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				</section>
				<footer>
					<div class="footer-block">
						<div class="container">
							<div class="row">
								<div id="powered" align="center">
									Powered By <a href="http://www.opencart.com">OpenCart</a><br />
									Look &amp; Listen &copy; 2016
								</div>
							</div>
						</div>
					</div>

				</footer>

			</div>
		</div>
	</div>
	<script>
		function getCat(tip)
	    {
	    	document.getElementById("category").value = tip;
	    	document.getElementById("categorieFilm").submit();
	    }
	</script>
</body>
</html>