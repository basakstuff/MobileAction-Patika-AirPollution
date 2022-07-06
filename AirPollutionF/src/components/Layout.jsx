import React, { Component } from "react";
import LoadingOverlay from "react-loading-overlay";
import PropTypes from "prop-types";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Header from "../content/Header";
import Footer from "../content/Footer";
import Homepage from "../pages/Homepage";
import About from "../pages/About";

import "../dist/css/bootstrap.css";
import "../dist/css/carousel.css";
import "../dist/css/style.css";
import ListAirPollutionComponent from "./ListAirPollutionComponent";
import NoContentPage from "../pages/NoContentPage";

class Layout extends Component {
  state = {
    isLoadingActive: false,
  };

  componentDidMount() {}

  render() {
    return (
      <Router>
        <div>
          <Header></Header>
          <LoadingOverlay active={this.state.isLoadingActive} spinner>
            <main>
              <Switch>
                <Route
                  exact
                  path='/'
                  component={ListAirPollutionComponent}
                ></Route>
                <Route exact path='/about'>
                  <About />
                </Route>
                <Route exact path='/'>
                  <Homepage />
                </Route>
                <Route path='*'>
                  <NoContentPage />
                </Route>

                <Route path='*'></Route>
              </Switch>
            </main>
          </LoadingOverlay>
          <Footer></Footer>
        </div>
      </Router>
    );
  }
}

Layout.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.node),
    PropTypes.node,
  ]),
  title: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.string),
    PropTypes.string,
  ]),
  titleShort: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.string),
    PropTypes.string,
  ]),
  browserTitle: PropTypes.string,
  homeTo: PropTypes.string,
  searchbarFilter: PropTypes.bool,
};

Layout.defaultProps = {
  children: null,
  title: ["", ""],
  titleShort: ["", ""],
  browserTitle: null,
  theme: "blue",
  footer: null,
  sidebar: undefined,
  homeTo: "/",
  searchbarFilter: false,
};

export default Layout;
