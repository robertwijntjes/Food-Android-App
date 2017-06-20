<?php
    require "conn.php";
    $food_name = $_POST["Name"];

    $mysql_query = "delete from rdetails where Name = '$food_name';";

    if($conn->query($mysql_query) == TRUE)
    {
        echo $food_name . " has been Deleted!";
    }
    else{
        echo "Error: " . $conn->error;
    }
?>