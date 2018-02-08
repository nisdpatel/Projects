<?php
// Setup, var init, DB prep.
session_start();
require('../config.php');
require('../login/login_api.php');
$loginInfo = getLoginInfo();
$name = $_POST['name'];
$college = $_POST['college'];
$date = $_POST['date'];
$advisor = $_POST['advisor'];
$major = $_POST['major'];
$catalog = $_POST['catalog'];
$newCourse = $_POST['newCourse'];
$oldCourse = $_POST['oldCourse'];
$substitution = $_POST['substitution'];
$reason1 = $_POST['reason1'];
$reason2 = $_POST['reason2'];
$PDF = $_SESSION['PDF'];
require '../config.php';
$db = "cs415_sp16_nisdpate";
$tbl = "blanketDB";

// Connect to DB.
$conn = mysqli_connect($hostname, $username, $password);
mysqli_select_db($conn, $db);

// Private view
if($loginInfo != null)
{
    // Check for SQL connection errors.
    if(mysqli_connect_errno())
    {
	die('Connect failed: ' . mysqli_connect_error());
    }

    // Add file and entry (only if file uploaded successfully) to DB.
    require 'upload.php';
    if($uploadOk == 1)
    {
	$query = 'INSERT INTO ' . $tbl . "(Name,College,Date,Advisor,`Major/Endorsement`,`Catalog of Graduation`,`Request to Use`,`To Satisfy`,`Course Substitution`,Reason,`Other Reason`,PDF) VALUES('" . $name."','".$college."','".$date."','".$advisor."','".$major."','".$catalog."','".$newCourse."','".$oldCourse."','".$substitution."','".$reason1."','".$reason2."','".basename($_FILES["fileToUpload"]["name"])."')";

	$result = mysqli_query($conn, $query);

	// Check for SQL query errors.
	if(!$result)
	{
	    die('Invalid mySQL query: ' . mysqli_error($conn));
	}
	else
	{
	    // Redirect back to admin page.
	    header('Location: ../admin.php');
	}
    }
}
// Public view.
else
{
    echo 'You need to be logged in to do that.<br>' . "\n";
    echo 'Click <a href="../index.php">here</a> to go back to the blanket requests.';
}

mysqli_close($conn);
?>
