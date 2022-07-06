import React, { Component } from "react";
import AirPollutionSearchService from "../services/AirPollutionSearchService";

class SearchResultComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      result: props.result,
      city: props.city,
    };

    this.clickDeleteButton = this.clickDeleteButton.bind(this);
  }

  clickDeleteButton(i, id) {
    const deleteQuery = "delete?id=" + id;
    AirPollutionSearchService.deletePollutionFromDatabases(deleteQuery);
    this.setState({ result: this.props.result.splice(i, 1) });
  }

  render() {
    return (
      <div>
        <br></br>
        <div className='card'>
          <h2 className='project-title text-center'>
            Air Pollution Search Result
          </h2>

          <h3 className='text-center'> </h3>
          <div className='card-body'>
            <table className='table'>
              <thead>
                <tr>
                  <th scope='col'>City</th>
                  <th scope='col'>Date</th>
                  <th scope='col'>CO</th>
                  <th scope='col'>O3</th>
                  <th scope='col'>SO2</th>
                  <th scope='col'>Delete</th>
                </tr>
              </thead>
              <tbody>
                {this.props.result.map((res, i) => {
                  return (
                    <tr>
                      <td key={res.id}>{this.props.city}</td>
                      <td>{res.date}</td>
                      <td>{res.categories.co}</td>
                      <td>{res.categories.o3} </td>
                      <td>{res.categories.so2} </td>
                      <td>
                        <button
                          className='btn-danger'
                          onClick={() => this.clickDeleteButton(i, res.id)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    );
  }
}

export default SearchResultComponent;
