document.addEventListener("DOMContentLoaded", () => {
    //let isOk = confirm("Are you sure?");
    //console.log("Nguoi dung da chon ", isOk);
    let hihiBtn = document.getElementById("hihi-btn");
    let container = document.getElementById("container");
    hihiBtn.addEventListener("mouseover", () => {
        console.log("hihi");
        hihiBtn.style.top = Math.round(Math.random() * (container.offsetHeight - hihiBtn.offsetHeight)) + "px";
        hihiBtn.style.left = Math.round(Math.random() * (container.offsetWidth - hihiBtn.offsetWidth)) + "px";
    });
});
