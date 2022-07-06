import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

const Footer = () => (
  <footer className='p-5 mt-5 border-top bg-blue-footer'>
    <div className='row'>
      <div className='col-md-2' style={{ color: "#fff" }}>
        <h5>Created By</h5>
        <ul className='nav flex-column'>
          <li className='nav-item mb-2'>
            <div className='p-0'>Başak ER</div>
          </li>
          <li className='nav-item mb-2'>
            <a href='https://www.linkedin.com/in/basaker/' target="_blank">
              <FontAwesomeIcon
                icon='fa-brands fa-linkedin '
                size='2xl'
                inverse
              />
            </a>
          </li>
        </ul>
      </div>

      <div className='col-md-6'></div>
      <div className='col-md-2' style={{ color: "#fff" }}>
        <h5>Sponsors</h5>

        <div className='mb-3 mt-3'>
          <a
            style={{ margin: "5px" }}
            href='https://www.mobileaction.co/'
            target="_blank"
            className='links'
          >
            MobileAction
            <FontAwesomeIcon
              icon='fa-solid fa-rocket'
              size='lg'
              inverse
              className='mx-1'
            />
          </a>
        </div>

        <div className='mb-3 mt-3 '>
          <a
            style={{ margin: "5px" }}
            href='https://www.patika.dev/'
            target="_blank"
            className='links'
          >
            Patika
            <FontAwesomeIcon
              icon='fa-brands fa-dev'
              size='lg'
              inverse
              className='mx-1'
            />
          </a>
        </div>
      </div>
    </div>
  </footer>
);

export default Footer;
