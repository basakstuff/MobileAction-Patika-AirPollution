import React, { Component } from "react";
import Content from "../components/Content";

class NoContentPage extends Component {
  constructor() {
    super();
    this.state = {
      showModal: true,
    };
    this.showModal = this.showModal.bind(this);
    this.onModalHide = this.onModalHide.bind(this);
  }
  showModal() {
    this.setState({ showModal: true });
  }
  onModalHide() {
    this.setState({ showModal: false });
  }
  state = {};
  async componentDidMount() {}

  render() {
    const { showModal } = this.state;
    let actualShow;
    actualShow = showModal;
    return (
      <>
        <Content
          modal
          customClassName={"modalLarge"}
          onHide={this.onModalHide}
          show={actualShow}
          modalCloseButton={true}
        >
          <p className='text-center'>
            Oops! You are trying to access a page that does not exist.
          </p>
        </Content>
        {}
      </>
    );
  }
}
export default NoContentPage;
