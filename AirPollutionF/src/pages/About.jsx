import React, { Component } from "react";
import { Container, Table } from "react-bootstrap";

class About extends Component {
  state = {};

  render() {
    return (
      <>
        <div className='about-div'>
          <div className='about-title'>What is CAQI?</div>

          <div className='about-body'>
            <div className='about-content'>
              <p>
                The Common Air Quality Index (CAQI) is an air quality index used
                in Europe since 2006. As of 2012, the EU-supported project
                CiteairII argued that the CAQI had been evaluated on a "large
                set" of data, and described the CAQI's motivation and
                definition. CiteairII stated that having an air quality index
                that would be easy to present to the general public was a major
                motivation, leaving aside the more complex question of a
                health-based index, which would require, for example, effects of
                combined levels of different pollutants. The main aim of the
                CAQI was to have an index that would encourage wide comparison
                across the EU, without replacing local indices. CiteairII stated
                that the "main goal of the CAQI is not to warn people for
                possible adverse health effects of poor air quality but to
                attract their attention to urban air pollution and its main
                source (traffic) and help them decrease their exposure."
              </p>
              <p>
                The CAQI is a number on a scale from 1 to 100, where a low value
                means good air quality and a high value means bad air quality.
                The index is defined in both hourly and daily versions, and
                separately near roads (a "roadside" or "traffic" index) or away
                from roads (a "background" index). As of 2012, the CAQI had two
                mandatory components for the roadside index, NO<sub>2</sub> and
                PM<sub>10</sub>, and three mandatory components for the
                background index, NO<sub>2</sub> , PM<sub>10</sub>
                and O<sub>3</sub>. It also included optional pollutants PM
                <sub>2.5</sub>, CO and SO<sub>2</sub>. A "sub-index" is
                calculated for each of the mandatory (and optional if available)
                components. The CAQI is defined as the sub-index that represents
                the worst quality among those components.
              </p>
              <p>
                Some of the key pollutant concentrations in μg/m<sup>3</sup> for
                the hourly background index, the corresponding sub-indices, and
                five CAQI ranges and verbal descriptions are as follows.
              </p>
            </div>
          </div>

          <div className='about-title-2'></div>
          <div>
            <Container className='my-5'>
              <Table>
                <tbody>
                  <tr>
                    <th>Qualitative name </th>
                    <th>Index or sub-index</th>
                    <th colspan='4'>Pollutant (hourly) concentration</th>
                  </tr>
                  <tr>
                    <th colspan='2'></th>
                    <th>
                      NO<sub>2</sub> μg/m<sup>3</sup>
                    </th>
                    <th>
                      PM<sub>10</sub> μg/m<sup>3</sup>
                    </th>
                    <th>
                      O<sub>3</sub> μg/m<sup>3</sup>
                    </th>
                    <th>
                      PM<sub>2.5</sub> (optional) μg/m<sup>3</sup>
                    </th>
                  </tr>
                  <tr>
                    <td>Very low</td>
                    <td style={{ background: "#79bc6a" }}>0–25</td>
                    <td>0–50</td>
                    <td>0–25</td>
                    <td>0–60</td>
                    <td>0–15</td>
                  </tr>
                  <tr>
                    <td>Low</td>
                    <td style={{ background: "#bbcf4c" }}>25–50</td>
                    <td>50–100</td>
                    <td>25–50</td>
                    <td>60–120</td>
                    <td>15–30</td>
                  </tr>
                  <tr>
                    <td>Medium</td>
                    <td style={{ background: "#eec20b" }}>50–75</td>
                    <td>100–200</td>
                    <td>50–90</td>
                    <td>120–180</td>
                    <td>30–55</td>
                  </tr>
                  <tr>
                    <td>High</td>
                    <td style={{ background: "#f29305" }}>75–100</td>
                    <td>200–400</td>
                    <td>90–180</td>
                    <td>180–240</td>
                    <td>55–110</td>
                  </tr>
                  <tr>
                    <td>Very high</td>
                    <td style={{ background: "#e8416f" }}>&gt;100</td>
                    <td>&gt;400</td>
                    <td>&gt;180</td>
                    <td>&gt;240</td>
                    <td>&gt;110</td>
                  </tr>
                </tbody>
              </Table>
            </Container>
          </div>
          <div className='about-cards'></div>
        </div>
      </>
    );
  }
}
export default About;
