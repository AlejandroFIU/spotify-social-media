import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="login-body">
      <div className="login-container">
        <form action ="/submit" method="post">
        <label htmlFor ="username">Username:</label>
        <input type ="textbox" id ="username" name ="username"></input>
        <label htmlFor ="username">Password:</label>
        <input type ="textbox" id ="password" name ="password"></input>
        <button type ="submit" id ="login-btn">Login🔐</button>
        </form>
      </div>
    </div>
  );
}

export default App;
