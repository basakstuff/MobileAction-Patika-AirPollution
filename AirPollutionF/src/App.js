import React from "react";
import "./App.css";
import { BrowserRouter as Router } from "react-router-dom";

import Layout from "./components/Layout";
import { library } from "@fortawesome/fontawesome-svg-core";
import { fab } from "@fortawesome/free-brands-svg-icons";
import { fas } from "@fortawesome/free-solid-svg-icons";

library.add(fab, fas);

function App() {
  return (
    <div className='App'>
      <Router>
        <Layout></Layout>
      </Router>
    </div>
  );
}

export default App;
