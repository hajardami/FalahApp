import React from 'react';
import { NavLink } from 'react-router-dom';
import style from './navItem.module.css';
import NavItemHeader from './NavItemHeader.jsx';
import {logOut} from '../../service/authentication';
import {goto} from '../../service/utils';
import { Button } from '@mui/material';
import {Grid, Avatar, CssBaseline, Container, Box, TextField, FormControlLabel, Checkbox, Link, Paper} from '@mui/material'

console.log({ style });
const NavItem = props => {
  
  function logOut(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("isExpert");
    localStorage.removeItem("isAdmin");
    goto("/");
}
  const { label, Icon, to, children } = props.item;

  if (children) {
    return <NavItemHeader item={props.item} />;
  }

  return (
    <Link href={to} >
< div className={style.navItem} >
      <Icon className={style.navIcon} />
      <span className={style.navLabel}>{label}</span></div></Link>

  );
};

export default NavItem;




/* onClick={logOut()}*/
//onclick={goto({to})}
 /*  <Button
//exact
     // to={to}
      className={style.navItem}
      activeClassName={style.activeNavItem}
     onClick={goto({to})}>*/
  