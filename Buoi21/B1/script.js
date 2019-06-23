function calc(opt) {
    let a = Number(document.getElementById("number-1").value);
    let b = Number(document.getElementById("number-2").value);
    let func = new Function("a", "b", "return a " + opt + " b;");
    document.getElementById("result").value = func(a, b);
}
