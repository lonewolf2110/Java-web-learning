let buff = 0;
let opt = null;
let cls = false;
let rstInp;
let buffB;
let clsB;
let optB;

function setValue(val) {
  rstInp.value = Number(Number(val).toFixed(5));
}

function updateBuff() {
  let optTxt = opt ? opt == '+' ? "cộng" : opt == '-' ? "trừ" : opt == '\u00D7' ? "nhân" : "chia" : "không";
  clsB.innerText = cls;
  optB.innerText = optTxt;
  buffB.innerText = buff;
}

function AC() {
  buff = 0;
  opt = null;
  rstInp.value = 0;
  cls = true;
  updateBuff();
}

function equal() {
  if (!opt) {
    return;
  }

  opt = opt == '\u00D7' ? '*' : opt == '\u00F7' ? "/" : opt;
  let rs = eval(buff + opt + rstInp.value);
  setValue(rs > 1e11 ? Infinity : rs);
}

function operate(txt) {
  if (cls) {
    opt = txt;
  } else {
    equal();
    buff = Number(rstInp.value);
    opt = txt;
    cls = true;
  }

  updateBuff();
}

function calc() {
  if (cls) {
    opt = null;
  }

  if (opt) {
    equal();
  } else {
    rstInp.value = Number(rstInp.value);
  }

  buff = Number(rstInp.value);
  opt = null;
  cls = true;
  updateBuff();
}

function type(txt) {
  let rs = rstInp.value;

  if (cls) {
    rs = "";
    cls = false;
  }

  if (rs.length > 10) {
    return;
  }

  let typeDot = txt == ".";
  let includeDot = rs.includes(".");
  let ct = typeDot ? !includeDot : true;

  rs += ct ? txt : "";

  rstInp.value = typeDot || includeDot ? rs : Number(rs);
  updateBuff();
}

let onClick = function (event) {
  let className = event.target.className;
  let txt = event.target.innerText;

  switch (className) {
    case "num":
      type(txt);
      break;

    case "AC":
      AC();
      break;

    case "opt":
      operate(txt);
      break;

    case "equal":
      calc();
      break;

    case "dot":
      type(".");
      break;
  }
}

document.addEventListener("DOMContentLoaded", function () {
  let btns = document.getElementsByTagName("button");
  rstInp = document.getElementById("result");
  buffB = document.getElementById("buff");
  clsB = document.getElementById("cls");
  optB = document.getElementById("opt");

  for (let btn of btns) {
    btn.addEventListener("click", onClick);
  }
});
