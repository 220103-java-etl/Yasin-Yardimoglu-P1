let emp = {
    empId: 0
}
async function login() {
    let loginUrl = 'http://localhost:8080/demo_war_exploded/login';

    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    // create a JS Object with those values
    let loginObj = {
        email: email,
        password: password
    }

    let loginJson = JSON.stringify(loginObj)

    let xhr = new XMLHttpRequest();

    xhr.onreadyStateChange = receiveData;

    xhr.open("GET", loginUrl, true);

    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.send(loginJson);


    function receiveData() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let r = xhr.responseText;

            rJson = JSON.parse(r);
            emp.empId = rJson.employeeRole;
            localStorage.setItem("employeeId", rJson.employeeId);
            localStorage.setItem("firstName", rJson.firstName);
            localStorage.setItem("email", rJson.email);
            localStorage.setItem("employeeRole", rJson.employeeRole);

            window.location.href="/demo_war_exploded/ReimbursementForm.html";

            console.log('JSON Response: ', rJson.employeeRole)
            if (rJson.employeeRole === 'associate'){
                console.log('THis is an associate')
                window.location.href="/demo_war_exploded/ReimbursementForm.html";
            }
            else{
                window.location.href="/Project-1/manager.html";
            }
        } else if(xhr.readyState === 4 && xhr.status === 418){
            alert(`Your login credentials were incorrect.`);
        }
    }
}
