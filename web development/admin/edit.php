<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="utf-8">
	<title>UTM Blanket Request Admin Page</title>
	<style>
	 body {font-family:Arial,Helvetica,sans-serif; color:white; background-color:black}
	</style>
	<script type="text/javascript">
	 function showFileDialog()
	 {
	     // Show/hide file upload interface.
	     if(document.getElementById('fileDialog').style.visibility == 'visible')
	     {
		 document.getElementById('fileDialog').style.visibility = 'hidden';
	     }
	     else
	     {
		 document.getElementById('fileDialog').style.visibility = 'visible';
	     }
	 }
	</script>
    </head>
    <body background="../data/background.jpg">
	<div style="positon:relative; max-width:1200px; margin:auto">
	    <?php
	    // Setup, var init, DB prep.
	    $id = $_GET['id'];
	    require'../config.php';
	    $db = 'cs415_sp16_nisdpate';
	    $tbl = 'blanketDB';

	    // Connect to DB.
	    $conn = mysqli_connect($hostname, $username,$password);
	    mysqli_select_db($conn, $db);

	    // Check to make sure we are logged in.
	    require('../login/login_api.php');
	    session_start();
	    $loginInfo = getLoginInfo();

	    // Private view of page.
	    if($loginInfo != null)
	    {
		// Check for SQL connection errors.
		if(mysqli_connect_errno())
		{
		    die('Connect failed: ' . mysqli_connect_error());
		}

		// Get info from DB.
		$query = "SELECT * FROM " . $tbl . " WHERE id=" . $id;

		$result = mysqli_query($conn, $query);

		// Check for SQL query errors.
		if(!$result)
		{
		    die('Invalid mySQL query: ' . mysqli_error($conn));
		}

		// Store data from DB in vars for PHP.
		$row = mysqli_fetch_array($result);
		$name = $row['Name'];
		$college = $row['College'];
		$date = $row['Date'];
		$advisor = $row['Advisor'];
		$major = $row['Major/Endorsement'];
		$catalog = $row['Catalog of Graduation'];
		$newCourse = $row['Request to Use'];
		$oldCourse = $row['To Satisfy'];
		$substitution = $row['Course Substitution'];
		$reason1 = $row['Reason'];
		$reason2 = $row['Other Reason'];
		$_SESSION['id'] = $id;
		$_SESSION['PDF'] = $row['PDF'];

		// Print out form for editing.
		echo '<form action="commit_edit.php" method="post" enctype="multipart/form-data">';
		echo '<h1>Blanket Request #'.$id.'</h1>';
		echo '<span style="font-weight:bold;text-decoration:underline">Name:</span><br><div style="display:inline-block"><input type="text" name="name" value="'.$name.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">College:</span><br><div style="diplay:inline-block"><input type="text" name="college" value="'.$college.'">' . "</div><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Date:</span><br><div style="display:inline-block"><input type="text" name="date" value="'.$date.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Advisor:</span><br><div style="display:inline-block"><input type="text" name="advisor" value="'.$advisor.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Major/Endorsement:</span><br><div style="display:inline-block"><input type="text" name="major" value="'.$major.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Catalog of Graduation:</span><br><div style="display:inline-block"><input type="text" name="catalog" value="'.$catalog.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Request to Use:</span><br><div style="display:inline-block"><input type="text" name="newCourse" value="'.$newCourse.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">To Satisfy:</span><br><div style="display:inline-block"><input type="text" name="oldCourse" value="'.$oldCourse.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Course Substitution:</span><br><div style="display:inline-block"><input type="text" name="substitution" value="'.$substitution.'">' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Reason:</span><br><div style="display:inline-block"><textarea rows="8" cols="50" type="text" name="reason1">'.$reason1.'</textarea>' . "</div><br><br>";
		echo '<span style="font-weight:bold;text-decoration:underline">Other Reason:</span><br><div style="display:inline-block"><textarea rows="8" cols="50" type="text" name="reason2">'.$reason2.'</textarea>' . "</div><br><br>";
		echo '<input type="submit" name="submit" value="Submit">' . "\n" . '<br><br>';
		echo '<span style="font-weight:bold;text-decoration:underline">PDF</span><br><div style="display:inline-block">';

		echo '<a id="showHideFileDialog" onclick="showFileDialog()" style="color:#aaaaff">Change PDF</a>';
		echo '<span id="fileDialog" style="visibility:hidden">: '.'<input type="file" name="fileToUpload" id="fileToUpload"></span></form><br><br>';


		// Display file if it exists.
		$file = "../data/".$row['PDF'];
		if(file_exists($file) && $row['PDF'] != '')
		{
		    echo '<object data="'. $file . '" width="800" height="1050" type="application/pdf"><br>';
		}
		else
		{
		    echo "<span>Can't find the PDF to display.</span><br>";
		}

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
