<?php
    $db_name = "recipe";
    $mysql_username = "root";
    $mysql_password = "";
    $server_name = "localhost";

    $conn = mysqli_connect($server_name,$mysql_username,$mysql_password,$db_name);
    
    $sql = "Create Database recipe";
    $conn->query($sql);


    $sql = "Create Table recipe.rdetails(
        Id int(11) auto_increment primary key,
        Name varchar(15),
        Time varchar(5),
        Description varchar(1000)
  )";
  $conn->query($sql);
?>