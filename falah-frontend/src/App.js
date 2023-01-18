import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomeAgri from './components/agriculteur/HomeAgri';

function App() {
  return (
      <div className="App">
        <HomeAgri/>
      </div>
  );
}

export default App;
