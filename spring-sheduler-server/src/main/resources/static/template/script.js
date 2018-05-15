var table = document.getElementById('timetable');

function AJAXStart() {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', '/demo/all');
    ourRequest.onload = function () {
        var ourData = JSON.parse(ourRequest.responseText);
        renderHTML(ourData);
    };
    ourRequest.send();
}

function renderHTML(data) {
    var dayNameArray = Object.keys(data);
    var groupNameArray = Object.keys(data.понедельник);
    var lessonStartTimeArray = Object.keys(data.понедельник['ЭК-11']);
    console.log(lessonStartTimeArray);



    var tr = document.createElement('tr');
    var th = document.createElement('th');

    th.insertAdjacentText('beforeend','*');
    tr.appendChild(th);
    table.appendChild(tr);

    for (groupIndex in groupNameArray){
        th = document.createElement('th');
        th.insertAdjacentText('beforeend',groupNameArray[groupIndex]);
        tr.appendChild(th);
        table.appendChild(tr);
    }

    Object.prototype.toString = function dataToString() {
            var property = '<div class="card bg-secondary">' + this.subjectName + ' : ' + this.number +'\n' + '</div>';
            return property;
    };


    for (dayIndex in dayNameArray){
        tr = document.createElement('tr');
        th = document.createElement('th');
        th.insertAdjacentText('beforeend',dayNameArray[dayIndex]);
        tr.appendChild(th);
        for (groupIndex in groupNameArray){
            var dayName = dayNameArray[dayIndex];
            var groupName = groupNameArray[groupIndex];
            var td = document.createElement('td');
            var datum = data[dayName];
            var groupData = datum[groupName];
            if (groupData !== undefined) {
                td.insertAdjacentHTML('beforeend', groupData.toString());
            }
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}
