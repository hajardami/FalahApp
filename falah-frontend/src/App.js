import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeAgri from './components/agriculteur/HomeAgri';
import Home from './components/home/Home'

function App() {
  return (
    <div>
      <HomeAgri/>
    </div>
  );
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
