import React, { Component } from "react";
import SearchCityComponent from "./SearchCityComponent";

class ListAirPollutionComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      result: [],
    };
  }

  render() {
    return (
      <div>
        <SearchCityComponent></SearchCityComponent>
      </div>
    );
  }
}

export default ListAirPollutionComponent;
