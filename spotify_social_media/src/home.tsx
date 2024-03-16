import React from "react";
import Navbar from "./navbar";
import "./home.css";
import Body from "./body";

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <div className="left"></div>
        <div className="middle">
          {" "}
          <Body />
          <Body />
          <Body />
          <Body />
          <Body />
          <Body />
          <Body />
        </div>
        <div className="right"></div>
      </div>
    </>
  );
}

export default App;
