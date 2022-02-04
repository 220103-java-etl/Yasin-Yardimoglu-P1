
async function submitReimForm() {
    let reimburseUrl = 'http://localhost:8080/demo_war_exploded/SubmitReimbursementFormServlet';

    let date = document.getElementById('date').value;
    let time = document.getElementById('time').value;
    let StreetAddress = document.getElementById('StreetAddress').value;
    let City = document.getElementById('City').value;
    let State = document.getElementById('State').value;
    let zipCode = document.getElementById('zipCode').value;
    let cost = document.getElementById('cost').value;
    let EventType = document.getElementById('EventType').value;
    let GradingFormat = document.getElementById('GradingFormat').value;
    let Description = document.getElementById('Description').value;
    let employeeId = document.getElementById('employeeId').value;
    // let employeeId = 1;

    // create a JS Object with those values
    let reimObj = {
        employeeId: employeeId,
        date: date,
        time: time,
        StreetAddress: StreetAddress,
        City: City,
        State: State,
        zipCode: zipCode,
        cost: cost,
        EventType: EventType,
        GradingFormat: GradingFormat,
        Description: Description
    }

    let reimJson = JSON.stringify(reimObj);

    let xhr = new XMLHttpRequest();

    xhr.onreadyStateChange = receiveData;

    xhr.open("POST", reimburseUrl, true);

    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.send(reimJson);

    function receiveData() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert(`Successfully submitted!`);
            window.location.href="/index.html"
        } else if(xhr.readyState === 4 && xhr.status === 418){
            alert(`Your login credentials were incorrect.`);
        }
    }
}