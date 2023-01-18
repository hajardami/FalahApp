import {goto} from "./utils";

function isExprt() {
    return localStorage.getItem("isExpert") === "true";
}

function isUser() {
    return localStorage.getItem("isExpert") === "false";
}

function isAdmin() {
    return localStorage.getItem("isAdmin") === "true";
}


function isGuest() {
    return localStorage.getItem("currentUser") === null || localStorage.getItem("currentUser") === undefined;
}
function logOut(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isExpert");
    localStorage.removeItem("isAdmin");
    goto("/");
}


export {isGuest,logOut}