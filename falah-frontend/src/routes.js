import { BrowserRouter as Router, Route, Routes, useRoutes } from "react-router-dom";
import { isExprt, isUser, isAdmin } from "./service/authentication"

import SignIn from "./components/signin/SignIn"
import SignUp from "./components/signup/Signup"
import Home from "./components/home/Home";
import Adverts from "./components/advert/Adverts";
import Forum from "./components/forum/Forum";
import Experts from "./components/expert/Experts";
import Nouveaute from "./components/nouveautes/Nouveaute";

import DocVerification from "./components/Admin/DocVerification";
import {goto} from "./service/utils";
import HomeAgri from "./components/agriculteur/HomeAgri";

const GuestRoutes = () => {
    logOut();
   return useRoutes([
   {path: "/signin", element: <SignIn/>},
   {path: "/", element: <Home/>},
   {path: "/signup", element: <SignUp/>},
  
   
]);}

function logOut(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isExpert");
    localStorage.removeItem("isAdmin");
 }


const UserRoutes = () => 

 useRoutes([
    {path: "/signin", element: <SignIn/>},
    {path: "/", element: <Adverts/>},
    {path: "/signup", element: <SignUp/>},
    {path: "/advert", element: <Adverts/>},
    {path: "/forum", element: <Forum/>},
    {path: "/expert", element: <Experts/>},
    {path: "/nouveautes", element: <Nouveaute/>},
    {path: "/logout", element: <GuestRoutes/>},
    
 ]);
 

const AdminRoutes = () => useRoutes([


    {path: "/signin", element: <SignIn/>},
    {path: "/", element: <DocVerification/>},
   
]);
const getRoutes = () => {

    if (isAdmin()) return <AdminRoutes />;
    if(isUser()) return <UserRoutes/>;
    return <GuestRoutes />;
    
 }
 






export { getRoutes};