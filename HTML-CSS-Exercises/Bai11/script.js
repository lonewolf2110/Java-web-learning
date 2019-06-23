function onSubmit() {
    document.getElementById("username").innerText = document.getElementsByName("username")[0].value;
    document.getElementById("username-tr").removeAttribute("hidden");
}