<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Rama Inn</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .jumbotron {
      background-color: maroon;
      color: #fff;
      padding: 70px 25px;
	 
  }
	
  .container-fluid {
      padding: 60px 50px;
  }
  .bg-grey {
      background-color: #f6f6f6;
  }
 
	  
/*customer_review */	  
.carousel-control.right, .carousel-control.left {
    background-image: none;
    color: maroon;
}

	 
.carousel-indicators li {
    border-color: white;
}

.carousel-indicators li.active {
    background-color: white;
}

.item h4 {
    font-size: 19px;
    line-height: 1.375em;
    font-weight: 400;
    font-style: italic;
    margin: 70px 0;
}

.item span {
    font-style: normal;
} /*end customer review and room */
h1 {
    font-size: 70px;
}	   
/*begin navugation bar */
  .navbar {
      margin-bottom: 0;
      background-color: maroon;
      z-index: 9999;
      border: 0;
      font-size: 15px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
      color: maroon !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      color: #fff !important;
  }/*end navugation bar */
	
	  
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
  }
  ul.a {
    list-style-type: circle;
}    
 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 90%;
      margin: auto;
	  }
	  .logo {
      color: #f4511e;
      font-size: 200px;
  }
  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      
    </div> 
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">ABOUT</a></li>
        <li><a href="#room">ROOM</a></li>
        
		  <li><a href="#pricing">PRICING</a></li>
		 <li><a href="#photos">PHOTOS</a></li>
		 <li><a href="#contact">CONTACT</a></li> 
		<li><a href="#location">LOCATION</a></li> 
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
	<!--
	<img src="sign.jpg" class="img-rounded" alt="Cinque Terre" width="200" height="150" position ="left">
  -->
<div class="row">
  
    <h1><font face = "gabriola">Rama Inn</font></h1> 
    <h2><font size =7 face = "gabriola"> 24 Edwards Dr Bells, TN 38006 </font></h2>
	
	</div>
</div>

<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row">
    <div class="col-sm-8">
      <h2>About </h2>
           
      <p>A one hour drive from Memphis, the Rama Inn, a Magnuson Hotel affiliate, is conveniently located on US Highway 412, about 20 miles from Jackson, TN, and 30 miles from Dyersburg, TN. It is also 15 miles from Exit 79 off of Interstate 40. See cars from movies like the Fast And Furious at Rustys TV and Car Museum; see the AA Mariner Affiliate team, the Jackson Generals; or visit some of the historical Civil War sites like the site of theBattle of Britton Lane. Or browse the world famous Brook Shaw Old Country Store, serving Southern buffets daily. Nearby colleges include Lane College and Union University.</p>
<p>
       While staying at the Rama Inn, guests can start each day with a free breakfast, stay connected with free high speed wireless internet access, and pets are welcome with an additional fee. </p>
<p>
       All guest rooms have free high speed wireless internet, microwave, mini fridge, cable TV, hair dryer, free local calls, alarm clock, iron and board, and individually controlled air conditioning and heat.
</p>
      
    </div>
    <div class="col-sm-4">
        
        <p><b>POINTS OF INTEREST</b></p>
     <ul class ="a">
        <li>Lane College </li>
         <li>Union University</li>
         <li>Jackson Generals Baseball</li>
         <li>Battle of Britton Lane Site, Civil War Attraction</li>
         <li>Brook Shaw Old Country Store</li>
         <li>Rustys TV And Movie Car Museum</li>
         <li>Tennessee Safari Park</li>
         <li>Jonesboro</li>
         <li>Memphis International</li>
         <li>Mc Kellar-Sipes Regional</li>
         <li>Olive Branch Arpt</li>
         <li>Memphis</li>
         <li>Jackson</li>
         <li>Dyersburg</li>
         <li>Bells</li>
        
        </ul>
      </div>
    </div>
</div>


	
<br>	
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
<!-- Container ROOM -->
<div id="room" class="container-fluid bg-grey">
  <h2 class="text-center">ROOM(Note: upload the new pictures - testing only)</h2>
  <div class="row">
    <div class="col-sm-5">
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
	  <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
    
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="queen.jpg" alt="Chania" width="460" height="345">
      </div>

      <div class="item">
        <img src="double.jpg" alt="Chania" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="single.jpg" alt="Flower" width="460" height="345">
      </div>

      <div class="item">
        <img src="tv.jpg" alt="Flower" width="460" height="345">
      </div>
		<div class="item">
        <img src="tv2.jpg" alt="Flower" width="460" height="345">
      </div>
		<div class="item">
        <img src="sink.jpg" alt="Flower" width="460" height="345">
      </div>
		
	
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
	  </div>
	</div>
	</div>

<br>
<br>
	<br>



	<!-- Container (Pricing Section) -->
	
<div id="pricing" class="container-fluid">
<p id="demo"></p>
  <div class="text-center">

    <h2>Pricing (temp)</h2>
	 
  </div>
 <center>

  <div class="row">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h2>Queen  </h2>
		
        </div>
        <div class="panel-body">
          <p> <strong>$50</strong> per night</p>
		  <p>Maximum 2 people. Addtional charge for an extra person.</p>
        </div>
      </div>      
    </div>  
	  
	   <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h2>King</h2>
        </div>
        <div class="panel-body">
          <p><strong>$55</strong> per night</p>
		  <p>Maximum 3 people. Additional charge for an extra person.</p>
       
        </div>
      </div>      
    </div>
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <h2>Double</h2>
        </div>
        <div class="panel-body">
          <p><strong>$60</strong> per night</p>
		  <p>Maximum 4 people. Additional charge for an extra person.</p>
       
        </div>
      </div>      
    </div> 
	      
	</div>
	</center>
	</div>
<br> 

	
	
<!--	
<div>	
<h2 class="text-center">What our customer say</h2>
<div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
 
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" role="listbox">
    <div class="item active">
    <h4>"This company is the best. I am so happy with the result!"<br><span style="font-style:normal;">Michael Roe, Vice President, Comment Box</span></h4>
    </div>
    <div class="item">
      <h4>"One word... WOW!!"<br><span style="font-style:normal;">John Doe, Salesman, Rep Inc</span></h4>
    </div>
    <div class="item">
      <h4>"Could I... BE any more happy with this company?"<br><span style="font-style:normal;">Chandler Bing, Actor, FriendsAlot</span></h4>
    </div>
  </div>


  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

	</div>
-->


	 <!-- 
<form id="my_form" onsubmit="submitForm(); return false;">
  <p><input id="n" placeholder="Name" required></p>
  <p><input id="e" placeholder="Email Address" type="email" required></p>
  <textarea id="m" placeholder="write your message here" rows="10" required></textarea>
  <p><input id="mybtn" type="submit" value="Submit Form"> <span id="status"></span></p>
</form>
  </div>
</div>   
 
-->	
<br>
 
	
	
	
	
	
<div id="photos" class="container-fluid bg-grey">
  <h2 class="text-center">PHOTOs(Note: upload the new pictures - testing only)</h2>
  <div class="row">	
<style>
.mySlides {display:none;}
</style>


<center>
<div class="w3-content w3-section" style="max-width:650px">
  <img class="mySlides w3-animate-top" src="sign.JPG" style="width:90%">
  <img class="mySlides w3-animate-bottom" src="sign2.JPG" style="width:90%">
  <img class="mySlides w3-animate-top" src="building.JPG" style="width:90%">
 
</div>
	</center>
	</div>
	</div>
	
	  
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2500);    
}
</script>	
<br>	
	  
<!-- Container (Contact Section) -->
	<br>
	
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">CONTACT</h2>
  <div class="row">
	 
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> Bells, US</p>
      <p><span class="glyphicon glyphicon-phone"></span> 731-663-1024</p>
      <p><span class="glyphicon glyphicon-envelope"></span> nis.patel23@gmail.com</p>
		<p><span> <a href = "https://search.google.com/local/writereview?placeid=ChIJEVEHRvm3fogRvaVFKMcy-4k"><font size = "4">Click here to wrtie a review</font></a></span></p>

    </div>
	  <form id="my_form" onsubmit="submitForm(); return false;">
    <div class="col-sm-7">
      <div class="row">
		 
        <div class="col-sm-6 form-group">
          <input class="form-control" id="n" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="e" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="m" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
		
          <button class="btn btn-default pull-right" type="submit">Send</button><span id="status"></span></div>
		  </div>
        </div>
		  
		  
   	</form>
	</div>
	</div>	
	
<br>	
<!-- Container (Location Section) -->
<div id="location" class="container-fluid bg-grey">
  <h2 class="text-center">LOCATION</h2>


   
	<!-- Add Google Maps -->
<div id="googleMap" style="height:400px;width:100%;"></div>
	
<script>
function myMap() {
var myCenter = new google.maps.LatLng(35.740700,-89.087809);
var mapProp = {center:myCenter, zoom:16, scrollwheel:false, draggable:false, mapTypeId:google.maps.MapTypeId.ROADMAP};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
var marker = new google.maps.Marker({position:myCenter});
marker.setMap(map);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDipKk9OYqnWG8IBTjkMyNx7Hm0NosXogk&callback=myMap"></script>	
	</div>

	
	
	<div style = "background-color:maroon"  data-position="fixed">
		<font size ="4" color = "white"><center>&copy; 2017 Rama Inn. All rights reserved.</center></font></div>
</body>
</html>