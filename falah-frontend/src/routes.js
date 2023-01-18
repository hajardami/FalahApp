import { BrowserRouter as Router, Route, Routes, useRoutes } from "react-router-dom";
import { isMentee, isMentor, isGuest, isAdmin, logOut } from "./service/authentication"

import SignIn from "./components/signin/SignIn"
import SignUp from "./components/signup/Signup"
import Home from "./components/home/Home"
const GuestRoutes = () => useRoutes([
   {path: "/signin", element: <SignIn/>},
   {path: "/", element: <Home/>},
   {path: "/signup", element: <SignUp/>},
]);
const getRoutes = () => {
   return <GuestRoutes />;
}




export { getRoutes };