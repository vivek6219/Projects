<?php
	require_once("contactform.php");
?>
<html>
<head>
	<title>CSV Demo</title>
	<style>
		#error{
			color:red;
		}
	</style>
	</head>

	<body>
		<h1>Contact Form</h1>
		<form name ="contact_submit_form" method = "post" action="contactform.php">
			<table>
				<tr>
					<td><label>Full name: </label></td>
					<td><input type ="text" name="full_name" value = "<?php echo htmlspecialchars($full_name);?>" required></td>
				</tr>

				<tr>
					<td><label>Email:</label></td>
					<td><input type = "email" name ="email" required></td>
				</tr>

				<tr>
					<td><label>Your info is: </label></td>
					<td><span id ="info" >
					 <?php echo isset($info)? $info :'';?> </td>
					</span>
				</td>

				</tr>
				<tr id ="error">
					<?php
					if(!is_null($error))
					{
						$escaped_error = htmlspecialchars($error);
						echo"<td>Error:</td><td>$escaped_error</td>";
					}
					?>
				</tr>
				<tr>
					<td></td><td><input type ="submit" name ="submit"></td>
				</tr>
			</table>
		</form>
		<?php
			if($debug){
				echo "FullName =$full_name, Email =$email";
			}
			?>
	</body>
</html>