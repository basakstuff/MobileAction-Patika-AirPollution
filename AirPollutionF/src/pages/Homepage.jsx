import React, { Component } from "react";
import Row from "react-bootstrap/Row";

class Homepage extends Component {
  state = {
    display: 0,
    slideItems: [],
  };

  checkSelected(itemId) {
    if (this.state.likedItems.filter((x) => x.ItemId === itemId).length > 0) {
      return true;
    } else {
      return false;
    }
  }

  render() {
    return (
      <>
        <hr className='featurette-divider' />

        <div className='container marketing'>
          <Row></Row>
        </div>
        <hr className='featurette-divider' />
      </>
    );
  }
}
export default Homepage;
