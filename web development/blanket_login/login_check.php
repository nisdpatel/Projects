<?php

require_once('login_api.php');

// original code from: http://www.phpeasystep.com/workshopview.php?id=6
// modified by Bob Bradley 9/5/2014 to work with php 5
// updated by Bob Bradley 3/16/2016 to work with mysqli

ob_start();
session_start();

// Define $myusername and $mypassword 
$myusername=$_POST['myusername']; 
$mypassword=$_POST['mypassword']; 

$info = getUserInfo($myusername, $mypassword);



// If result matched $myusername and $mypassword, table row must be 1 row
if($info != null){

    // Register $myusername, $mypassword and redirect to file "login_success.php"
    //session_register("myusername"); // does not work in php5
    $_SESSION['myusername']=$myusername;
    //session_register("mypassword"); 
    $_SESSION['mypassword']=$mypassword;
    echo "PAGE: " . $_GET["page"];
    
    if (isset($_GET["page"]) && $_GET["page"] != "")
        header("location:" . $_GET["page"]);
    else
        header("location:login_success.php");
       
}
else {
    echo "Wrong Username or Password";
    // Clear the session variables if it is a bad login
    $_SESSION = array();
    $_SESSION['myusername']=$myusername;
    
    $_SESSION["ERROR"] = "Wrong Username or Password";
    header("location:login.php?page=" . $_GET["page"]);
}
ob_end_flush();
?>