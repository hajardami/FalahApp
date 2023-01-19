import './App.css';

import Home from './components/home/Home';
import SignIn from './components/signin/SignIn';
import Signup from './components/signup/Signup';
import { BrowserRouter as Router, Route, Routes, useRoutes } from "react-router-dom";
import {  getRoutes , getSideBar} from './routes';
import Layout from './components/sidebar/Layout';
import Adverts from './components/advert/Adverts';
import Forum from './components/forum/Forum';
import Experts from './components/expert/Experts';
import Nouveaute from './components/nouveautes/Nouveaute';
import { useState } from 'react';

function App() {

  const isauth = true;

  return (
  <Router>
          {getSideBar()}        
          {getRoutes()}
      
  </Router>);

}

export default App;

/*
<Router>
    <Routes>
    <Route exact path='/' element={< Home />}></Route>
   <Route exact path='/homeagri' element={< HomeAgri />}></Route>
    </Routes>
  </Router>
*/ 
