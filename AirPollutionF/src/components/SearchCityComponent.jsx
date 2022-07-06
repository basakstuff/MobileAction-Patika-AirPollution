import React, { Component } from "react";
import Select from "react-select";
import AirPollutionSearchService from "../services/AirPollutionSearchService";
import SearchResultComponent from "./SearchResultComponent";

class SearchCityComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      result: [],
      city: "",
      startDate: "",
      endDate: "",
      cities: [
        { value: "LONDON", label: "LONDON" },
        { value: "BARCELONA", label: "BARCELONA" },
        { value: "ANKARA", label: "ANKARA" },
        { value: "TOKYO", label: "TOKYO" },
        { value: "MUMBAI", label: "MUMBAI" },
      ],
    };
    this.changeStartDateHandler = this.changeStartDateHandler.bind(this);
    this.changeEndDateHandler = this.changeEndDateHandler.bind(this);
    this.search = this.search.bind(this);
  }

  search = (e) => {
    e.preventDefault();
    if (this.state.city === "") {
      alert("City must be chosen");
      return;
    }

    function pad2(n) {
      return (n < 10 ? "0" : "") + n;
    }

    const date = new Date();
    const month = pad2(date.getMonth() + 1); //months (0-11)
    const day = pad2(date.getDate()); //day (1-31)
    const year = date.getFullYear();

    const formattedDate = year + "-" + month + "-" + day;

    if (
      (this.state.startDate !== "" &&
        (this.state.startDate < "2020-11-27" ||
          this.state.startDate > formattedDate)) ||
      (this.state.endDate !== "" &&
        (this.state.endDate < "2020-11-27" ||
          this.state.endDate > formattedDate))
    ) {
      alert("Date must be greater than 2020-11-27 and less than now");
      return;
    }
    const searchQuery =
      "?city=" +
      this.state.city +
      "&startDate=" +
      this.state.startDate +
      "&endDate=" +
      this.state.endDate;
    AirPollutionSearchService.searchAirPollutionForCityAndBetweenTwoDates(
      searchQuery
    ).then((response) => {
      this.setState({ result: response.data.result });
      console.log(response.data.city);
      this.setState({ city: response.data.city });
    });
  };

  changeStartDateHandler = (event) => {
    this.setState({ result: [] });
    this.setState({ startDate: event.target.value });
  };

  changeEndDateHandler = (event) => {
    this.setState({ result: [] });
    this.setState({ endDate: event.target.value });
  };

  changeCityHandler = (event) => {
    this.setState({ result: [] });
    this.setState({ city: event.value });
  };

  render() {
    return (
      <div>
        <br></br>
        <div className='container'>
          <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
              <div className='card-body'>
                <form>
                  <div className='form-group text-center'>
                    <label> City: </label>
                    <Select
                      options={this.state.cities}
                      onChange={(e) => this.changeCityHandler(e)}
                      value={this.state.cities.label}
                      placeholder=''
                      required='true'
                    ></Select>
                  </div>
                  <div className='form-group text-center'>
                    <label className='text-center'> Start Date: </label>
                    <input
                      placeholder='Start Date'
                      name='startDate'
                      className='form-control'
                      value={this.state.startDate}
                      onChange={this.changeStartDateHandler}
                      type={"date"}
                    />
                  </div>
                  <div className='form-group text-center'>
                    <label> End Date: </label>
                    <input
                      placeholder='End Date'
                      name='endDate'
                      className='form-control'
                      value={this.state.endDate}
                      onChange={this.changeEndDateHandler}
                      type={"date"}
                    />
                  </div>
                  <button className='btn-search' onClick={this.search}>
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
        <SearchResultComponent
          result={this.state.result}
          city={this.state.city}
        ></SearchResultComponent>
      </div>
    );
  }
}

export default SearchCityComponent;
