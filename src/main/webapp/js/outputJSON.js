"use strict";

let str = "";
function output()
{
    var client = new XMLHttpRequest();

    client.onreadystatechange = function ()
    {
        if (client.readyState == 4 && client.status == 200)
        {
            str = JSON.parse(client.responseText);
            gggg(str);
        }
    };
    client.open("POST", "http://localhost:8081/untitled8_war_exploded/OutputServlet?", true);
    client.setRequestHeader("Content-type", "application/json");
    client.send("");
}

function gggg(str)
{
    let out = document.getElementById("tablica");

    out.innerHTML = "<h1>Users list</h1>\n" +
        "        <table>\n" +
        "            <tr>\n" +
        "                <th>Имя</th><th>Порода</th><th>Возраст</th><th>Окрас</th><th>Особые приметы</th>\n" +
        "            </tr>\n";

    for(let i = 0; i < str.length; i++)
    {
        let sss = new Object(str[i]);
        out.innerHTML +=
            "<TR>\n" +
            "<TH>" + sss.name + "</TH><TH>" + sss.poroda + "</TH><TH>" + sss.age + "</TH><TH>" + sss.color + "</TH><TH>" + sss.warning + "</TH>\n" +
            "</TR>\n";
        out.innerHTML += "</br>";
    }
    out.innerHTML += "</table>"
}
