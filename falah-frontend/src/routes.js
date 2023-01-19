import { BrowserRouter as Router, Route, Routes, useRoutes } from "react-router-dom";
import { isExprt, isUser, isAdmin } from "./service/authentication"

import SignIn from "./components/signin/SignIn"
import SignUp from "./components/signup/Signup"
import Home from "./components/home/Home"

import DocVerification from "./components/Admin/DocVerification";

import HomeAgri from "./components/agriculteur/HomeAgri";

const GuestRoutes = () => useRoutes([
   {path: "/signin", element: <SignIn/>},
   {path: "/home", element: <HomeAgri/>},
   {path: "/", element: <Home/>},
   {path: "/signup", element: <SignUp/>}
]);

const AdminRoutes = () => useRoutes([


    {path: "/signin", element: <SignIn/>},
    {path: "/", element: <DocVerification/>},
   
]);
const getRoutes = () => {

    if (isAdmin()) return <AdminRoutes />;
    return <GuestRoutes />;
 }
 

const getSideBar = () => {
   //if(isExprt()||isUser()||isAdmin()) 
   return <HomeAgri/>
}





export { getRoutes , getSideBar};