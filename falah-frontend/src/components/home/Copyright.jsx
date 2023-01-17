import React from 'react';

const Copyright = (props) => {
    return (
        <div style={{ color: props.color ? props.color : "#007155"}}>
      &copy; {new Date().getFullYear()} Copyright : {props.title}
    </div>
    );
};

export default Copyright;