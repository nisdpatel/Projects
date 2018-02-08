<?php
// Setup, var init, DB prep.
session_start();
require('../config.php');
require('../login/login_api.php');
$loginInfo = getLoginInfo();
$id = $_SESSION['id'];
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

    // Check if User wanted to upload a file.
    if(!empty($_FILES["fileToUpload"]["name"]))
    {
	// Add new image.
	require('upload.php');

	// Delete old image.
	$fileLocation = '../data/' . $PDF;
	unlink($fileLocation);

	// Update $PDF to match new image name if file uploaded successfully.
	if($uploadOk == 1)
	{
	    $PDF = basename($_FILES["fileToUpload"]["name"]);
	}
    }

    // If upload is okay or image is not being modified, update DB.
    if($uploadOk == 1 || empty($_FILES["fileToUpload"]["name"]))
    {
	$query = 'UPDATE '.$tbl." SET Name='".$name."', College='".$college . "', Date='".$date."', Advisor='".$advisor."', `Major/Endorsement`='".$major."', `Catalog of Graduation`='".$catalog."', `Request to Use`='".$newCourse."', `To Satisfy`='".$oldCourse."', `Course Substitution`='".$substitution."', Reason='".$reason1."', `Other Reason`='".$reason2."', PDF='".$PDF."' WHERE id='" . $id . "'";

	$result = mysqli_query($conn, $query);

	// Check for SQL query errors.
	if(!$result)
	{
	    die('Invalid mySQL query: ' . mysqli_error($conn));
	}
	else
	{
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
