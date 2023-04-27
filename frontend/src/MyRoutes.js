import React from "react";
import Person from './components/Person/Person';
import Home from './components/Home';
import { Routes, Route } from 'react-router-dom';

const MyRoutes = () => {

    return (
        <>
            <Routes>
                <Route path="/" element={<Home/>}></Route>
                <Route path="Person" element={<Person/>}/>
            </Routes>
        </>
    );
};

export default MyRoutes;
