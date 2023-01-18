import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Adverts from '../advert/Adverts';
import Experts from '../expert/Experts';
import Forum from '../forum/Forum';
import Nouveaute from '../nouveautes/Nouveaute';
import Layout from '../sidebar/Layout';

const HomeAgri = () => {
    return (
    <Router>
        <Layout>
          <Routes>
          <Route path='/advert' element={<Adverts/>} />
          <Route path='/forum' element={<Forum />} />
          <Route path='/expert' element={<Experts />} />
          <Route path='/nouveautes' element={<Nouveaute />} />
          </Routes>
        </Layout>
    </Router>
    );
};

export default HomeAgri;