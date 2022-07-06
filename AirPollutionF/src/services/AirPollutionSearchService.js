import axios from "axios";

const SEARCH_URL = "http://localhost:8080/api/air-pollution/";

class AirPollutionSearchService {
  searchAirPollutionForCityAndBetweenTwoDates(searchQuery) {
    return axios.get(SEARCH_URL + "/search" + searchQuery);
  }

  deletePollutionFromDatabases(searchQuery) {
    axios.get(SEARCH_URL + searchQuery).then((r) => console.log(searchQuery));
  }
}

export default new AirPollutionSearchService();
