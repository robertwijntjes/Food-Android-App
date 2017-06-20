<?php
    require "conn.php";
    $food_name = $_POST["Name"];
    $food_howto = $_POST["Time"];
    $food_description = $_POST["Description"];

    $mysql_query = "insert into rdetails (Id,Name,Time,Description) values ('','$food_name','$food_howto','$food_description')";

    if($conn->query($mysql_query) === TRUE)
    {
        echo $food_name . "has been successfully Added!";
    }
    else{
        echo "Error: " . $conn->error;
    }
    $conn->close();
?>