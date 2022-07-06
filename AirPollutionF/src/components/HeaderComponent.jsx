import React, { Component } from "react";

class HeaderComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div>
        <header className='align-content-center'>
          <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
            <div className='text-center'>
              <a href='/' className='navbar-brand'>
                Air Pollution
              </a>
            </div>
          </nav>
        </header>
      </div>
    );
  }
}

export default HeaderComponent;
