<?php
require('login_api.php');

session_start(); // added this

?>

<html>
<body>
Public Stuff Page Example
<br><br>
    
This part of the page can be viewed by anybody...
    
<li><a href=login_success.php>Private Only Test page</a></li>
    
    <p></p>
    
<?php
    
    $loginInfo = getLoginInfo();
    
    showLoginUserPopup($loginInfo);

    
    if ($loginInfo == null){
        
        // PUBLIC VIEW OF PAGE GOES HERE...
        
        // Add, Modify, and Delete Stuff goes here.......Coming soon
        ?>
    
    <h1>Public View</h1>
    You are not logged in.  So here is the public stuff...
    <p>
        
    </p>
   <a href=login.php?page=login_public_stuff.php>Log in</a>
        
    <?php
        // END OF PUBLIC VIEW
    }
    
    
    else 
    
    
    {  
        // PRIVATE VIEW OF PAGE GOES HERE
    
        
    ?>
             
<a href="logout.php?page=login_public_stuff.php">Logout MAN</a>
                    
<?php } // END OF PRIVATE VIEW ?>

</body>
</html>