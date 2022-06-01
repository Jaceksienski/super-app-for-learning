function countingDown(){
    let time = new Date();
    let year = time.getFullYear();
    let month = time.getMonth();
    let day = time.getDay();

    let hour = time.getHours();
    let minutes = time.getMinutes();
    let seconds = time.getSeconds();

    if(month < 10) month = '0' + month;
    if(day < 10) day = '0' + day;

    if(hour < 10) hour = '0' + hour;
    if(minutes < 10) minutes = '0' + minutes;
    if(seconds < 10) seconds = '0' + seconds;

    let dateYYYYMMDD = year + "." + month + "." + day;
    let dateDDMMYYYY = year + "." + month + "." + day;
    let timeHHMMSS = hour + ":" + minutes + ":" + seconds;

    document.getElementById("clock").innerHTML = dateYYYYMMDD + " " + timeHHMMSS;
    setTimeout("countingDown()",1000);
    }