import React from "react";
import "./navbar.css";

export default function Navbar() {
  return (
    <div className="navbar-container">
      <link
        rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"
      />
      <div className="navbar">
        <div className="post-thread">
          <span className="material-icons-outlined" id="add-icon">
            ➕
          </span>
          <label>Create a Thread</label>
        </div>

        <div className="search">
          <span className="material-icons-outlined" id="search-icon">
            🔍
          </span>
          <input type="search" id="search-box" placeholder="search"></input>
          <button type="button" id="filter">
            <span className="material-icons-outlined" id="filter-text">
              Filter By:
            </span>{" "}
          </button>
        </div>

        <div className="login">
          <button id="login-btn">Login🔐</button>
        </div>
      </div>
    </div>
  );
}
