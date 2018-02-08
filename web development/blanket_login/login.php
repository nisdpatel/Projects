<html>
<body background = "background.jpeg">  
<br>
<br>
 <p><center><font color = "white" size = 50>
     <b><i>Welcome To The MEME_LOGIN PAGE </i></b></font></center></p>
<br>
<br>
<br>
<br>
<table width="300" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
<tr>
<form name="form1" method="post" action="login_check.php?page=<?=$_GET["page"]?>">
<td>
<table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
<tr>
<td colspan="3"><strong>Member Login </strong></td>
</tr>
<tr>
<td width="78">Username</td>
<td width="6">:</td>
<td width="294"><input name="myusername" type="text" id="myusername" value="<?php echo $_SESSION["myusername"]; ?>"></td>
</tr>
<tr>
<td>Password</td>
<td>:</td>
<td><input name="mypassword" type="password" id="mypassword"></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td><input type="submit" name="Submit" value="Login"></td>
</tr>
</table>
</td>
</form>
</tr>
</table>

<div style="color:red; text-align:center;"><?php echo $_SESSION["ERROR"]; ?></div>
<?php 
    $_SESSION["ERROR"] = "";
?>
    
</body>    
</html>