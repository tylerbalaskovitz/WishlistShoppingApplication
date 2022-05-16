import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import './App.css';
import { Home } from './components/Home/Home';
import { Login } from './components/Login/Login';
import { CreateUser } from './components/CreateUser/CreateUser';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Login/>}/>
        </Routes>
        <Routes>
          <Route path="/home" element={<Home/>}/>
        </Routes>
        <Routes>
          <Route path="/createuser" element={<CreateUser/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
