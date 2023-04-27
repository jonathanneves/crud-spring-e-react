import React from 'react';
import ReactDOM from 'react-dom/client';
import Footer from './components/Footer';
import Header from './components/Header';
import { BrowserRouter } from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode >
    <BrowserRouter>
      <Header />
    </BrowserRouter>
    <Footer />
  </React.StrictMode>
);
