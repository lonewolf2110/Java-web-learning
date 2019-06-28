function submit() {
  let name = document.getElementById("name-inp");
  let email = document.getElementById("email-inp");
  let website = document.getElementById("website-inp");
  let message = document.getElementById("message");

  let errors = document.getElementsByClassName("error");
  let elems = [name, email, website, message];

  elems.forEach(function (item, index) {
    let valid = Boolean(item.value.trim().length);
    errors[index].hidden = valid;
    item.style.border = valid ? "1px solid black" : "3px solid red";
  });
}

function keyUp(event) {
  if (event.keyCode == 13) {
    submit();
  }
}