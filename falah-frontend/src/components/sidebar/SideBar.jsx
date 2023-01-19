import NavItem from './NavItem.jsx';
import { sideMenu } from './menu.config.js';
import React from 'react';
import style from './sidebar.module.css';
import Avatar from '@mui/material/Avatar';
import user from '../../res/images/user.png';
import  Container  from '@mui/material/Container';
import { goto } from '../../service/utils.js';
import {logOut }from "../../service/authentication.js"
import Typography from '@mui/material/Typography';

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
    <Avatar alt="user" src={props.image} sx={{ width: 120, height: 120 , mb: 7, ml: 6 }}/>
    <Typography  style={{color: '#d1d5db',  marginLeft:20
}} variant="h6" component="div">
              {props.name}
          </Typography>
          <Typography  style={{color: '#d1d5db',marginBottom:50,marginLeft:20
}} variant="h7" component="div">
            
          {props.email}
          </Typography>
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