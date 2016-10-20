var control = true;
var controlBreak = true;
var clock;
var clockBreak;
var timeClockM = 0;
var timeClockS = 0;
var timeClockBreakM = 0;
var timeClockBreakS = 0;
var timeBreak = 0;


function setTimerClock(timeM, timeS) {
    timeClockM = timeM;
    timeClockS = timeS;

    if (timeM < 9 && timeS < 9) {
        document.getElementById("clock").innerHTML = "0" + timeM + ":0" + timeS;
    } else if (timeM <= 9 && timeS >= 9) {
        document.getElementById("clock").innerHTML = "0" + timeM + ":" + timeS;
    } else if (timeM >= 9 && timeS <= 9) {
        document.getElementById("clock").innerHTML = timeM + ":0" + timeS;
    } else if (timeM >= 9 && timeS >= 9) {
        document.getElementById("clock").innerHTML = timeM + ":" + timeS;
    }
}

function setTimerClockBreak(timeM, timeS) {
    timeClockBreakM = timeM;
    timeClockBreakS = timeS;

    if (timeM <= 9 && timeS <= 9) {
        document.getElementById("clock").innerHTML = "0" + timeM + ":0" + timeS;
    } else if (timeM <= 9 && timeS >= 9) {
        document.getElementById("clock").innerHTML = "0" + timeM + ":" + timeS;
    } else if (timeM >= 9 && timeS <= 9) {
        document.getElementById("clock").innerHTML = timeM + ":0" + timeS;
    } else if (timeM >= 9 && timeS >= 9) {
        document.getElementById("clock").innerHTML = timeM + ":" + timeS;
    }
}

function play() {

    disableButtons();
    disableThis("play");
    disableThis("customTime");
    disableThis("customMin");
    disableThis("customSec");
    enableThis("stop");
    enableThis("break");

    if (control) {

        control = false;

        clock = setInterval(function () {

            if (timeClockM > 0 && timeClockS > 0) {
                timeClockS--;
                setTimerClock(timeClockM, timeClockS)
            } else if (timeClockM > 0 && timeClockS == 0) {
                timeClockM--;
                timeClockS = 59;
                setTimerClock(timeClockM, timeClockS);
            } else if (timeClockM == 0 && timeClockS > 0) {
                timeClockS--;
                setTimerClock(timeClockM, timeClockS);
            } else if (timeClockM == 0 && timeClockS == 0) {
                finishTime();
            }
        }, 1000);
    }
}

function finishTime() {
    clearInterval(clock);
    saveTime(timeClockM, timeClockS);
    setTimerClock(25, 0);
    playAudio();
    enableButtons();
    enableThis("play");
    disableThis("stop");
    disableThis("break");
    enableThis("customTime");
    enableThis("customMin");
    enableThis("customSec");
    control = true;
}

function pause() {
    clearInterval(clock);
    control = true;
}

function stop() {
    finishTime();
}

function breakTime() {

    disableButtons();
    disableThis("stop");
    setTimerClockBreak(0, 0);
    pause();
    changeButtonBreak("nonBreak");

    if (controlBreak) {

        controlBreak = false;

        clockBreak = setInterval(function () {

            if (timeClockBreakM < 59 && timeClockBreakS < 59) {
                timeClockBreakS++;
                timeBreak++;
                setTimerClockBreak(timeClockBreakM, timeClockBreakS)
            } else if (timeClockBreakM < 59 && timeClockBreakS == 59) {
                timeClockBreakM++;
                timeBreak++;
                timeClockBreakS = 0;
                setTimerClockBreak(timeClockBreakM, timeClockBreakS);
            } else if (timeClockBreakM == 59 && timeClockBreakS < 59) {
                timeClockBreakS++;
                timeBreak++;
                setTimerClockBreak(timeClockBreakM, timeClockBreakS);
            } else if (timeClockBreakM == 59 && timeClockBreakS == 59) {
                finishBreak();
            }
        }, 1000);
    }
}

function finishBreak() {
    clearInterval(clockBreak);
    changeButtonBreak("breakIt");
    play();
    calculateTime()
    setTimerClock(timeClockM, timeClockS);
    controlBreak = true;
}

function calculateTime() {

    for (var i = 0; i < timeBreak; i++) {
        timeClockS--;

        if (timeClockS == 0) {
            timeClockS = 59;
            timeClockM--;
        }
    }

    timeBreak = 0;
}

function changeButtonBreak(typeChange) {
    if (typeChange == "breakIt") {
        document.getElementById("breakButton").innerHTML = "<button class='break' onclick='breakTime()' id='break'>X</button>";
    } else if (typeChange == "nonBreak") {
        document.getElementById("breakButton").innerHTML = "<button class='nonBreak' onclick='finishBreak()'>✓</button>";
    }
}

function playAudio() {
    var mp3 = document.getElementById("audios").value;
    var audio = new Audio("../sound/" + mp3);
    audio.play();
}

function saveTime(timeM, timeS) {
    savedTimeM = timeM;
    savedTimeS = timeS;
}

function disableButtons() {
    var buttons = document.getElementsByName("buttonSel");

    buttons[0].disabled = true;
    buttons[1].disabled = true;
    buttons[2].disabled = true;

}

function enableButtons() {
    var buttons = document.getElementsByName("buttonSel");

    buttons[0].disabled = false;
    buttons[1].disabled = false;
    buttons[2].disabled = false;

}

function disableThis(id) {
    document.getElementById(id).disabled = true;
}

function enableThis(id) {
    document.getElementById(id).disabled = false;
}

function setCustomTime() {

    var minutes = document.getElementById("customMin").value;
    var sec = document.getElementById("customSec").value;

    if(sec == ""){
        sec = 0;
    }
    if(minutes == ""){
        minutes = 0;
    }

    document.getElementById("customMin").value = "";
    document.getElementById("customSec").value = "";
    setTimerClock(minutes,sec);

}
