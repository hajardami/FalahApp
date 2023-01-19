import NavItem from './NavItem.jsx';
import { sideMenu } from './menu.config.js';
import React from 'react';
import style from './sidebar.module.css';
import Avatar from '@mui/material/Avatar';
import user from '../../res/images/user.png';
import  Container  from '@mui/material/Container';
import { goto } from '../../service/utils.js';
import {logOut }from "../../service/authentication.js"

const pages = [
  { name: 'Home', path: "/" },
  { name: 'Offers', path: "/offers" },
  { name: 'Settings', path: "/settings" },
  { name: 'Profile', path: "/" }
]

const Sidebar = props => {

  const handleClickNavItem = (page) => {
    console.log(page)
    goto(page.path)
  }

  return (
    <div className={style.sidebar}>
    <Container className={style.center} sx={{ pt:7 }}>
    <Avatar alt="user" src={user} sx={{ width: 120, height: 120 , mb: 7, ml: 6 }}/>
    </Container>
    <nav className={style.sidebar}>
      {sideMenu.map((item, index, to) => {
      
        return <NavItem key={`${item.label}-${index}`} item={item} to={to}/>;
      })}
    </nav>
    </div>
  );
};

export default Sidebar;