import React, { Component } from "react";
import PropTypes from "prop-types";

export default class LogoIcon extends Component {
  static defaultProps = {
    size: 32,
  };

  static propTypes = {
    size: PropTypes.number,
    width: PropTypes.number,
    height: PropTypes.number,
    dark: PropTypes.bool,
  };

  render() {
    let { height, width, size } = this.props;
    return (
      <svg
           viewBox="0 0 32 32"
           width={width || size}
           height={height || size}
           fill="currentcolor"
           x="0px"
           y="0px"

      >
        <style>
          { `.st0{fill:#3A3A3A;}
            .st1{fill:#0098DA;`}
          }
        </style>

        <g>
            <path d="M17.9,25.5c-0.7,0.2-1.5,0.2-2.2,0.2C10.3,25.7,6,21.4,6,16s4.3-9.7,9.7-9.7s9.7,4.3,9.7,9.7
              c0,3.3-1.6,6.2-4.2,8l3.5,4c3.6-2.7,5.9-7,5.9-11.9c0-8.3-6.7-15-15-15S0.8,7.7,0.8,16s6.7,15,15,15c2.1,0,4.2-0.4,6-1.3L17.9,25.5
              L17.9,25.5z"/>
            <path d="M22.1,16c0-3.5-2.8-6.4-6.4-6.4S9.4,12.5,9.4,16c0,3.6,2.8,6.4,6.4,6.4S22.1,19.6,22.1,16L22.1,16z"/>
          </g>
       </svg>
    );
  }
}
