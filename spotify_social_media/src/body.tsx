import React from "react";
import "./body.css";

function body() {
  return (
    <div id="thread-border">
      <div id="img-container">
        <img
          src="https://www.billboard.com/wp-content/uploads/media/tyler-the-creator-igor-album-art-2019-billboard-embed.jpg?w=600"
          id="thread-img"
        />
      </div>
      <div id="thread-container">
        <p id="thread-text">My favorite album out right now</p>
        <label id="user"> -Jeff Mcmane</label>
      </div>
    </div>
  );
}

export default body;
