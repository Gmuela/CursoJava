var control = true;
var controlBreak = true;
var clock;
var clockBreak;
var timeClockM = 0;
var timeClockS = 0;
var timeClockBreakM = 0;
var timeClockBreakS = 0;
var timeBreakSec = 0;
var timeBreak = 0;

var itsRelax = false;

var aperturaTabla = "<table>";
var cabeceraTabla = "<tr><th>TAREA</th><th>T. ESTIMADO</th><th>T. USADO</th><th>T. INTERRUPCIÓN</th><th>BORRAR</th></tr>";
var cierreTabla = "</table>";
var newTaskFields = "<td><input type='text' placeholder='Nombre nueva tarea' class='prepareInput' id='taskName'></td><td><input type='text' placeholder='Tiempo en Pomodoros' class='prepareInput' id='taskTime'></td>";

var prepareTaskRow = "<tr id='prepareTaskRow'></tr>";
var prepareTaskButton = "<span id='newTaskSpan'><button class='newTask' onclick='prepareTask()'>Nueva Tarea</button></span>";
var newTaskButton = "<button class='newTask' onclick='createTask()'>Crear Tarea</button>";

var taskArray = new Array();

var idTask = 0;

function task(name, time, finalTime, breakTime) {
    this.id = idTask;
    this.name = name;
    this.time = time;
    this.finalTime = finalTime;
    this.breakTime = breakTime;
}

function setTimerClock(timeM, timeS, relax) {
    timeClockM = timeM;
    timeClockS = timeS;

    if (relax != undefined) {
        itsRelax = relax;
    }
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
    if (!itsRelax) {
        saveTime(timeClockM, timeClockS);
    }
    itsRelax = false;
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
    clearInterval(clock);
    if (!itsRelax) {
        saveTime(timeClockM, timeClockS);
    }
    itsRelax = false;
    setTimerClock(25, 0);
    enableButtons();
    enableThis("play");
    disableThis("stop");
    disableThis("break");
    enableThis("customTime");
    enableThis("customMin");
    enableThis("customSec");
    control = true;
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
                timeBreakSec++;
                setTimerClockBreak(timeClockBreakM, timeClockBreakS)
            } else if (timeClockBreakM < 59 && timeClockBreakS == 59) {
                timeClockBreakM++;
                timeBreak++;
                timeBreakSec++;
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

function calculateBreakTime(task) {

    task.breakTime += timeBreakSec;
    timeBreakSec = 0;

}

function showBreakTime(task) {
    var breakM = 0;
    var breakS = 0;

    var stringBreak;

    for (var i = 0; i < task.breakTime; i++) {
        breakS++;

        if (breakS == 59) {
            breakS = 0;
            breakM++;
        }
    }

    if (breakM <= 9 && breakS <= 9) {

        stringBreak = "0" + breakM + ":0" + breakS;

    } else if (breakM <= 9 && breakS >= 9) {

        stringBreak = "0" + breakM + ":" + breakS;

    } else if (breakM >= 9 && breakS <= 9) {

        stringBreak = breakM + ":0" + breakS;

    } else if (breakM >= 9 && breakS >= 9) {

        stringBreak = breakM + ":" + breakS;
    }

    return stringBreak;
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
    var selectedId = document.getElementById("tasks").value;
    if (selectedId != "null") {
        taskArray[selectedId].finalTime++;
        calculateBreakTime(taskArray[selectedId]);
        createTable();
    }
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

    if (sec == "") {
        sec = 0;
    }
    if (minutes == "") {
        minutes = 0;
    }

    document.getElementById("customMin").value = "";
    document.getElementById("customSec").value = "";
    setTimerClock(minutes, sec);
}

function prepareTask() {
    var prepareTaskRow = document.getElementById("prepareTaskRow");
    var button = document.getElementById("newTaskSpan");

    prepareTaskRow.innerHTML = newTaskFields;
    button.innerHTML = newTaskButton;
}

function createTask() {
    var taskName = document.getElementById("taskName").value;
    var taskTime = document.getElementById("taskTime").value;
    var pomodoroTable = document.getElementById("pomodoroTable");

    var newTask = new task(taskName, taskTime, 0, 0);
    idTask++;
    taskArray.push(newTask);

    createTable();
    createSelectTask();
}

function createTable() {

    var taskTable = prepareTaskButton + aperturaTabla + cabeceraTabla;

    for (var i = 0; i < taskArray.length; i++) {
        taskTable += "<tr><td style='display:none' id='hideTaskId" + taskArray[i].id + "'></td><td>" + taskArray[i].name + "</td>" + "<td>" + taskArray[i].time + "</td><td id='finalTime" + taskArray[i].id + "'>" + taskArray[i].finalTime + "</td><td id='breakTime" + taskArray[i].id + "'>" + showBreakTime(taskArray[i]) + "</td><td><button class='deleteTask' onclick='deleteTask(" + taskArray[i].id + ")'>X</button></td></tr>";
    }

    taskTable += prepareTaskRow;

    pomodoroTable.innerHTML = taskTable;

}



function deleteTask(id) {

    for (var i = 0; i < taskArray.length; i++) {

        if (taskArray[i].id == id) {

            taskArray.splice(taskArray[i], 1);
            break;
        }
    }

    createTable();
    createSelectTask();
}

function createSelectTask() {

    var select = document.getElementById("tasks");

    var options;

    for (var i = 0; i < taskArray.length; i++) {
        options += "<option value='" + taskArray[i].id + "'>" + taskArray[i].name + "</option>"
    }

    if (options == undefined) {

        select.innerHTML = "<option value='null'>Sin tareas</option>";

    } else {

        select.innerHTML = options;
    }

}
