<?php

// original code from: http://www.phpeasystep.com/workshopview.php?id=6
// modified by Bob Bradley 9/5/2014 to work with php 5

// ob_start();
// session_start();

// THIS WAS BAD BAD BAD!!!
// DATA BASE PASSWORDS SHOULD NEVER BE IN GIT REPOSITORIES

// BETTER...
// Make a php file called login.php and put the following code in it
//  changing to the correct $host/$username/$password

/*  DO NOT UNCOMMENT HERE.  MOVE TO THE login.php FILE
<?php
// USER NAME AND PASSWORD STUFF HERE
// DO NOT INCLUDE IN GIT... USE A .getignore

$host="cs1.utm.edu";        // Host name 
$username="xxxx";           // Mysql username 
$password="xxxx";           // Mysql password 

?>
*/

$db_name="cs415_sp16_nisdpate"; // Database name 
$tbl_name="blanketDB";        // Table name 


require_once( "login_config.php" );

// Connect to server and select databse.
$dbc = mysqli_connect("$host", "$username", "$password", "$db_name")
       or die("cannot connect to database: " . mysqli_connect_error()); 
//mysqli_select_db("$db_name")or die("cannot select DB");

// // Define $myusername and $mypassword 
// $myusername=$_POST['myusername']; 
// $mypassword=$_POST['mypassword']; 


// getLoginInfo - returns back the user's login info as an array
//              - returns null if the user is not logged in
function getLoginInfo(){
    if(!isset($_SESSION['myusername']))
        return null;
    
    if(!isset($_SESSION['mypassword']))
        return null;
    
    return getUserInfo($_SESSION['myusername'], $_SESSION['mypassword']);
}

function getUserInfo($myusername, $mypassword) {
	global $tbl_name;
    global $dbc;

	// To protect MySQL injection (more detail about MySQL injection)
	$myusername = stripslashes($myusername);
	$mypassword = stripslashes($mypassword);
	$myusername = mysqli_real_escape_string($dbc,$myusername);
	$mypassword = mysqli_real_escape_string($dbc,$mypassword);
	$sql="SELECT * FROM $tbl_name WHERE username='$myusername' and password='$mypassword'";
	//$result=mysql_query($sql);
    $response = @mysqli_query($dbc, $sql);

	// return $response;
    
    $count=mysqli_num_rows($response);
    if($count==1){
        $info = mysqli_fetch_array( $response ); 
        return $info;
    }
    
    return null; // not found
}

// showLoginUserPopup - Emits the html code so that a box will float
//                      in the upper right that 
//                      lets the user see their login info and logout 
//                      or lets them log in if they are not yet logged in
function showLoginUserPopup($user){

    $first_name = $user['first_name'];
	$last_name = $user['last_name'];
	$image_url = $user['image_url'];

	
    if ($user == null){
        ?>

<div style='cursor:pointer;background-color:#AAAAFF;position:fixed;top:0px;right:0px;padding:10px;color:white;' >
    <a style="color:white;" href='login.php?page=<?=$_SERVER['REQUEST_URI']?>' >LOG IN</a>
</div>

    <?php  
    }
    else {
?>
<div style='cursor:pointer;background-color:#AAAAFF;position:fixed;top:0px;right:0px;padding:10px;color:white;' onClick="document.getElementById('login_popup').style.display = 'block';">
    (<?= $first_name?>
        <?=$last_name?>)
</div>
<div id='login_popup' style='display:none;background-color:white;position:fixed;top:32px;right:0px;padding:10px;border-style:solid;border-color:black;'>
    <img src='<?=$image_url?>' style='max-width:150px;' />
    <br>
    <?=$first_name?>
        <?=$last_name?>
            <br>
            <a href='logout.php?page=<?=$_SERVER['REQUEST_URI']?>'>Logout</a>
</div>

<script type=text/javascript>
    function onMouseOut(event) {
        // http://stackoverflow.com/questions/4697758/prevent-onmouseout-when-hovering-child-element-of-the-parent-absolute-div-withou
        //this is the original element the event handler was assigned to
        var e = event.toElement || event.relatedTarget;
        if (e.parentNode == this || e == this) {
            return;
        }
        //alert('MouseOut');
        // handle mouse event here!
        document.getElementById('login_popup').style.display = 'none';
    }

    document.getElementById('login_popup').addEventListener('mouseout', onMouseOut, true);
</script>

<?php
         }

} // end of showLoginUserPopup function

?>