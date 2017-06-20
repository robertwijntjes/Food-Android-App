<?php
    require "conn.php";
    $food_name = $_POST["name"];

    //$food_how = $_POST["foodhow"];
    //$food_des = $_POST["fooddes"];

    $mysql_qry = "select * from rdetails where name like '%$food_name%' ;";
    $result = mysqli_query($conn,$mysql_qry);

    $id = mysqli_fetch_array($result);

        if(mysqli_num_rows($result) > 0)
        {
            $rname = $id["Name"];
            $rid = $id["Id"]; 
            $rtime = $id["Time"];
            $rdes = $id["Description"];
            $String_put = "Id: " . $rid . "#" . "Name: " . $rname . "#" . "Time: " . $rtime . "#" . "Description: " . $rdes;
            echo $String_put;
            
        }
        else
        {
            echo "Food Item not Found.";
        }
        $conn->close();


?>
