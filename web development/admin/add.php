<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="utf-8">
	<title>UTM Blanket Request Admin Page</title>
	<style>
	 body {font-family:Arial,Helvetica,sans-serif; color:white; background-color:black}
	</style>
    </head>
    <body background="../data/background.jpg">
	<div style="positon:relative; max-width:1200px; margin:auto">
	    <?php
	    // Setup, var init.
	    $id = $_GET['id'];

	    // Check to make sure we are logged in.
	    require('../config.php');
	    require('../login/login_api.php');
	    session_start();
	    $loginInfo = getLoginInfo();

	    // Private view of page.
	    if($loginInfo != null)
	    {
		// Print out form to add entry.
		echo '<form action="commit_add.php" method="post" enctype="multipart/form-data">';
		echo '<h1>Add Entry to Database' . $id . '</h1>';
		echo '<span style="font-weight:bold;text-decoration:underline">Name:</span><br><div style="display:inline-block"><input type="text" name="name">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">College:</span><br><div style="diplay:inline-block"><input type="text" name="college">' . "</div><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Date:</span><br><div style="display:inline-block"><input type="text" name="date">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Advisor:</span><br><div style="display:inline-block"><input type="text" name="advisor">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Major/Endorsement:</span><br><div style="display:inline-block"><input type="text" name="major">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Catalog of Graduation:</span><br><div style="display:inline-block"><input type="text" name="catalog">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Request to Use:</span><br><div style="display:inline-block"><input type="text" name="newCourse">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">To Satisfy:</span><br><div style="display:inline-block"><input type="text" name="oldCourse">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Course Substitution:</span><br><div style="display:inline-block"><input type="text" name="substitution">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Reason:</span><br><div style="display:inline-block"><textarea rows="8" cols="50" type="text" name="reason1"></textarea>' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Other Reason:</span><br><div style="display:inline-block"><textarea rows="8" cols="50" type="text" name="reason2"></textarea>' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Upload PDF</span><br><div style="display:inline-block"><br><div style="display:inline-block"><input type="file" name="fileToUpload" id="fileToUpload">' . "</div><br><br>";
		echo '<input type="submit" name="submit" value="Submit">' . "\n" . '</form>';

		mysqli_close($conn);
	    }
	    // Public view of page.
	    else
	    {
		echo 'You need to be logged in to do that.<br>' . "\n";
		echo 'Click <a href="../index.php">here</a> to go back to the blanket requests.';
	    }
	    ?>
	</div>
    </body>

</html>
