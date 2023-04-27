import React, { useState } from "react";
import "../styles/Header.css";
import Routes from '../MyRoutes';

import { Link } from 'react-router-dom';

const Header = () => {
    const [activeTab1, setActiveTab1] = useState(true);
    const [activeTab2, setActiveTab2] = useState(false);

    const toggleClassTab1 = () => {
        setActiveTab1(true);
        setActiveTab2(false);
    };

    const toggleClassTab2 = () => {
        setActiveTab1(false);
        setActiveTab2(true);
    };

    return (
        <>
            <div className="header">
                <a className="logo">CRUD React + Spring</a>
                <div className="header-right">
                    <Link className={activeTab1 ? 'active': null} onClick={toggleClassTab1} to="/">Home</Link>
                    <Link className={activeTab2 ? 'active': null} onClick={toggleClassTab2} to="/Person">User</Link>
                </div>
            </div>
            <Routes/>
        </>
    );
};

export default Header;
