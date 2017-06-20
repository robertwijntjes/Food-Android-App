<?php
    require "conn.php";
    $foodname = $_POST["Name"];
    $description = $_POST["Description"];


    $mysql_query = "update rdetails set Description = '$description' where Name = '$foodname';";
    if($conn->query($mysql_query) == TRUE)
    {
        echo $foodname . " Has been altered to have a Description of " . $description;
    }
    else{
        echo "Well that didnt work :S";
    }
?>