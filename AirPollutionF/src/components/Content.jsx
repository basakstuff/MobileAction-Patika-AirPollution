import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import ReactRouterPropTypes from "react-router-prop-types";
import { Modal } from "react-bootstrap";
import PropTypes from "prop-types";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

class Content extends Component {
  componentDidMount() {
    const { browserTitle } = this.props;
    if (browserTitle) {
      document.title = browserTitle;
    }
  }

  isModal() {
    const { modal } = this.props;
    return modal;
  }

  render() {
    const {
      title,
      homeRoute = "/",
      modal,
      modalCloseTo,
      show = true,
      modalFooter,
      children,
      history,
      onHide,
      modalSize,
      modalType,
      modalCloseButton,
      customClassName,
    } = this.props;

    if (modal) {
      const dialogClassName = [
        modalType ? `modal-${modalType}` : "",
        customClassName,
      ]
        .filter((p) => p)
        .join(" ");

      return (
        <Modal
          show={show}
          // eslint-disable-next-line no-unused-expressions
          onHide={() => {
            if (modalCloseTo) {
              history.push(modalCloseTo);
            }
            if (onHide) onHide();
          }}
          onExited={() => {
            if (modalCloseTo) {
              history.push(modalCloseTo);
            }
          }}
          bsSize={modalSize}
          dialogClassName={dialogClassName}
          enforceFocus={false}
          backdrop='false'
          keyboard={false}
        >
          <Modal.Header closeButton={modalCloseButton}></Modal.Header>
          <Modal.Body>{children}</Modal.Body>
          {modalFooter && <Modal.Footer>{modalFooter}</Modal.Footer>}
        </Modal>
      );
    }

    return (
      <React.Fragment>
        <section className='content-header'>
          <ol className='breadcrumb'>
            <li>
              <Link to={homeRoute}>
                <FontAwesomeIcon icon={["fas", "home"]} />
                {" Home"}
              </Link>
            </li>
            <li className='active'>{title}</li>
          </ol>
        </section>
        <section className='content'>{children}</section>
      </React.Fragment>
    );
  }
}

Content.propTypes = {
  subTitle: PropTypes.string,
  homeRoute: PropTypes.string,
  modal: PropTypes.bool,
  modalCloseTo: PropTypes.func,
  show: PropTypes.bool,
  modalFooter: PropTypes.node,
  children: PropTypes.node,
  browserTitle: PropTypes.string,
  history: ReactRouterPropTypes.history,
  onHide: PropTypes.func,
  modalSize: PropTypes.oneOf(["xs", "sm", "md", "lg"]),
  modalCloseButton: PropTypes.bool,
  customClassName: PropTypes.string,
};

Content.defaultProps = {
  subTitle: null,
  homeRoute: "/",
  modal: false,
  modalCloseTo: null,
  show: true,
  modalFooter: null,
  children: null,
  browserTitle: null,
  history: null,
  onHide: null,
  modalSize: null,
  modalType: null,
  modalCloseButton: false,
  customClassName: "",
};

export default withRouter(Content);
