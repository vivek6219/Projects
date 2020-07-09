function startTime(){
    var today = new Date();
    var hours = today.getHours() %12 ||12;
    var minutes=today.getMinutes();
    var seconds =today.getSeconds();
    hours=checkTime(hours);
    minutes=checkTime(minutes);
    seconds=checkTime(seconds);
    document.getElementById('time').innerHTML = hours+ ":" +minutes+":"+seconds;
    var t = setTimeout(startTime,500); //updates time in real time
}
function checkTime(i){
    if(i<10)
        i="0" +i;
    return i;
}
