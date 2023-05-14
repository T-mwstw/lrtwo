"use strict";

let Users = new Object();
function req(){
    Users.name = document.getElementById("Name").value;
    Users.poroda = document.getElementById("Poroda").value;
    Users.age = document.getElementById("Age").value;
    Users.color = document.getElementById("Color").value;
    Users.warning = document.getElementById("Warning").value;

    let mydata = JSON.stringify(Users);

    $.ajax({
        type: 'POST',
        url: "http://localhost:8081/untitled8_war_exploded/AddingServlet?data=" + encodeURIComponent(mydata),
        data: mydata,
        dataType: "json",
        contentType: "application/json"
    });
}


