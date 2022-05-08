'use strict'
{
    const today = new Date();
    today.setDate(today.getDate())
    const yyyy = today.getFullYear();
    const mm = ("0"+(today.getMonth()+1)).slice(-2);
    const dd = ("0"+today.getDate()).slice(-2);
    document.getElementById("today").value = yyyy + '-' + mm + '-' + dd;
}