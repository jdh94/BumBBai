document.addEventListener("DOMContentLoaded", function() {

    let dataObject = {
        "tripid" : 1
    };

    let tripid = document.querySelector("#tripId").innerText;

    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/api/tripDetail/' + tripid, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(dataObject));
    xhr.onload = () => {
        if(xhr.status == 200){
            let trip = JSON.parse(xhr.response);
            console.log(trip);
            document.querySelector("#tripName").innerHTML = trip.tripname;
            document.querySelector("#attendantName").innerHTML = JSON.stringify(trip.attendant);
            document.querySelector("#expanseList").innerHTML = JSON.stringify(trip.expense);


        }else{
            alert(xhr.response);
            console.log(xhr.response);
        }
    }


});

