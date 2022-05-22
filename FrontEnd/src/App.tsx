import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import './App.css';
import { Home } from './components/Home/Home';
import { Login } from './components/Login/Login';
import { CreateUser } from './components/CreateUser/CreateUser';
import { Products } from './components/Products/Products';
import { ViewWishlist } from './components/ViewWishlist/ViewWishlist';
import { Electronics  } from './components/Products/Electronics';
import { Jewelery  } from './components/Products/Jewelery';
import { MensClothing  } from './components/Products/MensClothing';
import { WomensClothing  } from './components/Products/WomensClothing';

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
        <Routes>
          <Route path="/products" element={<Products/>}/>
        </Routes>
        <Routes>
          <Route path="/viewwishlist" element={<ViewWishlist/>}/>
        </Routes>
        <Routes>
          <Route path="/Electronics" element={<Electronics/>}/>
        </Routes>
        <Routes>
          <Route path="/Jewelery" element={<Jewelery/>}/>
        </Routes>
        <Routes>
          <Route path="/MensClothing" element={<MensClothing/>}/>
        </Routes>
        <Routes>
          <Route path="/WomensClothing" element={<WomensClothing/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
