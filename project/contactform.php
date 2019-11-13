<?php
  // Read input data
  $debug = false;
  $full_name = isset($_POST['full_name']) 
	? $_POST['full_name'] : '';
  $password = isset($_POST['email'])
	? $_POST['email'] : '';
  $error = null;
  $grade = null;
  if ($full_name !== '' && $email !== '') {
	// read contents of grade file 
	$fp = fopen("emails.csv", "r");
	$info_data = array();
	while (!feof($fp)) {
	  $line = fgets($fp);
	  // $data[0] holds student name, $data[1] holds password,
	  // $data[2] holds grade
	  $data = explode(",", $line);
	  $info_data[$data[0]] = array(
		'full_name' => $data[1],
		'email' => $data[2],
	  );
	}
	fclose($fp);

	
  }
?>