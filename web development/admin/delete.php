<?php
// Setup, var init, DB prep.
require('../config.php');
require('../login/login_api.php');
session_start();
$loginInfo = getLoginInfo();
$id = $_GET['id'];
$src = $_GET['src'];
require '../config.php';
$db = "cs415_sp16_nisdpate";
$tbl = "blanketDB";

// Connect to DB.
$conn = mysqli_connect($hostname, $username,$password);
mysqli_select_db($conn, $db);

// Make sure we are logged in.
if($loginInfo != null)
{
    // Check for SQL connection error.
    if(mysqli_connect_errno())
    {
	die('Connect failed: ' . mysqli_connect_error());
    }

    // Delete file and row from DB.
    $fileLocation = '../data/' . $src;
    unlink($fileLocation);
    $query = "DELETE FROM " . $tbl . " WHERE id=" . $id;

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
else
{
    echo 'You need to be logged in to do that.<br>' . "\n";
    echo 'Click <a href="../index.php">here</a> to go back to the list of blanket requests.';
}

mysqli_close($conn);
?>
