<?php 
session_start();
$page = $_GET["page"];
session_destroy();
$_SESSION = array();


 if ($page != "")
        header("location:" . $page);

?>

You are now logged out!

<a href="login.php?page=<?=$page?>">Login</a>