import './App.css';

import Home from './components/home/Home';
import SignIn from './components/signin/SignIn';
import Signup from './components/signup/Signup';
import { BrowserRouter as Router, Route, Routes, useRoutes } from "react-router-dom";
import {  getRoutes } from './routes';

function App() {
  return (
  <Router>
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
