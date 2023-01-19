import React from 'react';
import style from './layout.module.css';
import Sidebar from './SideBar';
import user from '../../res/images/user.png';
import { useEffect, useState } from 'react';
import {getUserData} from "../../service/personalData"
const Layout = props => {
const { children } = props;
let [users, setUsers] = useState({data : ""});
useEffect(() => {
    return () => {
      getUserData(setUsers)
    };
},[users.data]);
return (
  <div className={style.layout}>
    <header className={style.header}></header>
    <aside className={style.aside}>
      <Sidebar image={"http://localhost:8080/api/document/" +users.data.personalphoto } name={users.data.firstname +"  "+users.data.lastname} email={users.data.email} />
    </aside>
    <main className={style.main}>{children}</main>
    <footer className={style.footer}></footer>
  </div>
);
};

export default Layout;
