import React from "react";
import { Link } from "react-router-dom";
import MAction from "../img/maLogo.jpg";
import Patika from "../img/patikaLogo.png";

const Header = () => (
  <header>
    <nav className='navbar-inverse nav-upper vbar-expand navbar-light'>
      <div className='container-fluid text-center'>
        <Link className='navbar-brand' to={"/"}>
          <img src={MAction} alt='...' height='80' />
          <img src={Patika} alt='...' height='80' />
        </Link>
      </div>
    </nav>

    <nav className='navbar navbar-inverse sticky-top navbar-expand navbar-light navbar-lower'>
      <div className='container-fluid'>
        <div className='collapse navbar-collapse' id='navbar'>
          <ul className='nav navbar-nav'>
            <li className='nav-item'>
              <Link
                className='nav-link'
                to={"/"}
                style={{ "fontWeight": "bold" }}
              >
                PROJECT
              </Link>
            </li>
            <li className='nav-item'>
              <Link
                className='nav-link'
                to={"/about"}
                style={{ "fontWeight": "bold" }}
              >
                ABOUT
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
);

export default Header;
