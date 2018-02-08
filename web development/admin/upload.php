<?php
// Setup, var init.
require_once('../login/login_api.php');
session_start();
$loginInfo = getLoginInfo();

// Private view
if($loginInfo != null)
{
    /*** CODE FROM W3 ***/
    $target_dir = "../data/";
    $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
    $uploadOk = 1;
    $fileType = pathinfo($target_file,PATHINFO_EXTENSION);

    if(!empty($_FILES["fileToUpload"]["name"]))
    {
	// Check if image file is a actual image or fake image
	/*** Uploading PDFs, not images ***
	   if(isset($_POST["submit"])) {
	   $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
	   if($check !== false) {
	   $uploadOk = 1;
	   } else {
	   $uploadOk = 0;
	   }
	   }
	 */
	// Check if file already exists
	if (file_exists($target_file) && $uploadOk == 1) {
	    echo "Sorry, file already exists.<br>";
	    $uploadOk = 0;
	}
	// Check file size
	if ($_FILES["fileToUpload"]["size"] > 2500000 && $uploadOk == 1) {
	    echo "Sorry, your file is too large.<br>";
	    $uploadOk = 0;
	}
	// Allow certain file formats
	if($fileType != "pdf"  && $uploadOk == 1) {
	    echo "Sorry, only PDF files are allowed.<br>";
	    $uploadOk = 0;
	}
	// Check if $uploadOk is set to 0 by an error
	if ($uploadOk == 0) {
	    echo "Sorry, your file was not uploaded.<br>";
	    echo 'Click <a href="../admin.php">here</a> to go back to the admin page.';
	    // if everything is ok, try to upload file
	} else {
	    if (!move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
		echo "Sorry, there was an error uploading your file.";
		echo 'Click <a href="../admin.php">here</a> to go back to the admin page.';
	    }
	}
    }
    /*** END CODE FROM W3 ***/
}
else
{
    echo 'You need to be logged in to do that.<br>' . "\n";
    echo 'Click <a href="../index.php">here</a> to go back to the blanket requests.';
}
?>
