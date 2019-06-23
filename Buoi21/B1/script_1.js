function calc() {
    let f = document.getElementById("f-inp").value;
    let func = new Function("return " + f);
    document.getElementById("result").value = func();
}

function keyup(event) {
    if (event.keyCode == 13) {
        calc();
    }
}
