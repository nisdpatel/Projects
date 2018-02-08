<?php
require('login_api.php');

session_start(); // added this

$loginInfo = getLoginInfo();
if ($loginInfo == null){
    header("location:login.php");
}
?>

<html>
<body>
Login Successful
<br><br>
<?php

	showLoginUserPopup($loginInfo);
       
?>

    <li><a href=login_public_stuff.php>Public/Private Stuff</a></li>
    
    <p></p>
           
<br><br>
<a href="logout.php">Logout</a>

</body>
</html>